package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private Server server;
    private Socket socket;
    DataOutputStream out;
    DataInputStream in;
    String nick;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/auth")) {
                            String[] token = str.split(" ");
                            String newNick = AuthService.getNickByLoginAndPass(token[1], token[2]);
                            if (newNick != null) {
                                if (server.isLogged(newNick)){
                                    sendMSG("Пользователь с данным логином уже авторизован");
                                    continue;
                                }
                                sendMSG("/authok");
                                nick = newNick;
                                server.subscribe(this);
                                System.out.println("Пользователь " + nick + " подключился");
                                break;
                            } else {
                                sendMSG("Неверный логин / пароль");
                            }
                        }
                    }

                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            out.writeUTF("/end");
                            System.out.println("Клиент отключился");
                            break;
                        }
                        if (str.startsWith("/w")){
                            String[] token = str.split(" ");
                            String message = "";
                            for (int i = 2; i < token.length ; i++) {
                                message += token[i] + " ";
                            }
                            for (ClientHandler o: server.clients) {
                                if (o.nick.equals(token[1])){
                                    o.sendMSG(message);
                                }
                            }
                        }else {
                            System.out.println(nick + ": " + str);
                            server.broadcastMsg(nick + ": " + str);
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                    System.out.println("Клиент удален из Clients");
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMSG(String str) {
        try {
            out.writeUTF(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
