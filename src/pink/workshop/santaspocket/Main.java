package pink.workshop.santaspocket;

import java.util.List;

public class Main {

  // An example of using Santa's Pocket
  public static void main(String[] args) {
    SantasPocket santasPocket = new SantasPocket();

    Kid kid = new Kid("Lily");
    kid.setNice(true);
    kid.setWishedGifts(List.of("puzzle"));
    santasPocket.addKidToList(kid, true);

    Kid kid2 = new Kid("Annie");
    kid2.setNice(false);
    kid2.setWishedGifts(List.of("basketball"));
    santasPocket.addKidToList(kid2, false);

    santasPocket.removeKidFromList("Grinch", false);

    santasPocket.santasLists.forEach(list -> list.forEach(kids -> System.out.println(kids.name)));
  }
}
