package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.EmploymentInductionDocumentDAO;
import models.EmploymentInductionDocument;
import models.EmploymentInductionDocumentViewModel;

@Service
public class EmploymentInductionDocumentService implements EmploymentInductionDocumentServiceInterface {

	private EmploymentInductionDocumentDAO docDAO;

	@Autowired
	EmploymentInductionDocumentService(EmploymentInductionDocumentDAO docDAO) {
		this.docDAO = docDAO;
	}

	public void addEmploymentInductionDocument(EmploymentInductionDocument document) {
		docDAO.addEmploymentInductionDocument(document);// moves to the DAO class to add the documents
	}

	public List<EmploymentInductionDocumentViewModel> getAllDocuments() {
		return docDAO.getAllDocuments();// to get the document list
	}

}
