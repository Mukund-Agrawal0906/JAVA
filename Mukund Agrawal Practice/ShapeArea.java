
import java.util.*;
    class Shape {
        public double getArea() {
            return 0.0;
        }
    }

    class Rectangle extends Shape {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double getArea() {
            return length * width;
        }
    }

    public class ShapeArea {
        public static void main(String[] args) {
            Scanner scan=new Scanner(System.in);
            System.out.println("Enter the Length of rectangle: ");
            double len=scan.nextDouble();
            System.out.println("Enter the Breadth of rectangle: ");
            double br=scan.nextDouble();
            Rectangle rectangle = new Rectangle(len, br);
            System.out.println("Area of the rectangle: " + rectangle.getArea());
            scan.close();
        }
    }


