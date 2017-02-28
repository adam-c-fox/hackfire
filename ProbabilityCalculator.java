import java.util.concurrent.ThreadLocalRandom;
class ProbabilityCalculator extends Visitor {
    @Override
    void visit(ForestWorld f) {
        double rand = ((double)ThreadLocalRandom.current().nextInt(0,10))/10;
        ForestWorld n = new ForestWorld(f.sizeX, f.sizeY);
        for(int j = 1; j < f.sizeY-1; j++){
          for(int i = 1; i < f.sizeX-1; i++) {
                  n.world[i][j].probabilityOfFire = f.world[i][j+1].probabilityOfFire +
                                                    f.world[i][j-1].probabilityOfFire +
                                                    f.world[i+1][j].probabilityOfFire +
                                                    f.world[i+1][j+1].probabilityOfFire +
                                                    f.world[i-1][j-1].probabilityOfFire +
                                                    f.world[i-1][j].probabilityOfFire;

                System.out.println(n.world[i][j].probabilityOfFire);
                n.world[i][j].probabilityOfFire = n.world[i][j].probabilityOfFire/3;
                if(rand <= 5) n.world[i][j].probabilityOfFire -= 0.2;

                if(n.world[i][j].probabilityOfFire > 1) n.world[i][j].probabilityOfFire = 1.0;
                if(n.world[i][j].probabilityOfFire < 0) n.world[i][j].probabilityOfFire = 0.0;

                if(f.world[i][j].charred) n.world[i][j].probabilityOfFire = 0.0;
                if(f.world[i][j].onFire) n.world[i][j].probabilityOfFire = 1.0;

                f.world[i][j].probabilityOfFire = n.world[i][j].probabilityOfFire;
              }
          }
     }
}
