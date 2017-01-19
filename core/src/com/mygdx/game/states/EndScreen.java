/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.SuicideForest;

/**
 *
 * @author halll7908
 */
public class EndScreen extends State {

    private Texture es;

    public EndScreen(StateManager gsm) {
        super(gsm);
        es = new Texture("endScreen.png");
        setCameraView(SuicideForest.WIDTH, SuicideForest.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        batch.draw(es, 0, 0, getViewWidth(), getViewHeight());
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public void handleInput() {
        // if click on screen, send back to menu
        if (Gdx.input.justTouched()) {
            StateManager gsm = getStateManager();
            gsm.pop();
        }
    }

    @Override
    public void dispose() {
        es.dispose();
    }
}