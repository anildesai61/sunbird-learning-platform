package org.sunbird.jobs.samza.service;

/**
 * @author Pradyumna
 */

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.samza.config.Config;
import org.apache.samza.system.SystemStream;
import org.apache.samza.task.MessageCollector;
import org.ekstep.common.Platform;
import org.ekstep.jobs.samza.service.ISamzaService;
import org.ekstep.jobs.samza.service.task.JobMetrics;
import org.ekstep.jobs.samza.util.JSONUtils;
import org.ekstep.jobs.samza.util.JobLogger;
import org.sunbird.job.samza.util.CourseCertificateParams;

import java.util.Map;

public class CertificateGeneratorService implements ISamzaService {

    private static JobLogger LOGGER = new JobLogger(CertificateGeneratorService.class);
    private SystemStream systemStream;
    private Config config = null;
    private static int MAXITERTIONCOUNT = 2;
    /**
     * @param config
     * @throws Exception
     */
    @Override
    public void initialize(Config config) throws Exception {
        this.config = config;
        JSONUtils.loadProperties(config);
        LOGGER.info("Service config initialized");
        systemStream = new SystemStream("kafka", config.get("output.failed.events.topic.name"));
    }

    /**
     * The class processMessage is mainly responsible for processing the messages sent from consumers based on required
     * specifications
     *
     * @param message
     * @param metrics
     * @param collector
     */
    @Override
    public void processMessage(Map<String, Object> message, JobMetrics metrics, MessageCollector collector) throws Exception {
        if (null == message) {
            LOGGER.info("Ignoring the message because it is not valid for publishing.");
            return;
        }

        Map<String, Object> edata = (Map<String, Object>) message.get(CourseCertificateParams.edata.name());
        Map<String, Object> object = (Map<String, Object>) message.get(CourseCertificateParams.object.name());
        if(!validEdata(edata) || MapUtils.isEmpty(object)) {
            LOGGER.info("Ignoring the message because it is not valid for course-certificate-generator.");
            return;
        }

        String objectId = (String) object.get(CourseCertificateParams.id.name());
        if (StringUtils.isNotBlank(objectId)) {
            String action = (String) edata.get("action");
            switch (action) {
                case "generate-course-certificate" : break;
            }
        }
    }

    private boolean validEdata(Map<String, Object> edata) {
        if(MapUtils.isNotEmpty(edata)){
            Integer iteration = (Integer) edata.get(CourseCertificateParams.iteration.name());
            if ((iteration <= getMaxIterations())) {
                return true;
            }
        }
        return false;
    }

    protected int getMaxIterations() {
        if (Platform.config.hasPath("max.iteration.count.samza.job"))
            return Platform.config.getInt("max.iteration.count.samza.job");
        else
            return MAXITERTIONCOUNT;
    }
}
