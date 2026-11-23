# A2 – Buffered I/O

A 50 MB file read one byte at a time using `FileInputStream.read()` causes approximately 50 million read operations when every byte is requested separately. The exact number is the file's byte count plus end-of-file detection.

This is slow because each small read has method and operating-system/I/O overhead.

## Buffered redesign

Use `BufferedInputStream`:

```java
try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
    int b;
    while ((b = in.read()) != -1) {
        if (b == '\n') lines++;
    }
}
```

The application still calls `read()` repeatedly, but the buffered stream fetches larger blocks from the underlying file, greatly reducing physical I/O calls.

A byte-array approach can also be used:

```java
byte[] buffer = new byte[8192];
int count;
while ((count = in.read(buffer)) != -1) {
    for (int i = 0; i < count; i++) {
        if (buffer[i] == '\n') lines++;
    }
}
```

## When buffering gives little benefit

If the data source is already memory-resident or the workload is dominated by computation rather than I/O, another buffering layer may provide little benefit. It may also add unnecessary memory/copying overhead for very small inputs.
