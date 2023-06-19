
package DAO;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import models.EmploymentInductionDocument;

@Component
public class EmploymentInductionDocDAOImpl implements EmploymentInductionDocumentDAO {

	private EntityManagerFactory entityManagerFactory;

	@PersistenceContext
	private EntityManager entityManager;

	public void addEmploymentInductionDocument(EmploymentInductionDocument document) {
		entityManager.persist(document);
	}

	public EmploymentInductionDocument getEmploymentInductionDocument(int documentIndex) {
		return entityManager.find(EmploymentInductionDocument.class, documentIndex);
	}

	@Override
	public ArrayList<EmploymentInductionDocument> getAllDocuments() {
		String queryString = "SELECT e FROM EmploymentInductionDocument e";
		Query query = entityManager.createQuery(queryString);
		return (ArrayList<EmploymentInductionDocument>) query.getResultList();
	}

}
