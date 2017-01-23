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
import com.badlogic.gdx.math.Vector3;
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
        back = new Rectangle(170, 50, 160, 83);
        //create music and play it
        music1 = Gdx.audio.newMusic(Gdx.files.internal("OpeningMusic.mp3"));
        music1.play();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        //draw background image
        batch.draw(bg1, 0, 0, getViewWidth(), getViewHeight());
        batch.end();



    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            //get the mouse click/touch position
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            //convert that point to came coordinates
            unproject(touch);

           if(back.contains(touch.x, touch.y)){
                music1.pause();
                StateManager gsm = getStateManager();
                gsm.push(new MenuState(gsm));

            }
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
