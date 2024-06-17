package engine.gfx;

import engine.Globals;
import engine.manager.InputManager;

import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame {

    private final RenderEngine renderer;
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

        renderer = new RenderEngine(Color.BLACK);
        renderer.Initialize();
        add(renderer);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void Update(double delta) {
        renderer.Update(delta);
        input.Update(delta);
    }

    public void Render() { repaint(); }
}