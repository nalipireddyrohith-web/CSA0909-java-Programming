# Task 6 – Design the Inheritance Hierarchy

## Objective
Create a vehicle inheritance hierarchy and represent it using UML.

## Key Concepts
- Single and hierarchical inheritance
- `extends`, `implements` and `super`
- Constructor execution order
- Inheritance versus composition

## Suggested Hierarchy
- `Vehicle` is an abstract superclass.
- `TwoWheeler` extends `Vehicle`.
- `Car` extends `Vehicle`.
- `ElectricCar` extends `Car` and implements `Chargeable`.

## Required Evidence
- Include a UML class diagram.
- Explain inherited fields and methods and the additions in subclasses.
- Trace the constructor order when creating an `ElectricCar`.
- Compare inheritance with a `Vehicle` containing a `VehicleType` or pricing-rule object.

## Complexity Analysis
When the rate/rule is already selected, fee computation is `O(1)` for either a simple inheritance design or a composition design. Composition adds a reference and potentially a policy object.

## Result
The UML and Java hierarchy show shared vehicle state and specialised vehicle behaviour.
