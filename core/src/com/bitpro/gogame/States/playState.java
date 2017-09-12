package com.bitpro.gogame.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.bitpro.gogame.GoGame;
import com.bitpro.gogame.sprites.Astronaut;
import com.bitpro.gogame.sprites.asteroid;

import org.omg.CORBA.PRIVATE_MEMBER;


/**
 * Created by David on 9/6/2017.
 */

public class playState extends State {
    private static final int ASTEROID_SPACING = 125;
    private static final int ASTEROIDS_COUNT = 4;

    private Astronaut astronaut;
    private Texture back;
    private asteroid ast;

    private Array<asteroid> asteroids;


    protected playState(GameStateManager gsm) {
        super(gsm);
        astronaut = new Astronaut(100,300);
        back = new Texture("backspace.png");
        ast = new asteroid(100);
        cam.setToOrtho(false, GoGame.WIDTH/2,GoGame.HEIGHT/2);

        asteroids = new Array<asteroid>();
        for(int i = 1; i<=ASTEROIDS_COUNT; i++){
            asteroids.add(new asteroid(i*(ASTEROID_SPACING + asteroid.asteroidWidth)));
        }
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
           astronaut.jump();
        }
        if(Gdx.input.getAccelerometerX()!=0){
          //  Gdx.app.log("Giro",String.valueOf(Gdx.input.getAccelerometerX()));
           astronaut.tilt();
        }


    }

    @Override
    public void update(float d) {
        handleInput();
        astronaut.update(d);
       // Gdx.app.log("Giro Update",String.valueOf(Gdx.input.getAccelerometerX()));
        cam.position.y = astronaut.getPosition().y +80;
        cam.position.x = astronaut.getPosition().x +80;


        for(asteroid ast : asteroids){
            if(cam.position.y-(cam.viewportHeight/2)> ast.getPosition().y+ast.getTexture().getHeight()){
                ast.reposition(ast.getPosition().y + ((asteroid.asteroidHeight+ASTEROID_SPACING)* ASTEROIDS_COUNT));
            }
        }
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(back,cam.position.x -(cam.viewportWidth/2),0);
        sb.draw(astronaut.getTexture(),astronaut.getPosition().x,astronaut.getPosition().y);
        sb.draw(ast.getTexture(), ast.getPosition().x, ast.getPosition().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
