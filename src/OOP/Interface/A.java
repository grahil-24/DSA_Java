package OOP.Interface;

public interface A {

    default void fun(){
        System.out.println("Hi!");
    }

    void bruh();
}

class B implements A, C{


    public static void main(String[] args) {
        B b = new B();
        b.fun();
    }

    @Override
    public void fun() {
        A.super.fun();
    }

    @Override
    public void bruh() {

    }
}
