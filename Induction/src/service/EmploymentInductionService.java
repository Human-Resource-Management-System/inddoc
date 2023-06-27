package service;

import org.springframework.beans.factory.annotation.Autowired;

import DAO.InductionDAO;

public class EmploymentInductionService implements EmploymentInductionServiceInterface {

	@Autowired
	private InductionDAO idao;// injecting DAO class object

	public Integer getid() {
		return idao.getIndex();// to get the last recently conducted index of induction id
	}

	public Integer getidNext() {

		int i = idao.getIndex();// to get the last recently conducted index of induction id
		return i + 1;// for next index
	}

}
