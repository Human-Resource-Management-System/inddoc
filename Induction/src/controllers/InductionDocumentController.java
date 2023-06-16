package controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import models.EmploymentInductionDocument;
import service.EmploymentInductionDocumentService;

@Controller
public class InductionDocumentController {

	@Autowired
	private EmploymentInductionDocumentService docServ;

	@PostMapping("/documents/add")
	public String addDocument(@ModelAttribute("document") EmploymentInductionDocument document,
			@RequestParam("file") MultipartFile file) {
		try {
			// Set the file data in the document
			document.setDocumentData(file.getBytes());
			// Save the document using the service
			docServ.addEmploymentInductionDocument(document, file);
		} catch (IOException e) {
			e.printStackTrace();
			// Handle the exception as needed
		}
		return "redirect:/documents";
	}

	@GetMapping("/documents")
	public String getDocuments(Model model) {
		// Retrieve all documents using the service
		model.addAttribute("documents", docServ.getAllDocuments());
		return "documents";
	}

	@PostMapping("/documents/save")
	public String saveDocument(@ModelAttribute("document") EmploymentInductionDocument document,
			@RequestParam("file") MultipartFile file) {
		try {
			// Set the file data in the document
			document.setDocumentData(file.getBytes());
			// Save the document using the service
			docServ.saveEmploymentInductionDocument(document, file);
		} catch (IOException e) {
			e.printStackTrace();
			// Handle the exception as needed
		}
		return "redirect:/documents";
	}

	@GetMapping("/documents/download")
	public ResponseEntity<Resource> downloadDocument(@RequestParam("documentIndex") int documentIndex) {
		// Retrieve the document file using the service
		File documentFile = docServ.getEmploymentInductionDocumentFile(documentIndex);
		// Prepare the file as a resource for download
		Resource fileResource = new FileSystemResource(documentFile);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\"" + StringUtils.cleanPath(documentFile.getName()) + "\"")
				.body(fileResource);
	}

}
