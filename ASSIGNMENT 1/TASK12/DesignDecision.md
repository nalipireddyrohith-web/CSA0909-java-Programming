# Task 12 – Design Challenge Decision

## A. Impact analysis
New e-bikes, delivery vans, one-day visitor passes, unequal five-floor capacities and time-based van pricing affect vehicle classes, pricing and pass handling. Unequal floors require a jagged array such as `int[] floors` plus `String[][] slots`.

## B. Original design evaluation
The inheritance model can add new subclasses without changing existing vehicle subclasses. However, if pricing logic is duplicated inside many classes, new pricing rules become harder to maintain.

## C. Adaptation
The design is **MODIFIED**. Vehicle fee behaviour is abstracted, a `Pass` interface represents visitor passes, and the parking structure uses a jagged array. E-bike and delivery-van classes implement their own fee rules.

## D. Evidence-based defence
The changed code adds the new categories without modifying `NewCar`. Tests cover e-bike flat fee, van peak-time double rate, off-peak van rate and one-day pass validity. The trade-off is a few more classes, but the design is easier to extend and keeps pricing behaviour close to the relevant vehicle type.
