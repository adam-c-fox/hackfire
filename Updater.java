class Updater extends Visitor {
    public void visit(ForestWorld f) {
        for(int i = 0; i < f.sizeX; i++) {
            for(int j = 0; i < f.sizeY; j++) {
                if (f.world[i][j].probabilityOfFire == 1) {
                    f.world[i][j].onFire = true;
                }
            }
        }
    }
}
