package com.onlineCompetitionSystem.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "usluga")
public class Usluga {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usluga_id")
	private int id;
	
	@Column(name = "naziv")
	private String naziv;
	
	@Column(name = "opis")
	private String opis;
	
	@Column(name = "status")
	private String status="Na cekanju";

	
	@ManyToMany(mappedBy = "usluge")
	private Set<User> users;
	
	public Set<User> getUsers() {
		return users;
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
