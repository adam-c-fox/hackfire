class Main {
    public static void main(String[] args) {

        Datapoint test = new Datapoint(10.0, 10.0 ,10.0);
        System.out.println(test.getPressure());
        System.out.println(test.getWindVelocity());
        System.out.println("Hello World!");

        FireWorld testWorld = new FireWorld(10,10);

        testWorld.testData();

        System.out.println(testWorld.world[3][4].getPressure());

        HeatGrid h = new HeatGrid("small_fire_2.jpg", 200, 200);
        ForestWorld f = h.toForestWorld(80);

        BurnGrid b = new BurnGrid("small_burn.jpg", 200, 200);
        b.toForestWorld(f,200);
        //printInput(f,2000,2000);

        DrawGrid g = new DrawGrid(200,200);
        g.drawForest(f);

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
