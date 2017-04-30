package space.harbour.l51.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by tully.
 */
public class DateExample {
    public static void main(String... args) throws ParseException {
        date2String();
        string2Date();
        getCurrentDateTime();
        getCurrentDateTime2();
    }


    private static void date2String() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date = sdf.format(new Date());
        System.out.println(date); //15/10/2013
    }

    private static void string2Date() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        Date date = sdf.parse(dateInString);
        System.out.println(date); //Tue Aug 31 10:20:56 SGT 1982
    }

    private static void getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2013/10/15 16:16:39
    }

    private static void getCurrentDateTime2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar(2017, 0, 31);
        System.out.println(sdf.format(calendar.getTime()));
        //Output 2013 Jan 31 00:00:00
    }
}
