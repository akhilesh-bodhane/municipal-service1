package org.egov.integration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FireApplicationPendingDetail {
	public String task_name;
	public String appl_ref_no;
	public Object login_id;
}