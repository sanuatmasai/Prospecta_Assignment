package com.prospecta.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry implements Serializable{

	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	
	@JsonProperty("API")
	private String API;
	
	@JsonProperty("Description")
	private String Description;
	
	@JsonProperty("Auth")
	private String Auth;
	
	@JsonProperty("HTTPS")
	private boolean HTTPS;
	
	@JsonProperty("Cors")
	private String Cors;
	
	@JsonProperty("Category")
	private String Category;
}
