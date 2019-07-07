package Lesson_6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket;
        final String IP_ADRESS = "localhost";
        final int PORT = 8189;
        Scanner in;
        PrintWriter out;
        try {
            socket = new Socket(IP_ADRESS, PORT);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String str = in.nextLine();
                        System.out.println(str);
                    }
                }
            }).start();

            while (true){
                out.println(new Scanner(System.in).nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
