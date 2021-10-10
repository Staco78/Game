package Game.renderer.buffers;

import static org.lwjgl.opengl.GL46.*;

public class VAO {
    private final int id;

    public VAO() {
        id = glGenVertexArrays();
    }

    public void bind() {
        glBindVertexArray(id);
    }
}
