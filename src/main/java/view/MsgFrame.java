package main.java.view;

import main.java.dao.MsgDao;
import main.java.model.Msg;
import main.java.util.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class MsgFrame extends JFrame implements ActionListener{

    JPanel sendPanel, recevPanel;
    JLabel jlb_id, jlb_title, jlb_content, jlb_recev;
    JButton btn_send, btn_recev;
    JTextArea recevMsgArea, contentArea;
    JTextField tittleField, rececIdField;
    JScrollPane contentScrollPane, msgScrollPane;
    MsgDao msgDao = new MsgDao();


    public MsgFrame() {
        init();
        setTitle("站内信");
        setSize(700, 600);
        Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2-700/2,screenSize.height/2-400/2);
        setResizable(false);
        setLayout(new GridLayout());
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public MsgFrame(String id) {
        init();
        setTitle("站内信");
        setSize(700, 600);
        Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2-700/2,screenSize.height/2-400/2);
        setResizable(false);
        setLayout(new GridLayout());
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void init() {
        String id = "11111111";

        sendPanel = new JPanel();
        sendPanel.setLayout(new FlowLayout());
        sendPanel.setSize(350, 600);
        sendPanel.setVisible(true);

        jlb_id = new JLabel("收件人学号：");
        jlb_id.setFont(Fonts.titleFont);
        jlb_id.setSize(100, 100);
        sendPanel.add(jlb_id);

        rececIdField = new JTextField(10);
        rececIdField.setSize(250,100);
//        rececIdField.setText("请输入收件人学号");
        rececIdField.setFont(Fonts.textFont);

        sendPanel.add(rececIdField);

        jlb_title = new JLabel("邮件标题");
        jlb_title.setFont(Fonts.titleFont);
        jlb_title.setSize(100,100);
        sendPanel.add(jlb_title);

        tittleField = new JTextField(10);
//        tittleField.setText("请在此处输入标题");
        tittleField.setFont(Fonts.textFont);
        tittleField.setSize(250, 100);
        sendPanel.add(tittleField);

        jlb_content = new JLabel("邮件内容");
        jlb_content.setFont(Fonts.titleFont);
        jlb_content.setSize(100, 100);
        sendPanel.add(jlb_content);



        contentArea = new JTextArea(5,10);
//        contentArea.setText("请在此处输入发信内容");
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setFont(Fonts.textFont);
        contentScrollPane = new JScrollPane();
        contentScrollPane.add(new JScrollPane(contentArea));
        contentScrollPane.setViewportView(contentArea);
//        contentScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sendPanel.add(contentScrollPane);

        btn_send = new JButton("发送");
        btn_send.setFont(Fonts.titleFont);
        btn_send.setSize(350, 100);
        btn_send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recevId = String.valueOf(rececIdField.getText());
                try {
                    msgDao.insertMsg(id, rececIdField.getText(), tittleField.getText(), contentArea.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        sendPanel.add(btn_send);

        recevPanel = new JPanel();
        recevPanel.setLayout(new FlowLayout());
        recevPanel.setSize(350, 600);
        sendPanel.setVisible(true);

        jlb_recev = new JLabel("收件箱");
        jlb_recev.setFont(Fonts.titleFont);
        recevPanel.add(jlb_recev);

        recevMsgArea = new JTextArea(10,13);
        recevMsgArea.setEnabled(false);
        recevMsgArea.setLineWrap(true);
        recevMsgArea.setWrapStyleWord(true);
        recevMsgArea.setFont(Fonts.textFont);
        msgScrollPane = new JScrollPane();
        msgScrollPane.add(new JScrollPane(recevMsgArea));
        msgScrollPane.setViewportView(recevMsgArea);
//        msgScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        recevPanel.add(msgScrollPane);

        btn_recev = new JButton("收信");
        btn_recev.setFont(Fonts.titleFont);
        btn_recev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Msg> lst =  msgDao.getMsg(id);
                    for (int i = 0; i < lst.size(); ++i) {
                        recevMsgArea.append("Tittle: " + lst.get(i).getTittle() + "\n");
                        recevMsgArea.append("Content: " + lst.get(i).getContent() + "\n");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        recevPanel.add(btn_recev);

        add(sendPanel);
        add(recevPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        MsgFrame msgFrame = new MsgFrame();
    }
}
