package OOP;

public class Outer {
    public class Inner{
        String name;

        public Inner(String name){
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner("Sdija");
    }
}


