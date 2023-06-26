package models;

import java.io.Serializable;

public class InductionId implements Serializable {

	private Integer indcId;
	private Integer indcEmofId;

	public Integer getIndcId() {
		return indcId;
	}

	public void setIndcId(Integer indcId) {
		this.indcId = indcId;
	}

	public Integer getIndcEmofId() {
		return indcEmofId;
	}

	public void setIndcEmofId(Integer indcEmofId) {
		this.indcEmofId = indcEmofId;
	}

}