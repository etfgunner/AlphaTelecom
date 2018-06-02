package com.onlineCompetitionSystem.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "takmicenje")
public class Takmicenje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "takmicenje_id")
	private int id;
	
	@Column(name = "naziv")
	private String naziv;
	
	@Column(name = "trajanje")
	private int trajanje;
	
	@ManyToMany(mappedBy = "takmicenja")
	private Set<User> users;
	
	@OneToMany(mappedBy = "takmicenje", cascade = CascadeType.ALL)
	private Set<Pitanje> pitanja;
	
	@OneToMany(mappedBy = "takmicenje", cascade = CascadeType.ALL)
	private Set<Rezultati> rezultati;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Pitanje> getPitanja() {
		return pitanja;
	}

	public void setPitanja(Set<Pitanje> pitanja) {
		this.pitanja = pitanja;
	}

	public Set<Rezultati> getRezultati() {
		return rezultati;
	}

	public void setRezultati(Set<Rezultati> rezultati) {
		this.rezultati = rezultati;
	}

	public int getTrajanje() {
		return trajanje;
	}
	
	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	

}
