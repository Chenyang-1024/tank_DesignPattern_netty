package com.blackMamba.tank.strategy;

import com.blackMamba.tank.Bullet;
import com.blackMamba.tank.Tank;

/**
 * Created by Black Mamba on 2020/9/9 20:34
 *
 * @version 1.0
 * @description
 */
public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fireStrategy(Tank t) {
        int bulletX = t.getX()+(Tank.TANK_WIDTH-Bullet.BULLET_WIDTH)/2;
        int bulletY = t.getY()+(Tank.TANK_HEIGHT-Bullet.BULLET_HEIGHT)/2;

        new Bullet(bulletX,bulletY,t.dir,t.tGroup);

    }
}
