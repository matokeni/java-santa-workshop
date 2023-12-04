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
  // See how the tasks says there are other ways to play this? A more advanced thought here is to create an interface we methods
  // that each implementation of the SecretSanta game can customize with logic

  // As we discussed in Santa's Pocket as well, we need to consider if a List is really the best data structure here
  // We might want to use a simpler Set?
  private List<SecretSanta> santaGame;

  public void addSecretSanta(String name, int size) {
    if (santaGame == null || santaGame.isEmpty()) {
      // In case this is the first SecretSanta being added then the "santaGame" is initialized
      // But maybe it would be nicer to initialize this in a constructor?
      santaGame = new LinkedList<>();
      // The SecretSanta created here has a null in its "buyingGiftTo" field. Could we do better?
      SecretSanta secretSanta = new SecretSanta(name, size);
      santaGame.add(secretSanta);
    } else {
      // We create a new Random each time we add a SecretSanta -> is this really necessary?
      Random random = new Random();
      int number = random.nextInt(santaGame.size());
      // So confusing names
      SecretSanta secretSanta1 = santaGame.get(number);
      SecretSanta secretSanta2 = secretSanta1.getBuyingGiftTo();
      SecretSanta secretSanta = new SecretSanta(name, size, secretSanta2);
      secretSanta1.setBuyingGiftTo(secretSanta);
      // we use the add method again? is this something we could do outside the if-else?
      santaGame.add(secretSanta);
    }
  }

  // I'm super proud of how ugly this looks, just sayin :)
  public String whoGivesMeAGift(String name) {
    SecretSanta givingGiftToMe = null;
    // As discussed in Santa's Pocket, using Streams would be a modern and clean approach
    for (int i = 0; i < santaGame.size(); i++) {
      SecretSanta secretSanta = santaGame.get(i);
      // That's for sure not null safe, we get an exception if the secretSanta is null, or if the "buyingGiftsTo" field is null
      if (secretSanta.getBuyingGiftTo().getName() == name) {
        givingGiftToMe = secretSanta;
        break;
      }
    }
    // If we were using streams, we could also simply include this conditional logic there, i.e. lets do X if we found something, and Y is we didn't
    if (givingGiftToMe != null) {
      return givingGiftToMe.getName();
    } else {
      return "U ain't getting nothing";
    }
  }
}
