import com.pattern.creational.EnumSingleTon;
import com.pattern.creational.SingleTon;

public class Main {
    public static void main (String []arg) {
         SingleTon singleTon = SingleTon.getInstance();
         singleTon.process();
    }
}
