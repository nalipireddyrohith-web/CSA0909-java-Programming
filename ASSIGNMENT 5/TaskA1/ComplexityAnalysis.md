# A1 – Complexity Analysis

For n records in a delimited text file:

- Add: O(1) amortized append, excluding filesystem allocation effects.
- Find by ID: O(n) worst case because the file is scanned.
- List by route: O(n) because every record may need to be inspected.
- Extra memory for streaming: O(1) record-sized working memory.

RandomAccessFile with a fixed record index:
- Seek: O(1) for a known record index.
- ID lookup without an index: O(n).
- With a persistent ID-to-index map: O(1) expected lookup, with additional O(n) index storage.
