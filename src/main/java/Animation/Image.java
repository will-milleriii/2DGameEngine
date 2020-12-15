package Animation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image {
    private int width, height;
    private int[] pix;

    public Image(String path) throws IOException {
        BufferedImage image = null;
        image = ImageIO.read(Image.class.getResourceAsStream(path));

        width = image.getWidth();
        height = image.getHeight();
        pix = image.getRGB(0, 0, width, height, null, 0, width);

        image.flush();
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

    public int[] getPix() {
        return pix;
    }

    public void setPix(int[] pix) {
        this.pix = pix;
    }
}
