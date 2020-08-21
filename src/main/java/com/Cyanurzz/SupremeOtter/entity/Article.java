package com.Cyanurzz.SupremeOtter.entity;

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
import javax.persistence.ManyToOne;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String content;
	
	private String bannier;
	
	private Date releaseDate;
	
	@ManyToOne
	@JoinColumn(name="user_id", insertable = false, updatable = false, nullable=true)
	private User author;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "tag_article", joinColumns = @JoinColumn(name = "article_id") , inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;

	
	public Article() {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBannier() {
		return bannier;
	}

	public void setBannier(String bannier) {
		this.bannier = bannier;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	
}
