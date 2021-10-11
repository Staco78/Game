package Game.player;

import Game.common.InputManager;
import Game.common.Vec2;
import Game.renderer.shapes.TexturedRect;
import Game.renderer.Renderer;
import Game.renderer.textures.Texture;
import org.lwjgl.glfw.GLFW;

public class Player {
    Vec2<Double> pos = new Vec2<>(0.0, 0.0);
    Renderer renderer;
    Texture texture;
    TexturedRect rect = new TexturedRect(this.pos.x, this.pos.y, 100, 100);


    public Player(Renderer renderer) {
        this.renderer = renderer;
        this.texture = this.renderer.textures.get("player");
    }

    public void draw() {
        this.renderer.draw(this);
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

    public Texture getTexture() {
        return texture;
    }

    public TexturedRect getRect() {
        return rect;
    }
}
