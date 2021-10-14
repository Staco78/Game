package Game.entity;

import Game.Drawable;
import Game.common.Vec2;
import Game.renderer.Renderer;
import Game.renderer.textures.Texture;

public class Entity extends Drawable {

    public Entity(Renderer renderer, Texture texture, Vec2<Double> pos, Vec2<Double> size) {
        super(renderer, texture, pos, size);
    }

}