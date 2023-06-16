
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import models.EmploymentInductionDocument;

@Component
public class EmploymentInductionDocDAOImpl {

	private EntityManagerFactory entityManagerFactory;

	@PersistenceContext
	private EntityManager entityManager;

	public void addEmploymentInductionDocument(EmploymentInductionDocument document) {
		entityManager.persist(document);
	}

	public EmploymentInductionDocument getEmploymentInductionDocument(int documentIndex) {
		return entityManager.find(EmploymentInductionDocument.class, documentIndex);
	}

}
