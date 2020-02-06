package com.yess.yessdemo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@Entity
@Table(name = "KLASS")
@Data @NoArgsConstructor @AllArgsConstructor 
public class Klass implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String label;
	@Column
	private String description;
	@OneToMany(mappedBy = "klass")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private List<Student> students;
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	

	

}
