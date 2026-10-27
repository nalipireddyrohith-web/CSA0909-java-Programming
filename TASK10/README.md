# Task 10 – Enforce Encapsulation through Packages and Access Modifiers

## Objective
Organise classes into packages and protect their data using access modifiers and validation.

## Suggested Package Structure
```text
parking/
├── model/
├── pricing/
├── service/
└── app/
```

## Key Concepts
- `private`, package-private, `protected` and `public`
- Getters and setters
- Input validation
- Wrapper classes and autoboxing

## Required Evidence
- Explain the package structure.
- Justify access modifiers for fields, constructors and methods.
- Validate registration number, duration, charging energy, floor and slot values.
- Explain why comparing wrapper objects such as `Integer` with `==` can be incorrect.

## Compile and Run
Compile from the project root, adjusting the paths and main class to match your source files:

```bash
javac -d out parking/model/*.java parking/pricing/*.java parking/service/*.java parking/app/*.java
java -cp out parking.app.Main
```

## Complexity Analysis
A simple validation check per update is `O(1)`. Encapsulation keeps each rule in one place instead of requiring every caller to repeat the same checks.

## Result
The package structure and access modifiers protect object state and centralise validation.
