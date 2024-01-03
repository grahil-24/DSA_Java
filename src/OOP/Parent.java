package OOP;

public class Parent {

    public void parentMethod(){

    }
}


class Child extends Parent{

    public void childMethod(){

    }

    public static void main(String[] args) {
        Parent p = new Child();
        Child p2 = new Child();
    }
}
