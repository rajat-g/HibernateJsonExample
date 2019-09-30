package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.model.Location;
import com.example.demo.model.Participant;
import com.example.demo.model.Ticket;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.ParticipantRepository;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.web.bind.annotation.*;
import javax.persistence.criteria.CriteriaQuery;

@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	ParticipantRepository participantRepository;

	@PostMapping("/participant")
	public void create() {
		long j = 1;
		List<Event> events = new ArrayList<Event>();
		List<Participant> participants = new ArrayList<Participant>();
		for (int i = 0; i <= 100000; i++) {
			Location location = new Location();
			location.setCountry(RandomStringUtils.randomAlphabetic(10));
			location.setCity(RandomStringUtils.randomAlphabetic(10));

			Event event = new Event();
			event.setId(j);
			event.setLocation(location);
			events.add(event);

			Ticket ticket = new Ticket();
			ticket.setPrice(Double.parseDouble(RandomStringUtils.randomNumeric(4)));
			ticket.setRegistrationCode(RandomStringUtils.randomAlphanumeric(5));

			Participant participant = new Participant();
			participant.setId(j);
			participant.setTicket(ticket);
			participant.setEvent(event);
			participants.add(participant);
			j++;
		}
		eventRepository.saveAll(events);
		participantRepository.saveAll(participants);
	}
	
	@GetMapping("/participant")
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

	@GetMapping("/participant-by-event-country")
    public List<Participant> getParticipantByEventLocation(@RequestParam String country) { 
		Specifications<Participant> spec = Specifications.where(getEventCountry(country));		
        return participantRepository.findAll(spec);
//		return participantRepository.getParticipantByEventLocation(country);
    }
	
	private static Specification<Participant> getEventCountry(String country) {
        return (Root<Participant> root, CriteriaQuery<?> cq, CriteriaBuilder cb) -> 
        		cb.equal(cb.function("JSON_EXTRACT", String.class, root.get("event").get("location"), cb.literal("$.country")), country);
    }
	
	
	
}
