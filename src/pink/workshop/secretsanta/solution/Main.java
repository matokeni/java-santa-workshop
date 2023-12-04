package pink.workshop.secretsanta.solution;

class Main {

  // An example of using the Secret Santa game
  public static void main(String[] args) {
    SecretSantaGame secretSantaGame = new SecretSantaGameImpl();

    secretSantaGame.addSecretSanta("Annie", 37);
    secretSantaGame.addSecretSanta("Lily", 39);
    secretSantaGame.addSecretSanta("Bella", 42);
    secretSantaGame.addSecretSanta("Donna", 37);

    System.out.println(secretSantaGame.whoGivesMeGifts("Donna"));
  }
}
