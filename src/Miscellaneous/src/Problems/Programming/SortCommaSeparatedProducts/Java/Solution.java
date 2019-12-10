package Miscellaneous.src.Problems.Programming.SortCommaSeparatedProducts.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    // <Name>,<Sales>,<Price>
    static String[] INPUT = new String[] {"Selfie Stick,98,29", "iPhone Case,90,15",
            "Fire TV Stick,48,49", "Wyze Cam,48,25", "Water Filter,56,49",
            "Blue Light Blocking Glasses,90,16", "Ice Maker,47,119", "Video Doorbell,47,199",
            "AA Batteries,64,12", "Disinfecting Wipes,37,12", "Baseball Cards,73,16",
            "Winter Gloves,32,112", "Microphone,44,22", "Pet Kennel,5,24",
            "Jenga Classic Game,100,7", "Ink Cartridges,88,45", "Instant Pot,98,59",
            "Hoze Nozzle,74,26", "Gift Card,45,25", "Keyboard,82,19"};

    public static void main(String[] args) {
        List<Item> items = new ArrayList<Item>();
        for (String eachInput : INPUT) {
            String[] temps = eachInput.split(",");
            Item temp = new Solution.Item(temps[0], Integer.parseInt(temps[1]),
                    Integer.parseInt(temps[2]));
            items.add(temp);
        }

        List<Item> resultAll = getSorted(items);
        for (Item eachItem : resultAll) {
            System.out.println(eachItem.name);
        }
    }

    public static List<Item> getSorted(List<Item> items) {
        Collections.sort(items);
        return items;
    }

    static class Item implements Comparable<Item> {
        String name;
        int sales;
        int price;

        public Item(String name, int sales, int price) {
            this.name = name;
            this.sales = sales;
            this.price = price;
        }

        public int compareTo(Item otherItem) {
            if (this.sales == otherItem.sales) {
                return this.price - otherItem.price;
            } else {
                return otherItem.sales - this.sales;
            }
        }
    }
}
