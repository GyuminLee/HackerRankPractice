class MoveZeros {
    public void moveZeroes(int[] nums) {
        //Check num of 0
        int zeroCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            }
        }
        for (int j = 0; j < zeroCnt; j++) {
            for (int i = 0; i < nums.length-1; i++) {

                if (nums[i] == 0) {
                    nums[i] = nums[i+1];
                    nums[i+1] = 0;
                }
            }
        }
    }
}