package engine.render;

import engine.Globals;
import engine.manager.InputManager;
import engine.manager.RenderManager;

import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame {

    private final RenderManager render = new RenderManager();
    private final InputManager input = new InputManager();

    public WindowFrame() {
        setTitle(Globals.TITLE);
        setMinimumSize(new Dimension(Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT));
        setMaximumSize(new Dimension(Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT));
        setPreferredSize(new Dimension(Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setFocusable(true);
        addKeyListener(input.GetKeyboard());
        addMouseListener(input.GetMouse());
        addMouseMotionListener(input.GetMouseMotion());

        add(render.GetMainRender());
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void Update(double delta) {
        input.Update(delta);
    }

    public void Render() {
        render.Prepare();
        repaint();
    }
}