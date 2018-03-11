package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexFrame extends JFrame implements ActionListener{

    JLabel jlb_welcome = new JLabel("你跳转成功啦哈哈哈");

    public IndexFrame() {
        init();
        setVisible(true);
        setResizable(false);
        setBounds(200, 200, 580, 450);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void init() {
        add(jlb_welcome);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        IndexFrame indexFrame = new IndexFrame();
    }
}
