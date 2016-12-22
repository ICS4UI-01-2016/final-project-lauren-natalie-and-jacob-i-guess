/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Shigeru;
import com.mygdx.game.SuicideForest;
import com.mygdx.game.Enemy;

/**
 *
 * @author pirc0556
 */
public class PlayState extends State {

    private Shigeru shigeru;
    private Enemy[] enemy;
    private Texture bg;
    private final float CAM_X_OFFSET = 100;

    public PlayState(StateManager sm) {
        super(sm);
        setCameraView(SuicideForest.WIDTH / 2, SuicideForest.HEIGHT / 2);
        //setCameraPosition(SuicideForest.WIDTH/2, SuicideForest.HEIGHT/2);
        shigeru = new Shigeru(90, 30);
        bg = new Texture("fullBgPic.png");
        // move the camera to match the shigeru
        moveCameraX(shigeru.getX() + CAM_X_OFFSET);
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
        // draw the shigeru
        shigeru.render(batch);
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

        // did the shigeru hit an enemy
        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i].collides(shigeru)) {
                // end the game
                StateManager gsm = getStateManager();
                // pop off the game screen to go to menu
                gsm.pop();
            }
        }
    }

    @Override
    public void handleInput() {
        // handle any player input changes
        // pushUpButton
        // pushDownButton
        // pushRightButton
        // pushLeftButton
    }

    @Override
    public void dispose() {
        bg.dispose();
        shigeru.dispose();
        for (int i = 0; i < enemy.length; i++) {
            enemy[i].dispose();
        }
    }
}
