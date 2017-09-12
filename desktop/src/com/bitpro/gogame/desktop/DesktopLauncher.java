package com.bitpro.gogame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bitpro.gogame.GoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GoGame.WIDTH;
		config.height = GoGame.HEIGHT;
		config.title = GoGame.TITLE;
		new LwjglApplication(new GoGame(), config);
	}
}
