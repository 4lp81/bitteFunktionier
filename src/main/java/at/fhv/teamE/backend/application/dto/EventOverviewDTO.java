package at.fhv.teamE.backend.application.dto;

import at.fhv.teamE.backend.domain.model.event.Event;

import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class EventOverviewDTO {
    private final UUID eventId;
    private final String title;
    private final String location;
    private final String description;
    private final LocalDate date;
    private final double price;

    public EventOverviewDTO(UUID eventId, String title, String location, String description, LocalDate date, double price) {
        this.eventId = eventId;
        this.title = title;
        this.location = location;
        this.description = description;
        this.date = date;
        this.price = price;
    }

    public static EventOverviewDTO create(Event event){
        return new EventOverviewDTO(event.eventId().id(), event.title(), event.location(), event.description(), event.date(), event.price());
    }

    public static List<EventOverviewDTO> createAsList(List<Event> events){
        return events.stream().map(EventOverviewDTO::create).collect(Collectors.toList());
    }

    public UUID eventId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventOverviewDTO that = (EventOverviewDTO) o;
        return Double.compare(that.price, price) == 0 && eventId.equals(that.eventId) && title.equals(that.title) && location.equals(that.location) && description.equals(that.description) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, title, location, description, date, price);
    }
}
