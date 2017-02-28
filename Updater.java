class Updater extends Visitor {
    public void visit(ForestWorld f) {
        for(int i = 0; i < f.sizeX; i++) {
            for(int j = 0; i < f.sizeY; j++) {
                if (world[i][j].Color == stateColor[1]){
                    if ( world[i][j+1].probabilityOfFire > 0.5){
                        world[i][j+1].onFire = true;
                    }
                    if (world[i][j-1].probabilityOfFire > 0.5){
                        world[i][j-1].onFire = true;
                    }
                    if (world[i+1][j].probabilityOfFire > 0.5){
                        world[i+1][j].onFire = true;
                    }
                    if (world[i-1][j].probabilityOfFire > 0.5){
                        world[i-1][j].onFire = true;
                    }
                }
              
            }
        }
    }
}
