package Socket;

import java.io.*;
import java.net.*;
import java.sql.Date;

public class Sever1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is running on port 1234");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Đọc thời gian hiện tại
                String currentTime = getCurrentTime();

                // Gửi thời gian đến máy khách
                DataOutputStream toClient1 = new DataOutputStream(socket.getOutputStream());
                toClient1.writeBytes(currentTime + '\n');

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCurrentTime() {
        // Lấy thời gian hiện tại
        long currentTimeMillis = System.currentTimeMillis();
        return new Date(currentTimeMillis).toString();
    }
}
