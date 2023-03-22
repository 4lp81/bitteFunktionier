package at.fhv.teamE.backend.domain.repository;

import at.fhv.teamE.backend.domain.model.event.Event;

import java.util.List;

public interface EventRepository {
    List<Event> searchEventOrArtist(String searchString);

}
