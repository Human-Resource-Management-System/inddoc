package service;

import java.util.List;

import models.EmploymentInductionDocument;
import models.EmploymentInductionDocumentViewModel;

public interface EmploymentInductionDocumentServiceInterface {
	public void addEmploymentInductionDocument(EmploymentInductionDocument document);

	public List<EmploymentInductionDocumentViewModel> getAllDocuments();
}
