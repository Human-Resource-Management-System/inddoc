package models;

import org.springframework.web.multipart.MultipartFile;

public class addinductionDOC {
	private int emplid;
	private int employmentOfferId;
	private int documentTypeId;
	private MultipartFile documentData;
	private int processedUserId;
	private String verified;

	// Getters and setters

	public int getEmplid() {
		return emplid;
	}

	public void setEmplid(int emplid) {
		this.emplid = emplid;
	}

	public int getEmploymentOfferId() {
		return employmentOfferId;
	}

	public void setEmploymentOfferId(int employmentOfferId) {
		this.employmentOfferId = employmentOfferId;
	}

	public int getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(int documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public MultipartFile getDocumentData() {
		return documentData;
	}

	public void setDocumentData(MultipartFile documentData) {
		this.documentData = documentData;
	}

	public int getProcessedUserId() {
		return processedUserId;
	}

	public void setProcessedUserId(int processedUserId) {
		this.processedUserId = processedUserId;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public EmploymentOfferDocument getDocumentType() {
		// TODO Auto-generated method stub
		return null;
	}

	public adminusers getProcessedUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public HrmsEmploymentOffer getEmploymentOffer() {
		// TODO Auto-generated method stub
		return null;
	}
}
