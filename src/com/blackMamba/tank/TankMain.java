package com.blackMamba.tank;

import java.awt.*;

/**
 * Created by Black Mamba on 2020/8/24 22:01
 *
 * @version 1.0
 * @description
 */
public class TankMain {

    public static boolean gameFlag = true;

    public static void main(String[] args) throws Exception {
        TankFrame tankFrame = new TankFrame();
        Label label = new Label();

        new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while(gameFlag){
            Thread.sleep(50);
            tankFrame.repaint();
        }

        tankFrame.setFocusable(false);
        label.setBounds(200,400,650,250);
        label.setVisible(true);
        label.setBackground(Color.RED);
        label.setText("GAME OVER!!! 你个小辣鸡");
        Font f = new Font("微软雅黑",1,50);
        label.setFont(f);

        tankFrame.add(label);

    }
}
