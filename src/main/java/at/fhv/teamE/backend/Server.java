package at.fhv.teamE.backend;

import org.hibernate.boot.xsd.LocalXsdResolver;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;

public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

            Naming.rebind("rmi://localhost/eventService",ServiceRegistry.eventServiceRMI());

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
