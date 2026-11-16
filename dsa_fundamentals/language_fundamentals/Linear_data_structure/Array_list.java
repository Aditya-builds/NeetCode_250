// File: ArrayListDemo.java
import java.util.ArrayList;      // the class itself
import java.util.Collections;    // for sorting, reversing, etc.

public class Array_list {
    public static void main(String[] args) {

        // ---------- 1. DECLARATION ----------
        // ArrayList holds OBJECTS, not primitives.
        // So use Integer, not int. (String, Double, Boolean, etc.)
        ArrayList<Integer> list = new ArrayList<>();

        // You can also pre-size it (an optimization hint, not a limit):
        ArrayList<String> names = new ArrayList<>(10);

        // Pre-fill from an array-like source is done via a loop or Arrays.asList()
        // (we'll get to that later)

        // ---------- 2. SIZE ----------
        // NOTE: For ArrayList it's a METHOD (with parentheses!) -> .size()
        System.out.println("Initial size: " + list.size()); // 0

        // ---------- 3. ADD ----------
        list.add(10);          // append to the end
        list.add(20);
        list.add(30);
        list.add(1, 15);       // insert at index 1 -> [10, 15, 20, 30]
        System.out.println(list); // [10, 15, 20, 30]

        // ---------- 4. READ ----------
        // Use .get(index), NOT list[index]
        System.out.println("Element at 0: " + list.get(0)); // 10

        // ---------- 5. UPDATE ----------
        // Use .set(index, value)
        list.set(0, 99);
        System.out.println("After set: " + list); // [99, 15, 20, 30]

        // ---------- 6. REMOVE ----------
        list.remove(1);                  // removes element AT index 1
        System.out.println("After remove idx 1: " + list); // [99, 20, 30]

        // Careful: remove(Object) vs remove(int)
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(10);
        nums.remove(Integer.valueOf(5)); // removes the VALUE 5
        System.out.println("After remove value 5: " + nums); // [10]

        // ---------- 7. SEARCH ----------
        System.out.println("contains 20? " + list.contains(20)); // true
        System.out.println("indexOf 30: " + list.indexOf(30));   // 2

        // ---------- 8. ITERATION ----------

        // Classic for-loop
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // For-each (simplest)
        for (int val : list) {
            System.out.print(val + " ");
        }
        System.out.println();

        // ---------- 9. CONVERT TO / FROM ARRAY ----------

        // ArrayList -> int[]
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);        // unboxing Integer -> int
        }
        System.out.println("Converted array length: " + arr.length);

        // int[] -> ArrayList (must loop, since Arrays.asList doesn't work on primitives)
        int[] source = {1, 2, 3};
        ArrayList<Integer> fromArr = new ArrayList<>();
        for (int x : source) {
            fromArr.add(x);              // autoboxing int -> Integer
        }
        System.out.println("From array: " + fromArr); // [1, 2, 3]

        // ---------- 10. COMMON UTILITIES ----------

        Collections.sort(list);           // ascending
        System.out.println("Sorted: " + list);

        Collections.reverse(list);
        System.out.println("Reversed: " + list);

        list.clear();                     // empties the list
        System.out.println("isEmpty? " + list.isEmpty()); // true

        // ---------- 11. SUMMARY TABLE ----------
        // Thing you want          | ArrayList syntax
        // ------------------------|-------------------------
        // Import                  | import java.util.ArrayList;
        // Create                  | new ArrayList<Integer>()
        // Size                    | list.size()      (with parens!)
        // Read                    | list.get(i)
        // Write / Update          | list.set(i, x)
        // Append                  | list.add(x)
        // Insert at index         | list.add(i, x)
        // Remove by index         | list.remove(i)
        // Remove by value         | list.remove(Integer.valueOf(x))
        // Contains                | list.contains(x)
        // Loop                    | for (int v : list) { ... }
        // Convert to array        | manual loop (boxing!)
    }
}