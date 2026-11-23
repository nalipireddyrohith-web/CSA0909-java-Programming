# A4 – Serialization Design

The `Connection` field must be `transient` because a live database connection is an external runtime resource and should not be serialized.

Passwords should also not normally be serialized in plaintext. If a credential-related value must persist, use a secure representation appropriate to the application.

A serializable Hostel object graph follows reachable serializable references. Hostel → Rooms → Residents are serialized if their classes implement Serializable and their non-transient reachable fields are serializable. The transient Connection is skipped.

## serialVersionUID

A stable `serialVersionUID` is used to identify the intended class version. When an old serialized object is read by a compatible newer class, a newly added field such as `phoneNumber` receives its default value if no custom migration logic supplies it. If the class is incompatible and the serialVersionUID does not match, deserialization can fail with InvalidClassException.
