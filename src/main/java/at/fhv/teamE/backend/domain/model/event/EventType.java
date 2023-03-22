package at.fhv.teamE.backend.domain.model.event;

public enum EventType {
    CONCERT("Concert"),
    FESTIVAL("Festival"),
    THEATRE("Theatre");

    private final String name;

    EventType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
