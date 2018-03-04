import com.nulabinc.zxcvbn.Feedback;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Datte {
    public static void main(String[] args) {
        Zxcvbn zxcvbn = new Zxcvbn();
        Strength measure = zxcvbn.measure("65432");
        Feedback feedback = measure.getFeedback();
        System.out.println(feedback.getSuggestions(Locale.CHINESE));
        System.out.println(feedback.getWarning());
        System.out.println(measure.getScore());
        System.out.println(measure.getSequence());
    }
}
