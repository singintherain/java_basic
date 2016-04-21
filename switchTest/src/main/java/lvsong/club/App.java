package lvsong.club;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Code code = Code.OK;

        switch (code) {
            case OK:
                System.out.println("code ok");
                break;
            case SYSTEMERROR:
                System.out.println("code system error");
                break;
            default:
                System.out.println("default");
        }
    }
}
