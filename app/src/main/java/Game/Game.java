package Game;

import Game.player.Player;
import Game.renderer.Renderer;

public class Game {
    private final Renderer renderer = new Renderer();
    private final Player player = new Player(renderer);


    public void loop() {
        while (renderer.getWindow().isOpen()) {
            renderer.startRendering();
            player.draw();
            renderer.endRendering();
        }
    }
}
