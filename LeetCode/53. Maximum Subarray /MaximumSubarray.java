class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0 ;
        int max = Integer.MIN_VALUE ;

        for(int a =0 ; a < nums.length ; a++){
            int this1 = nums[a];
            //System.out.println(sum);

            if(sum <= 0 ) {
                sum = this1;
            } else {
                sum+= this1;
            }
            max = max>sum?max:sum;
        }
        return max ;
    }
}
