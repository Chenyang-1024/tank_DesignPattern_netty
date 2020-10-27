package com.blackMamba.tank.chainOfResponsibility;

import com.blackMamba.tank.*;
import com.blackMamba.tank.mediator.GameObject;

/**
 * Created by Black Mamba on 2020/10/25 15:53
 *
 * @version 1.0
 * @description
 *      炮弹和坦克的碰撞检测
 */
public class BulletWallCollider implements Collide {
    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            if(bullet.rectangle.intersects(wall.rectangle)){
                bullet.die();
                return false;
            }
            return true;
        }else if(o1 instanceof Wall && o2 instanceof Bullet){
            return collideWith(o2,o1);
        }else{
            return true;
        }
    }
}
