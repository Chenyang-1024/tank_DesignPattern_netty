package com.blackMamba.tank.chainOfResponsibility;

import com.blackMamba.tank.*;
import com.blackMamba.tank.mediator.GameObject;

/**
 * Created by Black Mamba on 2020/10/27 23:53
 *
 * @version 1.0
 * @description
 */
public class TankWallCollider implements Collide {
    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Wall){
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            if(tank.rectangle.intersects(wall.rectangle)){
                tank.back();
                return true;
            }
            return true;
        }else if(o1 instanceof Tank && o2 instanceof Bullet){
            return collideWith(o2,o1);
        }else{
            return true;
        }
    }
}
