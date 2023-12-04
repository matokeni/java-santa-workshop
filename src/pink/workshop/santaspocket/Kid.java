package pink.workshop.santaspocket;

import java.util.List;

public class Kid {

  // name can be final, lets assume kids don't change names
  // final is used for things we initialize then never change
  // for example: data coming in from an HTTP request -> you dont want to mess up the incoming data
  private final String name;
  // We removed the "isNice" field, it was redundant data, the list the kid is on already tells us if the kid's nice
  private List<String> wishedGifts;

  public Kid(String name) { //constructor
    this.name = name;
  }

  // We removed the setter for name, because it cannot be modified after the contractor has been called
  String getName() {
    return name;
  }

  public List<String> getWishedGifts() {
    return wishedGifts;
  }

  public void setWishedGifts(List<String> wishedGifts) {
    this.wishedGifts = wishedGifts;
  }

  // Not needed anymore, was used by the "tempKid" when removing from the list
//  @Override
//  public boolean equals(Object secondKid) {
//    if (this == secondKid) {
//      return true;
//    }
//    return (secondKid instanceof Kid otherKid) && Objects.equals(this.name, otherKid.name);
//  }
}
