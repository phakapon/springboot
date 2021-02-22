package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class EventsAPI {
	@Autowired
	EventsRepository Event;

	@GetMapping("/Events")
	public List<Events> getEvents() {
		return Event.findAll();
	}

	@GetMapping("/Events/{id}")
	public Events getEvents(@PathVariable("id") Integer id) {
		return Event.findById(id);
	}
	
	@PostMapping("/Events")
	public Events saveEvents(@RequestBody Events Events) {
		return Event.save(Events);
	}

	@PutMapping("/Events")
	public Events editEvents(@RequestBody Events Events) {
		Events editEvents = Event.findById(Events.getEventId());
		editEvents.setEventName(Events.getEventName());
		editEvents.setJoinNum(Events.getJoinNum());
		return Event.save(editEvents);
	}
	
	@DeleteMapping("/Events/{id}")
	public void deleteEvents(@PathVariable("id") Integer id) {
		Events Events = Event.findById(id);
		Event.delete(Events);
	}
}
