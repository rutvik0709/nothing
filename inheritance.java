class Shape{
    public void area(){
        System.out.println("Display the area");
    }
}
class Triangle extends Shape{
    int base,height;
    public void area(int base, int height){
        System.out.println(0.5*base*height);

    }
}


public class inheritance {
    public static void main(String[] args){
        Triangle t1 = new Triangle();
        t1.area(5,5);

    }
    
}
