package Socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    public Sever() throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is running on port 1234");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            
            // Đọc dữ liệu từ máy khách
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = fromClient.readLine();
            System.out.println("Received: " + line);
            
            // Tạo luồng đầu ra để gửi dữ liệu đến máy khách
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhập tin nhắn: ");
            String message = reader.readLine();

            // Gửi tin nhắn đến máy khách
            DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
            toClient.writeBytes(message + '\n');       
            // Đóng kết nối với máy khách
            socket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new Sever();
    }
}
