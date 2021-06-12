/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem2_da;

import java.awt.Rectangle;
import java.io.File;
import pkg2dgamesframework.Objects;


/**
 *
 * @author ngnha
 */
public class Hero extends Objects {

    private float vt = 0;
    private boolean isFlying = false;
    private Rectangle rect;  
    private boolean isLive = true;

            
    public Hero(int x, int y, int w, int h) {
        super(x, y, w, h);
        rect = new Rectangle(x, y, w, h);
        //gọi âm thanh
    }
    
    public void setLive(boolean l){
        isLive = l;
    }
    
    public boolean getLive(){
        return isLive;
    }
    
    public Rectangle getRect(){
        return rect;
    }

    public void setVt(float vt) {
        this.vt = vt;
    }

    public void update(long deltaTime) {
        vt += Sem2_DA.g;
        this.setPosY(this.getPosY() + vt);
        this.rect.setLocation((int)this.getPosX(),(int)this.getPosY());
        if (vt < 0) isFlying = true;
        else isFlying = false;
    }

    public void fly() {
        vt = -2;
        this.setPosY(this.getPosY() + vt);
    }

    public boolean getIsFlying() {
        return isFlying;
    }
    
}
