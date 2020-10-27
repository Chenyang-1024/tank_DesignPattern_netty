package com.blackMamba.tank;

import com.blackMamba.tank.mediator.GameObject;

import java.awt.*;

/**
 * Created by Black Mamba on 2020/10/27 22:26
 *
 * @version 1.0
 * @description
 */
public class Wall extends GameObject {

    int w , h;

    public Rectangle rectangle;

    public Wall(int x , int y , int w , int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.rectangle = new Rectangle(x,y,w,h);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GRAY);
        g.fillRect(x,y,w,h);
        g.setColor(c);
    }
}
