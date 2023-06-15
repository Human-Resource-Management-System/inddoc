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

	// Constructors, getters, and setters
}
