package OOP;

//poly meaning many, and morph means ways to represent
public class Polymorphism {

    public static void main(String[] args) {
        Shapes shape = new Circle();
        shape.area();
        Shapes.method();
        Circle circle = new Circle();
        Circle.method();
        Triangle triangle = new Triangle();
    }
}

class Shapes{


    void shapeMethod(){

    }
    void area(){
        System.out.println("I am in shapes");
    }

    // we cant override static methods
    static void method(){
        System.out.println("Shapes");
    }
}

class Circle extends Shapes{

    void circleMethod(){

    }
    void area(){
        System.out.println("area of circle");
    }

    static void method(){
        System.out.println("Circles");
    }
}

class Triangle extends Shapes{
    void area(){
        System.out.println("area of triangle");
    }
}