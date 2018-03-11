package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener{

    private JPanel panel;
    private JLabel jlb_username, jlb_passwd, jlb_status, jlb_tittle;
    private JButton btn_signIn, btn_reset;
    private JTextField jtf_username;
    private JPasswordField jpf_passwd;
    private JRadioButton jrb_stu, jrb_teacher, jrb_admin;


    Font titleFont = new Font("微软雅黑", Font.PLAIN, 36);
    Font textFont = new Font("微软雅黑", Font.PLAIN, 32);
    Font tipFont = new Font("微软雅黑", Font.PLAIN, 26);

    public LoginFrame() {
        init();
        setResizable(false);
        setBounds(200, 200, 580, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        panel = new JPanel();
        panel.setLayout(null);

        jlb_tittle = new JLabel("欢迎进入学生成绩管理系统");
        jlb_tittle.setBounds(70, 10, 500, 40);
        jlb_tittle.setFont(titleFont);
        panel.add(jlb_tittle);

        jlb_status = new JLabel("");
        jlb_status.setBounds(430, 60, 120, 30);
        jlb_status.setFont(tipFont);

        jlb_username = new JLabel("账号");
        jlb_username.setBounds(80, 115, 100, 40);
        jlb_username.setFont(textFont);
        panel.add(jlb_username);

        jlb_passwd = new JLabel("密码");
        jlb_passwd.setBounds(80, 195,100, 40);
        jlb_passwd.setFont(textFont);
        panel.add(jlb_passwd);

        jtf_username = new JTextField(20);
        jtf_username.setBounds(180, 115,300, 50);
        panel.add(jtf_username);

        jpf_passwd = new JPasswordField(20);
        jpf_passwd.setBounds(180, 195, 300, 50);
        panel.add(jpf_passwd);

        btn_reset = new JButton("重置");
        btn_reset.setBounds(110, 320, 150, 45);
        btn_reset.setFont(tipFont);
        btn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(btn_reset);

        btn_signIn = new JButton("登陆");
        btn_signIn.setFont(tipFont);
        btn_signIn.setBounds(310, 320, 150, 45);
        btn_signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(btn_signIn);


        jrb_admin = new JRadioButton("管理员");
        jrb_admin.setFont(tipFont);
        jrb_admin.setBounds(117, 270, 100, 30);
        panel.add(jrb_admin);

        jrb_stu = new JRadioButton("学生");
        jrb_stu.setFont(tipFont);
        jrb_stu.setBounds(244, 270, 100, 30);
        panel.add(jrb_stu);

        jrb_teacher = new JRadioButton("教师");
        jrb_teacher.setFont(tipFont);
        jrb_teacher.setBounds(360, 270,  100 ,30);
        panel.add(jrb_teacher);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
    }
}

