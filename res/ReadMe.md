# Project2--EquippingCharacters.

### About
This project is the implementation of Project2--EquippingCharacters. The implementation does all the functions mentioned in the design doc.

### List of features
* Predict the winner between 2 characters where they select 20 random items from a treasure chest.
* A treasure chest class to add items and verify them.
* Add item and discard item for a character.
* Items/Gears which are completely segregated using multiple interfaces and abstract classes.
* Double dispatched methods to prevent usage of smelly code like instanceOf and get class.

### How to Use:
Running the executable jar file should run the program. If by any chance it doesn't work running the Driver class will do the trick.

A small sample run of the code:

The run shows the character accessing the chest, the items which a character is discarding and the item which replaces it.

Bob is picking items from the chest\
Item discarded : Helmets of Wrath, Item picked : Visors of vision\
Character after equipping all items : Name : Bob, Basic attack : 12; Basic defense : 15; Total attack : 260; Total defense : 292; HeadGear : Visors of vision; FootWear : Boots of Lightening; HandGear : Rings of Saturn, Ice, Saturn, Strength, Mordor, Poise, Poise and Lightening; Jewelry: Gold of Smaug, Flames, Speed, Almandine, Heft, Madness, Lannisters and Madness.\
Bob is picking items from the chest\
Item discarded : Sneakers of Cytorrak, Item picked : HoverBoard of Madness\
Item discarded : HoverBoard of Madness, Item picked : Boots of Lightening\
Character after equipping all items : Name : Alice, Basic attack : 4; Basic defense : 25; Total attack : 322; Total defense : 166; HeadGear : Cape of doom; FootWear : HoverBoard of Madness and Lightening; HandGear : Gauntlets of Poise, Flames, Strength, Lightening, Madness, Mordor and Doom; Jewelry: Diamond of Almandine, Strength, Lightening, Speed, Tyrells, Ice and Ice.
******************************
The match was won by Alice
******************************
Press Y for a rematch.
Y

The user will press Y (UPPERCASE Y) for another rematch.


### Design Changes:

I made quite a few changes in the design of the project. In my earlier I made use of a Item interface and an abstract item, but in order to further segregate them I created two interfaces called OffensiveItem and DefensiveItem which stores the getters for offense and defense respectively. I also added another abstract class for representing those items with both the offensive or defensive stats called AbstractBothStats. I also make use of double dispatched methods to check object types and equals. I also made use of Comparable to compare Items.
I also removed the Arena design which I had in my original design along with the two enums HeadGearType and FootWearType as they had no particular use. The arena which I had planned for works on the driver with methods to dress the character and predict the winner between 2 characters.

### Assumptions
* After every match we reassign random 20 items to the Characters which they can choose to use/not.
* A matches result is determined by the number of potential rounds which a character can win, which is calculated by the following formula:

  DamageAlice = AttackBob - DefenseAlice

  DamageBob = AttackAlice - DefenseBob

  RoundsWonByAlice = (Alice.Hitpoints)/DamageBob

  RoundsWonByBob = (Bob.Hitpoints)/DamageAlice

### Limitations:
As much as I know the programs does all of the specified functions.
