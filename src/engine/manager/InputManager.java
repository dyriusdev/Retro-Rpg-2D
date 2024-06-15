package engine.manager;

import engine.util.Keyboard;
import engine.util.MouseInput;
import engine.util.MouseMotion;

public class InputManager {

    private final Keyboard keyboard = new Keyboard();
    private final MouseInput mouse = new MouseInput();
    private final MouseMotion motion = new MouseMotion();

    public Keyboard GetKeyboard() { return keyboard; }

    public MouseInput GetMouse() { return mouse; }

    public MouseMotion GetMouseMotion() { return motion; }



    public void Update(double delta) {}
}
