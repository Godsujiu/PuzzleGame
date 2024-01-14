package com.godsujiu.java;

import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame {
    int[][] data = new int[4][4];

    public GameJFrame() {

        initJFrame();
        initJMenuBar();

        initData();

        initImage();

        this.setVisible(true);
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        for (int i = 0; i < tempArr.length; i++) {
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    private void initImage() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                ImageIcon icon = new ImageIcon("D:\\javaNIUB\\puzzle\\puzzlegame\\image\\animal\\animal3\\" + num + ".jpg");
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(105 * j, 105 * i, 105, 105);
                this.getContentPane().add(jLabel);
            }

        }

    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenuItem replayGame = new JMenuItem("重新游戏");
        JMenuItem reLoginGame = new JMenuItem("重新登录");
        JMenuItem exitGame = new JMenuItem("退出游戏");

        JMenuItem aboutMe = new JMenuItem("公众号");

        functionJMenu.add(replayGame);
        functionJMenu.add(reLoginGame);
        functionJMenu.add(exitGame);

        aboutJMenu.add(aboutMe);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("拼图小游戏");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
    }

}
