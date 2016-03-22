package org.dean.game.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * 游戏主类
 * Created by Dean on 2016/3/20.
 */
public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 640;
    public static final int HEIGHT = 640 / 12 * 9;

    private Thread thread;
    private boolean running = false;

    private Random r;

    private Handler handler;

    public Game() {
        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
        this.start();
        handler = new Handler();

        r = new Random();

        for (int i = 0; i < 50; i++) {
            handler.addObject(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Player));
        };

    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta --;
            }
            if (running) {
                render();
            }
            frames ++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();//这里用到的是canvas类中的方法所以要继承
        if (bs == null) {
            this.createBufferStrategy(3);//这里用到的是canvas类中的方法所以要继承
            return ;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }


    private void tick() {
        handler.tick();
    }

    public static void main(String[] args) {

        new Game();

    }

}
