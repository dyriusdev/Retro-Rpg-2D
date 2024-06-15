package engine.manager;

import engine.render.MainRender;

public class RenderManager {

    private final MainRender render = new MainRender();

    public MainRender GetMainRender() { return render; }

    public void Prepare() {
        render.Prepare();
    }
}
