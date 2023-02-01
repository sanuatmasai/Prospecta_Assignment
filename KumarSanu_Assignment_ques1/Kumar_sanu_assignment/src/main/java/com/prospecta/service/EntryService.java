package com.prospecta.service;

import java.util.List;

import com.prospecta.dto.RequiredDataDTO;
import com.prospecta.exception.EntryDataException;
import com.prospecta.model.Entry;

public interface EntryService {

	public List<RequiredDataDTO> getRequiredListbyCategory(String category) throws EntryDataException;
	
	public Entry addNewEntry(Entry entry) throws EntryDataException;
}
