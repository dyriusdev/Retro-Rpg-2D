package engine;

public class Engine {

    private final Thread engineThread;

    private boolean running = false;

    public Engine() {
        engineThread = new Thread(this::Run);
    }

    public void Start() {
        if (running) { return; }
        engineThread.start();
    }

    public void Stop() {
        if (!running) { return; }
        running = false;
        engineThread.interrupt();
    }

    private void Run() {
        running = true;

        long lastTime = System.nanoTime(), timer = System.currentTimeMillis();
        double amountOfTicks = 60, ns = 1000000000 / amountOfTicks, delta = 0;
        int ticks = 0, frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                ticks++;
                Update(delta);
                delta--;
            }

            try { engineThread.wait(2); }
            catch (InterruptedException e) { System.err.println(e.getMessage()); }

            Render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.printf("Ticks : %d | Fps : %d\n", ticks, frames);
                frames = 0;
                ticks = 0;
            }
        }
    }

    private void Update(double delta) {}

    public void Render() {}
}