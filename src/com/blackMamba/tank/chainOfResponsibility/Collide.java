package com.blackMamba.tank.chainOfResponsibility;

import com.blackMamba.tank.mediator.GameObject;

/**
 * Created by Black Mamba on 2020/10/25 15:53
 *
 * @version 1.0
 * @description
 */
public interface Collide {

    boolean collideWith(GameObject o1 , GameObject o2);
}
