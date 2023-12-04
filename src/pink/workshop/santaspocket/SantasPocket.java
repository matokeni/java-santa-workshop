package pink.workshop.santaspocket;

import java.util.*;

/**
 * Let's model Santa's pocket!
 *
 * Santa loves lists, and he keeps them in his pocket. Right now he has two lists: one for nice
 * kids, and one for naughty kids, but in the future he might come up with more lists containing
 * kids, just for fun. Kids have names, and Santa also keeps track of the gifts that the kid wished
 * for.
 *
 * Santa would like to do two simple tasks with his lists: add new kids to them, and remove kids
 * based on name from them.
 *
 * We also know that the Grinch is on Santa's naughty list by default ;)
 *
 * ---
 *
 * Below (and in the Kid class) we can see a solution to the problem explained above. Let's
 * review the code, and propose improvements to it!
 */
public class SantasPocket {
  // List can have the same object multiple times
  // For unique objects we can use: Set
  private Map<ListType, Set<Kid>> santasLists = new HashMap<>();

  // getter method, creating a replica so that santasList cannot be modified form outside
  public Map<ListType, Set<Kid>> getSantasLists() {
    return Collections.unmodifiableMap(santasLists);
  }

  public SantasPocket() { // Constructor
    // Java 8: Streams <3
    // Initializing all types of lists based on the values that the enum has
    // The initializing is needed because otherwise we will get null Sets -> big fat NullPointerExvception
    Arrays.stream(ListType.values())
        .forEach(listType -> santasLists.put(listType, new HashSet<>()));
    // Reusing code to add a kid
    addKidToList(new Kid("Grinch"), ListType.NAUGHTY_KIDS);
  }

  public void addKidToList(Kid kid, ListType listType) {
    santasLists.get(listType).add(kid);
  }

  public void removeKidFromList(String name, ListType listType) {
    // Objects Util class since Java 7
    // Null safety -> check if the things that we are calling methods are not null
    // We could also add validation in the beginning of the method to make sure that we don't get nulls from the arguments
    santasLists
        .get(listType)
        .removeIf(kid -> Objects.nonNull(kid)
                && Objects.equals(name, kid.getName()));
  }
}
