# Package Structure

- `parking.model` – domain classes
- `parking.service` – service logic
- `parking.app` – application entry point

Fields are private, constructors and public methods form the controlled API, and setters validate state. Wrapper values should be compared with `equals()` rather than `==` because `==` compares object references.
