package fb;

import java.awt.GridLayout;

import javax.swing.*;


public class Test {

    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setBounds(500, 100, 529, 300);
        frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));


        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));


        JButton btnNewButton_4 = new JButton("New button");
        panel.add(btnNewButton_4);

        JButton btnNewButton_3 = new JButton("New button");
        panel.add(btnNewButton_3);

        JButton btnNewButton = new JButton("New button");
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("New button");
        panel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("New button");
        panel.add(btnNewButton_2);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
