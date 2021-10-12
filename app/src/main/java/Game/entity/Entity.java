package Game.entity;

import Game.Drawable;
import Game.common.Vec2;
import Game.renderer.Renderer;
import Game.renderer.shapes.TexturedRect;
import Game.renderer.textures.Texture;

public class Entity extends Drawable {
    protected final Vec2<Double> pos;
    protected final Vec2<Double> size;


    public Entity(Renderer renderer, Texture texture, Vec2<Double> pos, Vec2<Double> size) {
        super(renderer, texture, new TexturedRect(pos.x, pos.y, size.x, size.y));
        this.pos = pos;
        this.size = size;
    }

    public Vec2<Double> getPos() {
        return pos;
    }
}