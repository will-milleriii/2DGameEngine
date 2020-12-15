package Game;

import Animation.Image;

import java.awt.image.DataBufferInt;

public class GameRender {
    private int pixW, pixH;
    private int[] pix;

    public GameRender(Container container){

        pixW = container.getWidth();
        pixH = container.getHeight();
        pix = ((DataBufferInt)container.getWindow().getImage().getRaster().getDataBuffer()).getData(); //gives pix direct access to pixel data of img in window

    }

    public void clear(){
        for (int i = 0; i < pix.length; i++){
            pix[i] = 0xff000000;
        }
    }

    public void setPixel(int x, int y, int value){
        if ((x < 0 || x >= pixW || y < 0 || y >= pixH) || value == 0xffff00ff){
            return;
        }

        pix[x + y * pixW] = value;
    }

    public void draw(Image image, int offsetX, int offsetY){
        for (int x = 0; x < image.getWidth(); x++) {


            for (int y = 0; y < image.getHeight(); y++) {
                setPixel(x + offsetX, y + offsetY, image.getPix()[x + y * image.getWidth()]);

            }
        }
    }

}
