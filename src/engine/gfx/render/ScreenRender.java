package engine.gfx.render;

import engine.Globals;
import engine.util.IObject;

import java.awt.*;

public class ScreenRender implements IObject {

    @Override
    public void Update(double delta) {}

    @Override
    public void Render(Graphics2D graphic) {
        DisplayMode mode = graphic.getDeviceConfiguration().getDevice().getDisplayMode();
        DrawGrid(graphic, mode);
    }

    /*
    Draw a grid on the window and each tile on grid follow this formula :
    - OTile => 16 | Scale => 3
    - TileSize = OTile * Scale => 48
    With this all grid tiles is (48, 48)
    */
    private void DrawGrid(Graphics2D g, DisplayMode mode) {
        g.setColor(Color.RED);
        for (int x = 0; x < mode.getWidth(); x += Globals.ORIGINAL_TILE_SIZE) {
            for (int y = 0; y < mode.getHeight(); y += Globals.ORIGINAL_TILE_SIZE) {
                g.drawRect(x, y, Globals.TILE_SIZE, Globals.TILE_SIZE);
            }
        }
    }
}
