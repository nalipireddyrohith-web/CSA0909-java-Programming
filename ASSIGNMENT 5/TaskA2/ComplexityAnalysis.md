# A2 – Complexity Analysis

Let S be file size.

### Buffered streaming
- Time: O(S)
- Extra memory: O(B), where B is buffer size.
- Suitable for large files when only part of the data is needed at a time.

### Files.readAllLines()
- Time: O(S)
- Memory: O(S), plus the character/string object overhead.
- Convenient when the entire file must be processed repeatedly and memory is sufficient.

For a 50 MB file, streaming is safer when memory is constrained. Reading everything at once can be faster or simpler for some workloads but uses substantially more memory.
