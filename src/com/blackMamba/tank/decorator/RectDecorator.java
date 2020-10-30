package com.blackMamba.tank.decorator;

import com.blackMamba.tank.facade.GameModel;
import com.blackMamba.tank.mediator.GameObject;

import java.awt.*;

/**
 * Created by Black Mamba on 2020/10/30 22:48
 *
 * @version 1.0
 * @description
 */
public class RectDecorator extends GoDecorator {

    public RectDecorator(GameObject go) {
        super(go);
        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(go.x,go.y,go.width,go.height);
        g.setColor(c);
    }
}
