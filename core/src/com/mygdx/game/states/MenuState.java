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
    private float buttonx = 0;
    private float buttony = 0;
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Music music;

    public MenuState(StateManager gsm) {
        super(gsm);
        bg = new Texture("MenuScreen960x720.png");
        setCameraView(SuicideForest.WIDTH, SuicideForest.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        //create parameter for the "button"
        play = new Rectangle(100, 100, 100, 100);
        //create music and play it
        Music music = Gdx.audio.newMusic(Gdx.files.internal("OpeningMusic.mp3"));
        music.play();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        //draw background image
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        batch.end();

        //create shapeRenderer to create the button so user can move between menu screens
        shapeRenderer.setProjectionMatrix(getCombinedCamera());
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.rect(0, 0, 10, 10);
        shapeRenderer.end();

    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public void handleInput() {
        //Check if parameter is clicked on, to screen menu screens
        if (Gdx.input.isTouched()) {

            //get the mouse click/touch position
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
      
            //check if button is pressed
            float buttonX = getViewWidth() / 2 - play.getWidth() / 2;
            float buttonY = getViewHeight() / 2;

                   if (touch.x > buttonX && touch.x < buttonX + play.getWidth()
                    && touch.y > buttonY && touch.y < buttonY + play.getHeight()) {

                StateManager gsm = getStateManager();
                gsm.push(new PlayState(gsm));

            } else if (touch.x > buttonX && touch.x < buttonX + help.getWidth()
                    && touch.y > buttonY && touch.y < buttonY + help.getHeight()) {

                StateManager gsm = getStateManager();
                gsm.push(new HelpState(gsm));

            } else if (touch.x > buttonX && touch.x < buttonX + credits.getWidth()
                    && touch.y > buttonY && touch.y < buttonY + credits.getHeight()) {

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
