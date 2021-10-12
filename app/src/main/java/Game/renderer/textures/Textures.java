package Game.renderer.textures;

import java.util.HashMap;

public class Textures {
    private final HashMap<String, Texture> textures = new HashMap<>();

    public void loadAll() {
        textures.put("player", new Texture("player.png"));
        textures.put("img", new Texture("img.png"));
    }

    public Texture get(String name) {
        return textures.get(name);
    }
}
