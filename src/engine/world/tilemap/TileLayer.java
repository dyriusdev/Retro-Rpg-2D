package engine.world.tilemap;

import engine.util.IObject;
import engine.world.tile.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TileLayer implements IObject, Comparable<TileLayer> {

    private final List<Tile> tiles = new ArrayList<>();
    private final int index;

    public TileLayer(int i, List<Tile> t) {
        index = i;
        tiles.addAll(t);
    }

    public int GetIndex() { return index; }

    @Override
    public int compareTo(TileLayer o) { return Integer.compare(GetIndex(), o.GetIndex()); }

    @Override
    public void Update(double delta) {
        for (Tile tile : tiles) {
            if (tile.CanUpdate()) {
                tile.Update(delta);
                tile.SetUpdate(false);
            }
        }
    }

    @Override
    public void Render(Graphics2D graphic) {
        for (Tile tile : tiles) {
            if (tile.CanRender()) {
                tile.Render(graphic);
                tile.SetRender(false);
            }
        }
    }
}