package Game.player;

import Game.common.Vec2;
import Game.renderer.shapes.TexturedRect;
import Game.renderer.Renderer;
import Game.renderer.textures.Texture;

public class Player {
    Vec2<Integer> pos = new Vec2<>(0, 0);
    Renderer renderer;
    Texture texture;
    TexturedRect rect = new TexturedRect(0, 100, 500, 500);


    public Player(Renderer renderer) {
        this.renderer = renderer;
        this.texture = this.renderer.textures.get("player");
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
