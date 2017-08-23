package org.ekstep.searchindex.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.ekstep.searchindex.util.GraphUtil;
import org.ekstep.searchindex.util.HTTPUtil;
import org.ekstep.searchindex.util.PropertiesUtil;

import com.ilimi.common.logger.PlatformLogger;
import com.ilimi.graph.dac.model.Node;
import com.ilimi.graph.dac.model.Relation;

/**
 * The Class FlagParentProcessor, flags parent content if the content is flagged
 * and it has parent
 *
 * @author karthik
 */
public class FlagParentContentProcessor implements IMessageProcessor {

	/** The mapper. */
	private ObjectMapper mapper = new ObjectMapper();

	/**
	 * Instantiates a new flag parent processor.
	 */
	public FlagParentContentProcessor() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.ekstep.searchindex.processor.IMessageProcessor#processMessage(java.
	 * lang.String)
	 */
	@Override
	public void processMessage(String messageData) {
		try {
			Map<String, Object> message = new HashMap<String, Object>();
			if (StringUtils.isNotBlank(messageData)) {
				message = mapper.readValue(messageData, new TypeReference<Map<String, Object>>() {
				});
			}
			if (null != message) {
				processMessage(message);
			}
		} catch (Exception e) {
			PlatformLogger.log("Error while processing kafka message"+ e.getMessage(),null ,e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.ekstep.searchindex.processor.IMessageProcessor#processMessage(java.
	 * util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void processMessage(Map<String, Object> message) throws Exception {
		Map<String, Object> edata = new HashMap<String, Object>();
		Map<String, Object> eks = new HashMap<String, Object>();
		if (null != message.get("edata")) {
			edata = (Map) message.get("edata");
			if (null != edata.get("eks")) {
				eks = (Map) edata.get("eks");
				if (null != eks) {
					String contentId = (String) eks.get("cid");
					String status = (String) eks.get("state");
					if (null != contentId && null != status) {
						if (StringUtils.equalsIgnoreCase(status, "Flagged")) {
							try {
								Map<String, Object> nodeMap = GraphUtil.getDataNode("domain", contentId);
								Node node = mapper.convertValue(nodeMap, Node.class);
								List<String> flagReasons = (List<String>) node.getMetadata().get("flagReasons");
								List<String> flaggedBy = (List<String>) node.getMetadata().get("flaggedBy");
								for (Relation relation : node.getInRelations())
									if (relation.getRelationType().equalsIgnoreCase("hasSequenceMember")) {
										String parentContentId = relation.getStartNodeId();
										Map<String, Object> parentNodeMap = GraphUtil.getDataNode("domain",
												parentContentId);
										Node parentNode = mapper.convertValue(parentNodeMap, Node.class);
										String versionKey = (String) parentNode.getMetadata().get("versionKey");
										String flaggedByUser = "";
										if (flaggedBy != null && flaggedBy.size() > 0) {
											flaggedByUser = flaggedBy.get(0);
											if (flaggedBy.size() > 1) {
												List<String> parentFlaggedBy = (List<String>) parentNode.getMetadata()
														.get("flaggedBy");
												if (parentFlaggedBy != null)
													flaggedBy.removeAll(parentFlaggedBy);
												if (flaggedBy.size() > 0)
													flaggedByUser = flaggedBy.get(0);
											}
										}
										flagContent(parentContentId, flagReasons, flaggedByUser, versionKey);
									}
							} catch (Exception e) {
								PlatformLogger.log("Error while checking content node "+ e.getMessage(),null, e);
							}

						}
					}
				}
			}
		}
	}

	/**
	 * Flag content.
	 *
	 * @param contentId
	 *            the content id
	 * @param flagReasons
	 *            the flag reasons
	 * @param flaggedBy
	 *            the flagged by
	 * @param versionKey
	 *            the version key
	 * @throws Exception
	 *             the exception
	 */
	private void flagContent(String contentId, List<String> flagReasons, String flaggedBy, String versionKey)
			throws Exception {
		String url = PropertiesUtil.getProperty("platform-api-url") + "/v2/content/flag/" + contentId;

		Map<String, Object> requestBodyMap = new HashMap<String, Object>();
		Map<String, Object> requestMap = new HashMap<String, Object>();
		requestMap.put("flagReasons", flagReasons);
		requestMap.put("flaggedBy", flaggedBy);
		requestMap.put("versionKey", versionKey);
		requestBodyMap.put("request", requestMap);

		String requestBody = mapper.writeValueAsString(requestBodyMap);

		HTTPUtil.makePostRequest(url, requestBody);

	}
}
