package com.bitpro.gogame.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by David on 9/5/2017.
 */

public class GameStateManager {
    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();

    }

    public void push(State state){
        states.push(state);
    }

    public void pop(State state){
        states.pop();
    }

    public void set(State state){
        states.pop();
        states.push(state);
    }

    public void update(float d){
        states.peek().update(d);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }

}
