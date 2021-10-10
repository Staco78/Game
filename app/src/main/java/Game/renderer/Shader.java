package Game.renderer;

import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static Game.common.IOUtils.ioResourceToByteBuffer;
import static org.lwjgl.opengl.GL46.*;

public class Shader {

    private final int programId;

    public Shader(String vertPath, String fragPath) throws IOException {
        programId = glCreateProgram();
        int vshader = createShader("shaders/" + vertPath, GL_VERTEX_SHADER);
        int fshader = createShader("shaders/" + fragPath, GL_FRAGMENT_SHADER);
        glAttachShader(programId, vshader);
        glAttachShader(programId, fshader);
        glLinkProgram(programId);
        int linked = glGetProgrami(programId, GL_LINK_STATUS);
        String programLog = glGetProgramInfoLog(programId);
        if (programLog.trim().length() > 0)
            System.err.println(programLog);
        if (linked == 0)
            throw new AssertionError("Could not link program");
        glUseProgram(0);
    }

    void use() {
        glUseProgram(programId);
    }


    private static int createShader(String resource, int type) throws IOException {
        int shader = glCreateShader(type);

        ByteBuffer source = ioResourceToByteBuffer(resource, 8192);


        PointerBuffer strings = BufferUtils.createPointerBuffer(1);
        IntBuffer lengths = BufferUtils.createIntBuffer(1);

        strings.put(0, source);
        lengths.put(0, source.remaining());

        glShaderSource(shader, strings, lengths);


        glCompileShader(shader);
        int compiled = glGetShaderi(shader, GL_COMPILE_STATUS);
        String shaderLog = glGetShaderInfoLog(shader);
        if (shaderLog.trim().length() > 0) {
            System.err.println(shaderLog);
        }
        if (compiled == 0) {
            throw new AssertionError("Could not compile shader");
        }
        return shader;
    }

    public void set(String name, Matrix4f matrix) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            glUniformMatrix4fv(glGetUniformLocation(programId, name), false, matrix.get(stack.mallocFloat(16)));
        }
    }
}
