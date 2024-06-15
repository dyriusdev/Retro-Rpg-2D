package engine.world.tile;

import engine.util.IObject;

public abstract class Tile implements IObject {

    private final int id;
    private int x, y;
    private boolean canUpdate = false, canRender = false;

    public Tile(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public boolean CanUpdate() { return canUpdate; }

    public void SetUpdate(boolean value) { canUpdate = value; }

    public boolean CanRender() { return canRender; }

    public void SetRender(boolean value) { canRender = value; }

    public int GetX() { return x; }

    public void SetX(int value) { x = value; }

    public int GetY() { return y; }

    public void SetY(int value) { y = value; }

    public int GetId() { return id; }
}