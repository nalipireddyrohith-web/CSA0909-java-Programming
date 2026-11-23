# B4 – Final Engineering Decision

## Recommended store: relational database

At the new scale, the transport office serves 12 campuses, has approximately 100× the current volume, and has multiple counters issuing passes concurrently.

### Text file
Advantages:
- Simple
- Low setup cost

Limitations:
- Linear searches
- Difficult concurrent updates
- Weak transaction and integrity support

### Java serialization
Advantages:
- Convenient Java object persistence
- Object graph can be saved directly

Limitations:
- Java-specific format
- Versioning complexity
- Poor fit for concurrent multi-counter transactional updates

### Database
Advantages:
- Indexed search
- Concurrent transactions
- Constraints and validation
- PreparedStatement security
- Batch loading
- Metadata and operational tooling

Therefore the production design should use a relational database with indexed pass IDs, transaction-protected issuance, PreparedStatement for input, and batch processing for bulk migration/import.

The final report should replace general reasoning with the actual measurements collected from B1 and B3.
