package at.fhv.teamE.backend.communication;

import at.fhv.teamE.backend.ServiceRegistry;
import at.fhv.teamE.backend.application.api.EventService;
import at.fhv.teamE.backend.application.dto.EventOverviewDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
public class EventServiceImplRMI extends UnicastRemoteObject implements EventServiceRMI{
        public EventServiceImplRMI() throws RemoteException{
            super();
        }
        @Override
        public List<EventOverviewDTO> searchEventOrArtist(String searchString) throws RemoteException{
            EventService eventService = ServiceRegistry.eventService();

            return eventService.searchEventOrArtist(searchString);
        }
    }
