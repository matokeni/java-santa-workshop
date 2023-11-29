package pink.workshop.naughtylist;

import java.util.List;
import java.util.Objects;

public class Kid {

  String name;
  boolean isNice;
  List<String> wishedGifts;

  public Kid(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getWishedGifts() {
    return wishedGifts;
  }

  public void setWishedGifts(List<String> wishedGifts) {
    this.wishedGifts = wishedGifts;
  }

  public boolean isNice() {
    return isNice;
  }

  public void setNice(boolean nice) {
    this.isNice = nice;
  }

  @Override
  public boolean equals(Object secondKid) {
    if (this == secondKid) {
      return true;
    }
    return (secondKid instanceof Kid otherKid) && Objects.equals(this.name, otherKid.name);
  }
}
