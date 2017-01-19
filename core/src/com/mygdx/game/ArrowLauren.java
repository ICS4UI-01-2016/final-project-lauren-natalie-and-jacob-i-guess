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
 * @author halll7908
 */
public class ArrowLauren {

    private Vector3 position;
    private Vector3 velocity;
    private Texture arrowUp;
    private Texture arrowDown;
    private Texture arrowLeft;
    private Texture arrowRight;
    private final float MOVEMENT = 100;

    public ArrowLauren(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(MOVEMENT, 0, 0);
        arrowUp = new Texture("arrowUp.png");
        arrowDown = new Texture("arrowDown.png");
        arrowLeft = new Texture("arrowLeft.png");
        arrowRight = new Texture("arrowRight.png");
    }
    
    public void update(float deltaTime) {
        // scaling velocity by time
        velocity.scl(deltaTime);
        // adding velocity to position
        position.add(velocity);
        // unscale velocity
        velocity.scl(1 / deltaTime);
    }

    public void render(SpriteBatch batch) {
        batch.draw(arrowUp, position.x, position.y);
        batch.draw(arrowDown, position.x, position.y);
        batch.draw(arrowLeft, position.x, position.y);
        batch.draw(arrowDown, position.x, position.y);
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return 10;
    }
    
    public boolean isUp() {
        return true;
    } 

    public boolean isDown() {
        return true;
    }
    
    public boolean isLeft() {
        return true;
    }
    
    public boolean isRight() {
        return true;
    }
    
    public void dispose() {
        arrowUp.dispose();
        arrowDown.dispose();
        arrowLeft.dispose();
        arrowRight.dispose();
    }
}
