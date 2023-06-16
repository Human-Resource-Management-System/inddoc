package DAO;

import java.util.List;

import models.EmploymentInductionDocument;

public interface EmploymentInductionDocumentDAO {

	void addEmploymentInductionDocument(EmploymentInductionDocument document);

	EmploymentInductionDocument getEmploymentInductionDocument(int documentIndex);

	List<EmploymentInductionDocument> getAllDocuments();

	// Other methods for updating and deleting EmploymentInductionDocuments can be added here
}
