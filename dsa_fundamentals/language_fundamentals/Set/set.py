# this is basic set implementation in python
# to declare a set we use set() function
seen  = set()

# basics operations on set
seen.add(1) # add an element to the set
seen.add(2)

seen.remove(1) # remove an element from the set
print(seen) # prints {2}

set.add([1,2])
print(seen) # prints {2, [1, 2]} but this will raise an error because lists are unhashable and cannot be added to a set

set.update([3, 4]) # add multiple elements to the set
set.remove(2) # remove an element from the set
set.discard(5) # remove an element from the set if it exists, otherwise do nothing


# /*
# s = set()          # create
# s.add(x)           # add one
# s.update(it)       # add many
# s.remove(x)        # delete (error if absent)
# s.discard(x)       # delete (safe)
# s.pop()            # remove arbitrary
# s.clear()          # empty
# del s              # delete variable

# a | b  a & b  a - b  a ^ b          # union, intersection, diff, sym-diff
# x in s                              # membership
# len(s)                              # size
# */