package org.egov.pgr.model;

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
public class ReportResponse{
    public Object viewPath;
    public Boolean selectiveDownload;
    public List<ReportHeader> reportHeader;
    public Object ttl;
    public List<List<Object>> reportData;
}