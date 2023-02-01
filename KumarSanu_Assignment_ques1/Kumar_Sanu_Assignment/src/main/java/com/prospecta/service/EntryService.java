package com.prospecta.service;

import java.util.List;

import com.prospecta.dto.RequiredDataDTO;
import com.prospecta.exception.APIFetchingException;
import com.prospecta.model.Entry;

public interface EntryService {

	public List<RequiredDataDTO> getRequiredListbyCategory(String category) throws APIFetchingException;
	
	public Entry addNewEntry(Entry entry) throws APIFetchingException;
}
