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
public class Shigeru {

    private Vector3 position;
    private Vector3 velocity;
    private Texture shigeruPic;
    private Rectangle bounds;
    private final float MOVEMENT = 100;
    private float statetime = 0;
    //Shigeru run animation
    private Animation shigerun;

    public Shigeru(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(MOVEMENT, 0, 0);
        

        Array<TextureRegion> frames = new Array<TextureRegion>();
        for (int i = 1; i <= 4; i++) {
            frames.add(new TextureRegion(new Texture("ShigeruRun" + i + ".png")));
        }
        shigerun = new Animation(0.2f, frames);
        shigerun.setPlayMode(Animation.PlayMode.LOOP);
        bounds = new Rectangle(position.x, position.y, shigerun.getKeyFrames()[0].getTexture().getWidth(), shigerun.getKeyFrames()[0].getTexture().getHeight());
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
        batch.draw(shigerun.getKeyFrame(statetime), position.x, position.y);
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        // shigeruPic.dispose();
    }
}
