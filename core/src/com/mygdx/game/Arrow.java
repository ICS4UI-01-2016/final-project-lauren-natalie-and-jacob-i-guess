/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author moraj0721
 */
public class Arrow {

    private int random;
    public boolean arrowPic;
    public Texture arrowUp;
    public Texture arrowRight;
    public Texture arrowLeft;
    public Texture arrowDown;
    private Zombie zombie;

    public Arrow(int x, int y) {
        arrowUp = new Texture("arrowUp");
        arrowRight = new Texture("arrowRight");
        arrowLeft = new Texture("arrowLeft");
        arrowDown = new Texture("arrowDown");
    }

    private Texture arrowGenerator() {

        random = (int) (Math.random() * 3);

        if (random == 0) {
            return arrowUp;
        }

        if (random == 1) {
            return arrowRight;
        }

        if (random == 2) {
            return arrowLeft;
        }

        if (random == 3) {
            return arrowDown;
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
        return zombie.getX();
    }

    public float getY() {
        return zombie.getY();
    }

    public void render(SpriteBatch batch) {
        if (random == 0) {
            batch.draw(arrowUp, getX(), getY() + 200);
        }

        if (random == 1) {
            batch.draw(arrowRight, getX(), getY() + 200);
        }

        if (random == 2) {
            batch.draw(arrowLeft, getX(), getY() + 200);
        }

        if (random == 3) {
            batch.draw(arrowDown, getX(), getY() + 200);
        }

    }
}
