# Task 4 – Design Classes, Objects and Constructors

## Objective
Design the classes and decide how objects should be created and initialised.

## Key Concepts
- Fields and methods
- Default and parameterised constructors
- Constructor overloading and chaining
- `this` and copy constructors
- Stack and heap references

## Required Evidence
- List the fields and methods of each class.
- Show a parameterised constructor that validates required values.
- Explain how `this(...)` avoids repeated constructor logic.
- Explain whether a copy constructor is suitable for tickets; ticket IDs should not be duplicated.
- Describe object references and garbage-collection eligibility.

## Alternative Comparison
A parameterised constructor can enforce validity before an object is returned. A default constructor followed by setters can leave an object temporarily incomplete. A static factory method can centralise validation or select an implementation.

## Complexity Analysis
Creating `n` ticket objects takes `O(n)` total time and `O(n)` space for the ticket objects, excluding other referenced data.

## Result
Constructors and object design help keep tickets and other objects in valid states.
