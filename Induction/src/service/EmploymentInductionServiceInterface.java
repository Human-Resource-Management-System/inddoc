package service;

import java.util.List;

import models.OfferDiffModel;

public interface EmploymentInductionServiceInterface {

	Integer getidNext();

	Integer getid();

	List<OfferDiffModel> getAllEmploymentOffers();

}
