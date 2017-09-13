package com.bitpro.gogame.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by David on 9/6/2017.
 */

public class Astronaut {
    private static final int gravity = -5;
    private Vector3 position;
    private Vector3 velocity;
    private Texture astronauta;


    public Astronaut(int x,int y) {
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);

        astronauta = new Texture("astronauta.png");
    }

    public void update(float dt){

        velocity.add(0, gravity, 0);

        velocity.scl(dt);
        position.add(velocity.x,velocity.y,0);

           // velocity.y = 0;


        velocity.scl(1/dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return astronauta;
    }

    public void jump(){
        velocity.y = 250;
    }
    public void tilt(){

        velocity.x = (Gdx.input.getAccelerometerX()*25)*-1;
    }
}
