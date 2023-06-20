package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_insuctiondocumenttypes")
public class InductionDocumentTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idty_id")
	private int documentTypeId;

	@Column(name = "idty_code")
	private String code;

	@Column(name = "idty_title")
	private String title;

	@Column(name = "idty_desc")
	private String description;

	public int getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(int documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Constructors, getters, and setters
}
