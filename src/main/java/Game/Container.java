package Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Container implements Runnable {

    private Thread thread;
    private GameRender gameRender;
    private UserInput userInput;
    private GameWindow window;
    private GameAbstract game;
    private Boolean running = false;
    private final double UPDATE_CAP = 1.0/ 60.0;
    private int width = 320, height = 240;
    private float scale = 2f;
    private String title = "ZCW 2D Engine 1.0";

    public Container(GameAbstract game){
        this.game = game;

    }

    public void run(){
        running = true;
        boolean render = false;
        double firstTime = 0.0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0.0;
        double unprocessedTime = 0.0;
        double frameRate = 0.0;
        int fps = 0;
        int frames = 0;

        while (running){
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;
            unprocessedTime += passedTime;
            frameRate += passedTime;

            while(unprocessedTime >= UPDATE_CAP){
                unprocessedTime -= UPDATE_CAP;
                render = true;
                //TODO update game
                game.update(this, (float)UPDATE_CAP);
//                System.out.println("x: " + userInput.getMouseX() + " y: " + userInput.getMouseY()); //shows mouse coordinates on panel
//                if (userInput.isButtonDown(MouseEvent.BUTTON1));{
//                    System.out.println("You clicked Mouse 1");
//                }
//                if (userInput.isKey(KeyEvent.VK_W)){
//                    System.out.println("W is pressed");
//                }
//                if (userInput.isKeyUp(KeyEvent.VK_A)){
//                    System.out.println("A was pressed");
//                }
//                if (userInput.isKeyDown(KeyEvent.VK_S)){
//                    System.out.println("You pressed S once");
//                }
                //TODO This is for testing so remove/comment out at some point
                userInput.update();

                if (frameRate >= 1.0){
                    frameRate = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);
                }
                //if game freezes we still need it to update
                //so if the game froze for the time we need x amount of updates, we want it to update what was missed
            }
            if (render){
                gameRender.clear();
                window.updateWindow();
                game.render(this, gameRender);
                frames++;
                //TODO Render game
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        dispose();

    }

    public void start(){

        window = new GameWindow(this);
        gameRender = new GameRender(this);
        userInput = new UserInput(this);
        thread = new Thread(this);
        thread.run();

    }

    public void stop(){

    }

    public void dispose(){

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GameWindow getWindow() {
        return window;
    }

    public UserInput getUserInput() {
        return userInput;
    }
}
