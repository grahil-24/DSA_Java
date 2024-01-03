package OOP;

public class Static_OOP {
    static long population;
    void greeting(){
        System.out.println("hi!");
        endGreeting();
    }

    void endGreeting(){
        System.out.println("Bye!");
        greeting();
    }
    public static void main(String[] args) {
        Static_OOP so = new Static_OOP();
        so.greeting();
    }
}
