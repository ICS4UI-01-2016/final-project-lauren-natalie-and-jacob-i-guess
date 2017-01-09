/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author laurelizall
 */
public class Enemy {

    private final float PIPE_GAP = 100;
    private final float MIN_HEIGHT = 50;
    private final float MAX_HEIGHT = 350;
    public static final float WIDTH = 52;
    private Vector2 position;
    private Texture enemy;
    private Rectangle enemyBounds;

    public Enemy(float x) {
        float y = (int) (Math.random() * (325 - 75 + 1) + 75);
        position = new Vector2(x, y);
        enemy = new Texture("zombietemp.png");

        enemyBounds = new Rectangle(position.x, position.y - PIPE_GAP / 2 - enemy.getHeight(), enemy.getWidth(), enemy.getHeight());
    }

    public void render(SpriteBatch batch) {
        batch.draw(enemy, position.x, position.y - PIPE_GAP / 2 - enemy.getHeight());
    }

    public float getX() {
        return position.x;
    }

    public void setX(float x) {
        position.x = x;
        float y = (int) (Math.random() * (325 - 75 + 1) + 75);
        position.y = y;
        enemyBounds.setPosition(position.x, position.y - PIPE_GAP / 2 - enemy.getHeight());
    }

    public boolean collides(Shigeru b) {
        if (enemyBounds.overlaps(b.getBounds())) {
            return true;
        }
        return false;
    }

    public void dispose() {
        enemy.dispose();
    }
}
