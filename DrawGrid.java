//import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
//import java.System.*;

public class DrawGrid extends JPanel {
  private static List<Shape> grid = new ArrayList<Shape>();
  private static List<Shape> fill = new ArrayList<Shape>();
  int squareSize = 15;
  int arraySize = 50;
  int[][] rects = new int[arraySize][arraySize];

   public static void main(String[] a) {
     new DrawGrid();
   }

  public DrawGrid() {
    JFrame f = new JFrame();
    f.setSize(800, 800);
    f.add(this);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    //f.getContentPane().setBackground(Color.BLACK);
    f.setBackground(Color.BLACK);


    f.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        for (Shape shape : grid) {
          if (shape.contains(me.getPoint())) {
            if (fill.contains(shape)) {
                fill.remove(shape);
            } else {
                fill.add(shape);
            }
          }
          repaint();
      }
    }
    });
  }


   public void paint(Graphics g) {

     for (int i=1; i<arraySize; i++){
       for (int j=1; j<arraySize; j++){
         grid.add(new Rectangle(i*squareSize, j*squareSize, squareSize, squareSize));
       }
     }

      //super.paintComponent(g);
      //^What does this even do????
      Graphics2D g2d = (Graphics2D) g;
      g2d.setColor(Color.WHITE);
      for (Shape cell : fill) {
          g2d.fill(cell);
      }
      for (Shape cell : grid) {
          g2d.draw(cell);
      }

   }
}
