package InterviewBit.src.Courses.Programming.Level5_Backtracking.Examples.ModularExpression.Java;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(Mod(2, 3, 3)); //3
        //System.out.println(Mod(-1, 1, 20)); //19
        System.out.println(Mod_int2(71045970, 41535484, 64735492)); //20805472
    }

    public static int Mod(int a, int b, int c) {
	    if (b == 0) {
            return 1 % c;
        }
	    if (b == 1) {
            return ((a % c < 0) ? (a % c + c) : (a % c));
        }
	    int p = Mod(a, b / 2, c);
	    int q = Mod(a, b % 2, c);
	    int tmp = (int)((1L * p * p) % c);
	    tmp = (int)((1L * tmp * q) % c);
	    tmp = (tmp < 0) ? tmp + c : tmp;
	    return tmp;
    }
    
    // TODO: broken
    private static int Mod_int2(int A, int B, int C) {
        int y;
        if (B == 0) {
            return 1%C;
        }
        else if (B%2 == 0) {
            y = Mod_int2(A, B/2, C);
            y = (int)(1L * y * y) % C;
        }
        else {
            y = ((int)((1L * (A%C) * Mod_int2(A, B-1, C))) % C);
        }
        //return (int)((y+C) % C);
        return ((y+C) % C);
    }

    public static int Mod_int(int A, int B, int C) {
        long result = Mod_long(A, B, C);
        return Math.toIntExact(result);
    }
    
    private static long Mod_long(int A, int B, int C) {
        long y;
        if (B == 0) {
            return 1%C;
        }
        else if (B%2 == 0) {
            y = Mod_long(A, B/2, C);
            y = (y*y) % C;
        }
        else {
            y = ((A%C) * Mod_long(A, B-1, C)) % C;
        }
        //return (int)((y+C) % C);
        return ((y+C) % C);
    }
}