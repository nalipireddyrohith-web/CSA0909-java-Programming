# B1 Testing

| Test | Input | Expected |
|---|---|---|
| Normal add/find | P1003 | Record returned |
| Missing ID | P9999 | null / not found |
| Damaged line | P1004 | Line skipped; other records remain searchable |
| Route listing | route 7 | P1002 and P1003 returned |

For the final report, replace the measurement placeholders in `measurements.csv` with values measured on the execution machine.
