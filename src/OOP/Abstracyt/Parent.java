package OOP.Abstracyt;

public abstract class Parent {

    private final int age;

    public Parent(int age){
        this.age = age;
    }

}

class Child extends Parent{


    public Child(int age){
        super(age);
    }
}