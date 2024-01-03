package OOP.Object_class;

public class Obj_Class {
    public Obj_Class() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Obj_Class a1 = new Obj_Class();
        System.out.println(a1.hashCode());
        Obj_Class a2 = a1;
        System.out.println(a2.hashCode());

        String str = "Rahil";
        String str2 = "Rahil";
        System.out.println(str == str2);
        System.out.println(str.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str2);

        System.out.println(a1.getClass().getConstructor());
    }
}
