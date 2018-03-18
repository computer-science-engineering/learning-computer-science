package HackerRank.src.Tracks.Tutorials.ThirtyDaysOfCode.D14_Scope.Java;

import java.util.*;


class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}

class Difference {
    private int[] elements;
    public int maximumDifference;

    Difference(int[] items){
        this.elements = items;
    }

    public void computeDifference(){
        List<Integer> diff = new ArrayList<>();
        for (int i=0; i<elements.length-1; i++){
            for (int j=i+1; j<elements.length; j++) {
                int res = (elements[i] - elements[j]);
                if (res < 0){
                    res = res * -1;
                }
                //System.out.println(i + " " + j + " " + res);
                diff.add(res);
            }
        }
        maximumDifference = Collections.max(diff);
    }
}
