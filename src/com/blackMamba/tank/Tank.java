package com.blackMamba.tank;

import com.blackMamba.tank.facade.GameModel;
import com.blackMamba.tank.mediator.GameObject;
import com.blackMamba.tank.strategy.DefaultFireStrategy;
import com.blackMamba.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * Created by Black Mamba on 2020/8/26 8:00
 *
 * @version 1.0
 * @description
 */
public class Tank extends GameObject {
    public Dir dir = Dir.UP;

    public int preX , preY;

    public Group tGroup = Group.GOOD;
    private static int SPEED = 2;
    public static final int TANK_WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int TANK_HEIGHT = ResourceMgr.goodTankU.getHeight();
    public Random random = new Random();
    public boolean moving = true;
    public boolean isDeath = false;
    public Rectangle rectangle = new Rectangle();

    FireStrategy fireStrategy = null;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir, Group tGroup) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tGroup = tGroup;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = TANK_WIDTH;
        rectangle.height = TANK_HEIGHT;

        if(this.tGroup == Group.GOOD) fireStrategy=new DefaultFireStrategy();
        else fireStrategy = new DefaultFireStrategy();

        GameModel.getInstance().add(this);
    }

    // 涉及到窗口需要重画时，会调用到该方法
    public void paint(Graphics g) {
        if(isDeath){
            GameModel.getInstance().remove(this);
        }
        switch (dir) {
            case UP:
                g.drawImage(this.tGroup == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.tGroup == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD,x,y,null);
                break;
            case LEFT:
                g.drawImage(this.tGroup == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.tGroup == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR,x,y,null);
                break;
            default:
                break;
        }
        move();
    }

    public void back(){
        this.x = preX;
        this.y = preY;
    }

    private void move(){
        preX = x;
        preY = y;
        if(!moving) return;
        if(this.tGroup == Group.GOOD) {SPEED = 5;}
        else {SPEED = 2;}
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

        // 坏坦克随机发射炮弹
        if(this.tGroup == Group.BAD && random.nextInt(200) > 195) this.fire();
        // 坏坦克随机更换方向
        if(this.tGroup == Group.BAD && random.nextInt(100) > 95) this.dir = Dir.values()[new Random().nextInt(4)];
        // 坏坦克边界检测
        if(this.tGroup == Group.BAD) boundsCheck();
        // rectangle随坦克移动
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    private void boundsCheck() {
        if(x < 2) x = 2;
        if(y < 2) y = 2;
        if(x > TankFrame.GAME_WIDTH-Tank.TANK_WIDTH -2) x = TankFrame.GAME_WIDTH-Tank.TANK_WIDTH -2;
        if(y > TankFrame.GAME_HEIGHT-Tank.TANK_HEIGHT -2) y = TankFrame.GAME_HEIGHT-Tank.TANK_HEIGHT -2;
    }

    public void fire() {
        fireStrategy.fireStrategy(this);
//        tankFrame.bulletList.add(new Bullet(this.x+(TANK_WIDTH-Bullet.BULLET_WIDTH)/2,this.y+(TANK_HEIGHT-Bullet.BULLET_HEIGHT)/2,this.dir,this.tGroup,this.tankFrame));
//        if(this.tGroup == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    public void die() {
        this.isDeath = true;
    }

    public void boom() {
        GameModel.getInstance().add(new Explode(this.x,this.y));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSpeed() {
        return SPEED;
    }

}
