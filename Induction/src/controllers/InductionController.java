
package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.InductionDAO;
import models.EmploymentInductionDocument;
import models.EmploymentInductionDocumentViewModel;
import models.Induction;
import models.SaveInductioninput;
import models.addinductionDOC;
import service.EmploymentInductionDocumentServiceInterface;
import service.EmploymentInductionServiceInterface;

@Controller
public class InductionController {

	@Autowired
	private EmploymentInductionDocumentServiceInterface docServ; // injecting service class object

	@Autowired
	private EmploymentInductionServiceInterface indServ; // injecting service class object

	@Autowired
	private EmploymentInductionDocument document; // injecting Document Entity Model class object

	@Autowired
	private InductionDAO idao;// injecting DAO class object

	@Autowired
	private Induction induction; // injecting induction class object

	@RequestMapping("/inductionlist") // view the list of inductions conducted
	public String showEmployees(Model model) {
		List<Integer> inductions = idao.getAllInductions();
		model.addAttribute("inductions", inductions);
		return "inductions"; // opens the inductions.jsp page
	}

	@RequestMapping("/getinductiondetails") // shows the data regarding selected induction
	public String getEmployeeDetails(@RequestParam("id") Integer indid, Model model) {
		List<Induction> i = idao.getInductionById(indid);
		model.addAttribute("indid", i);
		model.addAttribute("ID", indid);
		return "inductiondetails"; // opens the inductiondetails.jsp page
	}

	@RequestMapping(value = "/inductioninsert", method = RequestMethod.GET) // to insert into induction
	public String createInduction(Model model) {
		List<Integer> hd = idao.getAllEmploymentOffers(); // moves to the InductionDAO class to get data
		model.addAttribute("employmentOffers", hd);
		return "createInduction"; // opens the createInduction.jsp page
	}

	@RequestMapping(value = "/inductionsave", method = RequestMethod.POST) // for saving the induction
	public String saveInduction(@ModelAttribute SaveInductioninput request, Model model) {
		List<Induction> inductions = new ArrayList<>(); // Create the Induction objects
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (Integer indcEmofId : request.getIndcEmofId()) {
			if (request.getIndcId().equals("same")) {
				induction.setIndcId(indServ.getid());// goes to the getid method in EmploymentInductionService class
			} else {
				induction.setIndcId(indServ.getidNext());// goes to the getidNext method in EmploymentInductionService
															// class
			}
			induction.setIndcEmofId(indcEmofId);
			induction.setIndcProcessedAusrId(request.getIndcProcessedAusrId());
			induction.setIndcStatus(request.getIndcStatus());
			try {
				Date date = dateFormat.parse(request.getIndcDate());
				induction.setIndcDate(new java.sql.Date(date.getTime()));
			} catch (ParseException e) {// Set an error message to be displayed to the user
				model.addAttribute("errorMessage", "Invalid date format. Please enter a valid date.");
				return "errorPage"; // Return the errorPage view
			}
			inductions.add(induction);
			// moves to the InductionDAO class to insert the candidates participated in the induction
			idao.insertEmployee(induction);
			// moves to the InductionDAO class to update the status in employeeoffer table
			idao.updateEmploymentOfferStatus(indcEmofId, "INDC");
		}
		List<Integer> induc = idao.getAllInductions();// goes to the getAllInductions method in DAO class
		model.addAttribute("inductions", induc);
		return "inductions"; // opens the inductions.jsp page
	}

	@GetMapping("/getform") // previews the form to fill and upload document
	public String getform(Model model) {
		// moves to the EmploymentInductionDocumentService class to get all document
		List<EmploymentInductionDocumentViewModel> doc = docServ.getAllDocuments();
		model.addAttribute("doc", doc);
		return "InductionDocument"; // opens the InductionDocument jsp page
	}

	@GetMapping("/add") // to save the induction documents
	public String addDocument(@ModelAttribute addinductionDOC input) {
		// Map the properties from the input model to the entity model
		document.setEmplid(input.getEmploymentOfferId());
		document.setEmplidty(input.getDocumentTypeId());
		document.setIndcProcessedAusrId(input.getProcessedUserId());
		document.setVerified(input.getVerified());
		String path = input.getDocumentData().getAbsolutePath();
		document.setDocumentData(path);
		// moves to the EmploymentInductionDocumentService class to insert document
		docServ.addEmploymentInductionDocument(document);
		return "success";
	}
}
