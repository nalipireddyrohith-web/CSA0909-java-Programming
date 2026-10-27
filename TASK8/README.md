# Task 8 – Apply Polymorphism

## Objective
Demonstrate compile-time and runtime polymorphism.

## Key Concepts
- Method overloading
- Upcasting
- Dynamic method dispatch
- Interface capability checks

## Required Evidence
- Include an overloaded method, such as `calculateFee(int minutes)` and a method accepting start/end times.
- Show one `Vehicle[]` holding multiple concrete vehicle objects.
- Trace a call with the declared reference type, actual object type and method executed.
- Complete and run the assignment's `FeeDemo`.

## Expected Output
```text
TwoWheeler TN01A1 -> Rs 30.0
Car TN02B2 -> Rs 90.0
ElectricCar TN03C3 -> Rs 210.0
true
```

## Complexity Analysis
Dynamic dispatch is effectively `O(1)` for this design. An `instanceof` chain may perform up to `k` checks for `k` vehicle categories, or `O(k)` worst-case time, and centralises code that must change when types are added.

## Result
The common `Vehicle` interface supports different concrete vehicle types and their fee behaviours.
