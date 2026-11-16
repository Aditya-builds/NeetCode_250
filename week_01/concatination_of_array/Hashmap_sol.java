import java.util.HashMap;

public class HashMap_Sol{
    public boolean containsDuplicate(int[] nums) {
        //declare a hash map 
        // iterate the for loop in array
        //if number is present in hash return true
        // if not add in hash 
        // if not found in entire iteration return False
        HashMap<Integer,Integer>seen = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (seen.contains.Key(nums[i])){
                return true;
            }
            else{
                seen.put(nums[i],1);
            }

        }


        return false;
    }
} {
    
}
