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
@Table(name = "rezultati")
public class Rezultati {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rezultati_id")
	private int id;
	
	
	@Column(name = "ostvareni_bodovi")
	private int ostvareni_bodovi;

	@ManyToOne
    @JoinColumn(name = "userid")
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "takmicenjeid")
	private Takmicenje takmicenje;

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

	public Takmicenje getTakmicenje() {
		return takmicenje;
	}

	public void setTakmicenje(Takmicenje takmicenje) {
		this.takmicenje = takmicenje;
	}

	public int getOstvareni_bodovi() {
		return ostvareni_bodovi;
	}

	public void setOstvareni_bodovi(int ostvareni_bodovi) {
		this.ostvareni_bodovi = ostvareni_bodovi;
	}
	
	
}
