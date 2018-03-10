package main.java.view;

import main.java.model.Msg;
import main.java.dao.MsgDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.List;

import static java.awt.SystemColor.info;

public class MsgWindow extends JFrame implements ActionListener {

    JButton recevMsg, sendMsg;
    JTextField msgArea, sendId, recevId, tittle, content;
    final String hint_sendId = "请输入发件人学号";
    final String hint_recevId = "请输入收件人学号";
    final String hint_tittle = "请输入信件标题";
    final String hint_content = "请输入邮件内容";

    MsgDao msgDao = new MsgDao();

    public MsgWindow() {};

    public MsgWindow(int x, int y, int w, int h) {
        init();
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
        sendId = new JTextField(10);
        sendId.addFocusListener(new MyFocusListener(hint_sendId, sendId));
        add(sendId);
        recevId = new JTextField(10);
        recevId.addFocusListener(new MyFocusListener(hint_recevId, recevId));
        add(recevId);
        tittle = new JTextField();
        tittle.addFocusListener(new MyFocusListener(hint_tittle, tittle));
        add(tittle);
        content = new JTextField();
        content.addFocusListener(new MyFocusListener(hint_content, content));
        add(content);
        sendMsg = new JButton("发信");
        add(sendMsg);
        sendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    msgDao.insertMsg(sendId.getText().toString(), recevId.getText().toString(),
                            tittle.getText().toString(), content.getText().toString());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    System.out.println("信息发送失败");
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}


class MyFocusListener implements FocusListener {
    String info;
    JTextField jtf;
    public MyFocusListener(String info, JTextField jtf) {
        this.info = info;
        this.jtf = jtf;
    }
    @Override
    public void focusGained(FocusEvent e) {//获得焦点的时候,清空提示文字
        String temp = jtf.getText();
        if(temp.equals(info)){
            jtf.setText("");
        }
    }
    @Override
    public void focusLost(FocusEvent e) {//失去焦点的时候,判断如果为空,就显示提示文字
        String temp = jtf.getText();
        if(temp.equals("")){
            jtf.setText(info);
        }
    }
}