package Socket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client1 extends JFrame {
    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Client1 frame = new Client1();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Client1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(118, 126, 169, 70);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Đồng hồ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(164, 55, 101, 42);
        contentPane.add(lblNewLabel);

        // Hiển thị thời gian hiện tại trong ô textField
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timer timer = new Timer(1000, e -> {
            String currentTime = dateFormat.format(new Date());
            textField.setText(currentTime);
        });
        timer.start();
    }
}
