/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class Zombie {

    private Vector3 position;
    private Vector3 velocity;
    private Texture shigeruPic;
    private Rectangle bounds;
    private final float MOVEMENT = 100;

    public Zombie(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(MOVEMENT, 0, 0);
        shigeruPic = new Texture("zombieChild.png");
        bounds = new Rectangle(position.x, position.y, shigeruPic.getWidth(), shigeruPic.getHeight());
    }

    // player input methods:
    // pushUpButton
    // pushDownButton
    // pushRightButton
    // pushLeftButton
    public void update(float deltaTime) {
        // scaling velocity by time
        velocity.scl(deltaTime);
        // adding velocity to position
        position.add(velocity);
        // unscale velocity
        velocity.scl(1 / deltaTime);

        // set the new bounds
        bounds.setPosition(position.x, position.y);
    }

    public void render(SpriteBatch batch) {
        batch.draw(shigeruPic, position.x, position.y);
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return 10;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean collides(Shigeru b) {
        if (bounds.overlaps(b.getBounds())) {
            return true;
        }
        return false;
    }

    public void dispose() {
        shigeruPic.dispose();
    }
}
