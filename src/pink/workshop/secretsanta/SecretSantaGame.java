package pink.workshop.secretsanta;

import java.util.*;

/**
 * Secret Santa!
 *
 * Secret Santa is a game where each participant is randomly assigned someone from the group to
 * buy gifts to. There are a couple different variants to playing Secret Santa (e.g. trying to guess
 * who the gift giver is), and here we would like to create a SecretSanta application that has the
 * following features:
 *  - the organizers decided that the gift should be a fun pair of socks, so about each participant we know their name and their shoe-size!
 *  - everyone is assigned 1 random person from the group
 *  - a participant can be added to the game, but we're not removing anyone
 *  - the application should be able to tell who's giving gifts to a certain participant based on name
 *
 * ---
 *
 * Below (and in the SecretSanta class) we can see a solution to the problem explained above.
 * Let's review the code, and propose improvements to it!
 */
public class SecretSantaGame {

  private List<SecretSanta> santaGame;

  public void addSecretSanta(String name, int size) {
    if (santaGame == null || santaGame.isEmpty()) {
      santaGame = new LinkedList<>();
      SecretSanta secretSanta = new SecretSanta(name, size);
      santaGame.add(secretSanta);
    } else {
      Random random = new Random();
      int number = random.nextInt(santaGame.size());
      SecretSanta secretSanta1 = santaGame.get(number);
      SecretSanta secretSanta2 = secretSanta1.getBuyingGiftTo();
      SecretSanta secretSanta = new SecretSanta(name, size, secretSanta2);
      secretSanta1.setBuyingGiftTo(secretSanta);
      santaGame.add(secretSanta);
    }
  }

  public String whoGivesMeAGift(String name) {
    SecretSanta givingGiftToMe = null;
    for (int i = 0; i < santaGame.size(); i++) {
      SecretSanta secretSanta = santaGame.get(i);
      if (secretSanta.getBuyingGiftTo().getName() == name) {
        givingGiftToMe = secretSanta;
        break;
      }
    }
    if (givingGiftToMe != null) {
      return givingGiftToMe.getName();
    } else {
      return "U ain't getting nothing";
    }
  }
}
