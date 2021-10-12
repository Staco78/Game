package Game.world;

import Game.Constants;
import Game.Drawable;
import Game.common.Vec2;
import Game.renderer.Renderer;
import Game.renderer.shapes.TexturedRect;
import Game.renderer.textures.Texture;

public abstract class Tile extends Drawable {
    protected final Vec2<Integer> pos;
    protected final Vec2<Integer> size;

    Tile(Renderer renderer, Texture texture, Vec2<Integer> pos) {
        super(renderer, texture, new TexturedRect(pos.x * Constants.tileSize, pos.y * Constants.tileSize, Constants.tileSize, Constants.tileSize));
        this.pos = pos;
        this.size = new Vec2<>(1, 1);
    }

    Tile(Renderer renderer, Texture texture, Vec2<Integer> pos, Vec2<Integer> size) {
        super(renderer, texture, new TexturedRect(pos.x * Constants.tileSize, pos.y * Constants.tileSize, size.x  * Constants.tileSize, size.y * Constants.tileSize));
        this.pos = pos;
        this.size = size;
    }
}
