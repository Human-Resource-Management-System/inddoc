package DAO;

import java.util.List;

import models.EmploymentInductionDocument;
import models.EmploymentInductionDocumentViewModel;

public interface EmploymentInductionDocumentDAO {

	void addEmploymentInductionDocument(EmploymentInductionDocument document);

	List<EmploymentInductionDocumentViewModel> getAllDocuments();
}
