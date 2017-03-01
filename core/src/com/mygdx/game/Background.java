package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.MyGdxGame.level;

/**
 * Created by Tanya on 27/02/2017.
 */
public class Background {
    class Tree{
        private Vector2 position;
        private float speed;

        public Tree(){
            position = new Vector2((float)Math.random() * 1280, (float)Math.random() * 720);
            speed = Hero.speed;
        }

        public void update(){
            speed = Hero.speed;
            position.x -= speed;
            if(position.x < -64){
                position.x = 1280;
                position.y = (float)Math.random() * 720;
            }
        }
    }

    private Texture texture;
    private Texture textureTree;
    private Tree[] trees;
    private static int TREES_COUNT = 30;

    public Background(){
        texture = new Texture("bg.jpeg");
        textureTree = new Texture("tree.jpeg");
        trees = new Tree[TREES_COUNT];
        for (int i = 0; i < trees.length; i++){
            trees[i] = new Tree();
        }
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, 0, 0);
        for (int i = 0; i < trees.length; i++){
            batch.draw(textureTree, trees[i].position.x, trees[i].position.y);
        }
    }

    public void update(){
        for (int i = 0; i < trees.length; i++){
            trees[i].update();
        }
    }

}
