# A5.1 – Transaction Pseudocode

START
    OPEN JDBC connection
    DISABLE auto-commit

    TRY
        READ hostel wallet balance
        IF balance < 500 THEN
            ROLLBACK
            DISPLAY "Insufficient funds"
            STOP
        END IF

        UPDATE hostel_wallet
        SET balance = balance - 500
        WHERE wallet_id = hostelWalletId

        UPDATE canteen_wallet
        SET balance = balance + 500
        WHERE wallet_id = canteenWalletId

        COMMIT
        DISPLAY "Transfer successful"

    CATCH any database error
        ROLLBACK
        DISPLAY "Transfer failed; no partial transfer retained"
    FINALLY
        RESTORE auto-commit
        CLOSE connection
END
