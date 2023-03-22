package at.fhv.teamE.backend.application.impl;

import at.fhv.teamE.backend.ServiceRegistry;
import at.fhv.teamE.backend.application.api.EventService;
import at.fhv.teamE.backend.application.dto.EventOverviewDTO;
import at.fhv.teamE.backend.domain.repository.EventRepository;

import java.util.List;

public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository = ServiceRegistry.eventRepository();

    @Override
    public List<EventOverviewDTO> searchEventOrArtist(String searchString){
        if(searchString.length() < 2){
            throw new IllegalArgumentException("Lak gib ma was ein ma ein");
        }
        return EventOverviewDTO.createAsList(eventRepository.searchEventOrArtist(searchString));
    }

}
