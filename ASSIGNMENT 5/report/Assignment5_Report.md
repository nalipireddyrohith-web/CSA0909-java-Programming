# CSA09 – Programming in Java
# Assignment 5 – CO5
## Data Persistence Engineering – Files and Databases

**Student:** NALIPI REDDY ROHITH  
**Register Number:** 192425115  
**Academic Year:** 2026–2027

## 1. Introduction
This report studies persistence using text files, buffered streams, serialization and JDBC. The engineering workflow is Understand → Design → Protect → Implement → Measure → Challenge → Interpret.

## 2. Part A
### A1
Include the record layouts, operation pseudocode, damaged-data strategy and RandomAccessFile complexity comparison from `TaskA1/`.

### A2
Include the unbuffered/buffered prediction, redesigned stream, limitation and memory comparison from `TaskA2/`.

### A3
Include the repeated JDBC pattern, generic DAO design and Student mapping from `TaskA3/`.

### A4
Include transient-field decisions, object-graph serialization and serialVersionUID discussion from `TaskA4/`.

### A5
Include transaction pseudocode, SQL injection analysis and PreparedStatement redesign from `TaskA5/`.

## 3. Part B
### B1
Run PassStore and line-counter programs. Record real timing values for 1 MB, 10 MB and 50 MB files and for 1,000, 10,000 and 100,000 records.

### B2
Run the unsafe and safe login tests using the local assignment database. Test damaged file inputs.

### B3
Run Statement, PreparedStatement and batch tests at 1,000, 10,000 and 100,000 rows. Repeat transaction/auto-commit tests and record actual results.

### B4
Run migration and DatabaseMetaData programs and make the final production decision using the measured evidence.

## 4. Measurement interpretation
The report must contain the actual measured values obtained during execution. Machine-specific timings must not be invented.

## 5. Conclusion
For small/simple persistence, text files can be adequate. At larger scale with concurrent counters, indexed searching, integrity and transaction requirements, a relational database is the practical engineering choice.
