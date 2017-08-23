package com.ilimi.graph.exception;

public enum GraphEngineErrorCodes {

    ERR_GRAPH_UNKNOWN_EXCEPTION,

    ERR_GRAPH_SYS_EXCEPTION,

    ERR_GRAPH_INVALID_GRAPH_ID,
    
    ERR_GRAPH_INVALID_NODE_ID,

    ERR_GRAPH_CREATE_GRAPH_UNKNOWN_ERROR,
    
    ERR_GRAPH_CREATE_INDEX_UNKNOWN_ERROR,
    
    ERR_GRAPH_CREATE_UNIQUE_CONSTRAINT_UNKNOWN_ERROR,

    ERR_GRAPH_LOAD_GRAPH_UNKNOWN_ERROR,

    ERR_GRAPH_VALIDATE_GRAPH_UNKNOWN_ERROR,

    ERR_GRAPH_DELETE_GRAPH_UNKNOWN_ERROR,

    ERR_GRAPH_SAVE_DEF_NODE_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_SAVE_DEF_NODE_FAILED_TO_CREATE,
    
    ERR_GRAPH_SAVE_DEF_NODE_VALIDATION_FAILED,
    
    ERR_GRAPH_SAVE_DEF_NODE_UNKNOWN_ERROR,

    ERR_GRAPH_INVALID_PROPERTY,

    ERR_GRAPH_ADD_NODE_INVALID_DEFINITION_NODE,
    
    ERR_GRAPH_ADD_NODE_VALIDATION_FAILED,
    
    ERR_GRAPH_ADD_NODE_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_ADD_NODE_UNKNOWN_ERROR,

    ERR_GRAPH_REMOVE_NODE_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_CREATE_NODE_ERROR,
    
    ERR_GRAPH_UPDATE_NODE_ERROR,

    ERR_GRAPH_UPDATE_NODE_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_VALIDATE_NODE_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_NODE_VALIDATION_FAILED,
    
    ERR_GRAPH_UPDATE_NODE_VALIDATION_FAILED,
    
    ERR_GRAPH_UPDATE_NODE_NOT_FOUND,
    
    ERR_GRAPH_UPDATE_NODE_UNKNOWN_ERROR,

    ERR_GRAPH_GET_NODE_PROPERTY_INVALID_KEY,

    ERR_GRAPH_SEARCH_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_SEARCH_NODE_NOT_FOUND,
    
    ERR_GRAPH_SEARCH_UNKNOWN_ERROR,

    ERR_GRAPH_GET_DESCENDANTS_MISSING_REQ_PARAMS,

    ERR_GRAPH_CREATE_SEQUENCE_INVALID_MEMBERIDS,
    
    ERR_GRAPH_CREATE_SEQUENCE_UNKNOWN_ERROR,

    ERR_GRAPH_ADD_SEQUENCE_MEMBER_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_ADD_SEQUENCE_MEMBER_UNKNOWN_ERROR,

    ERR_GRAPH_REMOVE_SEQUENCE_MEMBER_MISSING_REQ_PARAMS,

    ERR_GRAPH_DROP_SEQUENCE_MISSING_REQ_PARAMS,

    ERR_GRAPH_GET_SEQUENCE_MEMBERS_INVALID_SEQID,

    ERR_GRAPH_IS_SEQUENCE_MEMBER_MISSING_REQ_PARAMS,

    ERR_GRAPH_COLLECTION_GET_CARDINALITY_MISSING_REQ_PARAMS,

    ERR_GRAPH_IMPORT_INVALID_GRAPH_ID,
    
    ERR_GRAPH_IMPORT_INVALID_INPUTSTREAM,
    
    ERR_GRAPH_IMPORT_INVALID_FORMAT,
    
    ERR_GRAPH_IMPORT_MISSING_REQ_COLUMNS,
    
    ERR_GRAPH_IMPORT_MISSING_REQ_COLUMN_DATA,
    
    ERR_GRAPH_IMPORT_VALIDATION_FAILED,
    
    ERR_GRAPH_IMPORT_UNKNOWN_ERROR,

    ERR_GRAPH_EXPORT_INVALID_FORMAT,
    
