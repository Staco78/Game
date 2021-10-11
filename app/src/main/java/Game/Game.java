package Game;

import Game.common.InputManager;
import Game.player.Player;
import Game.renderer.Renderer;

import static org.lwjgl.glfw.GLFW.glfwGetTime;

public class Game {
    private final Renderer renderer = new Renderer();
    private final Player player = new Player(renderer);

    Game() {
        InputManager.init(renderer.getWindow());
    }

    public void loop() {
        double lastFrame = 0;
        while (renderer.getWindow().isOpen()) {
            double currentFrame = glfwGetTime();
            double deltaTime = currentFrame - lastFrame;
            lastFrame = currentFrame;

            player.tick(deltaTime);


            renderer.startRendering();

            player.draw();
            renderer.endRendering();
        }
    }
}
