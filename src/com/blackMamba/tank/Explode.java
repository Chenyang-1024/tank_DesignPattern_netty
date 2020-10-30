package com.blackMamba.tank;

import com.blackMamba.tank.facade.GameModel;
import com.blackMamba.tank.mediator.GameObject;

import java.awt.*;

/**
 * Created by Black Mamba on 2020/8/29 11:56
 *
 * @version 1.0
 * @description
 */
public class Explode extends GameObject {

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    int step = 0;

    public void paint(Graphics g) {

        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step >= ResourceMgr.explodes.length){
            GameModel.getInstance().remove(this);
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
