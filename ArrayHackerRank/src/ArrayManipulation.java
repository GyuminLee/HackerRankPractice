import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {
/*
int main() {
    long int N,K,p,q,sum,i,j,max=0,x=0;

    cin>>N>>K;
    long int *a=new long int[N+1]();

    for(i=0;i<K;i++)
    {
        cin>>p>>q>>sum;
        a[p]+=sum;
        if((q+1)<=N) a[q+1]-=sum;
    }

    for(i=1;i<=N;i++)
    {
       x=x+a[i];
       if(max<x) max=x;

    }

    cout<<max;
    return 0;
}
 */
    static long arrayManipulation(int n, int[][] queries) {
        int m = queries.length;

        long[] arr = new long[n];

        int lower;
        int upper;
        long sum;

        for(int i=0;i<n;i++) arr[i]=0;

        for(int i=0;i<m;i++){
            lower = queries[i][0];
            upper = queries[i][1];
            sum = queries[i][2];
            arr[lower-1]+=sum;
            if(upper<n) {
                arr[upper]-=sum;
            }
            for(int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]+ ", ");
            }
            System.out.println();
        }

        long max=0;
        long temp=0;

        for(int i=0;i<n;i++){

            temp += arr[i];
            if(temp> max) max=temp;
        }

       return max;
    }


    public static void main(String[] args) {

        int n = 5;

        int[][] queries = {{1, 2 ,100},
                {2, 5, 100},
                {3, 4 ,100}};


        long result = arrayManipulation(n, queries);

        System.out.println("Result : " + result);
    }
}
