# B2 Adversarial Testing

## SQL injection
Attack input:
`' OR '1'='1`

The unsafe concatenated SQL can change query logic. The PreparedStatement version treats the same text as parameter data.

## File attacks
1. Wrong field count → skip damaged record.
2. Non-numeric amount → reject/skip during validation.
3. Empty line → reject/skip.
4. Valid records around a damaged line → remain searchable.

Execute the tests against the local database created by `database.sql`.
