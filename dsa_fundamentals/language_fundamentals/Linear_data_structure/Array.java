// File: ArrayDemo.java
// No import needed for arrays — they're part of the Java language.
        import java.util.Arrays; /
public class ArrayDemo {
    public static void main(String[] args) {

        // ---------- 1. DECLARATION + INITIALIZATION ----------

        // Way 1: declare with a fixed size (all elements = 0 by default for int)
        int[] nums = new int[5];

        // Way 2: declare and set values directly (size is inferred)
        int[] nums2 = {10, 20, 30, 40, 50};

        // Way 3: declare with values using "new"
        int[] nums3 = new int[]{1, 2, 3};

        // ---------- 2. SIZE / LENGTH ----------
        // NOTE: For arrays it's a PROPERTY (no parentheses!) -> .length
        System.out.println("Length of nums2: " + nums2.length); // 5

        // ---------- 3. ACCESS + UPDATE ----------
        System.out.println("Element at index 2: " + nums2[2]); // 30
        nums2[2] = 999;                                        // update in place
        System.out.println("Updated index 2: " + nums2[2]);    // 999

        // IndexOutOfBoundsException if you go past length-1:
        // System.out.println(nums2[10]); // would crash

        // ---------- 4. ITERATION ----------

        // Classic for loop (when you need the index)
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();

        // For-each loop (when you only need the values)
        for (int val : nums2) {
            System.out.print(val + " ");
        }
        System.out.println();

        // ---------- 5. COMMON UTILITY METHODS ----------
        // Arrays is a helper class -> requires an import
// (imagine this at the top of the file)
    }
}