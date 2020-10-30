package com.blackMamba.tank.decorator;

import com.blackMamba.tank.mediator.GameObject;

import java.awt.*;

/**
 * Created by Black Mamba on 2020/10/30 22:44
 *
 * @version 1.0
 * @description
 */
public abstract class GoDecorator extends GameObject {

    GameObject go ;

    public GoDecorator(GameObject go){
        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);
}
