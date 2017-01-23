/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Arrow;
import com.mygdx.game.Shigeru;
import com.mygdx.game.SuicideForest;
import com.mygdx.game.Zombie;

/**
 *
 * @author pirc0556
 */
public class PlayState extends State {

    private Shigeru shigeru;
    private Zombie[] zombie;
    private Arrow[] arrow;
    private Texture heart1;
    private Texture heart2;
    private Texture heart3;
    private Texture bg;
    private Music musicPlay;
    private final float CAM_X_OFFSET = 400;

    public PlayState(StateManager sm) {
        super(sm);
        setCameraView(SuicideForest.WIDTH, SuicideForest.HEIGHT);
        shigeru = new Shigeru(90, 30);
        bg = new Texture("fullBgPic.png");
        heart1 = new Texture("heart.png");
        heart2 = new Texture("heart.png");
        heart3 = new Texture("heart.png");
        // move the camera to match the shigeru
        moveCameraX(shigeru.getX() + CAM_X_OFFSET);

        // creating the zombies
        zombie = new Zombie[3];
        for (int i = 0; i < zombie.length; i++) {
            zombie[i] = new Zombie(680, 30);
        }
        
        // creating the arrows
        arrow = new Arrow[4];
        for (int i = 0; i < arrow.length; i++) {
            arrow[i] = new Arrow(680, 30);
        }
        
         //create music and play it
        musicPlay = Gdx.audio.newMusic(Gdx.files.internal("GameplayMusic.mp3"));
        musicPlay.play();
        
    }

    @Override
    public void render(SpriteBatch batch) {
        // draw the screen
        // link spritebatch to the camera
        batch.setProjectionMatrix(getCombinedCamera());
        // beginning of stuff to draw
        batch.begin();
        // draw the background
        batch.draw(bg, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2);
        // draw the hearts
        batch.draw(heart1, getCameraX() - getViewWidth() / 2 + 15, 615);
        batch.draw(heart2, getCameraX() - getViewWidth() / 2 + 80, 615);
        batch.draw(heart3, getCameraX() - getViewWidth() / 2 + 145, 615);
        // draw the shigeru
        shigeru.render(batch);
        // draw the zombie
        for (int i = 0; i < zombie.length; i++) {
            zombie[i].render(batch);
        }
        
        // draw the arrows
        for (int i = 0; i < arrow.length; i++) {
            arrow[i].render(batch);
        }
        
        // end the stuff to draw
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        // update any game models
        shigeru.update(deltaTime);
        // move the camera to match the shigeru
        moveCameraX(shigeru.getX() + CAM_X_OFFSET);

        // did shigeru hit the bottom of the screen
        if (shigeru.getY() <= 0) {
            // end the game
            StateManager gsm = getStateManager();
            // pop off the game screen to go to menu
            gsm.pop();
        }

        // did the zombie hit the shigeru
        for (int i = 0; i < zombie.length; i++) {
            if (zombie[i].collides(shigeru)) {
                // end the game
                StateManager gsm = getStateManager();
                // pop off the game screen to go to menu                         // how to push end screen 
                gsm.set(new EndScreen(gsm));
            }
        }
    }

    @Override
    public void handleInput() {
        // handle any player input changes

        // pushUpButton
        // if arrow above zombie is UP
        if (arrow[i].isUp() == true) {                                          // fix 'i'
            if (Gdx.input.isButtonPressed(Input.Keys.UP)) {
                for (int i = 0; i < zombie.length; i++) {
                    zombie[i] = new Zombie(680, 30);
                }
            }
        }
//
//        // pushDownButton
//        // if arrow above zombie is DOWN
//        if (arrow.isDown()) {
//            if (Gdx.input.isButtonPressed(Input.Keys.DOWN)) {
//                for (int i = 0; i < zombie.length; i++) {
//                    zombie[i] = new Zombie(680, 30);
//                }
//            }
//        }
//
//        // pushRightButton
//        // if arrow above zombie is RIGHT
//        if (arrow.isRight()) {
//            if (Gdx.input.isButtonPressed(Input.Keys.RIGHT)) {
//                for (int i = 0; i < zombie.length; i++) {
//                    zombie[i] = new Zombie(680, 30);
//                }
//            }
//        }
//
//        // pushLeftButton
//        // if arrow above zombie is LEFT
//        if (arrow.isLeft()) {
//            if (Gdx.input.isButtonPressed(Input.Keys.LEFT)) {
//                for (int i = 0; i < zombie.length; i++) {
//                    zombie[i] = new Zombie(680, 30);
//                }
//            }
//        }
    }

    @Override
    public void dispose() {
        bg.dispose();
        shigeru.dispose();
        for (int i = 0; i < zombie.length; i++) {
        zombie[i].dispose();
        //stop the music from playing
        musicPlay.dispose();
        
        }
    }
}
