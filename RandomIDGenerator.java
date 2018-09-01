import java.util.Random;

public class RandomIDGenerator {

    public static String createId()
    {
        String random="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random rand=new Random();
        StringBuffer buffer =new StringBuffer();
        for(int i=0;i<=10;i++)
        {
            int num=rand.nextInt(62);
            buffer.append(random.charAt(num));

        }
        return buffer.toString();
    }
}
