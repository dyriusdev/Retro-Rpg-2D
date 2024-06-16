package engine.render;

import engine.Globals;
import engine.manager.ResourceManager;
import engine.render.texture.SpriteSheet;

import javax.swing.*;
import java.awt.*;

public class MainRender extends JPanel {

    public MainRender() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        DrawGrid(g2d);

        g2d.dispose();
    }

    public void Prepare() {

    }

    /*
    Draw a grid on the window and each tile on grid follow this formula :
    - OTile => 16 | Scale => 3
    - TileSize = OTile * Scale => 48
    With this all grid tiles is (48, 48)
    */
    private void DrawGrid(Graphics2D g) {
        g.setColor(Color.RED);
        for (int x = 0; x < Globals.SCREEN_WIDTH; x += Globals.TILE_SIZE) {
            for (int y = 0; y < Globals.SCREEN_HEIGHT; y += Globals.TILE_SIZE) {
                g.drawRect(x, y, Globals.TILE_SIZE, Globals.TILE_SIZE);
            }
        }
    }
}