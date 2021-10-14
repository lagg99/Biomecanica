package bmc.care.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class UtilDate {

    public static Date toDate(String dateString, String dateFormatPattern) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        Date date = null;
        dateFormat.applyPattern(dateFormatPattern);
        dateFormat.setLenient(true);
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException parseEx) {
            throw new Exception(parseEx);
        }
        return date;
    }

    public static Date toDate(Date date, String dateFormatPattern) throws Exception {
        Date reDate = null;
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(dateFormatPattern);
        String newDate = simpleDateFormat.format(date);
        try {
            reDate = simpleDateFormat.parse(newDate);
        } catch (ParseException parseEx) {
            throw new Exception(parseEx);
        }
        return date;
    }

    public static Timestamp toTimeStamp(String dateString, String dateFormatPattern) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        Date date = null;
        Timestamp time = null;
        dateFormat.applyPattern(dateFormatPattern);
        dateFormat.setLenient(true);
        try {
            date = dateFormat.parse(dateString);
            time = new Timestamp(date.getTime());
        } catch (ParseException parseEx) {
            throw new Exception(parseEx);
        }
        return time;
    }

    public static String  toTimeStampZone(String dateString, String dateFormatIn,String dateFormatOut,String zone) throws Exception{

        SimpleDateFormat formatter = new SimpleDateFormat(dateFormatIn);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = formatter.parse(dateString);
        SimpleDateFormat formatterSalida = new SimpleDateFormat(dateFormatOut);
        formatterSalida.setTimeZone(TimeZone.getTimeZone(zone));
        return  formatterSalida.format(date);
    }

    public static Timestamp toTimeStamp(Date date, String dateFormatPattern) throws Exception {

        Timestamp time = null;
        Date reDate = null;
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(dateFormatPattern);

        try {
            if (date != null) {
                String newDate = simpleDateFormat.format(date);
                reDate = simpleDateFormat.parse(newDate);
                time = new Timestamp(date.getTime());
            }
        } catch (ParseException parseEx) {
            throw new Exception(parseEx);
        }
        return time;

    }

    public static String toString(Date date, String dateFormatPattern) {
        if (date == null) {
            return "";
        }
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(dateFormatPattern);
        String newDate = simpleDateFormat.format(date);
        return newDate;
    }

}
