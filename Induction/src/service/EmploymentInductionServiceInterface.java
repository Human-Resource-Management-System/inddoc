package service;

import java.util.List;

import models.OfferDiffModel;

public interface EmploymentInductionServiceInterface {

	Integer getid();

	List<OfferDiffModel> getAllEmploymentOffers();

	String getStatusById(Integer indcEmofId);

}
