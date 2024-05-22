package org.august;

import org.august.model.Client;
import org.august.model.Planet;
import org.august.service.ClientCrudService;
import org.august.service.PlanetCrudService;


public class Main {
    public static void main(String[] args) {
        // Ініціалізація CRUD сервісів
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();

        // Додавання клієнтів
        Client client1 = new Client();
        client1.setName("John Doe");
        clientService.addClient(client1);

        Client client2 = new Client();
        client2.setName("Jane Doe");
        clientService.addClient(client2);

        // Отримання і оновлення клієнта
        Client client = clientService.getClient(1);  // Отримання клієнта за id
        if (client != null) {
            client.setName("John Smith");
            clientService.updateClient(client);
        }

        // Виведення всіх клієнтів
        System.out.println("All Clients:");
        clientService.getAllClients().forEach(c -> System.out.println(c.getId() + ": " + c.getName()));

        // Видалення клієнта
        clientService.deleteClient(2);

        // Додавання планет
        Planet planet1 = new Planet();
        planet1.setId("MARS");
        planet1.setName("Mars");
        planetService.addPlanet(planet1);

        Planet planet2 = new Planet();
        planet2.setId("VEN");
        planet2.setName("Venus");
        planetService.addPlanet(planet2);

        // Отримання і оновлення планети
        Planet planet = planetService.getPlanet("MARS");  // Отримання планети за id
        if (planet != null) {
            planet.setName("Red Planet");
            planetService.updatePlanet(planet);
        }

        // Виведення всіх планет
        System.out.println("All Planets:");
        planetService.getAllPlanets().forEach(p -> System.out.println(p.getId() + ": " + p.getName()));

        // Видалення планети
        planetService.deletePlanet("VEN");
    }
}
