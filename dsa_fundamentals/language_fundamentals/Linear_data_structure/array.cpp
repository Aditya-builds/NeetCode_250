// File: ArrayDemo.cpp
// Compile: g++ -std=c++17 ArrayDemo.cpp -o ArrayDemo && ./ArrayDemo

#include <array>      // std::array  (fixed-size, safe wrapper)
#include <algorithm>  // std::sort, std::fill, std::copy, std::binary_search
#include <iostream>
#include <iterator>   // std::size (C++17)

int main() {

    // ---------- 1. DECLARATION + INITIALIZATION ----------

    // Way 1: std::array (preferred — closest to Java's int[])
    std::array<int, 5> nums = {};                 // size 5, all zeros
    std::array<int, 5> nums2 = {10, 20, 30, 40, 50};

    // Way 2: raw C-style array (fixed size baked into the type)
    int raw[3] = {1, 2, 3};

    // ---------- 2. SIZE ----------
    // std::array -> .size()   (a METHOD)
    // raw array  -> std::size(raw)  or sizeof(raw)/sizeof(raw[0])
    std::cout << "nums2.size() = " << nums2.size() << "\n";         // 5
    std::cout << "std::size(raw) = " << std::size(raw) << "\n";     // 3

    // ---------- 3. ACCESS + UPDATE ----------
    // []  -> no bounds check (same as Java's array indexing)
    // .at() -> BOUNDS-CHECKED, throws std::out_of_range (safer)
    std::cout << "nums2[2] = " << nums2[2] << "\n";      // 30
    nums2[2] = 999;
    std::cout << "nums2.at(2) = " << nums2.at(2) << "\n"; // 999
    // nums2.at(10); // would throw std::out_of_range

    // ---------- 4. ITERATION ----------

    // Classic for-loop (needs the index)
    for (std::size_t i = 0; i < nums2.size(); i++)
        std::cout << nums2[i] << " ";
    std::cout << "\n";

    // Range-based for (like Java's for-each)
    for (int v : nums2) std::cout << v << " ";
    std::cout << "\n";

    // By reference if you want to MODIFY the elements
    for (int& v : nums2) v += 1;                         // bump each by 1

    // ---------- 5. UTILITIES (from <algorithm>) ----------

    // Print (no built-in toString — loop or ostream_iterator)
    for (int v : nums2) std::cout << v << " ";
    std::cout << "\n";

    // Sort (in place)
    std::array<int, 4> unsorted = {5, 2, 9, 1};
    std::sort(unsorted.begin(), unsorted.end());
    for (int v : unsorted) std::cout << v << " ";        // 1 2 5 9
    std::cout << "\n";

    // Fill every slot with one value
    std::array<int, 4> filled;
    filled.fill(7);                                      // [7, 7, 7, 7]

    // Copy into a bigger array ("resizing" in C++ = copy to a new one)
    std::array<int, 8> grown = {};                       // extras default to 0
    std::copy(nums2.begin(), nums2.end(), grown.begin());

    // Binary search (array must be sorted first) -> returns iterator
    bool found = std::binary_search(unsorted.begin(), unsorted.end(), 5);
    std::cout << "found 5? " << std::boolalpha << found << "\n"; // true

    // ---------- 6. SUMMARY TABLE ----------
    // Thing you want          | std::array syntax
    // ------------------------|-----------------------------
    // Header                  | #include <array>
    // Create                  | std::array<int, 5> a = {};
    // Size                    | a.size()        (method!)
    // Read                    | a[i]  or  a.at(i)  (at = checked)
    // Write                   | a[i] = x
    // Loop                    | for (int v : a) { ... }
    // Sort                    | std::sort(a.begin(), a.end());
    // Fill                    | a.fill(x);
    // Resize (impossible)     | copy into a new std::array

    return 0;
}