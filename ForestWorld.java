class ForrestWorld {
    Region[][] world;
    int sizeX, sizeY;

    ForrestWorld(int worldX, int worldY){
      this.sizeX = worldX;
      this.sizeY = worldY;

      this.world = new Region[this.sizeX][this.sizeY];

      for(int i = 0; i<this.sizeX; i++){
        for (int j = 0; j<this.sizeY; j++){
          world[i][j] = new Region();
        }
      }
    }

    public void testData() {
      for(int i = 0; i<sizeX; i++){
        for (int j = 0; j<sizeY; j++){
          world[i][j].onFire = false;
        }
      }
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
