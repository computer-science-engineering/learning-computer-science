package HackerRank.src.Tracks.CoreCS.Algorithms.Warmup.TimeConversion.Java;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] twelvehourtime = scan.next().split(":");
        String hour = twelvehourtime[0];
        String min = twelvehourtime[1];
        String second = twelvehourtime[2].substring(0, 2);
        String amOrPm = twelvehourtime[2].substring(2, 4);
        scan.close();
        if(amOrPm.equals("AM")){
            String newHour;
            if (hour.equals("12")){
                newHour = "00";
            }
            else{
                newHour = hour;
            }
            System.out.println(newHour + ":" + min + ":" + second);
        }
        else if (amOrPm.equals("PM")){
            int newHour;
            int oldHour = Integer.parseInt(hour);
            if (oldHour == 12){
                newHour = 12;
            }
            else{
                newHour = 12 + oldHour;
            }
            System.out.println(newHour + ":" + min + ":" + second);
        }
    }
}
