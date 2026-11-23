# A1.3 – Damaged Data Design

| Problem | Detection | Handling |
|---|---|---|
| Damaged line | Wrong field count or invalid numeric/date field | Record line number, skip line, continue |
| Missing file | Files.exists() / NoSuchFileException | Report missing file and return empty result |
| Incomplete final write | Final line has incomplete fields or invalid field value | Treat it as damaged and skip |
| Duplicate pass ID | Search existing IDs or database constraint after migration | Reject duplicate and report it |

A good implementation must fail locally for one damaged record instead of losing access to every valid record.
