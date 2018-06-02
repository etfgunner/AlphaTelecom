package com.onlineCompetitionSystem.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pitanje")
public class Pitanje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pitanje_id")
	private int id;
	
	@Column(name = "tekst_pitanja")
	private String tekst_pitanja;
	
	@Column(name = "tacan_odg")
	private String tacan_odg;	

	public Set<Ponudjeni_odg> getPonudjeni_odg() {
		return ponudjeni_odg;
	}

	public void setPonudjeni_odg(Set<Ponudjeni_odg> ponudjeni_odg) {
		this.ponudjeni_odg = ponudjeni_odg;
	}

	public Set<Pregledanje> getPregledanja() {
		return pregledanja;
	}

	public void setPregledanja(Set<Pregledanje> pregledanja) {
		this.pregledanja = pregledanja;
	}

	@Column(name = "broj_bodova")
	private int broj_bodova;
	
	@ManyToOne
    @JoinColumn(name = "takmicenjeid")
	private Takmicenje takmicenje;
	
	@OneToMany(mappedBy = "pitanje", cascade = CascadeType.ALL)
	private Set<Ponudjeni_odg> ponudjeni_odg;
	
	@OneToMany(mappedBy = "pitanje", cascade = CascadeType.ALL)
	private Set<Pregledanje> pregledanja;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTekst_pitanja() {
		return tekst_pitanja;
	}

	public void setTekst_pitanja(String tekst_pitanja) {
		this.tekst_pitanja = tekst_pitanja;
	}

	public String getTacan_odg() {
		return tacan_odg;
	}

	public void setTacan_odg(String tacan_odg) {
		this.tacan_odg = tacan_odg;
	}

	public int getBroj_bodova() {
		return broj_bodova;
	}

	public void setBroj_bodova(int broj_bodova) {
		this.broj_bodova = broj_bodova;
	}
	
	public Takmicenje getTakmicenje() {
		return takmicenje;
	}

	public void setTakmicenje(Takmicenje takmicenje) {
		this.takmicenje = takmicenje;
	}

}
