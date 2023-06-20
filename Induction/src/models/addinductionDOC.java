package models;

import org.springframework.web.multipart.MultipartFile;

public class addinductionDOC {
	private int employmentOfferId;
	private int documentTypeId;
	private MultipartFile documentData;
	private int processedUserId;
	private String verified;

	public addinductionDOC() {
		// Default constructor
	}

	public addinductionDOC(int employmentOfferId, int documentTypeId, MultipartFile documentData, int processedUserId,
			String verified) {
		this.employmentOfferId = employmentOfferId;
		this.documentTypeId = documentTypeId;
		this.documentData = documentData;
		this.processedUserId = processedUserId;
		this.verified = verified;
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

}
