# UML Class Diagram

```text
                +----------------+
                |    Vehicle     |
                +----------------+
                | - regNo:String |
                +----------------+
                       ^
                       |
                +----------------+
                |      Car       |
                +----------------+
                       ^
                       |
                +----------------+
                |  ElectricCar   |
                +----------------+

Vehicle <|-- TwoWheeler
Vehicle <|-- Car
Car <|-- ElectricCar
''`

Inheritance is hierarchical from `Vehicle`, with multilevel inheritance for `ElectricCar`.
