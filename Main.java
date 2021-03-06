class Main {
    public static void main(String[] args) {

        Datapoint test = new Datapoint(10.0, 10.0 ,10.0);
        System.out.println(test.getPressure());
        System.out.println(test.getWindVelocity());
        System.out.println("Hello World!");

        FireWorld testWorld = new FireWorld(10,10);

        testWorld.testData();

        System.out.println(testWorld.world[3][4].getPressure());

        DrawGrid g = new DrawGrid(200,200);
        g.drawForest(null);

        // DrawGrid g = new DrawGrid(100,100);
        // g.drawClick();
    }

    private static void printInput(ForestWorld f, int x, int y) {
         for(int i = 0; i<2000; i++) {
             for(int j = 0; j<2000; j++) {
                 System.out.print(toInt(f.world[i][j].onFire));
             }
             System.out.println();
         }
    }

    private static int toInt(Boolean b) {
        if (b == true) return 1;
        else return 0;
    }
}
