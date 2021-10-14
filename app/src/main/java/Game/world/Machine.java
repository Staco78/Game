package Game.world;

import Game.common.Vec2;
import Game.renderer.Renderer;
import Game.renderer.textures.Texture;

public class Machine extends Tile {
    public Machine(Renderer renderer, Texture texture, Vec2<Integer> pos, Vec2<Integer> size) {
        super(renderer, texture, pos, size, 2);
    }
}
