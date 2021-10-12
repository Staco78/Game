package Game;

import Game.renderer.Renderer;
import Game.renderer.shapes.TexturedRect;
import Game.renderer.textures.Texture;

public abstract class Drawable {
    private final Renderer renderer;
    private final Texture texture;
    protected final TexturedRect rect;

    public Drawable(Renderer renderer, Texture texture, TexturedRect rect) {
        this.renderer = renderer;
        this.texture = texture;
        this.rect = rect;
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
}
