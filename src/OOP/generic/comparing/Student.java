package OOP.generic.comparing;

public class Student implements Comparable<Student>{

    int rollno;

    float marks;

    public Student(int rollno, float marks){

    }

    @Override
    public int compareTo(Student student) {
        int diff = (int)(this.marks - student.marks);
        //if diff == 0, both are equal, if diff<1 means o is bigger
        return diff;
    }
}
