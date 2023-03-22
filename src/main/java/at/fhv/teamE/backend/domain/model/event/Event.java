package at.fhv.teamE.backend.domain.model.event;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long eventIdInternal;

    @Embedded
    private EventId eventId;
    private String title;
    private String location;
    private String description;
    private LocalDate date;
    private double price;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    protected Event(){

    }

    public Event(EventId eventId, String title, String location, String description, LocalDate date, double price, EventType eventType) {
        this.eventId = eventId;
        this.title = title;
        this.location = location;
        this.description = description;
        this.date = date;
        this.price = price;
        this.eventType = eventType;
    }

    public EventId eventId() {
        return eventId;
    }

    public String title() {
        return title;
    }

    public String location() {
        return location;
    }

    public String description() {
        return description;
    }

    public LocalDate date() {
        return date;
    }

    public double price() {
        return price;
    }

    public EventType eventType() {
        return eventType;
    }
}
