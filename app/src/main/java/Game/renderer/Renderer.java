package Game.renderer;

import Game.player.Player;
import Game.renderer.textures.Textures;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import java.io.IOException;

import static org.lwjgl.opengl.GL46.*;

import static org.lwjgl.glfw.GLFW.*;

public class Renderer {
    private final Window window;
    public final Textures textures = new Textures();
    private Shader shader = null;

    public Renderer() {

        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 6);

        window = new Window("Game", 500, 500);

        glfwMakeContextCurrent(window.getWindow());

        GL.createCapabilities();

        glClearColor(0, 0, 1, 1);


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

    }

    public void endRendering() {
        glfwSwapBuffers(window.getWindow());

        glfwPollEvents();
    }

    public void draw(Player player) {
        shader.use();
        player.getRect().bind();
        glDrawArrays(GL_TRIANGLES, 0, 6);
    }
}
