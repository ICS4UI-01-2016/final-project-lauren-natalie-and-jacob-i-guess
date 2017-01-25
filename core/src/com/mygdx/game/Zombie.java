/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author halll7908
 */
public class Zombie {

    static int randNum;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle boundsUp;
    private Rectangle boundsDown;
    private float statetime = 0;
    private final float MOVEMENT = 100;
    //arrow+zombie
    public Texture zombieUp;
    public Texture zombieDown;

    public Zombie(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(MOVEMENT, 0, 0);

        // arrow+zombie
        zombieUp = new Texture("zombieUp.png");
        zombieDown = new Texture("zombieDown.png");

        // zombie bounds
        // zombieUp
        boundsUp = new Rectangle(position.x, position.y, zombieUp.getWidth(), zombieUp.getHeight());
        //zombieDown
        boundsDown = new Rectangle(position.x, position.y, zombieDown.getWidth(), zombieDown.getHeight());
    }

    public void update(float deltaTime) {
        // scaling velocity by time
        velocity.scl(deltaTime);
        // adding velocity to position
        position.add(velocity);
        // unscale velocity
        velocity.scl(1 / deltaTime);

        // set the new bounds
        boundsUp.setPosition(position.x, position.y);
        boundsDown.setPosition(position.x, position.y);
        statetime += deltaTime;
    }

    public void randNum() {
        randNum = (int) (Math.random() * 2);
    }

    public void render(SpriteBatch batch) {
        if (randNum == 0) {
            batch.draw(zombieUp, position.x, position.y);
        }
        if (randNum == 1) {
            batch.draw(zombieDown, position.x, position.y);
        }
    }

    public boolean isUp() {
        if (randNum == 0) {
            System.out.println("here" + randNum);
            return true;
        }
        return false;
    }

    public boolean isDown() {
        if (randNum == 1) {
            System.out.println("here" + randNum);
            return true;
        }
        return false;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return 10;
    }

    public Rectangle getBounds() {
        if (randNum == 0) {
            return boundsUp;
        }
        if (randNum == 1) {
            return boundsDown;
        }
        return null;
    }

    public boolean collides(Shigeru b) {
        if (boundsUp.overlaps(b.getBounds()) || boundsDown.overlaps(b.getBounds())) {
            return true;
        }
        return false;
    }

    public void dispose() {
        //  for (int i = 0; i < zombie.length; i++) {
        //  zombie.dispose();
        // }
    }
}
