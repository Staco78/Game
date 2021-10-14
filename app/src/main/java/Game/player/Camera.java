package Game.player;

import Game.common.Vec2;
import org.joml.Matrix4f;

public class Camera {
    private float x = 0;
    private float y = 0;
    private int width;
    private int height;
    private final Matrix4f matrix = new Matrix4f();

    public Camera(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Camera(Vec2<Integer> size) {
        this.width = size.x;
        this.height = size.y;
    }

    public void setPos(float newX, float newY) {
        x = newX;
        y = newY;
    }

    public void setPos(Vec2<Float> pos) {
        setPos(pos.x, pos.y);
    }

    public Vec2<Float> getPos() {
        return new Vec2<>(x, y);
    }

    public void setSize(int newWidth, int newHeight) {
        width = newWidth;
        height = newHeight;
    }

    public Vec2<Integer> getSize() {
        return new Vec2<>(width, height);
    }

    public Matrix4f getMatrix() {
        return matrix.setOrtho(x - width / 2.0f, x + width / 2.0f, y + height / 2.0f, y - height / 2.0f, -10, 10);
    }

}
