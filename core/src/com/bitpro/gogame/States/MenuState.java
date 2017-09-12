package com.bitpro.gogame.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitpro.gogame.GoGame;

/**
 * Created by David on 9/5/2017.
 */

public class MenuState extends State {

    private Texture background;
    private Texture playBtn;

    private int screenWidth = Gdx.graphics.getWidth();
    private int screenHeight = Gdx.graphics.getHeight();

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("backspace.png");
        playBtn = new Texture("play.png");

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new playState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float d) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0,screenWidth,screenHeight);
        sb.draw(playBtn,(screenWidth)/2-playBtn.getWidth()/2,screenHeight/2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
