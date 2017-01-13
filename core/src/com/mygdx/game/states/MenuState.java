/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.SuicideForest;

/**
 *
 * @author pirc0556
 */
public class MenuState extends State{
    private Texture bg;
    private Rectangle play;
    private float buttonx = 0;
    private float buttony = 0;
    
    public MenuState(StateManager gsm){
        super(gsm);
        bg = new Texture("MenuScreen960x720.png");
        setCameraView(SuicideForest.WIDTH, SuicideForest.HEIGHT);
        setCameraPosition(getViewWidth()/2, getViewHeight()/2);
        play = new Rectangle(100,100,100,100);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        batch.draw(play, buttonx, buttony);
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            StateManager gsm = getStateManager();
            gsm.push(new PlayState(gsm));
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
    }
}
