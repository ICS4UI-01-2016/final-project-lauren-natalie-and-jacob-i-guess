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
 * @author pircn0556
 */
public class CreditState extends State {

    private Texture bg1;
    private Rectangle back;
    private ShapeRenderer shapeRenderer = new ShapeRenderer();

    public CreditState(StateManager gsm) {
        super(gsm);
        bg1 = new Texture("creditScreen.jpg");
        setCameraView(SuicideForest.WIDTH, SuicideForest.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        back = new Rectangle(10,10,10,10);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        batch.draw(bg1, 0, 0, getViewWidth(), getViewHeight());
        batch.end();
        
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
        if (Gdx.input.isTouched()) {
            StateManager gsm = getStateManager();
            gsm.push(new MenuState(gsm));
        }
    }

    @Override
    public void dispose() {
        bg1.dispose();
    }
}
