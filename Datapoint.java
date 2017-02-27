class Datapoint {
    private double pressure;
    private WindVelocity windVelocity;

    Datapoint(double pressure, double windVelocityX, double windVelocityY) {
        this.pressure = pressure;
        this.windVelocity.x = windVelocityX;
        this.windVelocity.y = windVelocityY;
    }

    public double getPressure() {
        return this.pressure;
    }
    public void setPressure(double pressureInput) {
        this.pressure = pressureInput;
    }

    public WindVelocity getWindVelocity() {
        return this.windVelocity;
    }
    public void setWindVelocity(double windVelocityX, double windVelocityY) {
        this.windVelocity = new WindVelocity(windVelocityX,windVelocityY);
    }
}
