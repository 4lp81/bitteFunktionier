package at.fhv.teamE.backend.application.api;

import at.fhv.teamE.backend.application.dto.EventOverviewDTO;
import java.util.*;

public interface EventService {
    List<EventOverviewDTO> searchEventOrArtist(String searchString);
}
