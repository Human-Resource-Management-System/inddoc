package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_employmentofferdocuments")
@IdClass(EmploymentOfferdocComposite.class)
public class EmploymentOfferDocument {

	@Id
	@Column(name = "eofd_id")
	private Integer offerid;

	@Id
	@Column(name = "eofd_docindex")
	private int documentIndex;

	@Column(name = "eofd_idty_id")
	private int offeridentity;

	@ManyToOne
	@JoinColumn(name = "eofd_id", referencedColumnName = "eofr_cand_id", insertable = false, updatable = false)
	private HrmsEmploymentOffer employmentOffer;

	@ManyToOne
	@JoinColumn(name = "eofd_idty_id", referencedColumnName = "idty_id", insertable = false, updatable = false)
	private InductionDocumentTypes documentType;

	// public EmploymentOfferDocument(EmploymentOfferdocComposite comp, int idtyId) {
	// this.offeridentity = idtyId;
	// this.empoff = comp;
	// }
	public Integer getOfferId() {
		return offerid;
	}

	public void setOfferId(Integer offerid) {
		this.offerid = offerid;
	}

	public InductionDocumentTypes getDocumentType() {
		return documentType;
	}

	public void setDocumentType(InductionDocumentTypes documentType) {
		this.documentType = documentType;
	}

	public int getOfferidentity() {
		return offeridentity;
	}

	public void setOfferidentity(int offeridentity) {
		this.offeridentity = offeridentity;
	}

	public HrmsEmploymentOffer getEmploymentOffer() {
		return employmentOffer;
	}

	public void setEmploymentOffer(HrmsEmploymentOffer employmentOffer) {
		this.employmentOffer = employmentOffer;
	}

}
