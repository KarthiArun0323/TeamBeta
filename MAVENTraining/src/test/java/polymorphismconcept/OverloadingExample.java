package polymorphismconcept;

public class OverloadingExample {

    public static void main(String[] args) {
        OverloadingExample output = new OverloadingExample();
        output.m1(323);
        output.m1("ArunKarthi");
    }

    public void m1(int a){
        System.out.println(a);
    }

    public void m1(String a){
        System.out.println(a);
    }

    public void m1(int a,int b){
        System.out.println(a+b);
    }

    public void m1(String a,int b){
        System.out.println(a);
    }
}
