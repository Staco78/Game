package Game.renderer;

import static org.lwjgl.system.MemoryUtil.*;

import static org.lwjgl.glfw.GLFW.*;

public class Window {
    private final long window;

    public Window(String title, int width, int height) {

        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        window = glfwCreateWindow(width, height, title, NULL, NULL);
        if (window == NULL)
            throw new RuntimeException("Failed to create the GLFW window");
    }

    public long getWindow() {
        return window;
    }

    public void show() {
        glfwShowWindow(window);
    }

    public boolean isOpen() {
        return !glfwWindowShouldClose(window);
    }

}
