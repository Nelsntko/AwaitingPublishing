/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awaitingpublishing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author ntko
 */
public class DiscrepancyCheck {
    private LocalDate parse(String date){
        // This counts the backslashes to determine what type of date
        ArrayList<String> textArray = new ArrayList<>(Arrays.asList(date.split("/")));
        // removes nulls to prevent extra '/' characters.
        textArray.removeAll(Collections.singleton(null));
        int size = textArray.size();
        Date e = null;
        SimpleDateFormat df = null;
        try {
            switch (size){
                case 1:
                {
                    df = new SimpleDateFormat("yyyy");
                    df.setLenient(false);
                    e = df.parse(date);
                    break;
                }
                    case 2:
                {
                    df = new SimpleDateFormat("MM/yyyy");
                    df.setLenient(false);
                    e = df.parse(date);
                    break;
                }
                    case 3:
                {
                    df = new SimpleDateFormat("dd/MM/yyyy");
                    df.setLenient(false);
                    e = df.parse(date);
                    break;
                }
                    default:
                {
                    break;
                }
            
        }
        } catch(ParseException error) {
            return null;

        }
        return e.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public boolean discrepancyCheck(JTextField provided, JTextField confirmed){
        try {
            String providedString = provided.getText();
            String confirmedString = confirmed.getText();

            LocalDate providedLocalDate = this.parse(providedString);
            LocalDate confirmedLocalDate = this.parse(confirmedString);

            long daysDif = ChronoUnit.DAYS.between(providedLocalDate, confirmedLocalDate);
            if (daysDif >= 30 | daysDif <= -30){  
                return true;
            } else {
                return false;
            }
            
        } catch(NullPointerException e){
            return false;
        }
    }

   
}
