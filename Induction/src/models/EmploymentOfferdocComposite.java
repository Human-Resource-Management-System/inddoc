package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmploymentOfferdocComposite implements Serializable {

	@Column(name = "eofd_id", insertable = false, updatable = false)
	private Integer offerid;

	@Column(name = "eofd_docindex", insertable = false, updatable = false)
	private int documentIndex;

	public Integer getOfferid() {
		return offerid;
	}

	public void setOfferid(Integer offerid) {
		this.offerid = offerid;
	}

	public int getDocumentIndex() {
		return documentIndex;
	}

	public void setDocumentIndex(int documentIndex) {
		this.documentIndex = documentIndex;
	}

}