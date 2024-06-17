package engine.gfx;

import engine.gfx.render.ScreenRender;
import engine.util.IObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RenderEngine extends JPanel {

    private final List<IObject> typesOfRender = new ArrayList<>();

    public RenderEngine(Color background) {
        setLayout(new BorderLayout());
        setBackground(background);
        setDoubleBuffered(true);
    }

    public void Initialize() {
        typesOfRender.add(new ScreenRender());
    }

    public void Update(double delta) {
        for (IObject object : typesOfRender) { object.Update(delta); }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (IObject object : typesOfRender) { object.Render(g2d); }
        g.dispose();
    }
}
