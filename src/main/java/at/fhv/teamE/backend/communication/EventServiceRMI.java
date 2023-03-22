package at.fhv.teamE.backend.communication;

import at.fhv.teamE.backend.application.dto.EventOverviewDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface EventServiceRMI extends Remote {
    List<EventOverviewDTO> searchEventOrArtist(String searchString) throws RemoteException;
}
