package org.egov.integration.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonReportResponse {
	
	  public Object viewPath;
	    public Boolean selectiveDownload;
	    public List<CommonReportHeader> reportHeader;
	    public Object ttl;
	    public List<List<Object>> reportData;

}
