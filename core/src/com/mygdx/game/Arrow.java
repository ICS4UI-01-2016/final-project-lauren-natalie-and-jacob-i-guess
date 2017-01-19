/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author moraj0721
 */
public class Arrow {
    public Texture arrowUp;
    public Texture arrowRight;
    public Texture arrowLeft;
    public Texture arrowDown;
    private Zombie zombie;
    
    
    
    public Arrow (int x, int y){
        arrowUp = new Texture("arrowUp");
        arrowRight = new Texture("arrowRight");
        arrowLeft = new Texture("arrowLeft");
        arrowDown = new Texture("arrowDown");
        }
    
    public int arrowGenerator(){
        float y = (int)(Math.random()*3);
        
        if(y = 1){
        return arrowUp;
    }
    }
    
    
    
    public boolean isUp(){
        if(arrowUp = ){
            return true;
        }
    }
    
    public float getX(){
        return zombie.getX();
    }
    
    public float getY(){
        return zombie.getY();
    }
    
    
    
}
