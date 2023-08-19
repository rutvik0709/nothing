class Pen{
    String type;
    String color;

    public void pentype(){
        System.out.println("Nice");
    }
    public void properties(){
        System.out.println(this.color);
    }
}
class Student{
    String name;
    String age;

    public void details(){
        System.out.println(name);
        System.out.println(age);
    }
    Student(Student s2){
        this.name = s2.name;
        this.age = s2.age;
    }
    Student(){

    }
}
public class revision{
    public static void main(String[] args){
        Pen p1 = new Pen();
        Pen p2 = new Pen();
        p1.color = "blue";
        p2.color = "green";
        p1.type="ball";
        // p1.pentype();
        p2.properties();

        Student s1 = new Student();
        // s1.details();
        s1.name="rutvik";
        s1.age="19";
        Student s2 = new Student(s1);
        s2.details();
    }
}