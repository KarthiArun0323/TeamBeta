package string;
public class StringBasics {
    public static void main(String[] args) {

    String name = "Arun";
    System.out.println(name.length());

    String b="       karthi      0323";
       String c=name.concat(b.trim());
        System.out.println(c);
        System.out.println(c.charAt(5));
        System.out.println(c.contains(b));

        String k=c.substring(4,7);
        System.out.println(k);

        String u="1234";
        int v=6;
        int x=Integer.parseInt(u);
        System.out.println(v+x);
            }
}
