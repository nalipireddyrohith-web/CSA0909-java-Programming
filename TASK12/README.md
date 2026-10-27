# Task 12 – Re-evaluate and Adapt the Design

## Objective
Adapt the original system to new vehicle categories, pricing rules, visitor passes and unequal floor capacities.

## Changed Requirements
- E-bikes pay a flat fee.
- Delivery vans pay double the car rate during 9 AM–5 PM.
- Visitors can buy a one-day pass.
- The facility has five floors with potentially different slot counts.

## Recommended Design
- Use a jagged array to represent floors with different slot counts.
- Introduce a `PricingRule` abstraction.
- Use an hourly pricing rule for ordinary hourly-priced vehicles.
- Use a flat-fee rule for e-bikes.
- Use a delivery-van rule that applies the higher rate to the relevant time window.
- Use a `Pass` interface with monthly and one-day pass implementations.

## Required Evidence
- Impact analysis identifying affected classes, methods and structures.
- Evaluation of whether to retain, modify or redesign the original system.
- Revised UML or class structure.
- Java implementation of the new categories and one-day pass.
- Tests for each new category and boundary times.
- Evidence-based defence explaining which existing classes changed and why.

## Test Cases to Record
| Test | Expected behaviour | Actual result |
|---|---|---|
| E-bike visit | Configured flat fee is charged | `<record result>` |
| Delivery van entirely within 9 AM–5 PM | Double car rate applies to the applicable interval | `<record result>` |
| Delivery van crosses 9 AM or 5 PM | Fee is split correctly across the time boundary | `<record result>` |
| One-day pass on valid date | Pass is valid | `<record result>` |
| One-day pass on a different date | Pass is invalid | `<record result>` |
| Unequal capacities on five floors | Each floor stores its configured slot count | `<record result>` |

## Complexity and Trade-offs
A preselected pricing strategy can calculate a fixed rule in `O(1)` time. A time-window rule must process the relevant interval boundaries; the exact cost depends on its implementation. Strategy and pass abstractions add indirection but reduce coupling when new rules are added.

## Result
The revised design supports the new requirements while aiming to minimise changes to previously tested classes. Replace placeholders with real test results before submission.
