package com.demo;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String id;
	private String password;
	private String favorite;
	private Integer follow;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
	private List<Events> events;
	
	@JsonManagedReference(value = "events-reference")
	public List<Events> getEvents(){
		return events;
	}
	
	public void setEvents(List<Events> events) {
		this.events = events;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
	private List<Join_event> join;
	
	@JsonManagedReference(value = "join-reference")
	public List<Join_event> getJoin_event(){
		return join;
	}
	
	public void setJoin_event(List<Join_event> join) {
		this.join = join;
	}
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

	public Integer getFollow() {
		return follow;
	}

	public void setFollow(Integer follow) {
		this.follow = follow;
	}
	

	
}
