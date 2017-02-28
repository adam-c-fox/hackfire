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
  private static List<Shape> fire = new ArrayList<Shape>();
  private static List<Shape> charred = new ArrayList<Shape>();
  private ForestWorld fWorld;
  int squareSize = 5;
  int arraySizeX = 50;
  int arraySizeY = 50;
  JFrame f;
  Updater updt = new Updater();


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
    //f.setLayout(null);
    JButton startButton = new JButton("Run...");
    // startButton.setBounds(1000,200,100,100);

    startButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.out.println("...to the hills");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
          @Override
          public void run() {
            //Updater updater = new Updater();
            updt.visit(fWorld);
            drawForest(fWorld);
            repaint();
            System.out.println("Iterated!");
          }
        }, 1000, 1000);
      }
    });

    JFrame buttonFrame = new JFrame();
    JButton clickButton = new JButton("Click map");
    JButton loadButton = new JButton("Load demo");
    JButton quitButton = new JButton("QUIT");

    clickButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        drawClick();
      }
    });

    loadButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        HeatGrid h = new HeatGrid("small_fire_2.jpg", 200, 200);
        ForestWorld f = h.toForestWorld(80);

        BurnGrid b = new BurnGrid("small_burn.jpg", 200, 200);
        b.toForestWorld(f,150);
        //printInput(f,2000,2000);

        DrawGrid g = new DrawGrid(200,200);
        g.drawForest(f);
      }
    });

    quitButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
      }
    });

    startButton.setBounds(0,0,150,80);
    clickButton.setBounds(0,80,150,80);
    loadButton.setBounds(0,160,150,80);
    quitButton.setBounds(0,300,150,80);


    buttonFrame.setLocation(arraySizeX*squareSize+70, 0);
    buttonFrame.setSize(150,400);
    buttonFrame.add(startButton);
    buttonFrame.add(clickButton);
    buttonFrame.add(loadButton);
    buttonFrame.add(quitButton);
    buttonFrame.setLayout(null);
    buttonFrame.setVisible(true);
  }

  public void drawForest(ForestWorld f) {
    this.fWorld = f;

    for(int i=0; i<f.sizeX; i++){
      for(int j=0; j<f.sizeY; j++){
        if(fWorld.world[i][j].onFire == true){
          Shape n = new Rectangle(i*squareSize, j*squareSize, squareSize, squareSize);
          fire.add(n);
        }
        if(fWorld.world[i][j].charred == true){
          Shape n = new Rectangle(i*squareSize, j*squareSize, squareSize, squareSize);
          charred.add(n);
        }
      }
    }
  }

  public void drawClick() {

    this.f.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        if(fWorld == null){
            fWorld = new ForestWorld(arraySizeX,arraySizeY);
        }
        for (Shape shape : grid) {
          if (shape.contains(me.getPoint())) {
              fWorld.world[me.getPoint().x/squareSize][me.getPoint().y/squareSize].onFire = true;
            if (fire.contains(shape)) {
                fire.remove(shape);
            } else {
                fire.add(shape);
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
      Color brown = new Color( 88, 51, 51 );

      g2d.setColor(Color.WHITE);
      for (Shape cell : fire) {
          g2d.fill(cell);
      }
      g2d.setColor(brown);
      for (Shape cell : charred) {
        g2d.fill(cell);
      }
      // for (Shape cell : grid) {
      //     g2d.draw(cell);
      // }

   }
}
