public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;

    public Octagon() {
        this.side = 0;
    }

    public Octagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public int compareTo(Octagon other) {
        if (this.getArea() < other.getArea()) {
            return -1;
        } else if (this.getArea() > other.getArea()) {
            return 1;
        }
        return 0;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Octagon with side = " + side + ", perimeter = " + getPerimeter() + ", area = " + getArea();
    }
}