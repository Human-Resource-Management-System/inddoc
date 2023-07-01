package TestControllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DAO.InductionDAO;
import controllers.InductionController;
import models.Induction;
import service.EmploymentInductionDocumentServiceInterface;
import service.EmploymentInductionServiceInterface;

public class TestInductionController {

	@Mock
	@Autowired
	private InductionDAO idao;

	@Mock
	@Autowired
	private EmploymentInductionServiceInterface indServ;

	@Mock
	@Autowired
	private EmploymentInductionDocumentServiceInterface docServ;

	@InjectMocks
	@Autowired
	private InductionController inductionController;

	@BeforeMethod

	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetOfferedCandidates() {
		// Prepare test data
		List<Integer> inductions = Arrays.asList(1, 2, 3);

		// Define the behavior of the mock object
		when(idao.getAllInductions()).thenReturn(inductions);

		// Call the method under test
		String result = inductionController.getOfferedCandidates(mock(Model.class));

		// Verify the result and interactions
		assertEquals(result, "inductions");

	}

	@Test
	public void testGetCandidateDetails() {
		// Prepare test data
		Integer indid = 1;
		List<Induction> inductions = new ArrayList<>();
		inductions.add(new Induction());
		Model model = Mockito.mock(Model.class);
		// Define the behavior of the mock InductionDAO
		when(idao.getInductionById(indid)).thenReturn(inductions);
		when(model.addAttribute("indid", inductions)).thenReturn(model);

		// Call the method under test
		String result = inductionController.getCandidateDetails(indid, model);

		// Verify the interaction with the mock InductionDAO and the result
		verify(idao, times(1)).getInductionById(indid);
		verify(model, times(1)).addAttribute("indid", inductions);
		verify(model, times(1)).addAttribute("ID", indid);
		assertEquals(result, "inductiondetails");
	}
}