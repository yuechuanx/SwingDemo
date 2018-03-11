package main.java.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexFrame extends JFrame implements ActionListener{

    StuPanel stuPanel;

    public IndexFrame(String id, int role) {
        init(id, role);
        setVisible(true);
        setResizable(false);
        setBounds(100, 100, 600, 480);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void init(String id, int role) {
        if (role == 2) {
            stuPanel = new StuPanel(id);
            add(stuPanel);
        } else if(role == 0) {
            /**
             * TODO
             * @desc 实例化管理员面板
             *
             */
        } else {
            /**
             * TODO
             * @desc 实例化教师面板
             *
             */
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        IndexFrame frame = new IndexFrame("11111111", 2);
    }

}
