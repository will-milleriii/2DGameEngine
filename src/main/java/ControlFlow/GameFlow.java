package ControlFlow;

import Game.Container;
import Game.GameAbstract;
import Game.GameRender;

import java.awt.event.KeyEvent;

public class GameFlow extends GameAbstract {

    public GameFlow(){}


    public static void main(String[] args){
        Container container = new Container(new GameFlow());
        container.start();
    }

    public void update(Container container, float deltaTime) {
        if (container.getUserInput().isKeyDown(KeyEvent.VK_W)){
            System.out.println("Game is running");
        }

    }

    public void render(Container container, GameRender gameRender) {

    }
}
