package org.egov.assets.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object holds the Supplier information.
 */

public class Supplier {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("tenantId")
	private String tenantId = null;

	/**
	 * type of the Supplier
	 */
	// public enum TypeEnum {
	// INDIVIDUAL("INDIVIDUAL"),
	//
	// FIRM("FIRM"),
	//
	// COMPANY("COMPANY"),
	//
	// REGISTEREDSOCIETY("REGISTEREDSOCIETY"),
	//
	// GOVERNMENTDEPARTMENT("GOVERNMENTDEPARTMENT"),
	//
	// OTHERS("OTHERS");
	//
	// private String value;
	//
	// TypeEnum(String value) {
	// this.value = value;
	// }
	//
	// @Override
	// @JsonValue
	// public String toString() {
	// return String.valueOf(value);
	// }
	//
	// @JsonCreator
	// public static TypeEnum fromValue(String text) {
	// for (TypeEnum b : TypeEnum.values()) {
	// if (String.valueOf(b.value).equals(text)) {
	// return b;
	// }
	// }
	// return null;
	// }
	// }

	@JsonProperty("narration")
	private String narration = null;

	@JsonProperty("code")
	private String code = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("correspondenceAddress")
	private String correspondenceAddress = null;

	@JsonProperty("paymentAddress")
	private String paymentAddress = null;

	/**
	 * status of the Supplier
	 */
	// public enum StatusEnum {
	// ACTIVE("ACTIVE"),
	//
	// SUSPENDED("SUSPENDED"),
	//
	// BARRED("BARRED"),
	//
	// INACTIVE("INACTIVE");
	//
	// private String value;
	//
	// StatusEnum(String value) {
	// this.value = value;
	// }
	//
	// @Override
	// @JsonValue
	// public String toString() {
	// return String.valueOf(value);
	// }
	//
	// @JsonCreator
	// public static StatusEnum fromValue(String text) {
	// for (StatusEnum b : StatusEnum.values()) {
	// if (String.valueOf(b.value).equals(text)) {
	// return b;
	// }
	// }
	// return null;
	// }
	// }

	@JsonProperty("status")
	private Object status = null;

	@JsonProperty("bankAccount")
	private String bankAccount = null;

//	@JsonProperty("bankaccount")
//	private String bankaccount = null;

	@JsonProperty("registrationNumber")
	private String registrationNumber;

	@JsonProperty("mobileNumber")
	private String mobileNumber = null;

	@JsonProperty("epfNumber")
	private String epfNumber = null;

	@JsonProperty("esiNumber")
	private String esiNumber = null;

	@JsonProperty("gstRegisteredState")
	private String gstRegisteredState = null;

	@JsonProperty("entityId")
	private String entityId = null;

	@JsonProperty("modeofpay")
	private String modeofpay = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("entityDescription")
	private String entityDescription = null;

	@JsonProperty("panNumber")
	private String panNumber = null;

	@JsonProperty("tinNumber")
	private String tinNumber = null;

	@JsonProperty("ifscCode")
	private String ifscCode = null;

//	@JsonProperty("ifsccode")
//	private String ifsccode = null;

	@JsonProperty("panno")
	private String panno = null;

	@JsonProperty("gstNo")
	private String gstNo = null;

	@JsonProperty("contactPerson")
	private String contactPerson = null;

	@JsonProperty("contactPersonNo")
	private String contactPersonNo = null;

	@JsonProperty("bankCode")
	private String bankCode = null;

	@JsonProperty("bankname")
	private String bankname = null;

	@JsonProperty("bankBranch")
	private String bankBranch = null;

	@JsonProperty("acctNo")
	private String acctNo = null;

	@JsonProperty("tinno")
	private String tinno = null;

	@JsonProperty("bank")
	private Object bank = null;

	@JsonProperty("egwStatus")
	private Object egwStatus = null;

	@JsonProperty("micr")
	private String micr = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public Supplier id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the Supplier
	 * 
	 * @return id
	 **/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Supplier tenantId(String tenantId) {
		this.tenantId = tenantId;
		return this;
	}

	/**
	 * Tenant id of the Supplier
	 * 
	 * @return tenantId
	 **/

	@NotNull
	@Size(min = 2, max = 128)
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Supplier code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * code of the Supplier
	 * 
	 * @return code
	 **/

	@NotNull

	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	@Size(max = 50)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Supplier name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * name of the Material
	 * 
	 * @return name
	 **/

	@NotNull

