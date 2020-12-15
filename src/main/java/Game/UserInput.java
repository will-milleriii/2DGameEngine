package Game;

import java.awt.event.*;

public class UserInput implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
    private Container container;
    private final int NUM_KEYS = 256;
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];

    private final int NUM_BUTTONS = 5;
    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];

    private int mouseX, mouseY;
    private int scrollW;

    public UserInput(Container container){
        this.container = container;
        mouseX = 0;
        mouseY = 0;
        scrollW = 0;

        container.getWindow().getCanvas().addKeyListener(this);
        container.getWindow().getCanvas().addMouseListener(this);
        container.getWindow().getCanvas().addMouseMotionListener(this);
        container.getWindow().getCanvas().addMouseWheelListener(this);

    }

    public void update(){
        scrollW = 0;

        for (int i = 0; i < NUM_KEYS; i++){
            keysLast[i] = keys[i];
        }

        for (int i = 0; i < NUM_BUTTONS; i++){
            buttonsLast[i] = buttons[i];
        }
    }

    public boolean isKey(int keyCode){
        return keys[keyCode];
    }

    public boolean isKeyUp(int keyCode){
        return !keys[keyCode] && keysLast[keyCode];
    }

    public boolean isKeyDown(int keyCode){
        return keys[keyCode] && !keysLast[keyCode];
    }

    public boolean isButton(int button){
        return buttons[button];
    }

    public boolean isButtonUp(int button){
        return !buttons[button] && buttonsLast[button];
    }

    public boolean isButtonDown(int button){
        return buttons[button] && !buttonsLast[button];
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;

    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;

    }

    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        mouseX = (int)(e.getX() / container.getScale());
        mouseY = (int)(e.getY() / container.getScale());

    }

    public void mouseMoved(MouseEvent e) {
        mouseX = (int)(e.getX() / container.getScale()); //scale lets this match window and resolution
        mouseY = (int)(e.getY() / container.getScale());

    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        scrollW = e.getWheelRotation();

    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }
}
