package Game.renderer;

import Game.entity.Entity;
import Game.renderer.textures.Textures;
import org.joml.Matrix4f;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import java.io.IOException;

import static org.lwjgl.opengl.GL46.*;

import static org.lwjgl.glfw.GLFW.*;

public class Renderer {
    private final Window window;
    public final Textures textures = new Textures();
    private Shader shader = null;

    private Matrix4f projection = new Matrix4f().ortho(0, 500, 500, 0, -1, 1);

    public Renderer() {

        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit())
            throw new IllegalStateException("Failed to initialize GLFW");

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 6);

        window = new Window("Game", 500, 500);

        glfwMakeContextCurrent(window.getWindow());
        GLFWWindowSizeCallback.create((i, x, y) -> {
            glViewport(0, 0, x, y);
            projection = new Matrix4f().ortho(0, x, y, 0, -1, 1);
        }).set(window.getWindow());

        GL.createCapabilities();

        glClearColor(0, 0, 1, 1);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glfwSwapInterval(1);


        textures.loadAll();

        try {
            shader = new Shader("shader.vert", "shader.frag");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        window.show();
    }

    public Window getWindow() {
        return window;
    }

    public void startRendering() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        shader.set("projection", projection);
        shader.use();


    }

    public void endRendering() {
        glfwSwapBuffers(window.getWindow());

        glfwPollEvents();
    }

    public void draw(Entity entity) {
        shader.use();
        shader.set("model", entity.getRect().getModel());
        entity.getTexture().bind();
        entity.getRect().bind();
        glDrawArrays(GL_TRIANGLES, 0, 6);
    }
}
