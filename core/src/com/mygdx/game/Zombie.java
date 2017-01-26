/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author halll7908
 */
public class Zombie {

    static int randNum;
    private Vector2 position;
    private Rectangle boundsUp;
    private Rectangle boundsDown;
    private float statetime = 0;
    private final float MOVEMENT = 100;
    //arrow+zombie
    public Texture zombieUp;
    public Texture zombieDown;

    public Zombie(int x, int y) {
        position = new Vector2(x, y);

        // arrow+zombie
        zombieUp = new Texture("zombieUp.png");
        // zombieDown = new Texture("zombieDown.png");

        // zombie bounds
        // zombieUp
        boundsUp = new Rectangle(position.x, position.y, zombieUp.getWidth(), zombieUp.getHeight());
        //zombieDown
        // boundsDown = new Rectangle(position.x, position.y, zombieDown.getWidth(), zombieDown.getHeight());
    }

    public void update(float deltaTime) {
        // set the new bounds
        boundsUp.setPosition(position.x, position.y);
        // boundsDown.setPosition(position.x, position.y);
        statetime += deltaTime;
    }

    public void randNum() {
        randNum = (int) (Math.random() * 2);
    }

    public void render(SpriteBatch batch) {
        batch.draw(zombieUp, position.x, position.y);
    }
    
    public float getX() {
        return position.x;
    }

    public float getY() {
        return 10;
    }

    //returns zombie to off the screen
    public void returnToStartX() {
       if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
                position.x = Gdx.graphics.getWidth();
       }
   
    }
    
    public Rectangle getBounds() {
        //if (randNum == 0) {
        return boundsUp;
        //}
        //if (randNum == 1) {
        //    return boundsDown;
        //}
        //return null;
    }

    public boolean collides(Shigeru b) {
        // || boundsDown.overlaps(b.getBounds())
        if (boundsUp.overlaps(b.getBounds())) {
            return true;
        }
        return false;
    }

    public void dispose() {
     zombieUp.dispose();
    }
}
