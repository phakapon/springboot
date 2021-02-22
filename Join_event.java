package com.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Join_event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer joinId;
	
	@ManyToOne
	@JoinColumn(name="userId", nullable = false)
	private User user;
	
	@JsonBackReference(value = "join-reference")
	public User getUser() {
		return user;
		}
	
	public void setUser(User user) {
		this.user = user;
		}
	
	@ManyToOne
	@JoinColumn(name="eventId", nullable = false)
	private Events events;
	
	@JsonBackReference(value = "join_event-reference")
	public Events getEvents() {
		return events;
		}
	
	public void setEvents(Events events) {
		this.events = events;
		}

	public Integer getJoinId() {
		return joinId;
	}

	public void setJoinId(Integer joinId) {
		this.joinId = joinId;
	}
	
}
