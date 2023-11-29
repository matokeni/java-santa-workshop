package pink.workshop.naughtylist;

import java.util.ArrayList;
import java.util.List;

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
  List<List<Kid>> santasLists = new ArrayList<>();

  public SantasPocket() {
    List<Kid> niceList = new ArrayList<>();
    santasLists.add(niceList);

    List<Kid> naughtyList = new ArrayList<>();
    Kid badKid = new Kid("Grinch");
    naughtyList.add(badKid);
    santasLists.add(naughtyList);
  }

  public void addKidToList(Kid kid, boolean isGoodKid) {
    if (isGoodKid) {
      santasLists.get(0).add(kid);
    } else {
      santasLists.get(1).add(kid);
    }
  }

  public void removeKidFromList(String name, boolean isGoodKid) {
    Kid tempKid = new Kid(name);
    if (isGoodKid) {
      santasLists.get(0).remove(tempKid);
    } else {
      santasLists.get(1).remove(tempKid);
    }
  }
}
