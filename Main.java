class Main {
    public static void main(String[] args) {
        Datapoint test = new Datapoint(10.0, 10.0 ,10.0);
        System.out.println(test.getPressure());
        System.out.println(test.getWindVelocity());
        System.out.println("Hello World!");

        FireWorld testWorld = new FireWorld(10,10);

        testWorld.testData();

        System.out.println(testWorld.world[3][4].getPressure());
    }
}
