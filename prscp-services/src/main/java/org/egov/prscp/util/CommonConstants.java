package org.egov.prscp.util;

public class CommonConstants {

	/* No args Constructor */
	private CommonConstants() {
	}

	public static final String DEVICE_EXTRENALGUEST = "EXTRENALGUEST";
	public static final String DEVICE_GUEST = "GUEST";
	public static final String DEVICE_EVENT = "EVENT";
	public static final String DEVICE_TENDER = "TENDER";
	public static final String DEVICE_PRESSNOTE = "PRESSNOTE";

	public static final String RECIEVER_TYPE_EVENT = "EVENT";
	public static final String RECIEVER_TYPE_EVENTUPDATE = "EVENTUPDATE";
	public static final String RECIEVER_TYPE_PRESSNOTE = "PRESSNOTE";
	public static final String RECIEVER_TYPE_TENDERNOTICE = "TENDERNOTICE";

	public static final String ID_GENERATION = "ID Generation Failed";

	public static final String TEMPLATE_LOAD = "Failed to load Template";
	public static final String WORKFLOW_MESSAGE = "Failed to Create Tender or Invalid User Action";

	public static final String EVENT_STATUS = "PUBLISHED";

	public static final String MODULE_NAME_EVENT = "EVENT";
	public static final String MODULE_NAME_PRESSNOTE = "PRESSNOTE";
	public static final String MODULE_NAME_TENDER = "TENDER";
	public static final String MODULE_NAME_INVALID = "Invalid Module Name";

	public static final String SUCCESS = "Success";
	public static final String FAIL = "Fail";
	public static final String SUCCESSFUL = "successful";
	public static final String UNABLETOPROCESSREQUEST = "Unable to Process request : ";

	public static final String INVALIDNOTEID = "Invalid Press Note ID";
	public static final String INVALID_LIBRARY = "Invalid Library ID";
	public static final String INVALID_EVENT = "Invalid Event ID";
	public static final String INVALID_FILE = "Request file is Invalid";

	public static final String INVALID_DATA = "Request data is Invalid";
	public static final String COMMIITEE_IS_EXISTS = "Duplicate Committee Details.";

	public static final String EVENT_EXCEPTION_EXPIRED = "Expired event can't be modified or cancelled.";

	public static final String EVENT_EXCEPTION_CODE = "EVENT_EXCEPTION";
	public static final String EVENT_EXCEPTION_MESSAGE_CREATE = "Failed to Create Event";
	public static final String EVENT_EXCEPTION_MESSAGE_UPDATE = "Failed to Update Event";
	public static final String EVENT_EXCEPTION_MESSAGE_GET = "Failed to Get Event";
	public static final String EVENT_EXCEPTION_MESSAGE_UPDATESTATUS = "Failed to Update Event";

	public static final String COMMITTEE_MASTER_EXCEPTION_CODE = "COMMITTEE_MASTER_EXCEPTION";
	public static final String COMMITTEE_MASTER_EXCEPTION_MESSAGE = "";

	public static final String PRESS_MASTER_EXCEPTION_CODE = "PRESS_MASTER_EXCEPTION";
	public static final String PRESS_MASTER_EXCEPTION_MESSAGE = "";

	public static final String LIBRARY_EXCEPTION_CODE = "LIBRARY_EXCEPTION";
	public static final String LIBRARY_EXCEPTION_MESSAGE = "";

	public static final String PRESSNOTE_EXCEPTION_CODE = "PRESSNOTE_EXCEPTION";
	public static final String PRESSNOTE_EXCEPTION_MESSAGE = "";

	public static final String TENDERNOTICE_EXCEPTION_CODE = "TENDERNOTICE_EXCEPTION";
	public static final String TENDERNOTICE_EXCEPTION_MESSAGE = "Invalid Tender Id";

	public static final String INVITATION_EXCEPTION_CODE = "INVITATION_EXCEPTION";
	public static final String INVITATION_EXCEPTION_MESSAGE = "";

	public static final String TEMPLATE_EXCEPTION_CODE = "TEMPLATE_EXCEPTION";
	public static final String TEMPLATE_EXCEPTION_MESSAGE = "";

	public static final String NOTIFICATION_TENDER_SEND_EXCEPTION_CODE = "NOTIFICATION_TENDER_SEND_EXCEPTION";
	public static final String NOTIFICATION_TENDER_RESEND_EXCEPTION_CODE = "NOTIFICATION_TENDER_RESEND_EXCEPTION";

	public static final String NOTIFICATION_PRESSNOTE_SEND_EXCEPTION_CODE = "NOTIFICATION_PRESSNOTE_SEND_EXCEPTION";
	public static final String NOTIFICATION_PRESSNOTE_RESEND_EXCEPTION_CODE = "NOTIFICATION_PRESSNOTE_RESEND_EXCEPTION";

