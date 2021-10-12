package Game.renderer.textures;

import static Game.common.IOUtils.ioResourceToByteBuffer;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glPixelStorei;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;
import static org.lwjgl.stb.STBImage.stbi_load_from_memory;
import static org.lwjgl.system.MemoryStack.stackPush;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;

public class Texture {
    private int width;
    private int height;
    public int id;

    public Texture(String imagePath) {
        ByteBuffer imageData;
        try {
            imageData = ioResourceToByteBuffer("textures/" + imagePath, 1024);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (MemoryStack stack = stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer components = stack.mallocInt(1);

            // Decode texture image into a byte buffer
            ByteBuffer decodedImage = stbi_load_from_memory(imageData, w, h, components, 4);

            this.width = w.get();
            this.height = h.get();

            // Create a new OpenGL texture
            this.id = glGenTextures();

            // Bind the texture
            glBindTexture(GL_TEXTURE_2D, this.id);

            // Tell OpenGL how to unpack the RGBA bytes. Each component is 1 byte size
            glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

            // Upload the texture data
            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.width, this.height, 0, GL_RGBA, GL_UNSIGNED_BYTE, decodedImage);

            // Generate Mip Map
            glGenerateMipmap(GL_TEXTURE_2D);
        }
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, this.id);
    }


}