package Game.player;

import Game.common.InputManager;
import Game.common.Vec2;
import Game.entity.Entity;
import Game.renderer.Renderer;
import org.lwjgl.glfw.GLFW;

public class Player extends Entity {


    public Player(Renderer renderer) {
        super(renderer, renderer.textures.get("player"), new Vec2<>(0.0, 0.0), new Vec2<>(100.0, 100.0));
    }

    public void tick(double deltaTime) {
        updatePos(deltaTime);
    }

    protected void updatePos(double deltaTime) {
        final double speed = 100 * deltaTime;

        if (InputManager.isActive(GLFW.GLFW_KEY_D))
            this.pos.x += speed;
        if (InputManager.isActive(GLFW.GLFW_KEY_A))
            this.pos.x -= speed;
        if (InputManager.isActive(GLFW.GLFW_KEY_S))
            this.pos.y += speed;
        if (InputManager.isActive(GLFW.GLFW_KEY_W))
            this.pos.y -= speed;


        rect.x = this.pos.x;
        rect.y = this.pos.y;

    }
}
