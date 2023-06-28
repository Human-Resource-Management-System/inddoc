package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_inductiondocumenttypes")
public class InductionDocumentTypes {
	@Id
	@Column(name = "idty_id")
	private int documentTypeId;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EmploymentInductionDocument> employmentInductionDocument;

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

}
