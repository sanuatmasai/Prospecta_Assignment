package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.dto.RequiredDataDTO;
import com.prospecta.exception.EntryDataException;
import com.prospecta.model.Entry;
import com.prospecta.service.EntryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/entries")
public class APIController {
	
	@Autowired
	private EntryService dService;

	//Handler to get the list of requiredData on the basis of category.
	@GetMapping("/{category}")
	public ResponseEntity<List<RequiredDataDTO>> getListbyCategoryHandler(@PathVariable String category) throws EntryDataException{
		
		return new ResponseEntity<List<RequiredDataDTO>>(dService.getRequiredListbyCategory(category), HttpStatus.OK);
	}
	
	//Handler to save newly created Entry.
	@PostMapping("/add")
	public ResponseEntity<Entry> addEntryHandler(@RequestBody Entry entry) throws EntryDataException{
		
		return new ResponseEntity<Entry>(dService.addNewEntry(entry), HttpStatus.ACCEPTED);
	}
}
