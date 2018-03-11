package main.java.view;// package view;

import main.java.dao.AdminDao;
import main.java.dao.StuDao;
import main.java.model.CrsEntity;
import main.java.model.StuEntity;
import main.java.util.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StuPanel extends JPanel implements ActionListener {

    private JLabel jlb_info, jlb_option, jlb_already;//对应个人信息、可选课程、已修课程
    private JButton btn_Renew, btn_Select, btn_Kick, btn_View, btn_Com;//对应5个按钮
    private JTextArea jtf_info, jtf_option, jtf_already;//对应3个输入区
    private JScrollPane optionScrollPane;
    private StuDao stuDao = new StuDao();
    private JPanel optionPane;
    private String id;

    public StuPanel(String Login_id) {
        id = Login_id;
        init();
    }

    private void init() {
        setLayout(null);

        jlb_info = new JLabel("个人信息：");
        jlb_info.setBounds(5, 5, 100, 24);
        jlb_info.setFont(Fonts.middleFont);
        add(jlb_info);

        jlb_option = new JLabel("可选课程：");
        jlb_option.setBounds(5, 200, 100, 24);
        jlb_option.setFont(Fonts.middleFont);
        add(jlb_option);

        jlb_already = new JLabel("已选课程：");
        jlb_already.setBounds(305, 5, 100, 24);
        jlb_already.setFont(Fonts.InfoFont);
        add(jlb_already);

        jtf_info = new JTextArea(10,20);
        jtf_info.setBounds(5, 35, 260, 145);
        jtf_info.setFont(Fonts.InfoFont);
        StuEntity stuEntity = stuDao.getStuInfo(id);
        String stuInfo = "学号：" + stuEntity.getXh() + "\n" +
                "姓名：" + stuEntity.getXm() + "\n" +
                "性别：" + stuEntity.getXb() + "\n" +
                "出生日期：" + stuEntity.getCsrq() + "\n";
        jtf_info.setText(stuInfo);
         add(jtf_info);

        jtf_option = new JTextArea(10,20);
        jtf_option.setBounds(5, 225, 260, 145);
        jtf_option.setLineWrap(true);
        jtf_option.setWrapStyleWord(true);
        jtf_option.setEnabled(false);
        jtf_option.setFont(Fonts.InfoFont);
//        optionScrollPane = new JScrollPane();
//        optionScrollPane.add(new JScrollPane(jtf_option));
//        optionScrollPane.setViewportView(jtf_option);
//        optionScrollPane.setVisible(true);
        String courseInfo = "  课程号  |  课程名|  学分  " + "\n";
        List<CrsEntity> lstAll = stuDao.getAllCourse();
        jtf_option.append(courseInfo);
        for(int i = 0; i < lstAll.size(); ++i) {
            jtf_option.append(lstAll.get(i).getKh() + " " + lstAll.get(i).getKm() + " " + lstAll.get(i).getXf() + "\n");
        }
//        add(optionScrollPane)
        add(jtf_option);

        jtf_already = new JTextArea(10,20);
        jtf_already.setBounds(305, 30, 260, 145);
        jtf_already.setFont(Fonts.InfoFont);
        List<CrsEntity> lst = stuDao.getChosenCourse(id);
        jtf_already.append(courseInfo);
        for(int i = 0; i < lst.size(); ++i) {
            jtf_already.append(lst.get(i).getKh() + " " + lst.get(i).getKm() + " " + lst.get(i).getXf() + "\n");
        }
        add(jtf_already);

        btn_Renew = new JButton("修改个人信息");
        btn_Renew.setBounds(110, 3, 155, 28);
        btn_Renew.setFont(Fonts.middleFont);
        btn_Renew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(btn_Renew);

        btn_Select = new JButton("选课");
        btn_Select.setFont(Fonts.middleFont);
        btn_Select.setBounds(305, 260, 100, 30);
        btn_Select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(btn_Select);

        btn_Kick = new JButton("退课");
        btn_Kick.setFont(Fonts.middleFont);
        btn_Kick.setBounds(465, 260, 100, 30);
        btn_Kick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(btn_Kick);

        btn_View = new JButton("查询成绩大表与绩点走势");
        btn_View.setFont(Fonts.middleFont);
        btn_View.setBounds(305, 300, 260, 30);
        btn_View.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(btn_View);

        btn_Com = new JButton("站内信系统");
        btn_Com.setFont(Fonts.middleFont);
        btn_Com.setBounds(305, 340, 260, 30);
        btn_Com.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MsgFrame(id);
            }
        });
        add(btn_Com);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public static void main(String[] args) {
        IndexFrame frame = new IndexFrame("15121102", 2);
    }
}

