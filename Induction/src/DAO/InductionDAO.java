package DAO;

import java.util.List;
import java.util.Map;

import exceptions.CustomException;
import models.Induction;

public interface InductionDAO {
	List<Integer> getAllInductions();

	public List<Induction> getInductionById(Integer id);

	public void insertEmployee(Induction induction) throws CustomException;

	public List<Integer> getAllEmploymentOffers();

	void updateEmploymentOfferStatus(int offerId, String status);

	Integer getIndex();

	Map<Integer, Integer> getEmployeeOfferedIdMaxMap(List<Integer> hd);

	int getCountOfOfferIdentity(int id);

	Map<Integer, Integer> getEmploymentInductionDocCountMap(List<Integer> hd);

	int getEmploymentInductionDocCount(int id);
}
