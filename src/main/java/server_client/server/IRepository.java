package server_client.server;

public interface IRepository {
    void saveLog(String message);
    String getHistory();
}
