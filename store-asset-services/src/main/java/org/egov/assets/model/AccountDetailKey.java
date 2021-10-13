package org.egov.assets.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 *
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-28T09:20:06.607Z")

public class AccountDetailKey {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("key")
	private String key = null;

	@JsonProperty("accountDetailType")
	private AccountDetailType accountDetailType = null;

	@JsonProperty("auditDetails")
	private Auditable auditDetails = null;

	public AccountDetailKey id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the AccountDetailKey
	 *
	 * @return id
	 **/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AccountDetailKey key(String key) {
		this.key = key;
		return this;
	}

	/**
	 * key of the AccountDetailKey
	 *
	 * @return key
	 **/

	@NotNull
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public AccountDetailKey accountDetailType(AccountDetailType accountDetailType) {
		this.accountDetailType = accountDetailType;
		return this;
	}

	/**
	 * account detail type of the AccountDetailKey
	 *
	 * @return accountDetailType
	 **/

	@NotNull
	@Valid
	public AccountDetailType getAccountDetailType() {
		return accountDetailType;
	}

	public void setAccountDetailType(AccountDetailType accountDetailType) {
		this.accountDetailType = accountDetailType;
	}

	public AccountDetailKey auditDetails(Auditable auditDetails) {
		this.auditDetails = auditDetails;
		return this;
	}

	/**
	 * Get auditDetails
	 *
	 * @return auditDetails
	 **/
	@Valid
	public Auditable getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(Auditable auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AccountDetailKey accountDetailKey = (AccountDetailKey) o;
		return Objects.equals(this.id, accountDetailKey.id) && Objects.equals(this.key, accountDetailKey.key)
				&& Objects.equals(this.accountDetailType, accountDetailKey.accountDetailType)
				&& Objects.equals(this.auditDetails, accountDetailKey.auditDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, key, accountDetailType, auditDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AccountDetailKey {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    key: ").append(toIndentedString(key)).append("\n");
		sb.append("    accountDetailType: ").append(toIndentedString(accountDetailType)).append("\n");
		sb.append("    auditDetails: ").append(toIndentedString(auditDetails)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
