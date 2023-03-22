package at.fhv.teamE.backend.infrastructure;

import at.fhv.teamE.backend.ServiceRegistry;
import at.fhv.teamE.backend.domain.model.event.Event;
import at.fhv.teamE.backend.domain.repository.EventRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class HibernateEventRepository implements EventRepository {
    private final EntityManager entityManager = ServiceRegistry.entityManager();

    @Override
    public List<Event> searchEventOrArtist(String searchString) {
        return entityManager
                .createQuery("SELECT e FROM Event e WHERE e.title = :searchString", Event.class)
                .setParameter("searchString", searchString)
                .getResultList();
    }

}

