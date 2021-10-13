package org.egov.assets.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaterialTypeStoreMappingSearch {

	private List<String> ids = null;

	private String materialType = null;

	private String store = null;

	private Boolean active = null;

	private String glCode = null;

	private String sortBy = null;

	private Integer pageSize;

	private Integer offset;

	@NotNull
	private String tenantId;
}
