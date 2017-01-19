/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    
    
    
    public MenuState(StateManager gsm){
        super(gsm);
        bg = new Texture("MenuScreen960x720.png");
        setCameraView(SuicideForest.WIDTH, SuicideForest.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        //create parameter for the "button"
        play = new Rectangle(100,100,100,100);
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
        shapeRenderer.rect(0,0,10,10);
        shapeRenderer.end();
        
    }

    @Override
    public void update(float deltaTime) {
        
    }

    @Override
    public void handleInput() {
        //Check if parameter is clicked on, to screen menu screens
        if(Gdx.input.isTouched()){
            StateManager gsm = getStateManager();
            gsm.push(new PlayState(gsm));
        }
    }

    @Override
    public void dispose() {
        //remove background image so that game runs smoother
        bg.dispose();
    }

}
