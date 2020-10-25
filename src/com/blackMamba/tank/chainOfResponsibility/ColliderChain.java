package com.blackMamba.tank.chainOfResponsibility;

import com.blackMamba.tank.PropertiesMgr;
import com.blackMamba.tank.mediator.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Black Mamba on 2020/10/25 16:39
 *
 * @version 1.0
 * @description
 */
public class ColliderChain implements Collide {

    public List<Collide> colliderChains = new LinkedList<>();

    public ColliderChain(){
        // 通过读取配置文件的方式加载碰撞检测器
        String[] colliderArr = PropertiesMgr.prop.getProperty("colliderChains").split(",");
        for (String className:colliderArr) {
            try {
                Class c = Class.forName(className);
                Collide collide = (Collide) c.newInstance();
                add(collide);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
//        add(new BulletTankCollider());
//        add(new TankTankCollider());

    }

    public void add(Collide collide){
        colliderChains.add(collide);
    }

    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        boolean flag = true;
        for(int i =0;i<colliderChains.size();i++){
            if(flag){
                flag = colliderChains.get(i).collideWith(o1,o2);
            }
        }
        return flag;
    }
}
