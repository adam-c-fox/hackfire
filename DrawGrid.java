//import java.awt.Graphics;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
//import java.System.*;

public class DrawGrid extends JPanel {
  private static List<Shape> grid = new ArrayList<Shape>();
  private static List<Shape> fill = new ArrayList<Shape>();
  private ForestWorld fWorld;
  int squareSize = 5;
  int arraySizeX = 50;
  int arraySizeY = 50;
  JFrame f;


  public DrawGrid(int x, int y) {
    arraySizeX = x;
    arraySizeY = y;
    this.f = new JFrame();


    f.setSize(x*squareSize, y*squareSize);
    f.add(this);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    f.setBackground(Color.BLACK);

    button();
  }

  private void button() {
    JButton startButton = new JButton("Run...");

    startButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.out.println("...to the hills");
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
          @Override
          public void run() {
            if(fWorld == null){
              fWorld = new ForestWorld(arraySizeX,arraySizeY);
            }
            Updater updater = new Updater();
            updater.visit(fWorld);
            drawForest(fWorld);
            System.out.println("Iterated!");
          }
        }, 1000, 1000);
      }
    });


    JFrame sB = new JFrame();
    sB.setSize(100,50);
    sB.add(startButton);
    sB.setVisible(true);
  }

  public void drawForest(ForestWorld f) {
    this.fWorld = f;

    for(int i=0; i<f.sizeX; i++){
      for(int j=0; j<f.sizeY; j++){
        if(fWorld.world[i][j].onFire == true){
          Shape n = new Rectangle(i*squareSize, j*squareSize, squareSize, squareSize);
          fill.add(n);
        }
      }
    }

    //DrawGrid g = new DrawGrid(f.sizeX, f.sizeY);

  }

  public void drawClick() {

    this.f.addMouseListener(new MouseAdapter() {
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

     for (int i=0; i<arraySizeX; i++){
       for (int j=0; j<arraySizeY; j++){
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
      // for (Shape cell : grid) {
      //     g2d.draw(cell);
      // }

   }
}
