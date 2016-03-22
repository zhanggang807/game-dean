package org.dean.game.main;

import java.awt.*;
import java.util.Random;

/**
 *
 * Created by Dean on 2016/3/22.
 */
public class Player extends GameObject{

    Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);
        velX = r.nextInt(5) + 1;
        velY = r.nextInt(5);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }

}
