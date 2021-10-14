package Game;

import Game.common.Vec2;
import Game.common.Vec3;
import Game.renderer.Renderer;
import Game.renderer.shapes.TexturedRect;
import Game.renderer.textures.Texture;

public abstract class Drawable {
    private final Renderer renderer;
    private final Texture texture;
    protected final TexturedRect rect;
    protected final Vec3<Double> pos;
    protected final Vec2<Double> size;

    public Drawable(Renderer renderer, Texture texture, Vec3<Double> pos, Vec2<Double> size) {
        this.renderer = renderer;
        this.texture = texture;
        this.rect = new TexturedRect(pos.x, pos.y, size.x, size.y);
        this.pos = pos;
        this.size = size;
    }

    public Drawable(Renderer renderer, Texture texture, Vec2<Double> pos, Vec2<Double> size) {
        this(renderer, texture, new Vec3<>(pos.x, pos.y, 0.0), size);
    }


    public void draw() {
        renderer.draw(this);
    }

    public Texture getTexture() {
        return texture;
    }

    public TexturedRect getRect() {
        return rect;
    }

    public Vec3<Double> getPos() {
        return pos;
    }

    public Vec2<Double> getSize() {
        return size;
    }
}
