package com.yess.yessdemo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTMENT")
@Data @NoArgsConstructor @AllArgsConstructor 
public class Department implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String label;
	@Column
	private String description;
	@OneToMany(mappedBy = "department")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private List<Klass> klasses;

	

}
