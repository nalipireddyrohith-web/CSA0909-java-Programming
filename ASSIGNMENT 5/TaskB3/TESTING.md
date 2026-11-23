# B3 Testing

Run the SQL script first. Replace `YOUR_PASSWORD` in the Java programs or supply credentials securely.

Required measurements:
- Statement: 1,000 / 10,000 / 100,000
- PreparedStatement: 1,000 / 10,000 / 100,000
- PreparedStatement batch: 1,000 / 10,000 / 100,000
- Auto-commit vs one transaction
- Forced failure half-way

Record the actual local times in `measurements.csv`. The values depend on the local computer, JVM, MySQL configuration and network/storage.
