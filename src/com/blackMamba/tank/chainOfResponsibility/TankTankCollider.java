package com.blackMamba.tank.chainOfResponsibility;

import com.blackMamba.tank.Tank;
import com.blackMamba.tank.TankMain;
import com.blackMamba.tank.mediator.GameObject;

/**
 * Created by Black Mamba on 2020/10/25 16:29
 *
 * @version 1.0
 * @description
 *      坦克和坦克的碰撞检测
 */
public class TankTankCollider implements Collide {

    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Tank){
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank) o2;
            if(tank1.tGroup == tank2.tGroup && tank1.rectangle.intersects(tank2.rectangle)) {
                tank1.back();
                tank2.back();
                return true;
            }
            if(tank1.tGroup != tank2.tGroup && tank1.rectangle.intersects(tank2.rectangle)){
                tank1.die();
                tank2.die();
                tank1.boom();
                tank2.boom();
                TankMain.gameFlag = false;
                return false;
            }
            return true;

        }else{
            return true;
        }
    }
}
