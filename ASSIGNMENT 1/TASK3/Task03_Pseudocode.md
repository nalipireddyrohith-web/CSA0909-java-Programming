# Task 3 – SIMATS-style Pseudocode

## Allocate a free slot
START
READ vehicleNo
FOR each floor f from first to last
    FOR each slot s from first to last on floor f
        IF slot[f][s] is free THEN
            STORE vehicleNo in slot[f][s]
            RETURN floor and slot
        END IF
    END FOR
END FOR
RETURN FULL
STOP

## Compute parking fee
START
READ durationMinutes and hourlyRate
hours ← (durationMinutes + 59) DIV 60
fee ← hours × hourlyRate
IF fee > dailyMaximum THEN
    fee ← dailyMaximum
END IF
RETURN fee
STOP
