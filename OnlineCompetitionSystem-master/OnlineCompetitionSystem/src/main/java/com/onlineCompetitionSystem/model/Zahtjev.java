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
	private int naziv_zahtjeva;
	
	@Column(name = "text")
	private int text;
	
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

	private int getNaziv_zahtjeva() {
		return naziv_zahtjeva;
	}

	private void setNaziv_zahtjeva(int naziv_zahtjeva) {
		this.naziv_zahtjeva = naziv_zahtjeva;
	}

	private int getText() {
		return text;
	}

	private void setText(int text) {
		this.text = text;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
