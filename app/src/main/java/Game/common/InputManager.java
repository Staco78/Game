package Game.common;

import Game.renderer.Window;

import static org.lwjgl.glfw.GLFW.*;

public class InputManager {
    private static long window;

    public static void init(Window window) {
        InputManager.window = window.getWindow();
    }

    public static boolean isActive(int key) {
        return glfwGetKey(window, key) == GLFW_PRESS;
    }
}
