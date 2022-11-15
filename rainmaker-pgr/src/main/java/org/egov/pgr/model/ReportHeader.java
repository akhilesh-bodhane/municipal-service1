package org.egov.pgr.model;

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
public class ReportHeader {

	public Boolean localisationRequired;
	public String name;
	public String label;
	public String type;
	public Object defaultValue;
	public Boolean isMandatory;
	public Boolean isLocalisationRequired;
	public String localisationPrefix;
	public Boolean showColumn;
	public Boolean total;
	public Object rowTotal;
	public Object columnTotal;
	public Object initialValue;
	public Object minValue;
	public Object maxValue;
}