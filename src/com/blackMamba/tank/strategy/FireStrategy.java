package com.blackMamba.tank.strategy;

import com.blackMamba.tank.Tank;

/**
 * Created by Black Mamba on 2020/9/9 20:29
 *
 * @version 1.0
 * @description
 *      坦克开火的策略接口
 */
public interface FireStrategy {

    void fireStrategy(Tank t);
}
