package pink.workshop.secretsanta;

public class SecretSanta {

  private final String name;
  private final int size;
  private SecretSanta buyingGiftTo;

  public SecretSanta(String name, int size) {
    this.name = name;
    this.size = size;
  }

  public SecretSanta(String name, int size, SecretSanta buyingGiftTo) {
    this.name = name;
    this.size = size;
    this.buyingGiftTo = buyingGiftTo;
  }

  public SecretSanta getBuyingGiftTo() {
    return buyingGiftTo;
  }

  public void setBuyingGiftTo(SecretSanta buyingGiftTo) {
    this.buyingGiftTo = buyingGiftTo;
  }

  public String getName() {
    return name;
  }
}
