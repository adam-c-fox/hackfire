class WindVelocity {
    public double x;
    public double y;

    public WindVelocity(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
    return ("(" + this.x + "," + this.y + ")");
    }
}
