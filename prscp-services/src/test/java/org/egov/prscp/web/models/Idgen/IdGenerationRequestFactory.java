package org.egov.prscp.web.models.Idgen;

import java.util.ArrayList;
import java.util.List;
import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.Role;
import org.egov.common.contract.request.User;


/**
 * The class <code>IdGenerationRequestFactory</code> implements static methods that return instances of the class <code>{@link IdGenerationRequest}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:54 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class IdGenerationRequestFactory
 {
	/**
	 * Prevent creation of instances of this class.
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	private IdGenerationRequestFactory() {
	}


	/**
	 * Create an instance of the class <code>{@link IdGenerationRequest}</code>.
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	public static IdGenerationRequest createIdGenerationRequest() {
		ArrayList<Role> list = new ArrayList<Role>();
		list.add(new Role());
		list.add(new Role(new Long(-1L), "", "", ""));
		list.add(new Role(new Long(0L), "0123456789", "0123456789", "0123456789"));
		list.add(new Role(new Long(1L), "An??t-1.0.txt", "An??t-1.0.txt", "An??t-1.0.txt"));
		list.add(new Role(new Long(Long.MAX_VALUE), (String) null, (String) null, (String) null));
		User user = new User(new Long(0L), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", list, "", "0123456789");
		RequestInfo requestInfo = new RequestInfo("", "", new Long(-1L), "", "", "", "", "", "", user);
		ArrayList<IdRequest> list1 = new ArrayList<IdRequest>();
		list1.add(new IdRequest("", "", ""));
		return new IdGenerationRequest(requestInfo, list1);
	}


	/**
	 * Create an instance of the class <code>{@link IdGenerationRequest}</code>.
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	public static IdGenerationRequest createIdGenerationRequest2() {
		ArrayList<Role> list = new ArrayList<Role>();
		list.add(new Role());
		list.add(new Role(new Long(-1L), "", "", ""));
		list.add(new Role(new Long(0L), "0123456789", "0123456789", "0123456789"));
		list.add(new Role(new Long(1L), "An??t-1.0.txt", "An??t-1.0.txt", "An??t-1.0.txt"));
		list.add(new Role(new Long(Long.MAX_VALUE), (String) null, (String) null, (String) null));
		User user = new User(new Long(0L), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", list, "", "0123456789");
		RequestInfo requestInfo = new RequestInfo("0123456789", "0123456789", new Long(0L), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", user);
		ArrayList<IdRequest> list1 = new ArrayList<IdRequest>();
		list1.add(new IdRequest("", "", ""));
		list1.add(new IdRequest("0123456789", "0123456789", "0123456789"));
		list1.add(new IdRequest("An??t-1.0.txt", "An??t-1.0.txt", "An??t-1.0.txt"));
		list1.add(new IdRequest());
		return new IdGenerationRequest(requestInfo, list1);
	}


	/**
	 * Create an instance of the class <code>{@link IdGenerationRequest}</code>.
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	public static IdGenerationRequest createIdGenerationRequest3() {
		return new IdGenerationRequest();
	}
}