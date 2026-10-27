# Task 9 – Introduce Abstraction

## Objective
Use abstract classes and interfaces to separate common state from optional capabilities.

## Key Concepts
- Abstract classes and abstract methods
- Interfaces
- Multiple interface implementation
- Default and static interface methods

## Required Evidence
- Justify why `Vehicle` should be abstract.
- Justify why `Chargeable` should be an interface.
- Show how a class can implement more than one capability.
- Explain when interface default or static methods are useful.
- Compare the design with changing `Vehicle` into an interface and `Chargeable` into an abstract class.

## Design Notes
An abstract class can hold instance state and constructors. An interface describes a capability that unrelated classes can implement. An electric car can extend `Car` and implement `Chargeable`.

## Complexity Analysis
For this small design, the method-call time is generally treated as `O(1)`. Changing abstraction types affects design constraints more than asymptotic runtime.

## Result
Shared vehicle state and required behaviour are abstracted, while optional charging capability is represented by an interface.
