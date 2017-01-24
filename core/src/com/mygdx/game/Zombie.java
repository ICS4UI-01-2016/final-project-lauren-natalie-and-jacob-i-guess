/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
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
    private Rectangle bounds;
    private float statetime = 0;
    private final float MOVEMENT = 100;
    private Animation zombiewalk;
    private Arrow arrow;
    // arrow textures
    public Texture arrowUp;
    public Texture arrowRight;
    public Texture arrowLeft;
    public Texture arrowDown;

    public Zombie(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(MOVEMENT, 0, 0);
        // arrows
        arrowUp = new Texture("arrowUp.png");
        arrowRight = new Texture("arrowRight.png");
        arrowLeft = new Texture("arrowLeft.png");
        arrowDown = new Texture("arrowDown.png ");

        Array<TextureRegion> frames = new Array<TextureRegion>();
        for (int i = 1; i <= 2; i++) {                                              // FIX THIS?
            frames.add(new TextureRegion(new Texture("ZombieChild" + i + ".png")));
        }
        zombiewalk = new Animation(0.2f, frames);
        zombiewalk.setPlayMode(Animation.PlayMode.LOOP);
        bounds = new Rectangle(position.x, position.y, zombiewalk.getKeyFrames()[0].getTexture().getWidth(), zombiewalk.getKeyFrames()[0].getTexture().getHeight());
    }

    public void randNum(){
        randNum = (int) (Math.random()*3);
    }
    
    public void arrow(){
        
    }
    
    public void update(float deltaTime) {
        // scaling velocity by time
        velocity.scl(deltaTime);
        // adding velocity to position
        position.add(velocity);
        // unscale velocity
        velocity.scl(1 / deltaTime);

        // set the new bounds
        bounds.setPosition(position.x, position.y);
        statetime += deltaTime;
    }

    public void render(SpriteBatch batch) {
        batch.draw(zombiewalk.getKeyFrame(statetime), position.x, position.y);
        // batch.draw(arrowPic, position.x, position.y + 200);
        
        if (randNum == 0) {
            batch.draw(arrowUp, getX(), getY() + 200);
        }

        if (randNum == 1) {
            batch.draw(arrowRight, getX(), getY() + 200);
        }

        if (randNum == 2) {
            batch.draw(arrowLeft, getX(), getY() + 200);
        }

        if (randNum == 3) {
            batch.draw(arrowDown, getX(), getY() + 200);
        }
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
        //  for (int i = 0; i < zombie.length; i++) {
        //  zombie.dispose();
        // }
    }
}
