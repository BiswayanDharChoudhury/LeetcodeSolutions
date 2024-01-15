class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, new int[amount + 1]);
       
    }
    private int helper(int[] coins, int amount, int[] memo){
        
        // check the amount
        if(amount == 0){
            memo[amount] = 0;
            return 0;
        }
        
        if(amount < 0){
            return -1;
        }
        
        // use the memo
        if(memo[amount] != 0){
            return memo[amount];
        }
        
        // greedy
        int result = Integer.MAX_VALUE;
        
        for(int coin : coins){
            int count = helper(coins, amount - coin, memo);
            
            if(count >= 0){
                result = Math.min(result, 1 + count);
            }
        }
        
        memo[amount] = result == Integer.MAX_VALUE ? -1 : result;
        
        return memo[amount]; 
    }
}
