/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.SuicideForest;

/**
 *
 * @author pircn0556
 */
public class CreditState extends State {

    private Texture bg1;
    private Rectangle back;
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Music music1;

    public CreditState(StateManager gsm) {
        super(gsm);
        bg1 = new Texture("creditScreen.jpg");
        setCameraView(SuicideForest.WIDTH, SuicideForest.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        //create parameter for the "button"
        back = new Rectangle(10,10,10,10);
        //create music and play it
        Music music1 = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music1.play();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        //draw background image
        batch.draw(bg1, 0, 0, getViewWidth(), getViewHeight());
        batch.end();
        
        //create shapeRenderer to create the button so user can move between menu screens
        shapeRenderer.setProjectionMatrix(getCombinedCamera());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(0,0,10,10);
        shapeRenderer.end();
        
        
    }

    @Override
    public void update(float deltaTime) {
        
    }

    @Override
    public void handleInput() {
        //Check if parameter is clicked on, to screen menu screens
        if (Gdx.input.isTouched()) {
            StateManager gsm = getStateManager();
            gsm.push(new MenuState(gsm));
        }
    }

    @Override
    public void dispose() {
        //remove background image so that game runs smoother
        bg1.dispose();
         //remove music so that it stops when changing to another screen
        music1.dispose();
    }
}
