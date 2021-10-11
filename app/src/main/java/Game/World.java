package Game;


import Game.common.Vec2;
import Game.entity.Entity;
import Game.player.Player;
import Game.renderer.Renderer;

import java.util.LinkedList;
import java.util.List;

public class World {

    Renderer renderer;
    List<Entity> entities = new LinkedList<>();

    public World(Renderer renderer, Player player) {
        this.renderer = renderer;
        entities.add(player);
        entities.add(new Entity(renderer, renderer.textures.get("player"), new Vec2<>(100.0, 100.0), new Vec2<>(30.0, 30.0)));
    }

    public void draw() {
        entities.forEach(Entity::draw);
    }
}
