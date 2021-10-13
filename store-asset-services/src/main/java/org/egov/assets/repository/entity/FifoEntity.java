package org.egov.assets.repository.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FifoEntity {
	
	private String receiptId;

	private String receiptDetailId;

	private String receiptDetailPODetailId;

	private Long receiptDate;

	private String mrnNumber;

	private String material;

	private String uomNo;

	private Double balance;

	private Double unitRate;

	private String receiptDetailAddnInfoId;

}
