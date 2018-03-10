package InterviewBit.src.Courses.Programming.Level6_HeapsAndMaps.Problems.Math.WaysToFormMaxHeap.Java;

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solve(20)); // 20 - 258365767 ; 4-3
    }
    
    public static int solve(int A) {
        if (A <= 1) {
            return 1;
        }
    
        int h = (int)(Math.log(A) / Math.log(2)) + 1;        
        int pow = (int)Math.pow(2, h - 1);        
        int maxLast = pow;
        int actualLast = A - (pow - 1);
        
        int l;
        if (actualLast >= maxLast / 2) {
            l = pow - 1;
        }
        else {
            l = pow - 1 - (maxLast / 2 - actualLast);
        }
        
        long subResult = ((long)solve(l) * (long)solve(A - 1 - l)) % 1000000007;
        long res = (combinationNcK(l, A - 1) * subResult) % 1000000007;

        //BigInteger subResult = BigInteger.valueOf(solve(l)).multiply(BigInteger.valueOf(solve(A - 1 - l))).divideAndRemainder(BigInteger.valueOf(1000000007))[1];
        //BigInteger res = subResult.multiply(BigInteger.valueOf(combinationNcK(l, A - 1))).divideAndRemainder(BigInteger.valueOf(1000000007))[1];
        //return (int)(res.intValue() % 1000000007);
            
        return (int)res;
    }

    long[] dp;  	/* dp[i] = number of max heaps for i distinct integers */
    long[][] nck;	/* nck[i][j] = i choose j if i>=j else 0 */
    int[] log2;		/* log2[i] = int(log base 2 of i) */
    
    final long MOD = 1000000007;
    
    public long choose(int n,int k)
    {
        if(k>n)
            return 0;
	if(n<=1)
	    return 1;
	if(k==0)
	    return 1;

        if(nck[n][k]!=-1)
            return nck[n][k];
        long answer = choose(n-1,k-1) + choose(n-1,k);
        answer%=MOD;
        nck[n][k] = answer;
        return answer;
    }
    
    public int getL(int n)
    {
        if(n==1)
            return 0;
            
        int h = log2[n];
        int p = n - ((1<<(h)) - 1);
        int m = (1<<h);
        if(p>=(m/2))
            return (1<<(h)) - 1;
        else
            return (1<<(h)) - 1 - ((m/2) - p);
    }
    
    public int solve_Editorial(int n)
    {
        dp = new long[n+1];
        for(int i=0;i<=n;i++)
            dp[i]=-1;
            
        nck = new long[n+1][n+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=n;j++)
                nck[i][j] = -1;
                
        log2 = new int[n+1];
        int currLogAnswer = -1;
        int currPower2 = 1;
        for(int i=1;i<=n;i++)
        {
	    if(currPower2==i)
            {
                currLogAnswer++;
                currPower2*=2;
            }
            log2[i] = currLogAnswer;
        }
        
        return (int)getNumberOfMaxHeaps(n);
    }
    
    public long getNumberOfMaxHeaps(int n)
    {
        if(n<=1)
            return 1;
            
        if(dp[n]!=-1)
            return dp[n];

        int L = getL(n);
        long ans = (choose(n-1,L)*getNumberOfMaxHeaps(L))%MOD*(getNumberOfMaxHeaps(n-1-L));
        ans%=MOD;
        dp[n] = ans;
        return ans;
    }

    private static long combinationNcK(int k, int n) {
        // long res = 1;
        // for (long i = k + 1; i <= n; i++) {
        //     res *= i;
        //     res /= i - k;
        // }         
        // return res % 1000000007;
        BigInteger factorial_n = factorial(n);
        BigInteger factorial_k = factorial(k);
        BigInteger factorial_nk = factorial(n - k);
        BigInteger denominator = factorial_k.multiply(factorial_nk);
        long res = factorial_n.divide(denominator).longValue();
        return res % 1000000007;
    }

    private static BigInteger factorial(int value){
        if(value < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
    
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
    
        return result;
    }    
}