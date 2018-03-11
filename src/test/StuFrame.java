// package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class StuFrame extends JFrame implements ActionListener{

    private JPanel panel_leftup,panel_leftdown,panel_rightup,panel_rightdown;//对应左上、坐下、右上、右下
    private JLabel jlb_info, jlb_option, jlb_already;//对应个人信息、可选课程、已修课程
    private JButton btn_Renew, btn_Select, btn_Kick, btn_View, btn_Com;//对应5个按钮
    private JTextField jtf_info,jtf_option,jtf_already;//对应3个输入区

    Font titleFont = new Font("微软雅黑", Font.PLAIN, 36);
    Font textFont = new Font("微软雅黑", Font.PLAIN, 32);
    Font tipFont = new Font("微软雅黑", Font.PLAIN, 26);

    public StuFrame() {
        init();
        setResizable(false);
        setBounds(200, 200, 1280, 900);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        // GridLayout grid = new GridLayout(2,2);
        panel_leftup = new JPanel();
        panel_leftup.setLayout(null);

        panel_leftdown = new JPanel();
        panel_leftdown.setLayout(null);

        panel_rightup = new JPanel();
        panel_rightup.setLayout(null);

        panel_rightdown = new JPanel();
        panel_rightdown.setLayout(null);

        jlb_info = new JLabel("个人信息：");
        jlb_info.setBounds(70, 10, 300, 40);
        jlb_info.setFont(titleFont);
        panel_leftup.add(jlb_info);

        jlb_option = new JLabel("可选课程：");
        jlb_option.setBounds(430, 60, 120, 30);
        jlb_option.setFont(tipFont);
        panel_rightup.add(jlb_option);

        jlb_already = new JLabel("已选课程：");
        jlb_already.setBounds(80, 115, 100, 40);
        jlb_already.setFont(textFont);
        panel_leftdown.add(jlb_already);

        jtf_info = new JTextField(20);
        jtf_info.setBounds(180, 115,300, 50);
        panel_leftup.add(jtf_info);

        jtf_option = new JTextField(20);
        jtf_option.setBounds(180, 195, 300, 50);
        panel_rightup.add(jtf_option);

        jtf_already = new JTextField(20);
        jtf_already.setBounds(180, 195, 300, 50);
        panel_leftdown.add(jtf_already);

        btn_Renew = new JButton("修改个人信息");
        btn_Renew.setBounds(110, 320, 150, 45);
        btn_Renew.setFont(tipFont);
        btn_Renew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel_leftup.add(btn_Renew);

        btn_Select = new JButton("选课");
        btn_Select.setFont(tipFont);
        btn_Select.setBounds(310, 320, 150, 45);
        btn_Select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel_rightdown.add(btn_Select);

        btn_Kick = new JButton("退课");
        btn_Kick.setFont(tipFont);
        btn_Kick.setBounds(310, 320, 150, 45);
        btn_Kick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel_rightdown.add(btn_Kick);

        btn_View = new JButton("查询成绩大表与绩点走势");
        btn_View.setFont(tipFont);
        btn_View.setBounds(310, 320, 150, 45);
        btn_View.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel_rightdown.add(btn_View);

        btn_Com = new JButton("师生通信情况与教学公告");
        btn_Com.setFont(tipFont);
        btn_Com.setBounds(310, 320, 150, 45);
        btn_Com.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel_rightdown.add(btn_Com);

        add(panel_leftup);
        add(panel_leftdown);
        add(panel_rightup);
        add(panel_rightdown);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {

        StuFrame StuFrame = new StuFrame();
    }
}

