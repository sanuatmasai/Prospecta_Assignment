package com.prospecta.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.dto.AllAPIDataDTO;
import com.prospecta.dto.RequiredDataDTO;
import com.prospecta.exception.EntryDataException;
import com.prospecta.model.Entry;
import com.prospecta.repository.EntryDAO;
import com.prospecta.service.EntryService;

@Service
public class EntryServiceImpl implements EntryService{
	
	public static boolean allDataInDB = false;
	
	@Autowired
	private EntryDAO eRepo;

	@Override
	public List<RequiredDataDTO> getRequiredListbyCategory(String category) throws EntryDataException {
		AllAPIDataDTO allEntry = new RestTemplate().getForObject("https://api.publicapis.org/entries", AllAPIDataDTO.class);
		
		List<RequiredDataDTO> RequiredDataList = allEntry.getEntries().stream()
																	  .filter(entry -> entry.getCategory().equals(category))
																	  .map(entry -> new RequiredDataDTO(entry.getAPI(), entry.getDescription()))
																	  .collect(Collectors.toList());


		//when no entry is found with the given category, we should throw checked Exception
		if(RequiredDataList.size() == 0)  throw new EntryDataException("No entry found with category " + category);
		
		return RequiredDataList;
	}

	@Override
	public Entry addNewEntry(Entry entry) throws EntryDataException {
		
		AllAPIDataDTO allEntry = new RestTemplate().getForObject("https://api.publicapis.org/entries", AllAPIDataDTO.class);
		
		allEntry.getEntries().add(entry);
		allEntry.setCount(allEntry.getEntries().size());
		
		if(!allDataInDB) {
			allEntry.getEntries().stream().forEach(e -> eRepo.save(e));
			allDataInDB = true;
		}else {
			eRepo.save(entry);
		}
		
		return entry;
	}

}
