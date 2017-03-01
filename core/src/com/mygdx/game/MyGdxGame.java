package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import sun.font.TrueTypeFont;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background background;
	Hero hero;
	final int FLOWER_COUNT = 40;
	Flower []flowers;
	float timer;
	public static int level = 1;
	public static int COUNT = 0;
	BitmapFont font;

	@Override
	public void create () {
		timer = 0.0f;
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);
		background = new Background();
		hero = new Hero(Input.Keys.UP, Input.Keys.DOWN,Input.Keys.RIGHT, Input.Keys.LEFT);
		flowers = new Flower[FLOWER_COUNT];
		for (int i = 0; i < flowers.length; i++){
			flowers[i] = new Flower();
		}
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		hero.render(batch);
		for (int i = 0; i < flowers.length; i++){
			flowers[i].render(batch);
		}
        String l = "LEVEL " + level;
        String f = "COLLECTED FLOWERS " + COUNT;
        font.draw(batch, l, 10, 710);
        font.draw(batch, f, 10, 680);
		batch.end();
	}

	public void update(){
		timer += Gdx.graphics.getDeltaTime();
		if(timer > 20.0f){
			timer = 0.0f;
			level++;
		}
		hero.update();
		background.update();
		for (int i = 0; i < flowers.length; i++){
			flowers[i].update();
		}
		for (int i = 0; i < flowers.length; i++){
			if (flowers[i].getRect().contains(hero.getPosition())){
				flowers[i].recreate();
				COUNT++;
				break;
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
