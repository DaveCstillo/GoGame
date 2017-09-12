package com.bitpro.gogame.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

/**
 * Created by David on 9/6/2017.
 */

public class asteroid {
    private static final int FLUCTUATION = 200;
    public static final int asteroidWidth = 72;
    public static final int asteroidHeight = 71;
    private Texture ball;
    private Vector2 position;
    private Random rand;


    public asteroid(float y){
        ball = new Texture("asteroid.png");
        rand = new Random();

        position = new Vector2(rand.nextInt(FLUCTUATION),y);
    }

    public Texture getTexture() {
        return ball;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void reposition(float y){
        position.set(50,y);
    }
}
