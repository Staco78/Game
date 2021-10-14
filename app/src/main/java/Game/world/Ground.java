package Game.world;

import Game.common.Vec2;
import Game.renderer.Renderer;

public class Ground extends Tile {
    public Ground(Renderer renderer, Vec2<Integer> pos) throws Exception {
        super(renderer, renderer.textures.get("grass"), pos, 1);
    }
}
