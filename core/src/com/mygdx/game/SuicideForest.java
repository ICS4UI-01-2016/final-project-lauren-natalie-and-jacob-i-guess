package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.StateManager;

public class SuicideForest extends ApplicationAdapter {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    
    private SpriteBatch batch; // to draw stuffs
    private StateManager stateManager; // look after the different states

    // menu 
//        @Override
//        public void create() {
//        batch = new SpriteBatch();
//        Gdx.gl.glClearColor(1, 0, 0, 1); // colour to clear the screen with
//        
//        stateManager = new StateManager();
//        State firstScreen = new MenuState(stateManager);
//        stateManager.push(firstScreen); // load the first screen
//    }
    
    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // handle input
        stateManager.handleInput();
        // update the game states
        stateManager.update(Gdx.graphics.getDeltaTime());
        // draw the screen
        stateManager.render(batch);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
