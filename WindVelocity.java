class windVelocity {
    public float x;
    public float y;

    public windVelocity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
    return ("(" + this.x + "," + this.y + ")");
    }
}
