
package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import models.EmploymentInductionDocument;
import models.EmploymentInductionDocumentViewModel;

@Component
public class EmploymentInductionDocDAOImpl implements EmploymentInductionDocumentDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addEmploymentInductionDocument(EmploymentInductionDocument document) {
		// to add Documents submitted at induction into the EmploymentInductionDocument table
		entityManager.persist(document);
	}

	@Override
	public List<EmploymentInductionDocumentViewModel> getAllDocuments() {
		// to get all the Documents submitted at induction from the EmploymentInductionDocument table
		String queryString = "SELECT e.emplid, e.emplidty, e.documentData, e.verified FROM EmploymentInductionDocument e WHERE e.emplid IS NOT NULL AND e.emplidty IS NOT NULL AND e.documentData IS NOT NULL AND e.verified IS NOT NULL";
		Query query = entityManager.createQuery(queryString);
		// return (List<EmploymentInductionDocumentViewModel>) query.getResultList();

		List<Object[]> results = query.getResultList();
		List<EmploymentInductionDocumentViewModel> documents = new ArrayList<>();

		for (Object[] result : results) {
			int emplid = (int) result[0];
			int emid_idty_id = (int) result[1];
			String documentData = (String) result[2];
			String verified = (String) result[3];

			EmploymentInductionDocumentViewModel document = new EmploymentInductionDocumentViewModel(emplid,
					emid_idty_id, documentData, verified);
			documents.add(document);
		}

		return documents;
	}

}
