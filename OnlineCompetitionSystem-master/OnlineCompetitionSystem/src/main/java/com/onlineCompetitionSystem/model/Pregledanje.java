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
@Table(name = "pregledanje")
public class Pregledanje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pregledanje_id")
	private int id;
	
	@Column(name = "odabrani_odg")
	private String odabrani_odg;
	
	@ManyToOne
    @JoinColumn(name = "pitanjeid")
	private Pitanje pitanje;
	
	@ManyToOne
    @JoinColumn(name = "userid")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOdabrani_odg() {
		return odabrani_odg;
	}

	public void setOdabrani_odg(String odabrani_odg) {
		this.odabrani_odg = odabrani_odg;
	}

	public Pitanje getPitanje() {
		return pitanje;
	}

	public void setPitanje(Pitanje pitanje) {
		this.pitanje = pitanje;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
