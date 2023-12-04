package pink.workshop.santaspocket;

import java.util.List;

public class Main {

  // An example of using Santa's Pocket
  public static void main(String[] args) {
//    SantasPocket santasPocket = new SantasPocket();
//
//    Kid kid = new Kid("Lily");
//    kid.setNice(true);
//    kid.setWishedGifts(List.of("puzzle"));
//    santasPocket.addKidToList(kid, true);
//
//    Kid kid2 = new Kid("Annie");
//    kid2.setNice(false);
//    kid2.setWishedGifts(List.of("basketball"));
//    santasPocket.addKidToList(kid2, false);
//
//    santasPocket.removeKidFromList("Grinch", false);
//
//    santasPocket.santasLists.forEach(list -> list.forEach(kids -> System.out.println(kids.name)));

    // Updated usage of Santa's Pocket
    SantasPocket santasNewPocket = new SantasPocket();

    Kid lily = new Kid("Lily");
    lily.setWishedGifts(List.of("puzzle"));
    santasNewPocket.addKidToList(lily, ListType.NICE_KIDS);

    Kid annie = new Kid("Annie");
    // List.of is a nice modern shortcut to create an unmodifiable/immutable list
    // If you try to change an immutable list you don't see errors compile time, you will get a runtime exception
    annie.setWishedGifts(List.of("basketball", "flowers", "chocolate"));

    santasNewPocket.addKidToList(annie, ListType.NAUGHTY_KIDS);

    santasNewPocket.removeKidFromList("Grinch", ListType.NAUGHTY_KIDS);

    santasNewPocket.getSantasLists().forEach((key, value) ->
            value.forEach(kid -> System.out.println(key + ": " + kid.getName())));
  }
}
