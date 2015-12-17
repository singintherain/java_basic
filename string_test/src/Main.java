public class Main {

    public static void main(String[] args) {
        String literal = "test";
        String one = new String(literal);
        String two = "test";

        System.out.println(literal == one);
        System.out.println(literal.equals(one));
        System.out.println(one == two);
    }
}
