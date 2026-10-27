# Task 7 – Override and Specialise Behaviour

## Objective
Use method overriding to specialise vehicle behaviour and implement object methods where needed.

## Key Concepts
- `@Override`
- Overriding rules and compatible signatures
- `final`
- `toString()`, `equals()` and `hashCode()`

## Required Evidence
- Show how subclasses provide a vehicle-specific rate.
- Explain valid overriding signatures and access rules.
- Justify use of `final` for immutable fields or methods that must not be overridden.
- Ensure `equals()` and `hashCode()` follow the same identity rule.

## Assignment Example
The supplied `FeeDemo` compares a `Car` and an `ElectricCar` with the same registration number. The supplied `Vehicle.equals()` implementation compares registration numbers, so the expression evaluates to `true`. Discuss whether registration alone is the intended identity rule for the system.

## Complexity Analysis
A fixed `switch` or virtual method call is effectively constant time for a fixed number of vehicle types. The main difference is maintainability: a central switch must be edited for new types, while a new subclass can supply its own override.

## Result
Vehicle-specific behaviour is specialised with overriding, and object equality methods use a consistent identity rule.
