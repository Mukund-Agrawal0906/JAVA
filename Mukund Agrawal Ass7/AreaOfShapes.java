import java.util.*;

abstract class Shape {
    public abstract double RectangleArea(double length, double breadth);

    public abstract double SquareArea(double side);

    public abstract double CircleArea(double radius);
}

class Area extends Shape {
    @Override
    public double RectangleArea(double length, double breadth) {
        return length * breadth;
    }

    @Override
    public double SquareArea(double side) {
        return side * side;
    }

    @Override
    public double CircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}

public class AreaOfShapes {
    public static void main(String[] args) {
        Area areaCalculator = new Area();
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter length of the rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter breadth of the rectangle: ");
        double breadth = scanner.nextDouble();
        double rectangleArea = areaCalculator.RectangleArea(length, breadth);

        System.out.print("Enter the side of the square: ");
        double side = scanner.nextDouble();
        double squareArea = areaCalculator.SquareArea(side);

        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        double circleArea = areaCalculator.CircleArea(radius);

        System.out.println("Area of Rectangle: " + rectangleArea);
        System.out.println("Area of Square: " + squareArea);
        System.out.println("Area of Circle: " + circleArea);

        scanner.close();
    }
}
