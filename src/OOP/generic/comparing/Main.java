package OOP.generic.comparing;

public class Main {


    public static void main(String[] args) {
        Student kunal  = new Student(2, 89.76f);
        Student rahul = new Student(5, 99.52f);

        if(kunal.compareTo(rahul) > 0){
            System.out.println("Kunal has more marks");
        }
    }
}