    ERR_GRAPH_EXPORT_UNKNOWN_ERROR,

    ERR_INVALID_NODE,

    ERR_GRAPH_UNSUPPORTED_OPERATION,

    ERR_GRAPH_INVALID_COLLECTION_TYPE,

    ERR_GRAPH_SEARCH_NODES_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_SEARCH_NODES_UNKNOWN_ERROR,

    ERR_GRAPH_TRAVERSAL_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_TRAVERSAL_UNKNOWN_ERROR,

    ERR_GRAPH_GET_CHILDREN_MISSING_REQ_PARAMS,

    ERR_GRAPH_CREATE_SET_NO_OBJ_TYPE,
    
    ERR_GRAPH_CREATE_SET_ONLY_INDEX_META,
    
    ERR_GRAPH_CREATE_SET_INVALID_MEMBER_IDS,
    
    ERR_GRAPH_CREATE_SET_UNKNOWN_ERROR,
    
    ERR_GRAPH_SET_UPDATE_INDEX_ERROR,
    
    ERR_GRAPH_SET_NOT_FOUND,
    
    ERR_GRAPH_SET_UPDATE_MEMBERSHIP_ERROR,
    
    ERR_GRAPH_SET_CRITERIA_INVALID,

    ERR_GRAPH_SET_CRITERIA_INVALID_OBJ_TYPE,

    ERR_GRAPH_ADD_SET_MEMBER_INVALID_REQ_PARAMS,

    ERR_GRAPH_REMOVE_SET_MEMBER_MISSING_REQ_PARAMS,

    ERR_GRAPH_GET_SET_MEMBERS_INVALID_SET_ID,

    ERR_GRAPH_IS_SET_MEMBER_INVALID_SET_ID,

    ERR_GRAPH_DROP_SET_INVALID_SET_ID,
    
    ERR_EMPTY_TAG_NAME,

    ERR_GRAPH_CREATE_TAG_INVALID_MEMBER_IDS,
    
    ERR_GRAPH_CREATE_TAG_UNKNOWN_ERROR,

    ERR_GRAPH_ADD_TAG_MEMBER_MISSING_REQ_PARAMS,

    ERR_GRAPH_REMOVE_TAG_MEMBER_MISSING_REQ_PARAMS,

    ERR_GRAPH_GET_TAG_MEMBERS_INVALID_TAG_ID,

    ERR_GRAPH_IS_TAG_MEMBER_MISSING_REQ_PARAMS,

    ERR_GRAPH_DROP_TAG_INVALID_TAG_ID,

    ERR_GRAPH_COLLECTION_ADD_MEMBER_MISSING_REQ_PARAMS,

    ERR_GRAPH_COLLECTION_REMOVE_MEMBER_MISSING_REQ_PARAMS,

    ERR_GRAPH_DROP_COLLECTION_MISSING_REQ_PARAMS,

    ERR_GRAPH_COLLECTION_GET_MEMBERS_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_CREATE_SET_MISSING_REQ_PARAMS,

    ERR_GRAPH_ADD_TAGS_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_ADD_TAGS_UNKNOWN_ERROR,
    
    ERR_GRAPH_EXPORT_NODE_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_EXPORT_NODE_UNKNOWN_ERROR,
    
    ERR_GRAPH_EXPORT_NODE_NOT_FOUND,
    
    ERR_GRAPH_INVALID_JSON,
    
    ERR_GRAPH_CREATE_METADATA_NODE_FAILED,
    
    ERR_GRAPH_CREATE_RELATION_NODE_FAILED,
    
    ERR_GRAPH_CREATE_VALUE_NODE_FAILED,
    
    ERR_GRAPH_GET_COLLECTION_MISSING_REQ_PARAMS,
    
    ERR_GRAPH_COLLECTION_ID_MISSING,
    
    ERR_GRAPH_UPDATE_SET_MISSING_REQ_PARAMS, ERR_SEARCH_CRITERIA_NOT_FOUND,
	
	ERR_GRAPH_PROCESSING_ERROR,
	
	ERR_GRAPH_INVALID_REQUEST_FORMAT, ERR_EXECUTE_QUERY_FOR_NODES_UNKNOWN_ERROR;
}
