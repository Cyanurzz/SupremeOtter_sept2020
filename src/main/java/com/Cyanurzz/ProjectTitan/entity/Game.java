package com.Cyanurzz.ProjectTitan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.Cyanurzz.ProjectTitan.entity.contentGame.Descriptor;
import com.Cyanurzz.ProjectTitan.entity.contentGame.Gender;
import com.Cyanurzz.ProjectTitan.entity.contentGame.Platform;
@Entity
public class Game {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotBlank
	@NotNull(message="Champs Vide")
	private String title;
	
	private String subtitle;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releaseDate;

	private int classification;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "tag_game", joinColumns = @JoinColumn(name = "game_id") , inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags = new ArrayList<>();
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "platform_game", joinColumns = @JoinColumn(name = "game_id") , inverseJoinColumns = @JoinColumn(name = "platform_id"))
	List<Platform> platforms = new ArrayList<>();
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "gender_game", joinColumns = @JoinColumn(name = "game_id") , inverseJoinColumns = @JoinColumn(name = "gender_id"))
	List<Gender> genders = new ArrayList<>();
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "descriptors_game", joinColumns = @JoinColumn(name = "game_id") , inverseJoinColumns = @JoinColumn(name = "descriptor_id"))
	List<Descriptor> descriptors = new ArrayList<>();
	
	@OneToMany(mappedBy="game")
	private List<Article> Articles;

	
	private String description;
	
	private String banner;
	
	private String video;
	
	private String logo;
	
	private Boolean mainGame;
	
	
	public Game() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	public int getClassification() {
		return classification;
	}

	public void setClassification(int classification) {
		this.classification = classification;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}


	public List<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<Platform> platforms) {
		this.platforms = platforms;
	}

	public List<Gender> getGenders() {
		return genders;
	}

	public void setGenders(List<Gender> genders) {
		this.genders = genders;
	}

	public List<Descriptor> getDescriptors() {
		return descriptors;
	}

	public void setDescriptors(List<Descriptor> descriptors) {
		this.descriptors = descriptors;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Boolean getMainGame() {
		return mainGame;
	}

	public void setMainGame(Boolean mainGame) {
		this.mainGame = mainGame;
	}
	
}
