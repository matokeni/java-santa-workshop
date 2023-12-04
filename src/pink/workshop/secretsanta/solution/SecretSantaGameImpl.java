package pink.workshop.secretsanta.solution;

import java.util.*;
class SecretSantaGameImpl implements SecretSantaGame { // we're using the new interface!

  // We kindly consider using a Set but the realize that if we want to grab a random person from the players we have an easier time with List
  // because List has indexes on each object it contains, Set does not
  private final List<SecretSanta> santaGame = new ArrayList<>();
  // We create one class-level Random instance that we can use each time we add a new Secret Santa
  private final Random random = new Random();

  // A null check and a check if the name is an empty String
  // Extracted to a method because we can add this same validation to both of our methods in the class
  private static boolean nonValidName(String name) {
    return Objects.isNull(name) || name.isEmpty();
  }

  @Override // Override means this method was defined first in a superclass or interface that we're implementing
  public void addSecretSanta(String name, int size) {
    if (nonValidName(name)) {
      return; // We can either simply return, or throw an exception.
      // Throwing an exception can be nicer if we need to know if the method successfully executed or not
    }

    // Only 1 new secret santa is being created
    SecretSanta newSecretSanta = new SecretSanta(name, size);
    if (santaGame.isEmpty()) {
      // In case we're the first in the game, we default to giving gifts to ourselves :)
      // Both the logic for adding a new person, and the iterating in "whoGivesMeLists" would rely on the fats that SecretSanta's don't have nulls in their "givingGiftsTo" field
      newSecretSanta.setBuyingGiftTo(newSecretSanta);
    } else {
      // We grab a random santa form the game
      SecretSanta personToChange = santaGame.get(random.nextInt(santaGame.size()));
      // Take the random santa's "buyingGiftsTo"...
      SecretSanta newPersonToGift = personToChange.getBuyingGiftTo();
      // ... and setting it as our person to buy gifts to
      newSecretSanta.setBuyingGiftTo(newPersonToGift);
      // ... and the random santa will buy gifts to us now!
      personToChange.setBuyingGiftTo(newSecretSanta);
    }
    // add method called once, outside the if-else
    santaGame.add(newSecretSanta);
  }

  @Override
  public String whoGivesMeGifts(String name) {
    if (nonValidName(name)) {
      return ""; // or throw exception, as in the prev method
    }

    return santaGame.stream() // iterating through all secret santas
        .filter(Objects::nonNull) // in case we have null santas, lets filter them out, we don't want null pointers
        .filter(santa -> buyingGiftsToNameMatches(name, santa))// another filter to find the person giving gifts to us
        .map(SecretSanta::getName)// grab the name of the secret santa we found
        .findFirst() // this creates a so-called "Optional". Optional is a wrapper class to handle objects that can be null
        .orElse("U ain't getting nothin"); // findFirst return the secret santa's name in case its found, orElse returns a default value if we didnt find anyone
  }

  private boolean buyingGiftsToNameMatches(String name, SecretSanta santa) {
    return Objects.equals( // using the null safe utility method
        name,
        // We can wrap objects in an Optional if we think they might be null, but we want to do some logic in case they are not
        Optional.ofNullable(santa.getBuyingGiftTo()) // in case the buyingGiftsTo is null the execution would jump to the .orElse below
                .map(SecretSanta::getName) // if the buyingGiftsTo was not null we grab the name
                .orElse(""));
  }
}
