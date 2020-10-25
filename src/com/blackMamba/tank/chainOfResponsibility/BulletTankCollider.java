package com.blackMamba.tank.chainOfResponsibility;

import com.blackMamba.tank.Bullet;
import com.blackMamba.tank.Group;
import com.blackMamba.tank.Tank;
import com.blackMamba.tank.TankMain;
import com.blackMamba.tank.mediator.GameObject;

/**
 * Created by Black Mamba on 2020/10/25 15:53
 *
 * @version 1.0
 * @description
 *      炮弹和坦克的碰撞检测
 */
public class BulletTankCollider implements Collide {
    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            if(bullet.bGroup == tank.tGroup) {
                return true;
            }
            if(bullet.isDeath == false && tank.isDeath == false && bullet.rectangle.intersects(tank.rectangle)){
                bullet.die();
                tank.die();
                tank.boom();
                if(tank.tGroup == Group.GOOD) {
                    TankMain.gameFlag = false;
                    return false;
                }
                return false;
            }
            return true;

        }else if(o1 instanceof Tank && o2 instanceof Bullet){
            return collideWith(o2,o1);
        }else{
            return true;
        }
    }
}
