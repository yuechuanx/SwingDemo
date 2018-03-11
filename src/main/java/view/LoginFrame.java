package main.java.view;

import main.java.util.DbUtil;
import main.java.util.Fonts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener{

    private JPanel bg_panel;
    private JLabel jlb_id, jlb_passwd, jlb_tittle, jlb_status;
    private JButton btn_reset, btn_signIn;
    private JTextField usernameFiled;
    private JPasswordField passwordField;
    private JRadioButton jrb_stu, jrb_teacher, jrb_admin;
    DbUtil dbUtil = new DbUtil();


    public LoginFrame() throws Exception {
        bg_panel = new JPanel();
        bg_panel.setLayout(null);

        jlb_tittle = new JLabel("欢迎进入学生成绩管理系统");
        jlb_tittle.setBounds(70,10,500,40);
        jlb_tittle.setFont(Fonts.titleFont);
        bg_panel.add(jlb_tittle);

        jlb_status = new JLabel("");
        jlb_status.setBounds(430,60,120,30);
        jlb_status.setFont(Fonts.tipFont);
        // TODOchange the name of tipFont;
        bg_panel.add(jlb_status);
        if(!dbUtil.getConn().isClosed())
            jlb_status.setText("连接正常");
        else
            jlb_status.setText("无连接");

/*        jtf_username = new JTextField(20);
        jtf_username.setBounds(180,115,300,50);
        jtf_username.setFont(Fonts.textFont);
        bg_panel.add(jtf_username);

        jtf_passwd = new JTextField(20);
        jtf_passwd.setBounds(180,195,300,50);
        jtf_passwd.setFont(Fonts.textFont);
        jtf_passwd.setE
        bg_panel.add(jtf_passwd);


        jtf_username = new JTextField(20);
        jtf_username.setBounds(387,202,173,30);
        jtf_username.setFont(Fonts.Static);*/

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
