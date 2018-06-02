package com.onlineCompetitionSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "zahtjev")
public class Zahtjev {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zahtjev_id")
	private int id;
	
	
	@Column(name = "naziv_zahtjeva")
	private String naziv_zahtjeva;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "status")
	private String status;


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
	
	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNaziv_zahtjeva() {
		return naziv_zahtjeva;
	}

	public void setNaziv_zahtjeva(String naziv_zahtjeva) {
		this.naziv_zahtjeva = naziv_zahtjeva;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
