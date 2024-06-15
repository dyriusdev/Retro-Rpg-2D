package engine.util;

import java.awt.*;

public interface IObject {

    void Update(double delta);

    void Render(Graphics2D graphic);
}