package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

public class Server {
    Vector<ClientHandler> clients;

    public Server() throws SQLException {
        AuthService.connect();
        ServerSocket server = null;
        Socket socket = null;

        try {
            clients = new Vector<>();
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            while (true){
                socket = server.accept();
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }
    public void broadcastMsg(String str){
        for (ClientHandler o:clients) {
            o.sendMSG(str);
        }
    }
    public void subscribe (ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe (ClientHandler clientHandler){
        clients.remove(clientHandler);
    }
    public boolean isLogged(String nick) {
        for (ClientHandler o : clients) {
            if (nick.equals(o.nick)) return true;
        }
        return false;
    }
}
