abstract class Animals{
    abstract void walk();
    public void eat(){
        System.out.println("Animal eats veg");
    }
}
class Horse extends Animals{
    public void walk(){
        System.out.println("Walks on 4 legs");
    }
}
class Chicken extends Animals{
    public void walk(){
        System.out.println("Walks on 2 legs");
    }
}
public class abstraction {
    public static void main(String[] args){
        Horse h1 = new Horse();
        h1.walk();
        h1.eat();
    }
}
