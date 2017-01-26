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
import com.mygdx.game.Shigeru;
import com.mygdx.game.SuicideForest;
import com.mygdx.game.Zombie;

/**
 *
 * @author pirc0556
 */
public class PlayState extends State {

    private Shigeru shigeru;
    private Zombie zombie;
    private Texture heart1;
    private Texture heart2;
    private Texture heart3;
    private Texture bg;
    private Music musicPlay;
    private final float CAM_X_OFFSET = 400;

    public PlayState(StateManager sm) {
        super(sm);
        setCameraView(SuicideForest.WIDTH, SuicideForest.HEIGHT);
        //create shigeru
        shigeru = new Shigeru(90, 30);
        bg = new Texture("fullBgPic.png");
        heart1 = new Texture("heart.png");
        heart2 = new Texture("heart.png");
        heart3 = new Texture("heart.png");
        // move the camera to match the shigeru
        moveCameraX(shigeru.getX() + CAM_X_OFFSET);
        //create the zombie
        zombie = new Zombie(1000, 30);
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
        zombie.render(batch);

        // end the stuff to draw
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        // update any game models
        shigeru.update(deltaTime);
        zombie.update(deltaTime);
        // move the camera to match the shigeru
        moveCameraX(shigeru.getX() + CAM_X_OFFSET);
        // did the zombie hit the shigeru
        if (zombie.collides(shigeru)) {
            // end the game
            StateManager gsm = getStateManager();
            // pop off the game screen to go to menu 
            gsm.set(new EndScreen(gsm));
        }
        //update zombie returning to its original spot (off the screen)
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            zombie.returnToStartX();
        }
    }

    @Override
    public void handleInput() {
        // handle any player input changes
        // zombie up - up key pressed
//        if (zombie.isUp() == true && Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
//            // delete and respawn at far right
//            zombie.returnToStartXY();
//        }
//        // zombie down - down key pressed
//        if (zombie.isDown() == true && Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
//            // delete and respawn at far right
//            zombie.returnToStartXY();
//        }
        // for just up

        //if the user presses the up key

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            StateManager gsm = getStateManager();
            // pop off the game screen to go to menu 
            gsm.set(new PlayState(gsm));
            // add point to counter
            // 
        }

    }

    @Override
    public void dispose() {
        //remove all objects that dont belong in other states
        bg.dispose();
        shigeru.dispose();
        zombie.dispose();
        //stop the music from playing
        musicPlay.dispose();
    }
}