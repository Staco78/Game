package Game.renderer.textures;

import java.util.HashMap;

public class Textures {
    private final HashMap<String, Texture> textures = new HashMap<>();

    public void loadAll() {
        textures.put("player", new Texture("player.png"));
        textures.put("img", new Texture("img.png"));
        textures.put("grass", new Texture("grass.png"));
    }

    public Texture get(String name) throws Exception {
        Texture value = textures.get(name);
        if (value == null) throw new Exception("Texture not found");
        return value;
    }
}
