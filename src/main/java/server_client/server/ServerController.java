package server_client.server;

import server_client.client.ClientController;
import server_client.client.ClientView;

import java.util.ArrayList;
import java.util.List;

public class ServerController {
    private boolean work;
    private List<ClientController> clientControllers;
    private IRepository iRepository;
    private IServerGUI iServerGUI;

    public ServerController(IServerGUI iServerGUI, IRepository iRepository) {
        this.iServerGUI = iServerGUI;
        this.iRepository = iRepository;
        clientControllers = new ArrayList<>();
        iServerGUI.setServerGui(this);
    }


    public boolean connectUser(ClientController clientController) {
        if (!work){
            return false;
        }
        clientControllers.add(clientController);
        appendLog("Подключилься!");
        return true;
    }

    public void disconnectUser(ClientController clientController) {
        clientControllers.remove(clientController);
        if (clientController != null){
            clientController.disconnectedFromServer();
        }
    }

    public void message(String message) {
        if (!work){
            return;
        }
        iServerGUI.appendLog(message);
        for (ClientController clientController : clientControllers){
            clientController.answerFromServer(message);
        }
        iRepository.saveLog(message);

    }

    public String getHistory() {
        return iRepository.getHistory();
    }

    public void appendLog(String message){
        iServerGUI.appendLog(message);
    }



}

