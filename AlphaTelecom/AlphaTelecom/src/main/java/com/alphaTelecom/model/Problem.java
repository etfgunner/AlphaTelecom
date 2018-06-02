package com.alphaTelecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "problem")
public class Problem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "problem_id")
	private int id;
	
	
	@Column(name = "naziv_problema")
	private String naziv_problema;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "incident")
	private String incident;

	@ManyToOne
    @JoinColumn(name = "userid")
	private User user;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public User getUser() {
		return user;
	}

	public String getNaziv_problema() {
		return naziv_problema;
	}

	public void setNaziv_problema(String naziv_problema) {
		this.naziv_problema = naziv_problema;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIncident() {
		return incident;
	}

	public void setIncident(String incident) {
		this.incident = incident;
	}
}
