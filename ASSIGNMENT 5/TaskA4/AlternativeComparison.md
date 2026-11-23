# A4 – Serialization vs CSV/JSON

| Feature | Java Serialization | CSV/JSON |
|---|---|---|
| Size | Binary metadata can be compact but implementation-dependent | Text usually larger |
| Save/load | O(n) for n residents | O(n) |
| New field | Version compatibility must be managed | Often easier to add optional fields |
| Interoperability | Java-focused | CSV/JSON widely interoperable |
| Security | Must validate untrusted serialized data | Still requires validation, but format is easier to inspect |

For a long-lived interoperable application, JSON/CSV is often easier to evolve. Java serialization can be convenient for Java-only object graphs but needs careful versioning and security controls.
