/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Shigeru;
import com.mygdx.game.SuicideForest;

/**
 *
 * @author pircn0556
 */
public class PlayState extends State {

    private Shigeru shigeru;
    private Texture bg;
    private int score;
    private BitmapFont font;
    private final float CAM_X_OFFSET = 30;
    private final float PIPE_GAP_AMOUNT = 4;

    public PlayState(StateManager sm) {
        super(sm);
        setCameraView(SuicideForest.WIDTH / 2, SuicideForest.HEIGHT / 2);
        //setCameraPosition(FlappyBird.WIDTH/2, FlappyBird.HEIGHT/2);
        shigeru = new Shigeru(50, 200);
        bg = new Texture("bg.png");
        // move the camera to match the bird
        moveCameraX(shigeru.getX() + CAM_X_OFFSET);

        // set up the score and font
        score = 0;
        font = new BitmapFont();
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
        // draw the score
        font.draw(batch, "" + score, getCameraX(), getCameraY() + 150);
        // end the stuff to draw
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        // update any game models
        shigeru.update(deltaTime);
        // move the camera to match the bird
        moveCameraX(shigeru.getX() + CAM_X_OFFSET);

        // did bird hit the bottom of the screen
        if (shigeru.getY() <= 0) {
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

        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
        public void dispose() {
        bg.dispose();
        shigeru.dispose();
    }
}
