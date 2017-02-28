import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;

class BurnGrid {
    short[][] pixelsR, pixelsG, pixelsB;
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

        this.pixelsR = new short[w][h];
        this.pixelsG = new short[w][h];
        this.pixelsB = new short[w][h];

        for( int i = 0; i < w; i++ ) {
             for( int j = 0; j < h; j++ ) {
                 Color color = new Color(img.getRGB(i, j));
                     this.pixelsR[i][j] = (short)(color.getRed());
                     this.pixelsG[i][j] = (short)(color.getGreen());
                     this.pixelsB[i][j] = (short)(color.getBlue());
             }
        }
    }

    public void toForestWorld(ForestWorld f, int tollerance) {
        for( int i = 0; i < w; i++ ) {
             for( int j = 0; j < h; j++ ) {
                 if (this.pixelsR[i][j] <= tollerance && this.pixelsG[i][j] <= tollerance/2 && this.pixelsB[i][j] <= tollerance/2) {
                     f.world[i][j].charred = true;
                 }
             }
        }
    }
}
