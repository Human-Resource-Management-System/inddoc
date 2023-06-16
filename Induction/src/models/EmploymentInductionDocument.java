package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_employmentinductiondocuments")
public class EmploymentInductionDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emid_docindex")
	private int documentIndex;

	@Column(name = "empl_id")
	private int emplid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empl_id", referencedColumnName = "eofr_cand_id", insertable = false, updatable = false)
	private HrmsEmploymentOffer employmentOffer;

	@Column(name = "emid_idty_id")
	private int emplidty;

	@ManyToOne
	@JoinColumn(name = "emid_idty_id", referencedColumnName = "eofd_idty_id")
	private EmploymentOfferDocument documentType;

	@Column(name = "emid_document")
	private byte[] documentData;

	@Column(name = "emid_processed_ausr_id")
	private int indcProcessedAusrId;

	@ManyToOne
	@JoinColumn(name = "emid_processed_ausr_id", referencedColumnName = "ausr_id")
	private HrmsEmploymentOffer processedUser;

	@Column(name = "emid_verified")
	private String verified;

	public int getDocumentIndex() {
		return documentIndex;
	}

	public void setDocumentIndex(int documentIndex) {
		this.documentIndex = documentIndex;
	}

	public int getEmplid() {
		return emplid;
	}

	public void setEmplid(int emplid) {
		this.emplid = emplid;
	}

	public HrmsEmploymentOffer getEmploymentOffer() {
		return employmentOffer;
	}

	public void setEmploymentOffer(HrmsEmploymentOffer employmentOffer) {
		this.employmentOffer = employmentOffer;
	}

	public int getEmplidty() {
		return emplidty;
	}

	public void setEmplidty(int emplidty) {
		this.emplidty = emplidty;
	}

	public EmploymentOfferDocument getDocumentType() {
		return documentType;
	}

	public void setDocumentType(EmploymentOfferDocument documentType) {
		this.documentType = documentType;
	}

	public byte[] getDocumentData() {
		return documentData;
	}

	public void setDocumentData(byte[] documentData) {
		this.documentData = documentData;
	}

	public int getIndcProcessedAusrId() {
		return indcProcessedAusrId;
	}

	public void setIndcProcessedAusrId(int indcProcessedAusrId) {
		this.indcProcessedAusrId = indcProcessedAusrId;
	}

	public HrmsEmploymentOffer getProcessedUser() {
		return processedUser;
	}

	public void setProcessedUser(HrmsEmploymentOffer processedUser) {
		this.processedUser = processedUser;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

}
