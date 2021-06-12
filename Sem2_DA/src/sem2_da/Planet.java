/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem2_da;

import java.awt.Rectangle;
import pkg2dgamesframework.Objects;

/**
 *
 * @author ngnha
 */
public class Planet extends Objects {
    
    private Rectangle rect;
    private boolean isBehindHero = false; //xác định xem planet nằm sau hero ko
    public float time=0f;
    
    public Planet(int x, int y, int w, int h){
        super(x, y, w, h);
        rect = new Rectangle(x, y, w, h);
        
    }
    
    public void update(){
        time += Sem2_DA.g;
        System.out.println(time);
        setPosX(getPosX()-speed());
        rect.setLocation((int)this.getPosX(),(int)this.getPosY());
    }
    
    public Rectangle getRect(){
        return rect;
    }

    public boolean getisIsBehindHero() {
        return isBehindHero;
    }

    public void setIsBehindHero(boolean isBehindHero) { 
        this.isBehindHero = isBehindHero;
    }
    
    public int speed(){
        if (time <500) return 2;
        else if (time <1000) return 3;
        else if (time <2000) return 4;
        else if (time <3000) return 5;
        else if (time <4000) return 6;
        else return 7;
    }
    
    
}
