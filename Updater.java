class Updater extends Visitor {
    public void visit(ForestWorld f) {
        for(int i = 0; i < f.sizeX; i++) {
            for(int j = 0; i < f.sizeY; j++) {
                if (f.world[i][j].onFire == true){
                    if (f.world[i][j+1].probabilityOfFire > 0.5){
                        f.world[i][j+1].onFire = true;
                    }
                    if (f.world[i][j-1].probabilityOfFire > 0.5){
                        f.world[i][j-1].onFire = true;
                    }
                    if (f.world[i+1][j].probabilityOfFire > 0.5){
                        f.world[i+1][j].onFire = true;
                    }
                    if (f.world[i-1][j].probabilityOfFire > 0.5){
                        f.world[i-1][j].onFire = true;
                    }
                }
              
            }
        }
    }
}
