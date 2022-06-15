package org.egov.temporarystall.common;

public class CommonConstants {

	/* No args Constructor */
	private CommonConstants() {
	}


	public static final String ID_GENERATION = "ID Generation Failed";
	public static final String ID_GENERATION_1 = "ID Generation Failed2";
	public static final String ID_GENERATION_2 = "ID Generation Failed3";
	
	public static final String ORGANIZATION_EXCEPTION_CODE="ORGANIZATION_EXCEPTION";
	public static final String SUH_APPLICATION_EXCEPTION_CODE="SUH_APPLICATION_EXCEPTION";
	public static final String SUSV_RENEW_APPLICATION_EXCEPTION_CODE="SUSV_RENEW_APPLICATION_EXCEPTION";
	public static final String STALL_APPLICATION_EXCEPTION_CODE = "STALL_APPLICATION_EXCEPTION";
	public static final String SMID_APPLICATION_EXCEPTION_CODE = "SMID_APPLICATION_EXCEPTION";
	public static final String  SMID_SHG_APPLICATION_EXCEPTION_CODE= "SMID_SHG_APPLICATION_EXCEPTION_CODE";
	public static final String SUSV_APPLICATION_EXCEPTION_CODE="SUSV_APPLICATION_EXCEPTION";
	public static final String  SMID_SHG_MEMBER_APPLICATION_EXCEPTION_CODE="SMID_SHG_MEMBER_APPLICATION_EXCEPTION_CODE";
	public static final String  SUH_LOG_EXCEPTION_CODE="SUH_LOG_EXCEPTION_CODE";
	public static final String  INVALID_SUH_LOG_REQUEST="INVALID_SUH_LOG_REQUEST";
	public static final String  INVALID_SUH_LOG_REQUEST_MESSAGE="you can not delete record ";
	public static final String  INVALID_SUH_LOG_UUID_REQUEST_MESSAGE="please provide valid log UUid";
	public static final String WORKFLOW_MESSAGE = "Failed to Create Tender or Invalid User Action";
	public static final String INVALID_ORGANIZATION_REQUEST="INVALID_ORGANIZATION_REQUEST";
	public static final String INVALID_ORGANIZATION_REQUEST_MOBILE_MESSAGE="Mobile No already Exists";
	public static final String INVALID_ORGANIZATION_REQUEST_ORG_NAME_MESSAGE="Organization Name already Exists";
	
	public static final String USER_CREATION = "User creation  Failed";
	public static final String ROLE = "role may not be null";	
	
	public static final String INVALID_SUH_REQUEST= "INVALID_SUH_REQUEST";
	public static final String INVALID_SUSV_REQUEST= "INVALID_SUSV_REQUEST";
	public static final String DIPLICATE_COV_NO_MESSAGE= "COV NO already exists";

	public static final String INVALID_SUH_REQUEST_MESSAGE= "Shelter Name already exists";
	public static final String INVALID_SUH_ASSIGNED_TO="please provide valid organization uuid";
	public static final String APPLICATION_MINORITY_NULL_CODE = "SEP_APPLICATION_MINORITY_NULL_CODE";
	public static final String APPLICATION_MINORITY_NULL_CODE_MESSAGE = "As Minority is Yes,please provide minority type";
	public static final String SEP_APPLICATION_STATUS_EXCEPTION_CODE = "Invalid Application Status";
	public static final String SMID_APPLICATION_STATUS_EXCEPTION_CODE= "Invalid Application Status";
	
	public static final String MISSING_OR_INVALID_SEP_APPLICATION_OBJECT = "SEP_APPLICATION_OBJECT";
	public static final String MISSING_OR_INVALID_SEP_APPLICATION_MESSAGE = "Null or Invalid SEPAPPLICATION Request";
	
	public static final String MISSING_OR_INVALID_SMID_APPLICATION_OBJECT = "SMID_APPLICATION_OBJECT";
	public static final String MISSING_OR_INVALID_SMID_APPLICATION_MESSAGE = "Null or Invalid SMIDAPPLICATION Request";
	
	public static final String APPLICATION_BPLNO_NULL_CODE = "SEP_APPLICATION_BPLNO_NULL_CODE";
	public static final String APPLICATION_BPLNO_NULL_CODE_MESSAGE = "As Urban is poor ,please provide BPL No";
	
	public static final String APPLICATION_INSURANCE_NULL_CODE="APPLICATION_INSURANCE_NULL_CODE";
	public static final String  APPLICATION_INSURANCE_NULL_CODE_MESSAGE = "As Insurance is yes ,please provide Insurance through";
	
	
	public static final String INVALID_SHG_UUID="INVALID_SHG_UUID";
	public static final String  INVALID_SHG_UUID_MESSAGE="provide valid SHG id";
	public static final String INVALID_MEMBER_UUID="INVALID_SHD_MEMBER_APPLICATION_UUID";
	public static final String  INVALID_MEMBER_UUID_MESSAGE="provide valid SHG memeber application id";
	public static final String TRANSACTION_EXCEPTION_CODE="TRANSACTION_EXCEPTION";
	
	public static final String ACTION_CREATE="CREATE";
	public static final String ACTION_UPDATE="UPDATE";
	public static final String ACTION_DRAFT="DRAFTED";
	public static final String SUCCESS = "Success";
	public static final String FAIL = "Fail";
	public static final String SUCCESSFUL = "successful";
	public static final String INVALID_SHG_REQUEST = "Invalid SHG Request";
	public static final String INVALID_SHG_REQUEST_MESSAGE = "For approval minimum 10 members required";
	public static final String STALL_APPLICATION_CREATED = "Application Created";
	
	public static final String MDMS_FESTIVAL = "Festival";
	public static final String MDMS_PM_PATH = "$.MdmsRes.Temporary-Stall";
	public static final String MDMS_TAXHEAD_PATH = "$.MdmsRes.Temporary-Stall.Festival";
	public static final String MDMS_TAXHEAD_SIZE_PATH = "$.MdmsRes.Temporary-Stall.size";
	public static final String MDMS_TEMPORARYSTALL = "Temporary-Stall";
	public static final String MDMS_EGF_MASTER = "egf-master";
	public static final String MDMS_FINANCIALYEAR = "FinancialYear";
	public static final String SIZE = "size";
	
	public static final String BWT_TAXHEAD_CODE_1 = "WATER_TANKAR_CHARGES_BOOKING_BRANCH";

	public static final String BWT_TAXHEAD_CODE_2 = "BWT_TAX";
	
    public static final String MDMS_STARTDATE  = "startingDate";

    public static final String MDMS_ENDDATE  = "endingDate";
    
    public static final String STALL_TAX_HEAD_CODE = "TEMPORARY_STALL_CHARGES_BOOKING";

}
