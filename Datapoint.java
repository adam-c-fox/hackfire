class Datapoint {
    private float pressure;
    private WindVelocity windVelocity;

    Datapoint(float pressure, float windVelocityX, float windVelocityY) {
        this.pressure = pressure;
        this.windVelocity.x = windVelocityX;
        this.windVelocity.y = windVelocityY;

    }

    public float getPressure() {
        return this.pressure;
    }
    public float setPressure(float pressureInput) {
        this.pressure = pressureInput;
    }

    public float getWindVelocity() {
        return this.windVelocity;
    }
    public float setWindVelocity(float windVelocityX, float windVelocityY) {
        this.windVelocity = new windVelocity(windVelocityX,windVelocityY);
    }
}
