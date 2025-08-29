package io.munkush.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

public class Main extends ApplicationAdapter {

    private Player player;

    @Override
    public void create() {
        player = new Player(125, 75, Color.RED);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.render();
        player.startMoving();
    }

    @Override
    public void dispose() {
        player.dispose();
    }
}
