import engine.Engine;
import engine.render.WindowFrame;

public class LauncherTest {

    public static void main(String[] args) {
        WindowFrame frame = new WindowFrame();
        Engine engine = new Engine(frame);
        engine.Start();
    }
}