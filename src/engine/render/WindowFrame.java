package engine.render;

import engine.Globals;

import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame {

    private final MainRender render = new MainRender();

    public WindowFrame() {
        setMinimumSize(new Dimension(Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT));
        setMaximumSize(new Dimension(Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT));
        setPreferredSize(new Dimension(Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT));
        setLayout(new BorderLayout());

        setFocusable(true);
        add(render);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void Update(double delta) {}

    public void Render() {
        repaint();
    }
}