	@Pattern(regexp = "^[a-zA-Z ]*$")
	@Size(max = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * email of the Supplier
	 * 
	 * @return email
	 **/

	@Pattern(regexp = "^$|([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
	@Size(max = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * gst number of supplier
	 * 
	 * @return gstNo
	 **/

	@Size(min = 15, max = 15)
	@Pattern(regexp = "[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[0-9A-Za-z]{1}[Z]{1}[0-9]{1}")
	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public Supplier contactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
		return this;
	}

	/**
	 * name of the contact person
	 * 
	 * @return contactPerson
	 **/
	@Pattern(regexp = "^[a-zA-Z ]*$")
	@Size(max = 50)
	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Supplier contactPersonNo(String contactPersonNo) {
		this.contactPersonNo = contactPersonNo;
		return this;
	}

	/**
	 * contact number of the contact person
	 * 
	 * @return contactPersonNo
	 **/

	@Pattern(regexp = "^[0-9]*$")
	@Size(max = 10)
	public String getContactPersonNo() {
		return contactPersonNo;
	}

	public void setContactPersonNo(String contactPersonNo) {
		this.contactPersonNo = contactPersonNo;
	}

	public Supplier bankCode(String bankCode) {
		this.bankCode = bankCode;
		return this;
	}

	/**
	 * code of the bank
	 * 
	 * @return bankCode
	 **/

	@NotNull
	@Size(max = 50)
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * name of the bank branch
	 * 
	 * @return bankBranch
	 **/

	@Size(max = 100)
	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public Supplier acctNo(String acctNo) {
		this.acctNo = acctNo;
		return this;
	}

	/**
	 * account number in the bank
	 * 
	 * @return acctNo
	 **/

	@NotNull
	@Size(max = 16)
	@Pattern(regexp = "^[0-9]*$")
	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public Supplier micr(String micr) {
		this.micr = micr;
		return this;
	}

	/**
	 * micr of the bank
	 * 
	 * @return micr
	 **/

	@Size(max = 10)
	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	public String getMicr() {
		return micr;
	}

	public void setMicr(String micr) {
		this.micr = micr;
	}

	public Supplier auditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
		return this;
	}

	/**
	 * Get auditDetails
	 * 
	 * @return auditDetails
	 **/

	@Valid

	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getCorrespondenceAddress() {
		return correspondenceAddress;
	}

	public void setCorrespondenceAddress(String correspondenceAddress) {
		this.correspondenceAddress = correspondenceAddress;
	}

	public String getPaymentAddress() {
		return paymentAddress;
	}

	public void setPaymentAddress(String paymentAddress) {
		this.paymentAddress = paymentAddress;
	}

	public Object getStatus() {
		return status;
	}

	public void setStatus(Object status) {
		this.status = status;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

//	public String getBankaccount() {
//		return bankaccount;
//	}
//
//	public void setBankaccount(String bankaccount) {
//		this.bankaccount = bankaccount;
//	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEpfNumber() {
		return epfNumber;
	}

	public void setEpfNumber(String epfNumber) {
		this.epfNumber = epfNumber;
	}

	public String getEsiNumber() {
		return esiNumber;
	}

	public void setEsiNumber(String esiNumber) {
		this.esiNumber = esiNumber;
	}

	public String getGstRegisteredState() {
		return gstRegisteredState;
	}

	public void setGstRegisteredState(String gstRegisteredState) {
		this.gstRegisteredState = gstRegisteredState;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getModeofpay() {
		return modeofpay;
	}

	public void setModeofpay(String modeofpay) {
		this.modeofpay = modeofpay;
	}

	public String getEntityDescription() {
		return entityDescription;
	}

	public void setEntityDescription(String entityDescription) {
		this.entityDescription = entityDescription;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getTinNumber() {
		return tinNumber;
	}

	public void setTinNumber(String tinNumber) {
		this.tinNumber = tinNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

//	public String getIfsccode() {
//		return ifsccode;
//	}
//
//	public void setIfsccode(String ifsccode) {
//		this.ifsccode = ifsccode;
//	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getTinno() {
		return tinno;
	}

	public void setTinno(String tinno) {
		this.tinno = tinno;
	}

	public Object getBank() {
		return bank;
	}

	public void setBank(Object bank) {
		this.bank = bank;
	}

	public Object getEgwStatus() {
		return egwStatus;
	}

	public void setEgwStatus(Object egwStatus) {
		this.egwStatus = egwStatus;
	}

}
