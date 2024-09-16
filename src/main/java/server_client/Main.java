package server_client;

import server_client.client.ClientController;
import server_client.client.ClientGUI;
import server_client.server.*;

public class Main {
    public static void main(String[] args) {
        ServerController serverController = new ServerController(new ServerGUI(), new ServerRepository());

        new ClientController(new ClientGUI(), serverController);
    }
}
