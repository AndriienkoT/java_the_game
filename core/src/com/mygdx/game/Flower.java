package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tanya on 27/02/2017.
 */
public class Flower {
    private static Texture texture;
    private Vector2 position;
    private float speed;
    private Rectangle rect;

    public Flower(){
        if(texture == null){
            texture = new Texture("flower.png");
        }
        position = new Vector2((float)Math.random() * 1280, (float)Math.random() * 720);
        speed = Hero.speed;
        rect = new Rectangle(position.x - 10 , position.y -  10, 40, 40);
    }

    public Rectangle getRect(){
        return rect;
    }

    public void recreate(){
        position.x = (float)Math.random() * 1280;
        position.y = (float)Math.random() * 720;
        speed = Hero.speed;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x, position.y, 20, 20);
    }

    public void update(){
        speed = Hero.speed;
        position.x -= speed;
        if(position.x < -20){
            position.x = 1280;
            position.y = (float)Math.random() * 720;
        }
        rect.x = position.x;
        rect.y = position.y;
    }
}
