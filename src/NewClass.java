import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewClass
{
    public static void main(String[] args) {
        System.out.println( "helo there" );
        System.out.println(add2Numbers(25,75));
        FizzBuzz();
        System.out.println(isPalindrome("A man a plan a canal Panama"));
        System.out.println(rotateArray( new int[] { 1, 2, 3, 4, 5 }, 1).toString());
        System.out.println(findSecondLargest(new int[] { 10 ,32 ,1 ,23 ,198 }));
        System.out.println(findSecondSmallest(new int[] { 10 ,32 ,1 ,23 ,198 }));
        System.out.println(findMissingNumber(new int[] { 1,2,4,5,3 }));

        var cat = new cat();
        var human = new human();

        cat.wag();
        human.work();
    }

    public static int add2Numbers( int a ,int b ) {
        return a + b;
    }

    // Challenge 1: FizzBuzz variant
    // Print 1-100, but "Fizz" for multiples of 3, "Buzz" for 5, "FizzBuzz" for both
    public static void FizzBuzz() {

        for( int i = 1; i <= 100; i = i + 1 ){

            if( i % 3 == 0 &&  i % 5 == 0  ) {
                System.out.println("FizzBuzz");
            }else if( i % 3 == 0 ) {
                System.out.println("Fizz");
            } else if( i % 5 == 0 ) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    // Challenge 2: Palindrome checker
    // Return true if string reads same forwards/backwards (ignore case/spaces)
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        if (str.length() <= 1) return true;

        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // Challenge 3: Array rotation
    // Rotate array right by k positions: [1,2,3,4,5] rotated by 2 = [4,5,1,2,3]

    public static int[] rotateArray(int[] array, int k) {
        // Edge case handling - crucial for interviews
        if (array == null || array.length == 0 || k == 0) {
            return array;
        }

        int n = array.length;
        k = k % n; // Handle k > array length

        // If k is 0 after modulo, no rotation needed
        if (k == 0) return array;

        int[] result = new int[n];

        // Copy elements to their new positions
        // Element at index i goes to index (i + k) % n
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = array[i];
        }

        return result;
    }


    public static int findSecondLargest(int[] arr) {

        if( arr == null || arr.length < 2 ) {
            throw new IllegalArgumentException("Array must have atleast 2 numbers");
        }

        int firstBiggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;

        for( int num: arr ) {
            if( num > firstBiggest ) {
                secondBiggest = firstBiggest;
                firstBiggest = num;
            }
            else if(num > secondBiggest && num != firstBiggest) {
                secondBiggest = num;
            }
        }

        if( secondBiggest == Integer.MIN_VALUE ) {
            throw new IllegalArgumentException("All elements are the same");
        }

        return secondBiggest;
    }

    public static int findSecondSmallest(int[] arr) {
        if( arr == null || arr.length < 2 ) {
            throw new IllegalArgumentException("Array must have atleast 2 numbers");
        }

        int smallestNumber = Integer.MAX_VALUE;
        int secondSmallestNumber = Integer.MAX_VALUE;

        for( int num: arr ) {
            if( num < smallestNumber) {
                secondSmallestNumber = smallestNumber;
                smallestNumber = num;
            }
            else if( num < secondSmallestNumber && num != smallestNumber ) {
                secondSmallestNumber = num;
            }
        }

        if( secondSmallestNumber == Integer.MAX_VALUE ) {
            throw new IllegalArgumentException("The array must atleast have 2 numbers");
        }

        return secondSmallestNumber;
    }

    public static int findMissingNumber(int[] arr) {
        if( arr == null ) {
            throw new IllegalArgumentException("Array is empty");
        }
        int n = arr.length + 1;
        int totalSum = n * (n + 1) / 2;
        int actualSum = 0;

        for( int num: arr ) {
            actualSum += num;
        }

        return totalSum - actualSum;
    }

    public class TwoSumOptimal {

        public static int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                throw new IllegalArgumentException("Array must have at least 2 elements");
            }

            // Map to store value -> index mapping
            Map<Integer, Integer> numMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];

                // Check if complement exists in map
                if (numMap.containsKey(complement)) {
                    return new int[]{numMap.get(complement), i};
                }

                // Store current number and its index
                numMap.put(nums[i], i);
            }

            // No solution found
            throw new IllegalArgumentException("No two sum solution exists");
        }

        public static void main(String[] args) {
            int[] nums1 = {2, 7, 11, 15};
            int target1 = 9;

            int[] result1 = twoSum(nums1, target1);
            System.out.println("HashMap: [" + result1[0] + ", " + result1[1] + "]");

            // Test with duplicates
            int[] nums2 = {3, 3};
            int target2 = 6;

            int[] result2 = twoSum(nums2, target2);
            System.out.println("Duplicates: [" + result2[0] + ", " + result2[1] + "]");
        }
    }


}
