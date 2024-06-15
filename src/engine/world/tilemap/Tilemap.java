package engine.world.tilemap;

import engine.util.IObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tilemap implements IObject {

    private final List<TileLayer> layers = new ArrayList<>();

    public Tilemap() {

        layers.sort((o1, o2) -> 0);
    }

    @Override
    public void Update(double delta) {
        for (TileLayer layer : layers) {
            layer.Update(delta);
        }
    }

    @Override
    public void Render(Graphics2D graphic) {
        for (TileLayer layer : layers) {
            layer.Render(graphic);
        }
    }
}