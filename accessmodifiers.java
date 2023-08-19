class Bank{
    public String name;
    protected String email;
    int ifsccode;
    private String password;

    public String getPassword() {
       return this.password;
    }
    public void setPassword(String pass) {
        this.password = pass;
    }
}



public class accessmodifiers {
    public static void main(String[] args){
        Bank b1 = new Bank();
        b1.name = "Rutvik";
        b1.email = "rutvik0709@gmail.com";
        b1.ifsccode = 19;

        b1.setPassword("abcd");
        System.out.println(b1.getPassword());
    }
    
}
