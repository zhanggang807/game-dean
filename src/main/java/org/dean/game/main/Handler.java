package org.dean.game.main;

import java.awt.*;
import java.util.LinkedList;

/**
 *
 * Created by Dean on 2016/3/22.
 */
public class Handler {

    LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public void tick(){
        for (GameObject tempObject : objects) {
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for (GameObject tempObject : objects) {
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.objects.add(object);
    }

    public void removeObject(GameObject object){
        this.objects.remove(object);
    }

}
