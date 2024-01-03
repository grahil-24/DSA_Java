package Enums;

public class EnumEg {
    enum Week{
        //enum constants, which are public static and final
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

        Week(){
            System.out.println("constructor called");
        }
    }

    public static void main(String[] args) {
        Week week;
        week = Week.Monday;

        for(Week day: Week.values()){
            System.out.println(day);
        }

        System.out.println(week.ordinal());
        System.out.println(Week.valueOf("Monday"));
    }
}
