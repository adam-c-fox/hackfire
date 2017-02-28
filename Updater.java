class Updater extends Visitor {
    public void visit(ForestWorld f) {
      ForestWorld n = new ForestWorld(f.sizeX, f.sizeY);
      n.world = f.world;

        for(int i = 1; i < f.sizeX-1; i++) {
            for(int j = 1; j < f.sizeY-1; j++) {
                if (f.world[i][j].onFire == true){
                    if (f.world[i][j+1].probabilityOfFire > 0.5 && f.world[i][j+1].charred == false) {
                        n.world[i][j+1].onFire = true;
                    }
                    if (f.world[i][j-1].probabilityOfFire > 0.5 && f.world[i][j-1].charred == false){
                        n.world[i][j-1].onFire = true;
                    }
                    if (f.world[i+1][j].probabilityOfFire > 0.5 && f.world[i+1][j].charred == false){
                        n.world[i+1][j].onFire = true;
                    }
                    if (f.world[i-1][j].probabilityOfFire > 0.5 && f.world[i-1][j].charred == false){
                        n.world[i-1][j].onFire = true;
                    }
                }

            }
        }

        f.world = n.world;
    }
}
