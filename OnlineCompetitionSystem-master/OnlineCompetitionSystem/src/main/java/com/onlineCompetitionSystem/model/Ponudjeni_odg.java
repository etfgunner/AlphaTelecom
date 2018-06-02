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
@Table(name = "ponudjeni_odg")
public class Ponudjeni_odg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ponudjeni_odg_id")
	private int id;
	
	@Column(name = "opcija_1")
	private String opcija_1;
	
	@Column(name = "opcija_2")
	private String opcija_2;
	
	@Column(name = "opcija_3")
	private String opcija_3;
	
	@Column(name = "opcija_4")
	private String opcija_4;
	
	public Pitanje getPitanje() {
		return pitanje;
	}

	public void setPitanje(Pitanje pitanje) {
		this.pitanje = pitanje;
	}

	@Column(name = "opcija_5")
	private String opcija_5;
	
	@ManyToOne
    @JoinColumn(name = "pitanjeid")
	private Pitanje pitanje;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpcija_1() {
		return opcija_1;
	}

	public void setOpcija_1(String opcija_1) {
		this.opcija_1 = opcija_1;
	}

	public String getOpcija_2() {
		return opcija_2;
	}

	public void setOpcija_2(String opcija_2) {
		this.opcija_2 = opcija_2;
	}

	public String getOpcija_3() {
		return opcija_3;
	}

	public void setOpcija_3(String opcija_3) {
		this.opcija_3 = opcija_3;
	}

	public String getOpcija_4() {
		return opcija_4;
	}

	public void setOpcija_4(String opcija_4) {
		this.opcija_4 = opcija_4;
	}

	public String getOpcija_5() {
		return opcija_5;
	}

	public void setOpcija_5(String opcija_5) {
		this.opcija_5 = opcija_5;
	}
	
	

}
