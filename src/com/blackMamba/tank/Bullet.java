package com.blackMamba.tank;

import com.blackMamba.tank.facade.GameModel;
import com.blackMamba.tank.mediator.GameObject;

import java.awt.*;

/**
 * Created by Black Mamba on 2020/8/26 19:26
 *
 * @version 1.0
 * @description
 */
public class Bullet extends GameObject {

    private static final int SPEED = 10;
    public static final int BULLET_WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int BULLET_HEIGHT = ResourceMgr.bulletD.getHeight();
    private Dir dir;
    public Group bGroup = Group.GOOD;
    public GameModel gm = null;
    public Rectangle rectangle = new Rectangle();

    public boolean isDeath = false;

    public Bullet(int x, int y, Dir dir, Group bGroup , GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.bGroup = bGroup;
        this.gm = gm;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = BULLET_WIDTH;
        rectangle.height = BULLET_HEIGHT;

        gm.add(this);
    }

    public void paint(Graphics g) {
        if(isDeath){
            gm.remove(this);
        }

        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            default:
                break;
        }

        move();
    }

    private void move(){
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

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) isDeath = true;
        // rectangle随坦克移动
        rectangle.x = this.x;
        rectangle.y = this.y;

    }

    public void collideWith(Tank tank){
        if(this.bGroup == tank.tGroup) return;
        if(this.isDeath == false && tank.isDeath == false && rectangle.intersects(tank.rectangle)){
            this.die();
            tank.die();
            tank.boom();
            if(tank.tGroup == Group.GOOD) TankMain.gameFlag = false;
        }
    }

    public void die() {
        this.isDeath = true;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

}
