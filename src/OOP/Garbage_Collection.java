package OOP;

public class Garbage_Collection {

    final int num = 10;
    String name;

    public Garbage_Collection(String name){
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("Object is destroyed!");
    }

    public static void main(String[] args) {
        Garbage_Collection gc = new Garbage_Collection("sex");
    }
}
