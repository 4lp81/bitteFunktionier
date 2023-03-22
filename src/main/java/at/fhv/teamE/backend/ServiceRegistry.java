package at.fhv.teamE.backend;

import at.fhv.teamE.backend.application.api.EventService;
import at.fhv.teamE.backend.application.impl.EventServiceImpl;
import at.fhv.teamE.backend.communication.EventServiceImplRMI;
import at.fhv.teamE.backend.communication.EventServiceRMI;
import at.fhv.teamE.backend.domain.model.event.Event;
import at.fhv.teamE.backend.domain.repository.EventRepository;
import at.fhv.teamE.backend.infrastructure.HibernateEventRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.rmi.RemoteException;

public class ServiceRegistry {
    private static EntityManagerFactory entityManagerFactory;
    private static EventServiceImplRMI eventServiceRMI;
    private static EventService eventService;
    private static EventRepository eventRepository;

    public static EntityManager entityManager(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("etickerBackend");
        }
        return entityManagerFactory.createEntityManager();
    }

    public static EventService eventService(){
        if(eventService == null){
            eventService = new EventServiceImpl();
        }
        return eventService;
    }


    public static EventServiceRMI eventServiceRMI() throws RemoteException{
        if(eventServiceRMI == null){
                eventServiceRMI = new EventServiceImplRMI();
        }
        return eventServiceRMI;
    }

    public static EventRepository eventRepository(){
        if(eventRepository == null){
            eventRepository = new HibernateEventRepository();
        }
        return eventRepository;
    }
}
