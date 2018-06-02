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
@Table(name = "problem")
public class Problem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "problem_id")
	private int id;
	
	
	@Column(name = "naziv_problema")
	private int naziv_problema;
	
	@Column(name = "text")
	private int text;

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

	private int getNaziv_problema() {
		return naziv_problema;
	}

	private void setNaziv_problema(int naziv_problema) {
		this.naziv_problema = naziv_problema;
	}

	private int getText() {
		return text;
	}

	private void setText(int text) {
		this.text = text;
	}

}
