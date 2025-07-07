package kdrems.gameone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Ball {

    static int RADIUS;
    static int XSPD;
    static int YSPD;

    Vector2 pos;

    Color color = Color.WHITE;

    public Ball(Vector2 pos, int radius, int xspd, int yspd) {
        this.pos = pos;
        this.RADIUS = radius;
        this.XSPD = xspd;
        this.YSPD = yspd;
    }

    public void update()
    {
        pos.x += XSPD;
        pos.y += YSPD;

        //X-axis bounce
        if (pos.x + RADIUS >= Gdx.graphics.getWidth() || pos.x - RADIUS <= 0){XSPD *= -1;}

        //Y-axis bounce
        if (pos.y + RADIUS >= Gdx.graphics.getHeight()){YSPD *= -1;}
    }

    public void draw(ShapeRenderer shape)
    {
        shape.setColor(color);
        shape.circle(pos.x, pos.y, RADIUS);
    }

    public void CheckCollision(Paddle paddle)
    {
        if (CollidesWith(paddle))
        {
            YSPD *= -1;
        }
    }

    public void CheckCollision(Blocks blocks)
    {
        if (CollidesWith(blocks))
        {
            YSPD *= -1;
            blocks.destroy = true;
        }
    }

    public boolean CollidesWith(Paddle paddle)
    {
        if (paddle.POSITION.x + paddle.WIDTH + paddle.WIDTH/5 >= pos.x + RADIUS && paddle.POSITION.x - paddle.WIDTH/5 <= pos.x - RADIUS && paddle.POSITION.y + paddle.HEIGHT >= pos.y - RADIUS && paddle.POSITION.y <= pos.y + RADIUS)
        {
            return true;
        }else
        {
            return false;
        }
    }

    public boolean CollidesWith(Blocks blocks)
    {
        if (blocks.X + blocks.WIDTH + blocks.WIDTH/5 >= pos.x + RADIUS && blocks.X - blocks.WIDTH/5 <= pos.x - RADIUS && blocks.Y + blocks.HEIGHT >= pos.y - RADIUS && blocks.Y <= pos.y + RADIUS)
        {
            return true;
        }else
        {
            return false;
        }
    }
}
