package org.dean.game.main;

import javax.swing.*;
import java.awt.*;

/**
 * 窗口类
 * Created by Dean on 2016/3/20.
 */
public class Window extends Canvas{

    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);

//        game.start();//实际是在这里启动的。这句代码应该放到外边比较好吧，放到外面了

    }

}
