/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.SuicideForest;

/**
 *
 * @author pirc0556
 */
public class MenuState extends State {

    private Texture bg;
    private Rectangle play;
    private Rectangle help;
    private Rectangle credits;
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Music music;

    public MenuState(StateManager gsm) {
        super(gsm);
        bg = new Texture("MenuScreen960x720.png");
        setCameraView(SuicideForest.WIDTH, SuicideForest.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        //create parameter for the buttons
        play = new Rectangle(290, 170, 378, 150);
        help = new Rectangle(180, 38, 245, 90);
        credits = new Rectangle(535, 35, 245, 90);

        // create music and play it
        music = Gdx.audio.newMusic(Gdx.files.internal("OpeningMusic.mp3"));
        music.play();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        //draw background image
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public void handleInput() {
        // Check if parameter is clicked on, to screen menu screens
        if (Gdx.input.justTouched()) {

            //get the mouse click/touch position
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

            unproject(touch);
            //check if button is pressed
            if (play.contains(touch.x, touch.y)) {
                music.pause();
                StateManager gsm = getStateManager();
                gsm.push(new PlayState(gsm));

            } else if (help.contains(touch.x, touch.y)) {
                music.pause();
                StateManager gsm = getStateManager();
                gsm.push(new HelpState(gsm));

            } else if (credits.contains(touch.x, touch.y)) {
                music.pause();
                StateManager gsm = getStateManager();
                gsm.push(new CreditState(gsm));
            }
        }
    }

    @Override
    public void dispose() {
        //remove background image so that game runs smoother
        bg.dispose();
        //remove music so that it stops when changing to another screen
        music.dispose();
    }
}
