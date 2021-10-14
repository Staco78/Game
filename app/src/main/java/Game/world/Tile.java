package Game.world;

import Game.Constants;
import Game.Drawable;
import Game.common.Vec2;
import Game.common.Vec3;
import Game.renderer.Renderer;
import Game.renderer.textures.Texture;

public abstract class Tile extends Drawable {
    protected final Vec2<Integer> size;

    Tile(Renderer renderer, Texture texture, Vec2<Integer> pos, double z_index) {
        super(renderer, texture, new Vec3<>(pos.x.doubleValue() * Constants.tileSize, pos.y.doubleValue() * Constants.tileSize, z_index), new Vec2<>(1.0 * Constants.tileSize, 1.0 * Constants.tileSize));
        this.size = new Vec2<>(1, 1);
    }

    Tile(Renderer renderer, Texture texture, Vec2<Integer> pos, Vec2<Integer> size, double z_index) {
        super(renderer, texture, new Vec3<>(pos.x.doubleValue() * Constants.tileSize, pos.y.doubleValue() * Constants.tileSize, z_index), new Vec2<>(size.x.doubleValue() * Constants.tileSize, size.y.doubleValue() * Constants.tileSize));
        this.size = size;
    }
}
