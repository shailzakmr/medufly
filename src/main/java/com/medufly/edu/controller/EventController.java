package com.medufly.edu.controller;

import com.medufly.edu.entity.Event;
import com.medufly.edu.repository.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public Map<String, List<Event>> listEvents() {
        List<Event> allActive = eventRepository.findByActiveTrueOrderByEventDateAsc();

        Map<Boolean, List<Event>> partitioned = allActive.stream()
            .collect(Collectors.partitioningBy(e -> Boolean.TRUE.equals(e.getIsPast())));

        Map<String, List<Event>> result = new LinkedHashMap<>();
        result.put("upcoming", partitioned.get(false));
        result.put("past", partitioned.get(true));
        return result;
    }
}
