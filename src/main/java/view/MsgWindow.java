package main.java.view;

import main.java.model.Msg;
import main.java.dao.MsgDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class MsgWindow extends JFrame implements ActionListener {

    JButton recevMsg;
    JButton sendMsg;
    JTextField msgArea;
    MsgDao msgDao = new MsgDao();

    public MsgWindow() {};

    public MsgWindow(int x, int y, int w, int h) {
        init();
//        setLayout(new GridLayout());
        setLocation(x, y);
        setSize(w, h);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        setLayout(new GridLayout());
        recevMsg = new JButton("收信");
        add(recevMsg);
        msgArea = new JTextField();
        add(msgArea);
        recevMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Msg> lst = null;
                try {
                    lst = msgDao.getMsg("2");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                String str = "";
                for(int i = 0; i < lst.size(); ++i) {
                    str += lst.get(i).getTittle().toString();
                    str += " ";
                    str += lst.get(i).getContent().toString();
                    str += "\n";
                }
//                msgArea.setText((String) lst.get(1).getContent());
                msgArea.setText(str);
            }
        });
        sendMsg = new JButton("发信");
        add(sendMsg);
        sendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
