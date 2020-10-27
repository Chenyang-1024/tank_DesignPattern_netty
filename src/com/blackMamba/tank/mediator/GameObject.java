package com.blackMamba.tank.mediator;

import com.blackMamba.tank.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black Mamba on 2020/10/24 15:24
 *
 * @version 1.0
 * @description
 */
public abstract class GameObject {

    // 将游戏对象转移到GameObject中
    public int x , y;
    public java.util.List<Bullet> bulletList = new ArrayList<Bullet>();
    public java.util.List<Explode> explodeList = new ArrayList<>();
    public List<Tank> tankList = new ArrayList<>();

    public abstract void paint(Graphics g);
}
