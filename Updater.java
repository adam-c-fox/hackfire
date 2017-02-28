class Updater extends Visitor {
    public void visit(ForestWorld f) {
        for(int i = 1; i < f.sizeX-1; i++) {
            for(int j = 1; i < f.sizeY-1; j++) {
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
