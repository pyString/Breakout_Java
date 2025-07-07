package kdrems.gameone;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.time.Year;


public class Blocks {


    int X, Y, WIDTH, HEIGHT;
    Color color = Color.WHITE;
    boolean destroy = false;

    public Blocks(int X, int Y, int WIDTH, int HEIGHT)
    {
        this.X = X;
        this.Y = Y;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void draw(ShapeRenderer shape)
    {
        shape.setColor(color);
        shape.rect(X, Y, WIDTH, HEIGHT);
    }
}
