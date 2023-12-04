package pink.workshop.secretsanta.solution;
class SecretSanta {
    private final String name;
    private final int size;
    private SecretSanta buyingGiftTo;

    public SecretSanta(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public SecretSanta(String name, int size, SecretSanta buyingGiftTo) {
        this(name, size); // This reuses the code from the constructor above
        this.buyingGiftTo = buyingGiftTo;
    }

    public SecretSanta getBuyingGiftTo() {
        return buyingGiftTo;
    }

    public String getName() {
        return name;
    }

    public void setBuyingGiftTo(SecretSanta buyingGiftTo) {
        this.buyingGiftTo = buyingGiftTo;
    }
}
