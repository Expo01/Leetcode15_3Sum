import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0; // target sum of 3 ints defined
        Arrays.sort(nums); // sorted for 2 pointer O-logn binary search
        Set<List<Integer>> s = new HashSet<>(); // this is like a multidimensional array. a greater Set contains a List
        // of integers  such that each List contains 3 integers which add to 0, and the Set will contain as many of those
        // lists as were added in the forthcoming loop.
        // the properties of a set include that is is unordered and does NOT allow for duplicates. this is important since
        // a condition in the problem is no duplicate triplets
        List<List<Integer>> output = new ArrayList<>(); // a List is created as required for the return type
        // a List DOES allow for duplication and it IS ordered. which is why we didn't directly add triplets to a List
        for (int i = 0; i < nums.length; i++){ // identifies the first potential triplet value
            int j = i + 1; // left pointer for binary search
            int k = nums.length - 1; // right pointer
            while (j < k) { // working lateral to medially
                int sum = nums[i] + nums[j] + nums[k]; // discern sum at current values
                if (sum == target) { // if ==, increment and decrement so as not to reuse anything
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) { // if sum too low, increment j which must be a large negative value
                    j++;
                } else { // otherwise sum too high and need a smaller R pointer valueee
                    k--;
                }
            }
        }
        output.addAll(s); // add the unordered non-redundant Set items to the ordered List for return
        return output;
    }
}