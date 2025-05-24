//[pms-booking-service](../../../index.md)/[com.github.j4c62.pms.booking.application.strategy](../index.md)/[BookingCommandStrategy](index.md)/[execute](execute.md)

# execute

[java]\
abstract fun [execute](execute.md)(command: [T](index.md)): [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md)

Executes the command, applying domain logic to produce a [BookingOutput](../../com.github.j4c62.pms.booking.domain.driver.output/-booking-output/index.md).

#### Return

The output DTO representing the result of the command execution.

#### Author

Jose Antonio (J4c62)

#### Since

2025-04-30

#### Parameters

java

| | |
|---|---|
| command | The command to execute. |

#### Throws

| | |
|---|---|
| [IllegalStateException](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/IllegalStateException.html) | or other domain-specific exceptions if business rules are violated. |