import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class HashMapDemo {

    public static void main(String[] args) {

        // =====================================================
        // 1. DECLARATION & INITIALIZATION
        // =====================================================

        // (a) Empty map
        Map<String, Integer> scores = new HashMap<>();

        // (b) With capacity (good if you know approx size — avoids rehashing)
        Map<String, Integer> scores2 = new HashMap<>(64);

        // (c) Capacity + load factor (0.75 default)
        Map<String, Integer> scores3 = new HashMap<>(64, 0.75f);

        // (d) Copy from another map
        Map<String, Integer> copy = new HashMap<>(scores);

        // (e) Initialize with values using Map.of (up to 10 entries, immutable!)
        Map<String, Integer> immutable = Map.of(
            "Alice", 90,
            "Bob", 85,
            "Charlie", 92
        );

        // (f) Mutable map from Map.of (wrap it)
        Map<String, Integer> mutableFromOf = new HashMap<>(Map.of("Alice", 90, "Bob", 85));

        // (g) Using Map.ofEntries (for > 10 entries)
        Map<String, Integer> entries = new HashMap<>(Map.ofEntries(
            Map.entry("Alice", 90),
            Map.entry("Bob", 85)
        ));

        // (h) Double-brace init — AVOID (creates anonymous class, memory leak risk)
        // Map<String, Integer> bad = new HashMap<>() {{ put("a", 1); }};

        // =====================================================
        // 2. ADDING VALUES
        // =====================================================

        scores.put("Alice", 90);            // adds or overwrites
        scores.put("Bob", 85);
        scores.put("Alice", 95);            // overwrites → 95

        scores.putIfAbsent("Alice", 100);   // does nothing (key exists)
        scores.putIfAbsent("Charlie", 88);  // adds

        // Add many at once
        Map<String, Integer> more = Map.of("Dave", 70, "Eve", 99);
        scores.putAll(more);

        // computeIfAbsent — great for map-of-lists
        Map<String, List<String>> groups = new HashMap<>();
        groups.computeIfAbsent("admin", k -> new ArrayList<>()).add("Alice");
        groups.computeIfAbsent("admin", k -> new ArrayList<>()).add("Bob");
        // groups → {admin=[Alice, Bob]}

        // merge — add/increment pattern
        Map<String, Integer> counter = new HashMap<>();
        counter.merge("apple", 1, Integer::sum);  // apple=1
        counter.merge("apple", 1, Integer::sum);  // apple=2

        // compute — fully custom logic
        scores.compute("Bob", (k, v) -> (v == null) ? 50 : v + 5); // Bob = 90

        // =====================================================
        // 3. BASIC OPERATIONS
        // =====================================================

        int aliceScore = scores.get("Alice");              // 95
        int unknown = scores.getOrDefault("Zed", -1);      // -1

        boolean has = scores.containsKey("Bob");           // true
        boolean hasVal = scores.containsValue(99);         // true
        int size = scores.size();                          // 6
        boolean empty = scores.isEmpty();                  // false

        scores.remove("Eve");                              // remove by key
        scores.remove("Dave", 70);                         // remove only if value matches

        scores.replace("Alice", 100);                      // replace only if key exists
        scores.replace("Alice", 100, 105);                 // replace only if old value matches

        // =====================================================
        // 4. ITERATION (multiple ways)
        // =====================================================

        // (a) forEach — cleanest
        scores.forEach((k, v) -> System.out.println(k + " = " + v));

        // (b) entrySet
        for (Map.Entry<String, Integer> e : scores.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // (c) keySet
        for (String k : scores.keySet()) {
            System.out.println(k + " = " + scores.get(k));
        }

        // (d) values only
        for (int v : scores.values()) {
            System.out.println(v);
        }

        // (e) Java 21 — pattern matching with switch (records + Map.Entry not needed,
        //     but here's a modern flavor using var)
        for (var entry : scores.entrySet()) {
            System.out.printf("%s scored %d%n", entry.getKey(), entry.getValue());
        }

        // =====================================================
        // 5. USEFUL STREAM / COLLECTION INTEROP
        // =====================================================

        // Filter & collect into new map
        Map<String, Integer> high = new HashMap<>();
        scores.forEach((k, v) -> { if (v >= 90) high.put(k, v); });

        // Or with streams
        Map<String, Integer> high2 = scores.entrySet().stream()
                .filter(e -> e.getValue() >= 90)
                .collect(java.util.stream.Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue));

        // Sort by value, collect to LinkedHashMap (ordered)
        Map<String, Integer> sorted = scores.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(java.util.stream.Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (a, b) -> a, java.util.LinkedHashMap::new));
    }
}