package com.blackMamba.tank.abstractFactory;

import com.blackMamba.tank.TankFrame;

/**
 * Created by Black Mamba on 2020/10/12 21:51
 *
 * @version 1.0
 * @description
 */
// 名词用抽象类 形容词用接口
public abstract class GameFactoty {

    public abstract BaseTank createTank(int x , int y , TankFrame tf);

    public abstract BaseBullet createBullet(int x , int y , TankFrame tf);

    public abstract BaseExplode createExplode(int x , int y , TankFrame tf);

}
