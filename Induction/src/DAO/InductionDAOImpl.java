package DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import models.Induction;

@Repository
public class InductionDAOImpl implements InductionDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Integer> getAllInductions() {// to get all the inductions list
		String query = "SELECT DISTINCT i.indcId FROM Induction i ORDER BY i.indcId DESC";
		return entityManager.createQuery(query, Integer.class).getResultList();
	}

	@Override
	@Transactional
	public List<Induction> getInductionById(Integer id) {
		TypedQuery<Induction> parameterQuery = entityManager
				.createQuery("SELECT i FROM Induction i WHERE i.indcId = :id", Induction.class);
		parameterQuery.setParameter("id", id);
		return parameterQuery.getResultList();
	}

	@Override
	@Transactional
	public void insertEmployee(Induction induction) {// to insert the selected into the induction
		entityManager.persist(induction);
	}

	@Override
	@Transactional //
	public List<Integer> getAllEmploymentOffers() {// to get the list of employeeoffer id inorder to select for the
													// inductions
		String query = "SELECT o.candidateId FROM HrmsEmploymentOffer o WHERE o.status='INPR'";
		return entityManager.createQuery(query, Integer.class).getResultList();
	}

	@Override
	@Transactional
	public void updateEmploymentOfferStatus(int offerId, String status) {// to update the status in the employment offer
																			// table after attending induction
		String query = "UPDATE HrmsEmploymentOffer SET eofr_status = :status WHERE candidateId = :offerId";
		entityManager.createQuery(query).setParameter("status", status).setParameter("offerId", offerId)
				.executeUpdate();
	}

	@Override
	@Transactional
	public Integer getIndex() {
		String query = "SELECT MAX(ind.indcId) FROM Induction ind";
		TypedQuery<Integer> typedQuery = entityManager.createQuery(query, Integer.class);
		Integer maxId = typedQuery.getSingleResult();
		return maxId != null ? maxId + 1 : 1;
	}

	@Override
	public Map<Integer, Integer> getEmployeeOfferedIdMaxMap(List<Integer> hd) {
		Map<Integer, Integer> maxMap = new HashMap<>();
		for (Integer id : hd) {
			int count = getCountOfOfferIdentity(id);
			maxMap.put(id, count);
		}
		return maxMap;
	}

	@Override
	public int getCountOfOfferIdentity(int id) {
		String query = "SELECT COUNT(e.offeridentity) FROM EmploymentOfferDocument e WHERE e.offerid = :id";

		TypedQuery<Long> typedQuery = entityManager.createQuery(query, Long.class);
		typedQuery.setParameter("id", id);

		Long count = typedQuery.getSingleResult();

		return count.intValue();
	}

	@Override
	public Map<Integer, Integer> getEmploymentInductionDocCountMap(List<Integer> hd) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (Integer id : hd) {
			int count = getEmploymentInductionDocCount(id);
			countMap.put(id, count);
		}
		return countMap;
	}

	@Override
	public int getEmploymentInductionDocCount(int id) {
		String query = "SELECT COUNT(e.emplidty) FROM EmploymentInductionDocument e WHERE e.id = :id";

		TypedQuery<Long> typedQuery = entityManager.createQuery(query, Long.class);
		typedQuery.setParameter("id", id);

		Long count = typedQuery.getSingleResult();

		return count.intValue();
	}

}
