package Game;

public abstract class GameAbstract {

    public abstract void update(Container container, float deltaTime);
    public abstract void render(Container container, GameRender gameRender);
}