	public static final String NOTIFICATION_EVENT_SEND_EXCEPTION_CODE = "NOTIFICATION_EVENT_SEND_EXCEPTION";
	public static final String NOTIFICATION_EVENT_RESEND_EXCEPTION_CODE = "NOTIFICATION_EVENT_RESEND_EXCEPTION";

	public static final String NOTIFICATION_EVENT_SEND_REMINDER_EXCEPTION_CODE = "NOTIFICATION_EVENT_SEND_REMINDER_EXCEPTION";
	public static final String NOTIFICATION_EVENT_SEND_LIBRARY_EXCEPTION_CODE = "NOTIFICATION_EVENT_SEND_LIBRARY_EXCEPTION";
	public static final String NOTIFICATION_EVENT_SEND_CANCEL_EXCEPTION_CODE = "NOTIFICATION_EVENT_SEND_CANCEL_EXCEPTION";
	public static final String NOTIFICATION_EVENT_SEND_UPDATE_EXCEPTION_CODE = "NOTIFICATION_EVENT_SEND_UPDATE_EXCEPTION";

	public static final String NOTIFICATION_EMAIL_ATTACHMENTS_EXCEPTION_CODE = "NOTIFICATION_EMAIL_ATTACHMENTS_EXCEPTION";
	
	
	public static final String EVENTCREATE = "EVENTCREATE";
	public static final String EVENTUPDATE = "EVENTUPDATE";
	public static final String EVENTGET = "EVENTGET";
	public static final String EVENTPUBLISH = "EVENTPUBLISH";
	public static final String GETEVENTTEMPLATE = "GETEVENTTEMPLATE";
	public static final String GETPRASSNOTETEMPLATE = "GETPRASSNOTETEMPLATE";
	public static final String GETTENDERTEMPLATE = "GETTENDERTEMPLATE";
	public static final String RESENDNOTIFICATION = "RESENDNOTIFICATION";
	public static final String ADDENVITEGUEST = "ADDENVITEGUEST";
	public static final String REMOVEENVITEGUEST = "REMOVEENVITEGUEST";
	public static final String GETENVITEGUEST = "GETENVITEGUEST";
	public static final String UPLOADEXTERNALENVITEGUESTLIST = "UPLOADEXTERNALENVITEGUESTLIST";
	public static final String SENDENVITEENVITATION = "SENDENVITEENVITATION";
	public static final String LIBRARYUPLOAD = "LIBRARYUPLOAD";
	public static final String LIBRARYGET = "LIBRARYGET";
	public static final String LIBRARYDELETE = "LIBRARYDELETE";
	public static final String COMMITTEEMASTERCREATE = "COMMITTEEMASTERCREATE";
	public static final String COMMITTEEMASTERUPDATE = "COMMITTEEMASTERUPDATE";
	public static final String COMMITTEEMASTERGET = "COMMITTEEMASTERGET";
	public static final String PRESSMASTERCREATE = "PRESSMASTERCREATE";
	public static final String PRESSMASTERUPDATE = "PRESSMASTERUPDATE";
	public static final String PRESSMASTERGET = "PRESSMASTERGET";
	public static final String PRESSMASTERDELETE = "PRESSMASTERDELETE";
	public static final String PRESSNOTESCREATE = "PRESSNOTESCREATE";
	public static final String PRESSNOTEUPDATE = "PRESSNOTEUPDATE";
	public static final String PRESSNOTEGET = "PRESSNOTEGET";
	public static final String TENDERNOTICECREATE = "TENDERNOTICECREATE";
	public static final String TENDERNOTICEUPDATE = "TENDERNOTICEUPDATE";
	public static final String TENDERNOTICEGET = "TENDERNOTICEGET";
	public static final String TENDERNOTICEPUBLISH = "TENDERNOTICEPUBLISH";
	public static final String TENDERNOTICETEMPLATE = "TENDERNOTICETEMPLATE";
	
	public static final String SCRIPTTAGXSS = "(.*?)<(\\s*?)script(\\s*?)(.*?)>(.*?)<(\\s*?)/(\\s*?)script(\\s*?)>(.*?)";
	public static final String SRC1TAGXSS = "(.*?)src[\\r\\n]*=[\\r\\n]*\\\'(.*?)\\\'(.*?)";
	public static final String SRC2TAGXSS = "(.*?)src[\\r\\n]*=[\\r\\n]*\\\"(.*?)\\\"(.*?)";
	public static final String SCRIPTENDTAGXSS = "(.*?)</script(\\s*?)>(.*?)";
	public static final String SCRIPTSTARTTAGXSS = "(.*?)<(\\s*?)script(\\s*?)>(.*?)";
	public static final String JSTAGXSS = "(.*?)javascript:(.*?)";
	public static final String VBTAGXSS = "(.*?)vbscript:(.*?)";
	public static final String ONLOADTAGXSS = "(.*?)onload(.*?)=(.*?)";
}
