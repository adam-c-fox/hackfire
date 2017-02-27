class FireWorld {
    Datapoint[][] world;
    int sizeX, sizeY;

    FireWorld(int worldX, int worldY){
      this.sizeX = worldX;
      this.sizeY = worldY;

      this.world = new Datapoint[this.sizeX][this.sizeY];

      for(int i = 0; i<this.sizeX; i++){
        for (int j = 0; j<this.sizeY; j++){
          world[i][j] = new Datapoint(0,0,0);
        }
      }
    }

    public void testData() {
      for(int i = 0; i<sizeX; i++){
        for (int j = 0; j<sizeY; j++){
          world[i][j].setPressure(100000);
          world[i][j].setWindVelocity(0,1);
        }
      }
    }
}
