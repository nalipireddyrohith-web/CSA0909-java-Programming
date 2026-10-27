# Task 11 – Implement, Test and Defend the Design

## Objective
Implement the system, test normal and edge cases, and evaluate the design based on evidence.

## Required Test Scenarios
- Different vehicle types enter and exit.
- Last free slot is allocated.
- Zero-minute parking.
- Parking exactly at a fee-slab boundary.
- Unknown vehicle type.
- Duplicate active registration number.
- Invalid floor or slot number.
- Hand-calculated daily collection total matches the program.

## Test Table Template
Fill in the actual results after running your code.

| Test ID | Input / scenario | Expected result | Actual result |
|---|---|---|---|
| T11-01 | TwoWheeler, 130 minutes | Rs 30 parking fee | `<record result>` |
| T11-02 | Car, 130 minutes | Rs 90 parking fee | `<record result>` |
| T11-03 | ElectricCar, 130 minutes, 10 kWh | Rs 210 total | `<record result>` |
| T11-04 | Allocate 4 vehicles into 3 slots | Fourth allocation fails | `<record result>` |
| T11-05 | Release same slot twice | `true`, then `false` | `<record result>` |
| T11-06 | Invalid floor index | Release returns `false` | `<record result>` |
| T11-07 | Zero-minute stay | Rs 0 under the supplied fee formula | `<record result>` |
| T11-08 | 61-minute stay | 2 billable hours | `<record result>` |
| T11-09 | Duplicate active registration | Second entry rejected | `<record result>` |

## Daily Collection Example
For one TwoWheeler at Rs 30, one Car at Rs 90, and one ElectricCar with Rs 90 parking plus Rs 120 charging, the expected total is Rs 330, assuming no pass discounts or daily maximum. Compare this calculation with your program output.

## Complexity Analysis
- Array/list ticket search: `O(n)`.
- `HashMap` lookup by registration: average `O(1)`.
- Slot allocation by scanning: `O(N)` for `N` total slots.
- Release of a known slot: `O(1)`.

## Result
The design is evaluated using observed test results, expected outputs and a reasoned discussion of its strengths and limitations.
