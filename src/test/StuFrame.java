// package view;

import main.java.util.Fonts;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class StuFrame extends JFrame implements ActionListener {

    private JPanel panel;
    // private JPanel panel_leftup,panel_leftdown,panel_rightup,panel_rightdown;//对应左上、坐下、右上、右下
    private JLabel jlb_info, jlb_option, jlb_already;//对应个人信息、可选课程、已修课程
    private JButton btn_Renew, btn_Select, btn_Kick, btn_View, btn_Com;//对应5个按钮
    private JTextField jtf_info, jtf_option, jtf_already;//对应3个输入区

    public StuFrame() {

        init();
        setResizable(false);
        setBounds(100, 100, 600, 480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {

        panel = new JPanel();
        panel.setLayout(null);

        // panel_leftdown = new JPanel();
        // panel_leftdown.setLayout(null);

        // panel_rightup = new JPanel();
        // panel_rightup.setLayout(null);

        // panel_rightdown = new JPanel();
        // panel_rightdown.setLayout(null);

        jlb_info = new JLabel("个人信息：");
        jlb_info.setBounds(5, 5, 100, 24);
        jlb_info.setFont(Fonts.titleFont);
        panel.add(jlb_info);

        jlb_option = new JLabel("可选课程：");
        jlb_option.setBounds(5, 200, 100, 24);
        jlb_option.setFont(Fonts.tipFont);
        panel.add(jlb_option);

        jlb_already = new JLabel("已选课程：");
        jlb_already.setBounds(305, 5, 100, 24);
        jlb_already.setFont(Fonts.textFont);
        panel.add(jlb_already);

        jtf_info = new JTextField(20);
        jtf_info.setBounds(5, 35, 260, 145);
        panel.add(jtf_info);

        jtf_option = new JTextField(20);
        jtf_option.setBounds(5, 225, 260, 145);
        panel.add(jtf_option);

        jtf_already = new JTextField(20);
        jtf_already.setBounds(305, 30, 260, 145);
        panel.add(jtf_already);

        btn_Renew = new JButton("修改个人信息");
        btn_Renew.setBounds(110, 3, 155, 28);
        btn_Renew.setFont(Fonts.tipFont);
        btn_Renew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(btn_Renew);

        btn_Select = new JButton("选课");
        btn_Select.setFont(Fonts.tipFont);
        btn_Select.setBounds(305, 260, 100, 30);
        btn_Select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(btn_Select);

        btn_Kick = new JButton("退课");
        btn_Kick.setFont(Fonts.tipFont);
        btn_Kick.setBounds(465, 260, 100, 30);
        btn_Kick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(btn_Kick);

        btn_View = new JButton("查询成绩大表与绩点走势");
        btn_View.setFont(Fonts.tipFont);
        btn_View.setBounds(305, 300, 260, 30);
        btn_View.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(btn_View);

        btn_Com = new JButton("师生通信情况与教学公告");
        btn_Com.setFont(Fonts.tipFont);
        btn_Com.setBounds(305, 340, 260, 30);
        btn_Com.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(btn_Com);
        // add(panel_leftup);
        // add(panel_rightup);
        // add(panel_leftdown);
        // add(panel_rightdown);


        // GridBagConstraints constraints=new GridBagConstraints();
        // constraints.fill=GridBagConstraints.NONE;
        // constraints.weightx=2;
        // constraints.weighty=2;

        //使用网格组布局添加控件

        //     add(panel_leftup,constraints,0,0);  //第0列第0行
        //     add(panel_leftdown,constraints,0,1);  //第0列第1行
        //     add(panel_rightup,constraints,0,2);  //第1列第1行
        //     add(panel_rightdown,constraints,0,3);   //第1列第2行
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        StuFrame frame = new StuFrame();
    }
}

