package at.fhv.teamE.backend;

import at.fhv.teamE.backend.domain.model.event.Event;
import at.fhv.teamE.backend.domain.model.event.EventId;
import at.fhv.teamE.backend.domain.model.event.EventType;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataGenerator {
    private static final List<Event> events = new ArrayList<>();

    public static void main(String[] args) {
        generateData();
        persistData();
    }

    private static void generateData() {
        Event event1 = new Event(new EventId(UUID.randomUUID()),"Szene Openair","Lustenau","A Festival für Wapplar", LocalDate.now(), 9.99, EventType.CONCERT);
        Event event2 = new Event(new EventId(UUID.randomUUID()),"Jamule","Wien","Konzert von Jamule", LocalDate.now(), 9.99, EventType.CONCERT);
        Event event3 = new Event(new EventId(UUID.randomUUID()),"André Rieu","Wien","Walzerkönig André Rieu kündigt vier neue Deutschland-Konzerte an!", LocalDate.now(),9.99, EventType.CONCERT);
        Event event4 = new Event(new EventId(UUID.randomUUID()),"Openair Frauenfeld","Frauenfeld","Brutal", LocalDate.now(), 9.99, EventType.CONCERT);
        events.addAll(List.of(event1,event2,event3,event4));
    }

    private static void persistData() {
        EntityManager em = ServiceRegistry.entityManager();
        em.getTransaction().begin();

        events.forEach(em::persist);

        em.getTransaction().commit();
    }

}