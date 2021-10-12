package Game;

import Game.common.InputManager;
import Game.common.Vec2;
import Game.player.Camera;
import Game.player.Player;
import Game.renderer.Renderer;
import Game.world.World;

import static org.lwjgl.glfw.GLFW.glfwGetTime;

public class Game {
    private final Camera camera = new Camera(new Vec2<>(0, 0));
    private final Renderer renderer = new Renderer(camera);
    private final Player player = new Player(renderer);
    private final World world = new World(renderer, player);

    Game() throws Exception {
        InputManager.init(renderer.getWindow());
    }

    public void loop() {
        double lastFrame = 0;
        while (renderer.getWindow().isOpen()) {
            double currentFrame = glfwGetTime();
            double deltaTime = currentFrame - lastFrame;
            lastFrame = currentFrame;

            player.tick(deltaTime);
            camera.setPos(player.getPos().x.floatValue(), player.getPos().y.floatValue());


            renderer.startRendering();

            world.draw();
            renderer.endRendering();
        }
    }
}
