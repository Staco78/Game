package Game.entity;

import Game.common.Vec2;
import Game.renderer.Renderer;
import Game.renderer.shapes.TexturedRect;
import Game.renderer.textures.Texture;

public class Entity {
    protected final Vec2<Double> pos;
    protected final Vec2<Double> size;
    protected final Renderer renderer;
    protected final Texture texture;
    protected final TexturedRect rect;


    public Entity(Renderer renderer, Texture texture, Vec2<Double> pos, Vec2<Double> size) {
        this.renderer = renderer;
        this.texture = texture;
        this.pos = pos;
        this.size = size;
        this.rect = new TexturedRect(pos.x, pos.y, size.x, size.y);
    }

    public void draw() {
        this.renderer.draw(this);
    }

    public Texture getTexture() {
        return texture;
    }

    public TexturedRect getRect() {
        return rect;
    }
}