package Lab_12;

import javax.swing.*;
import java.awt.*;

public class SwingWork {
    static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1600, 800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("Username: ");
        label1.setBounds(20 , 20 , 190 , 20);
        label1.setFont(new Font("Aptos ExtraBold" ,Font.BOLD , 23));

        frame.add(label1);

        JLabel label2 = new JLabel("Password: ");
        label2.setBounds(20 , 80 , 190 , 20);
        label2.setFont(new Font("Aptos ExtraBold" , Font.BOLD , 23));

        frame.add(label2);

        JTextField field1 = new JTextField();
        field1.setBounds(190 , 20 , 80 , 20);

        frame.add(field1);

        JTextField field2 = new JTextField();
        field2.setBounds(190 , 80 , 80 , 20);

        frame.add(field2);

        frame.setVisible(true);

    }
}
