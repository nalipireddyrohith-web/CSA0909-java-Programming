# A1 – Standard Algorithmic Pseudocode

## AddPass

START
    READ passId, registerNo, name, routeNo, boardingStop, validityDate, amount
    VALIDATE all required fields
    IF validation fails THEN
        DISPLAY "Invalid record"
        STOP
    END IF

    OPEN pass file using BufferedWriter in APPEND mode
    WRITE all fields in the defined order using the delimiter
    WRITE newline
    CLOSE writer
    DISPLAY "Pass added"
END

## FindPass

START
    READ targetPassId
    IF file does not exist THEN
        DISPLAY "File not found"
        STOP
    END IF

    OPEN file using BufferedReader
    WHILE a line can be read
        PARSE line into fields
        IF field count is not 7 THEN
            DISPLAY "Damaged line skipped"
            CONTINUE
        END IF

        IF passId equals targetPassId THEN
            DISPLAY complete record
            CLOSE reader
            STOP
        END IF
    END WHILE

    CLOSE reader
    DISPLAY "Pass not found"
END

## ListByRoute

START
    READ targetRoute
    OPEN file using BufferedReader

    WHILE a line can be read
        PARSE line
        IF field count is not 7 THEN
            DISPLAY "Damaged line skipped"
            CONTINUE
        END IF

        IF routeNo equals targetRoute THEN
            DISPLAY record
        END IF
    END WHILE

    CLOSE reader
END
