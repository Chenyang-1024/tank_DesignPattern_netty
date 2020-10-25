package com.blackMamba.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Black Mamba on 2020/8/27 21:02
 *
 * @version 1.0
 * @description
 */
public class ResourceMgr {
    public static BufferedImage goodTankD , goodTankL , goodTankR , goodTankU;
    public static BufferedImage badTankD , badTankL , badTankR , badTankU;
    public static BufferedImage bulletD , bulletL , bulletR , bulletU;
    public static  BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            // 加载好坦克的上下左右4张图片
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankR = ImageUtil.rotateImage(goodTankU,90);
            goodTankL = ImageUtil.rotateImage(goodTankU,-90);
            goodTankD = ImageUtil.rotateImage(goodTankU,180);

            // 加载好坦克的上下左右4张图片
            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankR = ImageUtil.rotateImage(badTankU,90);
            badTankL = ImageUtil.rotateImage(badTankU,-90);
            badTankD = ImageUtil.rotateImage(badTankU,180);

            // 加载子弹的上下左右4张图片
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletR = ImageUtil.rotateImage(bulletU,90);
            bulletL = ImageUtil.rotateImage(bulletU,-90);
            bulletD = ImageUtil.rotateImage(bulletU,180);

            // 加载爆炸过程的16张图片
            for(int i =0;i<explodes.length;i++){
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
