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
public class PlayState extends State{
    private Shigeru shigeru;
    private Texture bg;
    private int score;
    private BitmapFont font;
    
    private final float CAM_X_OFFSET = 30;
    
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
    public void create() {
        batch = new SpriteBatch();
        Gdx.gl.glClearColor(1, 0, 0, 1); // colour to clear the screen with
        
        stateManager = new StateManager();
        State firstScreen = new MenuState(stateManager);
        stateManager.push(firstScreen); // load the first screen
    }
    
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

    @Override
    public void render(SpriteBatch batch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(float deltaTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
