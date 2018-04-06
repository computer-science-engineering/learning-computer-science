package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.Knapsack.EqualAveragePartition.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 7, 15, 29, 11, 9));
        ArrayList<ArrayList<Integer>> result = avgSet(A);
        System.out.println(result);
    }
    
    public static ArrayList<ArrayList<Integer>> avgSet(ArrayList<Integer> A) {        
        Collections.sort( A );
        final ArrayList<ArrayList<Integer>> res = new ArrayList<>();        
        final ArrayList<Integer> path = new ArrayList<>();        
        int N = A.size();        
        int totalSum = 0;
        
        for( int a : A ) {
            totalSum += a;
        }
        
        final boolean T[][][] = new boolean[N][totalSum+1][N];
        
        for( int i =0; i < N; i++) {
            for( int j =0; j <= totalSum; j++) {
                for( int k =0; k < N; k++) {
                    T[i][j][k] = true;
                }
            }
        }
        
        for( int i = 1; i < N; i++ ) {
            if((totalSum*i)%N != 0) {
                continue;
            }
            
            final int sumOfSet_i = (totalSum*i)/N;
            
            if( isPossible( 0, sumOfSet_i, i, A, T, path )) {
                int i1=0;
                int i2=0;
                final ArrayList<Integer> res2 = new ArrayList<>();
                while( i2 < path.size() || i1 < N ) {
                    if( i2 < path.size() && path.get( i2 ) == A.get( i1 )) {
                        i2++;
                        i1++;
                        continue;
                    }
                    
                    res2.add( A.get( i1++ ) );
                }
                
                if( path.size() > res2.size()) {
                    res.add( res2 );
                    res.add( path );
                }
                else {
                    res.add( path );
                    res.add( res2 );
                }
                
                return res;
            }
        }
        
        return res;
    }

    private static boolean isPossible(int index, int currentSum, int len, ArrayList<Integer> A, final boolean [][][] T, final ArrayList<Integer> path) {
        if( len == 0) {
            return currentSum == 0;
        }
        
        if( index >= A.size()) {
            return false;
        }
        
        if( !T[index][currentSum][len]) {
            return false;
        }
        
        if( currentSum >= A.get( index )) {
            path.add( A.get( index ) );
            if( isPossible(index+1, currentSum-A.get( index ), len-1, A, T, path)) {
                return true;
            }
            path.remove( path.size()-1 );
        }
        
        if( isPossible( index+1, currentSum, len, A, T, path )) {
            return true;
        }
        
        T[index][currentSum][len] = false;        
        return false;
    }

    // Editorial

    private ArrayList<Integer> array;
    private boolean[][][] dp;
    private ArrayList<Integer> indexSetA;

    public ArrayList<ArrayList<Integer>> avgSet_Editorial(ArrayList<Integer> array) {
        if (array == null || array.isEmpty()) {
            return new ArrayList<>();
        }

        this.array = array;
        Collections.sort(this.array);

        int sum = 0;
        for (int element : array) {
            sum += element;
        }

        int n = array.size();

        // memoization table by three states : (index, sum of setA, size of setA)
        this.dp = new boolean[n][1 + sum][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1 + sum; j++) {
                for (int k = 0; k < n; k++) {
                    this.dp[i][j][k] = true;
                }
            }
        }

        this.indexSetA = new ArrayList<>();

        // iterate for third state : size of setA which varies from 1 to n-1
        for (int sizeA = 1; sizeA < n; sizeA++) {
            if ((sum * sizeA) % n != 0) {
                continue;
            }

            int sumA = (sum * sizeA) / n;

            if (isPartitionPossible(0, sumA, sizeA) == true) {
                break;
            }
        }

        return generatePartitions();
    }

    private boolean isPartitionPossible(final int index, final int sumA, final int sizeA) {
        if (sizeA == 0) {
            return sumA == 0;
        }

        int n = this.array.size();
        if (index >= n) {
            return false;
        }

        if (this.dp[index][sumA][sizeA] == false) {
            return false;
        }

        if (sumA >= this.array.get(index)) {
            // include the current index i.e. include the current element in setA
            this.indexSetA.add(index);
            if (isPartitionPossible(index + 1, sumA - this.array.get(index), sizeA - 1) == true) {
                return true;
            }
            this.indexSetA.remove(this.indexSetA.size() - 1);
        }

        if (isPartitionPossible(index + 1, sumA, sizeA)) {
            // skip the current index i.e. don't include the current element in setA
            return true;
        }

        this.dp[index][sumA][sizeA] = false;
        return this.dp[index][sumA][sizeA];
    }

    private ArrayList<ArrayList<Integer>> generatePartitions() {
        int i = 0, j = 0;
        int sizeA = this.indexSetA.size();
        int n = this.array.size();

        if (sizeA == n || sizeA == 0) {   // no solution exists
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        // index i is used to iterate over all elements and index j is used to iterate over indexSetA
        while (i < n && j < sizeA) {
            if (i == this.indexSetA.get(j)) {
                result.get(0).add(this.array.get(i));
                j++;
            } else {
                result.get(1).add(this.array.get(i));
            }
            i++;
        }

        while (i < n) {
            result.get(1).add(this.array.get(i));
            i++;
        }

        return result;
    }
}