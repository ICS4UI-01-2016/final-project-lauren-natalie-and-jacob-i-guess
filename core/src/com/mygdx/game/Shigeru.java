/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author pircn0556
 */
public class Shigeru {

    private Vector3 position;
    private Vector3 velocity;
    private Texture shigeruPic; // ADD base picture for Shigeru
    private Rectangle bounds;

    private final float GRAVITY = -15;  // gravity for jumping?
    private final float MOVEMENT = 100;
    
    // collisions of character
    public Shigeru(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(MOVEMENT, 0, 0);
        shigeruPic = new Texture("shigeruPic.png");
        bounds = new Rectangle(position.x, position.y, shigeruPic.getWidth(), shigeruPic.getHeight());
    }

    public void jump() {
        velocity.y = 250;
    }
    
    public void render(SpriteBatch batch){
        batch.draw(shigeruPic, position.x, position.y);
    }
    
    public float getX(){
        return position.x;
    }
    
    public float getY(){
        return position.y;
    }
    
    public Rectangle getBounds(){
        return bounds;
    }
    
    public void dispose(){
        shigeruPic.dispose();
    }
}
