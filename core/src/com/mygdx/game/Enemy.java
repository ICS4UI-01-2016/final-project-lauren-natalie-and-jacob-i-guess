/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author lamon
 */
public class Enemy {
    private final float PIPE_GAP = 100;
    private final float MIN_HEIGHT = 50;
    private final float MAX_HEIGHT = 350;
    public static final float WIDTH = 52;
    
    private Vector2 position;
    private Texture pipeTop;
    private Texture pipeBottom;
    
    private Rectangle topBounds;
    private Rectangle bottomBounds;
    
    public Pipe(float x){
        float y = (int)(Math.random()*(325-75+1) + 75); 
        position = new Vector2(x,y);
        pipeTop = new Texture("toptube.png");
        pipeBottom = new Texture("bottomtube.png");
        
        topBounds = new Rectangle(position.x, position.y + PIPE_GAP/2, pipeTop.getWidth(), pipeTop.getHeight());
        bottomBounds = new Rectangle(position.x, position.y - PIPE_GAP/2 - pipeBottom.getHeight(), pipeBottom.getWidth(), pipeBottom.getHeight());
    }
    
    public void render(SpriteBatch batch){
        batch.draw(pipeTop, position.x, position.y + PIPE_GAP/2);
        batch.draw(pipeBottom, position.x, position.y - PIPE_GAP/2 - pipeBottom.getHeight());
    }
    
    public float getX(){
        return position.x;
    }
    
    public void setX(float x){
        position.x = x;
        float y = (int)(Math.random()*(325-75+1) + 75); 
        position.y = y;
        topBounds.setPosition(position.x, position.y + PIPE_GAP/2);
        bottomBounds.setPosition(position.x, position.y - PIPE_GAP/2 - pipeBottom.getHeight());
    }
    
    public boolean collides(Shigeru b){
        if(topBounds.overlaps(b.getBounds())){
            return true;
        }
        if(bottomBounds.overlaps(b.getBounds())){
            return true;
        }
        return false;
    }
    
    public void dispose(){
        pipeTop.dispose();
        pipeBottom.dispose();
    }
    
}
