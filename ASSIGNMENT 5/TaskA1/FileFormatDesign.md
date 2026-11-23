# A1 – File Format Design

## Text format

One pass per line, comma-delimited:

`passId,regNo,name,routeNo,boardingStop,validityDate,amountPaid`

Example:
`P1001,192311001,Arun Kumar,12,CMBT,2027-03-31,4500.00`

### Delimiter handling
The comma is reserved as the delimiter. A name or boarding stop containing a comma is quoted and escaped using CSV rules. For a simple assignment implementation, the safer option is to reject an unescaped delimiter and report the record as damaged. A production implementation should use a CSV parser.

## Binary format using DataOutputStream

Fields are written in fixed order:
1. pass ID – UTF string
2. register number – UTF string
3. name – UTF string
4. route number – int
5. boarding stop – UTF string
6. validity date – UTF string in ISO-8601 format
7. amount paid – double

`DataOutputStream` writes the primitive values in a machine-independent binary representation.

## Operation design

### Add
Use `BufferedWriter` with `Files.newBufferedWriter(..., CREATE, APPEND)`. Buffered character output is appropriate because the data is text and multiple records are appended.

### Find
Use `BufferedReader` and scan one line at a time. Split/parse each valid record and compare field 1 with the requested pass ID.

### List by route
Use `BufferedReader`, validate each line, parse route number, and emit records whose route equals the requested route.

### Damaged data
A line is damaged when the number of fields is incorrect, a required field is empty, or a numeric field cannot be parsed. Log the line number and continue rather than stopping the complete search.

### Missing file
If the file does not exist, report that no records are available. For a read operation, return an empty result or a controlled error.

### Incomplete write
Use one complete record per line and append through a buffered writer. A final line without the expected number of fields is treated as damaged and skipped. For stronger durability, write to a temporary file and atomically replace the old file during full rewrites.

## RandomAccessFile alternative

With fixed-length records:
`offset = recordIndex × recordSize`

If a direct index maps pass ID to record index, the record can be reached in O(1) seek time. Without an index, finding an arbitrary pass ID still requires scanning records.

Fixed-width fields waste space when actual values are shorter than their allocated widths. The wasted space is approximately the sum of unused padding bytes over all records.
