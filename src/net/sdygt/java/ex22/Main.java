package net.sdygt.java.ex22;

import javax.swing.*;

public class Main extends JFrame {
    private final JButton b = new JButton();

    private Main() {
        super();
        this.setTitle("HelloApp");
        this.getContentPane().setLayout(null);
        this.setBounds(100, 100, 180, 140);
        this.add(makeButton());
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JButton makeButton() {
        b.setText("Click me!");
        b.setBounds(40, 40, 100, 30);
        b.addActionListener(e -> JOptionPane.showMessageDialog(b, "Hello World!"));
        return b;
    }

    public static void main(String[] args) {
        new Main();
    }
}