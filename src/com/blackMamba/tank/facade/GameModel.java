package com.blackMamba.tank.facade;

import com.blackMamba.tank.*;
import com.blackMamba.tank.chainOfResponsibility.ColliderChain;
import com.blackMamba.tank.mediator.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Black Mamba on 2020/9/26 17:15
 *
 * @version 1.0
 * @description
 */
public class GameModel {

    public static final GameModel instance = new GameModel();

    static {
        instance.init();
    }

    public static GameModel getInstance(){
        return instance;
    }

    // 把tank对象封装起来，，体现面向对象编程
    Tank myTank;

    public List<GameObject> gos = new ArrayList<>();
    // 引入责任链模式
    ColliderChain colliderChain = new ColliderChain();

    private GameModel(){}

    private void init(){
        myTank = new Tank(Integer.parseInt(PropertiesMgr.prop.getProperty("myTankX")), Integer.parseInt(PropertiesMgr.prop.getProperty("myTankY")), Dir.UP, Group.GOOD);

        for(int i = new Random().nextInt(15); i>0; i--){
            new Tank((i*80),150,Dir.DOWN,Group.BAD);
        }

        add(new Wall(250,250,250,40));
        add(new Wall(600,250,250,40));
        add(new Wall(375,350,40,200));
        add(new Wall(720,350,40,200));
    }

    public void add(GameObject go){
        this.gos.add(go);
    }

    public void remove(GameObject go){
        this.gos.remove(go);
    }

    public void paint(Graphics g) {
        int bulletCount = 0;
        int tankCount = 0;
        for(int i =0;i<gos.size();i++){
            if(gos.get(i) instanceof Bullet){
                bulletCount += 1;
            }else if(gos.get(i) instanceof Tank){
                tankCount += 1;
            }
        }

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("炮弹的数量："+bulletCount,20,60);
        g.drawString("敌军的数量："+(tankCount-1),20,80);
        g.setColor(c);


        // 画所有游戏对象
        for(int i = 0; i < gos.size();i++){
            gos.get(i).paint(g);
        }


        /**
         * 这种遍历删除方式可以避免发生 java.util.ConcurrentModificationException
         * 如果对该异常不熟悉的，建议Google搜索下异常原因及解决方案在。
         */
        /*for(Iterator<Bullet> it = bulletList.iterator(); it.hasNext();){
            Bullet bullet = it.next();
            if(bullet.isDeath){
                it.remove();
            }else{
                bullet.paint(g);
            }
        }*/

        for(int i = 0;i<gos.size();i++){
            for(int j = 0;j<gos.size();j++){
                if(j != i) {
                    /*collide.collideWith(gos.get(i),gos.get(j));
                    collide1.collideWith(gos.get(i),gos.get(j));*/
                    colliderChain.collideWith(gos.get(i),gos.get(j));
                }
            }
        }
    }

    public Tank getMyTank(){
        return myTank;
    }

}
