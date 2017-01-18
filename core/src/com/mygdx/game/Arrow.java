/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author moraj0721
 */
public class Arrow  {
    private Vector3 position;
    private Vector3 velocity;
    private Texture arrowPicUp;
    private Texture arrowPicDown;
    private Texture arrowPicUpLeft;
    private Texture arrowPicUpRight;
    private Rectangle bounds;
    private final float MOVEMENT = 100;
    
    public Arrow(int x, int y) {
        position = new Vector3(x, y + 100, 0);
        velocity = new Vector3(MOVEMENT, 0, 0);
        arrowPic = new Texture("arrowUp.png");
        bounds = new Rectangle(position.x, position.y, arrowPic.getWidth(), arrowPic.getHeight());
    }
}
