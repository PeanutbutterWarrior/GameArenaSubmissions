public class RelativeRect extends Rectangle {
    private Rectangle parent;
    public RelativeRect(double x, double y, double w, double h, String col, Rectangle parent) {
        super(x, y, w, h, col);
        this.parent = parent;
    }

    public RelativeRect(double x, double y, double w, double h, String col, int layer, Rectangle parent) {
        super(x, y, w, h, col, layer);
        this.parent = parent;
    }

    public double getXPosition() {
        return parent.getXPosition() + super.getXPosition();
    }

    public double getYPosition() {
        return parent.getYPosition() + super.getYPosition();
    }
}
