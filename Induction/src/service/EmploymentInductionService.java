package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import DAO.InductionDAO;
import models.OfferDiffModel;

public class EmploymentInductionService implements EmploymentInductionServiceInterface {

	private InductionDAO idao;// injecting DAO class object
	private OfferDiffModel offerDiff;

	@Autowired
	EmploymentInductionService(InductionDAO idao, OfferDiffModel offerDiff) {
		this.offerDiff = offerDiff;
		this.idao = idao;
	}

	@Override
	public Integer getid() {
		return idao.getIndex();// to get the last recently conducted index of induction id
	}

	@Override
	public Integer getidNext() {

		int i = idao.getIndex();// to get the last recently conducted index of induction id
		return i + 1;// for next index
	}

	@Override
	public List<OfferDiffModel> getAllEmploymentOffers() {
		List<Integer> hd = idao.getAllEmploymentOffers();
		Map<Integer, Integer> cntOfferTypeDocMap = idao.getEmployeeOfferedIdMaxMap(hd);
		Map<Integer, Integer> cntInductionDocTypeMap = idao.getEmploymentInductionDocCountMap(hd);
		List<OfferDiffModel> offerDiffList = new ArrayList<>();
		// Iterate over the hd list and calculate the difference between cntOfferTypeDocMap and cntInductionDocTypeMap
		for (Integer id : hd) {
			OfferDiffModel offerDiff = new OfferDiffModel();
			int maxCount = cntOfferTypeDocMap.getOrDefault(id, 0);
			int cntCount = cntInductionDocTypeMap.getOrDefault(id, 0);
			int diff = maxCount - cntCount;
			// setting the values to the attributes
			offerDiff.setOfferId(id);

			if (diff == 0) {
				offerDiff.setStatus("Submitted");
			} else if (diff == maxCount) {
				offerDiff.setStatus("No document submitted");
			} else {
				offerDiff.setStatus(diff + " documents pending");
			}
			System.out.println(diff + " the difference " + id);
			// setting the list of objects into offerDiffList list to pass the list of objects to the controller
			offerDiffList.add(offerDiff);
		}
		return offerDiffList;
	}

}
