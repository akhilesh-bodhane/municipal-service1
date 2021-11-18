package org.egov.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FireNocTaskDetail {

	@JsonProperty("amount")
	private String amount;

	@JsonProperty("appl_id")
	private String applicationId;

	@JsonProperty("remarks")
	private String remarks;

	@JsonProperty("task_id")
	private String taskId;

	@JsonProperty("action_no")
	private String actionNo;

	@JsonProperty("task_name")
	private String taskName;

	@JsonProperty("task_type")
	private String taskType;

	@JsonProperty("user_name")
	private String userName;

	@JsonProperty("service_id")
	private String serviceId;

	@JsonProperty("user_detail")
	private FireNocUserDetail fireNocUserDetail;

	@JsonProperty("action_taken")
	private String actionTaken;

	@JsonProperty("payment_date")
	private String paymentDate;

	@JsonProperty("payment_mode")
	private String paymentMode;

	@JsonProperty("pull_user_id")
	private String pullUserId;

	@JsonProperty("executed_time")
	private String executedTime;

	@JsonProperty("received_time")
	private String receivedTime;

	@JsonProperty("payment_ref_no")
	private String paymentRefNo;

	@JsonProperty("current_process_id")
	private String currentProcessId;

	@JsonProperty("callback_curr_proc_id")
	private String callbackCurrProcId;

}
