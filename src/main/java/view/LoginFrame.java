package main.java.view;

import main.java.service.LoginService;
import main.java.util.Fonts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener{

    private JPanel panel;
    private JOptionPane errorPanel;
    private JLabel jlb_username, jlb_passwd, jlb_status, jlb_tittle;
    private JButton btn_signIn, btn_reset;
    private JTextField jtf_username;
    private JPasswordField jpf_passwd;
    private JRadioButton jrb_stu, jrb_teacher, jrb_admin;
    private ButtonGroup roleButtonGroup;


    private int role = 2; // 0-管理员， 1-教师， 2-学生

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
        jlb_tittle.setFont(Fonts.titleFont);
        panel.add(jlb_tittle);

        jlb_status = new JLabel("");
        jlb_status.setBounds(430, 60, 120, 30);
        jlb_status.setFont(Fonts.tipFont);

        jlb_username = new JLabel("账号");
        jlb_username.setBounds(80, 115, 100, 40);
        jlb_username.setFont(Fonts.textFont);
        panel.add(jlb_username);

        jlb_passwd = new JLabel("密码");
        jlb_passwd.setBounds(80, 195,100, 40);
        jlb_passwd.setFont(Fonts.textFont);
        panel.add(jlb_passwd);

        jtf_username = new JTextField(20);
        jtf_username.setFont(Fonts.textFont);
        jtf_username.setBounds(180, 115,300, 50);
        panel.add(jtf_username);

        jpf_passwd = new JPasswordField(20);
        jpf_passwd.setFont(Fonts.textFont);
        jpf_passwd.setBounds(180, 195, 300, 50);
        panel.add(jpf_passwd);

        btn_reset = new JButton("重置");
        btn_reset.setBounds(110, 320, 150, 45);
        btn_reset.setFont(Fonts.tipFont);
        btn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            jtf_username.setText("");
            jpf_passwd.setText("");
            }
        });
        panel.add(btn_reset);

        btn_signIn = new JButton("登陆");
        btn_signIn.setFont(Fonts.tipFont);
        btn_signIn.setBounds(310, 320, 150, 45);
        btn_signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passwd = "";
                passwd = String.valueOf(jpf_passwd.getPassword());
                String id = "";
                id = String.valueOf(jtf_username.getText());
                LoginService loginService = new LoginService();
                try {
                    if (passwd.equals(loginService.LoginService(id, role))) {
                        new IndexFrame();
                    } else {
                        showErrorDialog();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        panel.add(btn_signIn);

        jrb_admin = new JRadioButton("管理员");
        jrb_admin.setFont(Fonts.tipFont);
        jrb_admin.setBounds(117, 270, 100, 30);
        jrb_admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                role = 0;
                System.out.println(role);
            }
        });
        panel.add(jrb_admin);

        jrb_stu = new JRadioButton("学生", true);
        jrb_stu.setFont(Fonts.tipFont);
        jrb_stu.setBounds(244, 270, 100, 30);
        jrb_stu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                role = 2;
                System.out.println(role);
            }
        });
        panel.add(jrb_stu);

        jrb_teacher = new JRadioButton("教师");
        jrb_teacher.setFont(Fonts.tipFont);
        jrb_teacher.setBounds(360, 270,  100 ,30);
        jrb_teacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                role = 1;
                System.out.println(role);
            }
        });
        panel.add(jrb_teacher);
        
        roleButtonGroup = new ButtonGroup();
        roleButtonGroup.add(jrb_admin);
        roleButtonGroup.add(jrb_teacher);
        roleButtonGroup.add(jrb_stu);
        
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void showErrorDialog() {
        errorPanel = new JOptionPane();
        errorPanel.setFont(Fonts.InfoFont);
        JOptionPane.showMessageDialog(new JFrame().getContentPane(),
                "请检查你的用户名和密码！", "系统信息",JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
    }

}

