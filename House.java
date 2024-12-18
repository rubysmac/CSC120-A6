/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building {

  // Attributes
  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  // Constructor
  /**
   * Constructs the house with its name, address, the number of floors,
   * and the presence of dining room, and assigns a new arraylist of residents
   * 
   * @param name    the name of house
   * @param address the address of house
   * @param nFloors the number of floors of house
   * @param dining  the boolean value if the dining room exists in house
   */
  public House(String name, String address, int nFloors, boolean dining) {
    super(name, address, nFloors);
    this.hasDiningRoom = dining;
    this.residents = new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  }

  // Accessors
  /**
   * Returns the boolean value if this house has a dining room
   * 
   * @return true if it has, false if it doesn't
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Returns the number of residents in this house
   * 
   * @return the number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Checks if the person is living in this house
   * 
   * @param person the person to check
   * @return true if the person is a resident, false otherwise
   */
  public boolean isResident(String person) {
    if (this.residents.contains(person)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Adds the person into this house's resident list
   * 
   * @param name the person to be added
   */
  public void moveIn(String name) {
    try {
      if (this.isResident(name)) {
        System.out.println(name + " is already living in " + this.name);
      } else {
        residents.add(name);
        System.out.println(name + " successfully moved in to " + this.name);
      }
    } catch (Exception e) {
      System.out.println("Something's wrong.");
    }
  }

  /**
   * Removes the person from this house's resident list
   * 
   * @param name the person to be removed
   * @return the person's name
   * @throws Exception if the resident is not found in the list
   */
  public String moveOut(String name) throws Exception {
    if (this.isResident(name)) {
      residents.remove(name);
      System.out.println(name + " successfully moved out from " + this.name);
    } else {
      throw new Exception(name + " is not living in " + this.name);

    }
    return name;
  }

  public static void main(String[] args) {
    House myHouse = new House("Tyler", "1 chapin way", 4, true);
    String ruby = new String("Ruby");
    myHouse.moveIn(ruby);
  }

}