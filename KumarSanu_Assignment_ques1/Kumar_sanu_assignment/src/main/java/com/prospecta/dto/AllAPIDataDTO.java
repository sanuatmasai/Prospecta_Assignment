package com.prospecta.dto;

import java.io.Serializable;
import java.util.List;

import com.prospecta.model.Entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllAPIDataDTO implements Serializable{

	private Integer count;
	private List<Entry> entries;
}
