package Game.common;

import Game.Drawable;

import java.util.LinkedList;

public class DrawableArray extends LinkedList<Drawable> {


    @Override
    public boolean add(Drawable drawable) {
        boolean result = super.add(drawable);
        this.sort((o1, o2) -> (int) (o2.getPos().z - o1.getPos().z) * 10);
        return result;
    }
}


