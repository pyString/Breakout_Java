package kdrems.gameone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Paddle {

    Vector2 POSITION;

    public int WIDTH;
    public int HEIGHT;

    public Paddle(Vector2 position, int width, int height)
    {
        this.POSITION = position;
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    public void update()
    {
        POSITION.x = Gdx.input.getX() - WIDTH/2;

        if (POSITION.x + WIDTH >= Gdx.graphics.getWidth())
        {
            POSITION.x = Gdx.graphics.getWidth() - WIDTH;
        }
        if (POSITION.x <= 0)
        {
            POSITION.x = 0;
        }

    }

    public void draw(ShapeRenderer shape)
    {
        shape.rect(POSITION.x, POSITION.y, WIDTH, HEIGHT);
    }
}
