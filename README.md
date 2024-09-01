**Project Title:**  
**"Hash Table Implementation with Quadratic Probing in Java"**

**Project Description:**

In this project, you will create a custom hash table in Java using quadratic probing as a collision resolution technique. Quadratic probing is an open addressing scheme in hash tables that resolves collisions by probing or searching for the next available slot using a quadratic function of the form \( f(i) = i^2 \).

**Project Objectives:**

1. **Implement a Hash Table:**
   - Create a hash table class in Java that uses an array to store elements.
   - Implement hash functions that map keys to indexes in the array.

2. **Quadratic Probing for Collision Resolution:**
   - Implement quadratic probing to handle collisions. When a collision occurs, use the quadratic function to find the next available slot for the element.
   - The quadratic function should have the form:  
     \( \text{Index} = ( \text{hash}(key) + c1 \times i + c2 \times i^2 ) \mod \text{table\_size} \)  
     where `i` is the collision count, and `c1` and `c2` are constants that determine the probing sequence.

3. **Basic Operations:**
   - Implement the basic hash table operations: `insert(key, value)`, `get(key)`, and `remove(key)`.
   - Ensure that the hash table dynamically resizes when it reaches a certain load factor to maintain efficient operations.

4. **Error Handling:**
   - Handle scenarios where the table becomes full or cannot find a suitable slot due to quadratic probing.
   - Implement proper error handling and user-friendly messages for these cases.

5. **Testing and Performance Analysis:**
   - Create a set of test cases to validate your hash table's functionality, including edge cases like inserting duplicate keys, removing non-existent keys, and handling rehashing.
   - Analyze the performance of your hash table, focusing on the efficiency of insertion, deletion, and lookup operations with varying load factors and table sizes.

**Project Deliverables:**

1. **Source Code:** Java source files for the hash table implementation, including a main class to demonstrate and test functionality.
2. **Test Cases:** A set of test cases and their results, demonstrating that the hash table functions correctly and efficiently.
