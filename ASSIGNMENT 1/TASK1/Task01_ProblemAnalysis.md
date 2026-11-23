# Task 1 – Problem Analysis and Objects

## Inputs
- Registration number, vehicle type and user type.
- Entry and exit time.
- Floor/slot availability.
- Pass validity for students/staff.

## Outputs
- Allocated floor and slot.
- Unique parking ticket number.
- Parking fee.
- Slot release status and daily collection.

## Candidate classes
| Class | Reason | Main responsibility |
|---|---|---|
| Vehicle | A parked vehicle has state and behaviour | Store registration number/type and calculate vehicle-specific rate |
| TwoWheeler | Different rate | Provide two-wheeler rate |
| Car | Different rate | Provide car rate |
| ElectricCar | Car + charging capability | Add charging fee |
| ParkingSlot | Physical slot | Know whether a slot is occupied |
| ParkingTicket | Entry transaction | Store ticket number, vehicle and entry time |
| ParkingFacility | Main resource manager | Allocate/release slots and track occupancy |
| User/Pass | Parking entitlement | Identify free monthly pass or visitor payment |

## Important business rules
1. A slot cannot contain two vehicles.
2. A ticket number is unique and is not reused.
3. A duplicate active registration number is rejected.
4. An invalid floor/slot is rejected.
5. Staff/student monthly-pass holders pay zero parking fee.
6. Visitors pay the applicable fee.
7. An EV charging fee is added separately when charging is used.

## Assumptions
- Slot numbers start at 0 internally.
- Every vehicle has one unique registration number while active.
- Parking duration is calculated from entry and exit times.
- The facility can have unequal slots per floor, so a jagged array is suitable.

## Alternative: parallel arrays
`String[] regNo`, `String[] type`, and `LocalDateTime[] entryTime` can represent the same data, but one vehicle's state is spread across several arrays. Finding a vehicle is O(n). Adding an attribute requires another parallel array and changes all related code. With objects, search is also O(n) in a simple array, but each vehicle keeps its related state together and new attributes can be added to the class.
