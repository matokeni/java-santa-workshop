package pink.workshop.secretsanta.solution;


// so now we have an interface for the generic SecretSanta service
interface SecretSantaGame {

    // In interfaces all your methods are "public" by default, no need to explicitly add "public"
    void addSecretSanta(String name, int size);

    String whoGivesMeGifts(String name);
}
