package kdrems.gameone;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    float delta;
    int scrnW;
    int scrnH;


    Vector2 ballPos;
    Vector2 paddlePos;

    Ball ball;
    Paddle paddle;

    ShapeRenderer shape;

    ArrayList<Blocks> blocks = new ArrayList<>();

    @Override
    public void create() {
        scrnH = Gdx.graphics.getHeight();
        scrnW = Gdx.graphics.getWidth();
        int blockW = 65;
        int blockH = 30;

        shape = new ShapeRenderer();
        delta = Gdx.graphics.getDeltaTime();
        ballPos = new Vector2(50, 50);
        paddlePos = new Vector2(10, 10);
        ball = new Ball(ballPos, 10, 5, 5);
        paddle = new Paddle(paddlePos, 100, 5);

        for (int y = scrnH/2; y < scrnH - 50; y += blockH + 3)
        {
            for (int x = 50; x < scrnW - 80; x += blockW + 3)
            {
                blocks.add(new Blocks(x, y, blockW, blockH));
            }
        }
    }

    private void update() {
        int scrnW = Gdx.graphics.getWidth();
        int scrnH = Gdx.graphics.getHeight();

        ball.update();
        ball.CheckCollision(paddle);
        paddle.update();

    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);
        update();
        //render
        shape.begin(ShapeRenderer.ShapeType.Filled);

        ball.draw(shape);
        paddle.draw(shape);
        for (Blocks blocks1 : blocks)
        {
            blocks1.draw(shape);
            ball.CheckCollision(blocks1);
        }
        for (int i = 0; i < blocks.size(); i++)
        {
            Blocks blocks1 = blocks.get(i);
            if (blocks1.destroy)
            {
                blocks.remove(blocks1);
                i--;
            }
        }

        shape.end();
    }


    @Override
    public void dispose() {
        shape.dispose();
    }
}
