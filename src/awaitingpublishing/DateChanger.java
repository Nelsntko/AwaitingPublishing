/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awaitingpublishing;

import static com.google.common.base.Preconditions.*;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;





/**
 *
 * @author ntko
 */
public class DateChanger {
    private String getSuffix(final int n) {
        checkArgument(n >= 1 && n <= 31, "illegal day of month: " + n);
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }
    
    public String dateChanger(String date) {

        ArrayList<String> textArray = new ArrayList<>(Arrays.asList(date.split("/")));
        textArray.removeAll(Collections.singleton(null));
        int size = textArray.size();
        
        Date e = null;
        try{
        switch (size){
            case 1:
        {
            SimpleDateFormat dfShort = new SimpleDateFormat("yyyy");
            dfShort.setLenient(false); // delete those non-dates
            e = dfShort.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(e);
            String year = String.valueOf(cal.get(Calendar.YEAR));
            return year;
        }
            case 2:
        {
            SimpleDateFormat dfMed = new SimpleDateFormat("MM/yyyy");
            dfMed.setLenient(false); // delete those non-dates
            e = dfMed.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(e);
            String year = String.valueOf(cal.get(Calendar.YEAR));
            String month = new DateFormatSymbols().getMonths()[cal.get(Calendar.MONTH)];
            return month + " " + year;

        }
            case 3:
        {
            SimpleDateFormat dfLong = new SimpleDateFormat("dd/MM/yyyy");
            dfLong.setLenient(false); // delete those non dates
            e = dfLong.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(e);
            String year = String.valueOf(cal.get(Calendar.YEAR));
            String month = new DateFormatSymbols().getMonths()[cal.get(Calendar.MONTH)];
            String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
            return day + this.getSuffix(cal.get(Calendar.DAY_OF_MONTH)) + " " + month + " " + year;
        }
            default:
                return date;
        }
        } catch(ArrayIndexOutOfBoundsException | ParseException error) {
            return date;
            
        }
            
    }
}