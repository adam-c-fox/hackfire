class ForestWorld {
    Region[][] world;
    int sizeX, sizeY;
    //2D array which should store given probabilities...need a way to use .dat file to get 2D array
    double [][] givenprob;

    ForestWorld(int worldX, int worldY){
      this.sizeX = worldX;
      this.sizeY = worldY;

      this.world = new Region[this.sizeX][this.sizeY];

      for(int i = 0; i<this.sizeX; i++){
        for (int j = 0; j<this.sizeY; j++){
          world[i][j] = new Region();
          //input all given probablitites
          //world[i][j].probabilityOfFire = givenprob[i][j];
        }
      }
    }

    public void testData() {
      for(int i = 0; i<sizeX; i++){
        for (int j = 0; j<sizeY; j++){
          world[i][j].onFire = false;
          world[i][j].probabilityOfFire = 0.1;
        }
      }
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
