/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author moraj0721
 */
public class Arrow {

    private int random;
    public boolean arrowPic;
    private Zombie zombie;
    private Vector3 position;
    private Vector3 velocity;
    private final float MOVEMENT = 100;

    public Arrow(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(MOVEMENT, 0, 0);
    }
    
    public String getDirection(){
        if (Zombie.randNum == 0){
            return "arrowUp";
        }
        if (Zombie.randNum == 1){
            return "arrowRight";
        }
        if (Zombie.randNum == 2){
            return "arrowLeft";
        }
        if (Zombie.randNum == 3){
            return "arrowRight";
        }
        return null;
    }

    public boolean isUp() {
        if (random == 0) {
            return true;
        }
        return false;
    }

    public boolean isRight() {
        if (random == 1) {
            return true;
        }
        return false;
    }

    public boolean isLeft() {
        if (random == 2) {
            return true;
        }
        return false;
    }

    public boolean isDown() {
        if (random == 3) {
            return true;
        }
        return false;
    }

    public float getX() {
        return position.x + 10;
    }

    public float getY() {
        return 45;
    }

    public void render(SpriteBatch batch) {
    }
    
    
}
