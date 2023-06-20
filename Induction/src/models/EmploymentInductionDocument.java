package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_employmentinductiondocuments")
public class EmploymentInductionDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emid_docindex")
	private int documentIndex;

	@Column(name = "empl_id", insertable = false, updatable = false)
	private int emplid;// employe offer id

	@Column(name = "emid_idty_id", insertable = false, updatable = false)
	private int emplidty;// employee offer document type

	@Column(name = "emid_document")
	private byte[] documentData;

	@Column(name = "emid_processed_ausr_id", insertable = false, updatable = false)
	private int indcProcessedAusrId;

	@Column(name = "emid_verified")
	private String verified;

	// Parameterized Constructor
	public EmploymentInductionDocument(int emplid, int emplidty, byte[] documentData, int indcProcessedAusrId,
			String verified) {
		this.emplid = emplid;
		this.emplidty = emplidty;
		this.documentData = documentData;
		this.indcProcessedAusrId = indcProcessedAusrId;
		this.verified = verified;
	}

	// Default Constructor
	public EmploymentInductionDocument() {
	}

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

	public int getEmplidty() {
		return emplidty;
	}

	public void setEmplidty(int emplidty) {
		this.emplidty = emplidty;
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

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

}
