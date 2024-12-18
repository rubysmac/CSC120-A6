/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.Map;

public class Library extends Building {

  // Attribute
  private Hashtable<String, Boolean> collection;

  // Constructor
  /**
   * Constructs the library with its name, address, and the number of floors,
   * and assigns a new Hashtable of books
   * 
   * @param name    name of library
   * @param address address of library
   * @param nFloors number of floors of library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Checks if the book is in this collection
   * 
   * @param title title of the book
   * @return true if the title appears as a key in the Libary's collection,
   *         false otherwise
   */
  public boolean containsTitle(String title) {
    return this.collection.contains(title);
  }

  /**
   * Checks if the book is now available to check out
   * 
   * @param title title of the book
   * @return true if the title is currently available, false otherwise
   */
  public boolean isAvailable(String title) {
    return this.collection.get(title);
  }

  /**
   * Adds the book into the collection hashtable
   * with the title as a key and true as a value
   * 
   * @param title the title of the book
   * @throws Exception if the book is already in the collection
   */
  public void addTitle(String title) throws Exception {
    if (!this.containsTitle(title)) {
      this.collection.put(title, true);
      System.out.println(title + " is successfully added!");
    } else {
      throw new Exception(title + " is already in this collection");
    }
  }

  /**
   * Removes the book from the collection hashtable
   * and returns the title of the book
   * 
   * @param title the title of the book
   * @return the title of the book
   * @throws Exception if the book is not in the collection
   */
  public String removeTitle(String title) throws Exception {
    if (this.containsTitle(title)) {
      this.collection.remove(title);
      System.out.println(title + " is successfully removed!");
    } else {
      throw new Exception(title + " is not in this collection");
    }
    return title;
  }

  /**
   * Changes the book's availability into false
   * 
   * @param title the title of the book
   * @throws Exception if the book is not available
   */
  public void checkOut(String title) throws Exception {
    if (this.isAvailable(title)) {
      this.collection.replace(title, false);
      System.out.println(title + " is checked out!");
    } else {
      throw new Exception(title + " is not available now");
    }
  }

  /**
   * Changes the book's availability into true
   * 
   * @param title the title of the book
   * @throws Exception if the book is already returned
   * 
   */
  public void returnBook(String title) throws Exception {
    if (!this.isAvailable(title)) {
      this.collection.replace(title, true);
      System.out.println(title + " is returned!");
    } else {
      throw new Exception(title + " seems to be already returned");
    }
  }

  /**
   * Prints all the book in the collection hashtable
   * including the title and the availability
   */
  public void printCollection() {
    System.out.println("Below is the entire list of books in the collection:");
    for (Map.Entry<String, Boolean> entry : this.collection.entrySet()) {
      System.out.print(entry.getKey() + " -> ");
      if (entry.getValue().equals(true)) {
        System.out.println("available");
      } else {
        System.out.println("not available");
      }
    }
  }

  public static void main(String[] args) {
    Library myLibrary = new Library("Neilson Library", "neilson", 5);
    try {
      myLibrary.addTitle("The Lorax by Dr. Seuss");
    } catch (Exception e) {
    }
    myLibrary.printCollection();
  }

}