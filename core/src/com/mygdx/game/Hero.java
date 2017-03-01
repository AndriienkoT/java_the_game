package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.MyGdxGame.level;

/**
 * Created by Tanya on 27/02/2017.
 */
public class Hero {
    private Texture texture;
    private Vector2 position;
    public static float speed;
    private int keyUp, keyDown, keyRight, keyLeft;


    public Hero(int keyUp,int keyDown,int keyRight,int keyLeft){
        texture = new Texture("hero.png");
        position = new Vector2(100, 100);
        speed = 0.0f;
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.keyRight = keyRight;
        this.keyLeft = keyLeft;
    }

    public Vector2 getPosition(){
        return position;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x, position.y);
    }

    public void update(){
        if(Gdx.input.isKeyPressed(keyUp)){
            position.y += MyGdxGame.level;
            if(position.y > 720){
                position.y = -60;
            }
        }
        if(Gdx.input.isKeyPressed(keyDown)){
            position.y -= MyGdxGame.level;
            if(position.y < -60){
                position.y = 720;
            }
        }
        if(Gdx.input.isKeyPressed(keyLeft)){
            speed = - MyGdxGame.level;
            position.x += speed;
            if(position.x < 0){
                position.x = 0;
            }
        }
        if(Gdx.input.isKeyPressed(keyRight)){
            speed = MyGdxGame.level;
            position.x += speed;
            if(position.x > 1200){
                position.x = 1200;
            }
        }
    }
}
