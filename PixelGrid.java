import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;

class PixelGrid {
    int[][] pixels;
    int w, h;

    public PixelGrid(String s, int w, int h) {
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

        this.pixels = new int[w][h];

        for( int i = 0; i < w; i++ ) {
             for( int j = 0; j < h; j++ ) {
                 this.pixels[i][j] = img.getRGB( i, j );
             }
        }
    }

    public ForrestWorld toForrestWorld() {
        ForrestWorld f = new ForrestWorld(this.w, this.h);
        for( int i = 0; i < w; i++ ) {
             for( int j = 0; j < h; j++ ) {
                 Color pixelColor = new Color(this.pixels[i][j]);
                 if (pixelColor.equals(pixelColor.WHITE)) f.world[i][j].onFire = true;
             }
        }
        return f;
    }
}
