package at.fhv.teamE.backend.domain.model.event;

import java.util.Objects;
import java.util.UUID;

public class EventId {
    private UUID id;

    protected EventId(){

    }

    public EventId(UUID id) {
        this.id = id;
    }

    public UUID id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventId eventId = (EventId) o;
        return id.equals(eventId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
