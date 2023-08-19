class Functions{
    static int add(int ...arr){
        int sum = 0;
        for(int element : arr){
            sum+=element;
        }
        return sum;
    }
}


public class varargs {
    public static void main(String[] args){
        System.out.println(Functions.add(1,2,3,4,5));
        System.out.println(Functions.add(1,2,3,4,5,6,7,8,9,10));
        System.out.println(Functions.add(1,2,3));
    }
    
}
