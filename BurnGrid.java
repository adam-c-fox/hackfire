import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;

class BurnGrid {
    short[][] pixels;
    int w, h;

    public BurnGrid(String s, int w, int h) {
        BufferedImage img = null;
        this.w = w;
        this.h = h;

        //read image
        try{
          File f = new File(s); //image file path
          img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
          img = ImageIO.read(f);
          System.out.println("Reading complete.");
        }
        catch(IOException e){
          System.out.println("Error: "+e);
        }

        this.pixels = new short[w][h];

        for( int i = 0; i < w; i++ ) {
             for( int j = 0; j < h; j++ ) {
                 Color color = new Color(img.getRGB(i, j));
                     this.pixels[i][j] =  (short)(color.getRed() + color.getBlue() + color.getGreen());
             }
        }
    }

    public void toForestWorld(ForestWorld f, int tollerance) {
        for( int i = 0; i < w; i++ ) {
             for( int j = 0; j < h; j++ ) {
                 if (this.pixels[i][j] <= tollerance) {
                     f.world[i][j].charred = true;
                 }
             }
        }
    }
}
