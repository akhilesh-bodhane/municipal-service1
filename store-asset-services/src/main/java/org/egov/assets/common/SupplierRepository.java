/*
 * eGov suite of products aim to improve the internal efficiency,transparency,
 *      accountability and the service delivery of the government  organizations.
 *
 *       Copyright (C) <2015>  eGovernments Foundation
 *
 *       The updated version of eGov suite of products as by eGovernments Foundation
 *       is available at http://www.egovernments.org
 *
 *       This program is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU General Public License as published by
 *       the Free Software Foundation, either version 3 of the License, or
 *       any later version.
 *
 *       This program is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU General Public License for more details.
 *
 *       You should have received a copy of the GNU General Public License
 *       along with this program. If not, see http://www.gnu.org/licenses/ or
 *       http://www.gnu.org/licenses/gpl.html .
 *
 *       In addition to the terms of the GPL license to be adhered to in using this
 *       program, the following additional terms are to be complied with:
 *
 *           1) All versions of this program, verbatim or modified must carry this
 *              Legal Notice.
 *
 *           2) Any misrepresentation of the origin of the material is prohibited. It
 *              is required that all modified versions of this material be marked in
 *              reasonable ways as different from the original version.
 *
 *           3) This license does not grant any rights to any user of the program
 *              with regards to rights under trademark law for use of the trade names
 *              or trademarks of eGovernments Foundation.
 *
 *     In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
 */
package org.egov.assets.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.egov.assets.model.Supplier;
import org.egov.assets.model.SuppliersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SupplierRepository {

	private final RestTemplate restTemplate;
	private final String supplierBySearchCriteriaUrl;

	@Autowired
	public SupplierRepository(final RestTemplate restTemplate,
			@Value("${egov.services.egov_egf.hostname}") final String supplierHostname,
			@Value("${egov.services.egov_egf.searchpath}") final String supplierSearchCriteriaUrl) {

		this.restTemplate = restTemplate;
		this.supplierBySearchCriteriaUrl = supplierHostname + supplierSearchCriteriaUrl;
	}

	public List<Supplier> getAll() {
		SuppliersResponse response = restTemplate.getForObject(supplierBySearchCriteriaUrl, SuppliersResponse.class);
		if (response != null && !response.getResponseBody().isEmpty()) {
			return response.getResponseBody();
		}
		return new ArrayList<>();
	}

	public Supplier getByCode(String code) {
		StringBuilder tempUrl = new StringBuilder(supplierBySearchCriteriaUrl);
		tempUrl.append("?code=");
		tempUrl.append(code);

		SuppliersResponse response = restTemplate.getForObject(tempUrl.toString(), SuppliersResponse.class);
		if (response != null && !response.getResponseBody().isEmpty()) {
			return response.getResponseBody().get(0);
		}
		return null;
	}

}
