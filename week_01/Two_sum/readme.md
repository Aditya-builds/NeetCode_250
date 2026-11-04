

## 1. Python fundamentals learned

### Python range()

```python
range(start, stop, step)
```

- `start`: Starting value (inclusive).
- `stop`: Ending boundary (exclusive).
- `step`: Increment/decrement (default is 1).

Example:

```python
range(0, 4)  # 0, 1, 2, 3
```

Important: `range(len(nums))` iterates over all valid array indices.

## 2. Brute-force approach

The initial approach is to examine every possible pair using nested loops.

```python
for i in range(len(nums)):
    for j in range(i + 1, len(nums)):
        if nums[i] + nums[j] == target:
            return [i, j]
```

Why `i + 1`?

- Prevents comparing an element with itself.
- Prevents examining the same pair twice.
- Ensures that the second index is always greater than the first.

**Complexity:**
- Time: O(n²)
- Auxiliary space: O(1)

Number of comparisons in the worst case:

\[
\frac{n(n-1)}{2}
\]

## 3. Mathematical observation — Complement

Initially, the problem looks like finding two numbers whose sum equals the target.

Express it mathematically:

\[
x+y=target
\]

Rearrange:

\[
y=target-x
\]

This gives us an important observation:

If I already know one number, I know exactly what the other number must be.

That required number is called the **complement**.

Instead of searching for every possible pair, calculate the complement and check whether it exists.

## 4. Two HashMap approaches

### Approach A — Store future complements

Process the array from left to right.

1. Check whether the current number exists as a key in the dictionary.
2. If it exists, we found its previously stored complement.
3. Otherwise, calculate its complement.
4. Store the complement as the key and current index as the value.

Dictionary representation:

```python
complements = {
    7: 0
}
```

Meaning: If we encounter 7, pair it with the element at index 0.

### Approach B — Store previously encountered numbers

Process the array from left to right.

1. Calculate the current number's complement.
2. Check whether the complement exists in the dictionary.
3. If it exists, return the previously stored index and current index.
4. Otherwise, store the current number and its index.

Dictionary representation:

```python
seen = {
    2: 0,
    7: 1
}
```

Meaning: We have already encountered 2 at index 0 and 7 at index 1.

**Important invariant:**

At the beginning of every iteration, `seen` contains only elements encountered at earlier indices.

This guarantees that we never use the same array element twice.

**Complexity for both approaches:**
- Time: O(n) average.
- Auxiliary space: O(n).

## 5. Why the HashMap works

A Python dictionary uses a hash table internally.

- A hash function helps determine where a key is stored.
- Lookup is O(1) on average.
- Hash collisions are possible and require collision handling.
- Worst-case lookup can be O(n).

The optimization trades additional memory for faster execution.

## 6. Important edge cases

- Duplicate values: `[3, 3]`, target = 6.
- Negative numbers.
- Zero values.
- Complement equals the current value.
- Last array element forms the answer.
- No pair found (depending on the problem's input guarantee).

## 7. Language comparison — To complete

| Concept | Python | Java | C++ |
|---|---|---|---|
| Hash map | dict | HashMap | unordered_map |
| Insert/update | `d[key] = value` | `put()` | `m[key] = value` |
| Lookup | `key in d` | `containsKey()` | `find()` |
| Retrieve | `d[key]` | `get()` | `m[key]` |

## 8. Lessons learned

1. Understand the mathematical relationship before selecting a data structure.
2. A data structure should be selected based on the operation we need to optimize.
3. Dictionary keys should represent what we need to search for.
4. Operation order matters for algorithm correctness.
5. Always distinguish between input space and auxiliary space.
6. Prove correctness with an invariant, not just sample test cases.

## 9. Revision checklist

- [ ] Reconstruct brute force without notes.
- [ ] Derive the complement equation independently.
- [ ] Implement both HashMap approaches.
- [ ] Explain the invariant.
- [ ] Explain O(n²) versus O(n).
- [ ] Implement in Python.
- [ ] Implement in Java.
- [ ] Implement in C++.
- [ ] Solve again without looking at previous implementations.