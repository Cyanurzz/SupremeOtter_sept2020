package com.Cyanurzz.SupremeOtter.entity.contentGame;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.Cyanurzz.SupremeOtter.entity.Game;

@Entity
public class Content {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "messagekey")
	private final String key = "game.content";
	
	@Column
	private String locale;
	
	@Column
	@NotNull(message="Champs Vide")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {  CascadeType.REFRESH  })
	@JoinColumn(name = "game_id")
	private Game game;

	
	
	public Content() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	
	public String getKey() {
		return key;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	
	
	
	
}
