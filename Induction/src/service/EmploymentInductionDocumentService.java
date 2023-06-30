package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.EmploymentInductionDocumentDAO;
import models.EmploymentInductionDocument;
import models.EmploymentInductionDocumentViewModel;

@Service
public class EmploymentInductionDocumentService implements EmploymentInductionDocumentServiceInterface {

	private EmploymentInductionDocumentDAO docDAO;
	private final Logger logger = LoggerFactory.getLogger(EmploymentInductionDocumentService.class);

	@Autowired
	EmploymentInductionDocumentService(EmploymentInductionDocumentDAO docDAO) {
		this.docDAO = docDAO;
	}

	public void addCandidateInductionDocument(EmploymentInductionDocument document) {
		logger.info("--------Adding Candidate induction document------------");
		docDAO.addEmploymentInductionDocument(document);// moves to the DAO class to add the documents
		logger.info("--------Employment Candidate document added successfully--------------");
	}

	public List<EmploymentInductionDocumentViewModel> getAllDocuments() {
		logger.info("Retrieving all employment induction documents");
		return docDAO.getAllDocuments();// to get the document list
	}

}
