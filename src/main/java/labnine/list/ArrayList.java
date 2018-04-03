package labnine.list;

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Realization of a list by means of a dynamic array. This is a simplified version
 * of the java.util.ArrayList class. Please see the JavaDoc documentation and
 * the material in the textbook to learn more about how the data structures are
 * similar to and different from each other.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class ArrayList<E> implements List<E> {

  /** Default array capacity. */
  public static final int CAPACITY = 16;

  /** Generic array used for storage of list elements. */
  private E[] data;

  /** Current number of elements in the list. */
  private int size = 0;

  /** Creates an array list with default initial capacity. */
  public ArrayList() {
    this(CAPACITY);
  }

  /** Creates an array list with given initial capacity. */
  @SuppressWarnings({"unchecked"})
  public ArrayList(int capacity) {
    // TODO: All the correct implementation of the constructor
  }

  /**
   * Returns the number of elements in the list.
   * @return number of elements in the list
   */
  public int getSize() {
    return size;
  }

  /**
   * Tests whether the array list is empty.
   * @return true if the array list is empty, false otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns (but does not remove) the element at index i.
   * @param index the index of the element to return
   * @return the element at the specified index
   * @throws IndexOutOfBoundsException if the index is negative or greater than size()-1
   */
  public E get(int index) throws IndexOutOfBoundsException {
    checkIndex(index, size);
    return data[index];
  }

  /**
   * Replaces the element at the specified index, and returns the element previously stored.
   * @param index the index of the element to replace
   * @param element the new element to be stored
   * @return the previously stored element
   * @throws IndexOutOfBoundsException if the index is negative or greater than size()-1
   */
  public E set(int index, E element) throws IndexOutOfBoundsException {
    // TODO: Add the complete implementation of the set method
  }

  /**
   * Inserts the given element at the specified index of the list, shifting all
   * subsequent elements in the list one position further to make room.
   * @param index the index at which the new element should be stored
   * @param element the new element to be stored
   * @throws IndexOutOfBoundsException if the index is negative or greater than size()
   */
  public void add(int index, E element) throws IndexOutOfBoundsException {
    checkIndex(index, size + 1);
    if (size == data.length) {
      resize(2 * data.length);
    }
    for (int k = size - 1; k >= index; k--) {
      data[k + 1] = data[k];
    }
    data[index] = element;
    size++;
  }

  /**
   * Removes and returns the element at the given index, shifting all subsequent
   * elements in the list one position closer to the front.
   * @param index the index of the element to be removed
   * @return the element that had be stored at the given index
   * @throws IndexOutOfBoundsException if the index is negative or greater than size()
   */
  public E remove(int index) throws IndexOutOfBoundsException {
    checkIndex(index, size);
    final E temp = data[index];
    for (int k = index; k < size - 1; k++) {
      data[k] = data[k + 1];
    }
    data[size - 1] = null;
    size--;
    return temp;
  }

  /** Checks whether the given index is in the range [0, n-1]. */
  protected void checkIndex(int index, int size) throws IndexOutOfBoundsException {
    // TODO: Add the full implementation of the checkIndex method
  }

  /** Resizes internal array to have given capacity >= size. */
  @SuppressWarnings({"unchecked"})
  protected void resize(int capacity) {
    E[] temp = (E[]) new Object[capacity];
    for (int k = 0; k < size; k++) {
      temp[k] = data[k];
    }
    data = temp;
  }

  /**
   * A (nonstatic) inner class. Note well that each instance contains an implicit
   * reference to the containing list, allowing it to access the list's members.
   */
  private class ArrayIterator implements Iterator<E> {

    /** Index of the next element to report. */
    private int nextElementIndex = 0;

    /** Flag to indicate whether or not the remove method can be called. */
    private boolean removable = false;

    /**
     * Tests whether the iterator has a next object.
     * @return true if there are further objects, false otherwise
     */
    public boolean hasNext() {
      return nextElementIndex < size;
    }

    /**
     * Returns the next object in the iterator.
     *
     * @return next object
     * @throws NoSuchElementException if there are no further elements
     */
    public E next() throws NoSuchElementException {
      if (nextElementIndex == size) {
        throw new NoSuchElementException("No next element");
      }
      removable = true;
      return data[nextElementIndex++];
    }

    /**
     * Removes the element returned by most recent call to next.
     * @throws IllegalStateException if next has not yet been called
     * @throws IllegalStateException if remove was already called since recent next
     */
    public void remove() throws IllegalStateException {
      if (!removable) {
        throw new IllegalStateException("nothing to remove");
      }
      ArrayList.this.remove(nextElementIndex - 1);
      nextElementIndex--;
      removable = false;
    }
  }

  /**
   * Returns an iterator of the elements stored in the list.
   * @return iterator of the list's elements
   */
  @Override
  public Iterator<E> iterator() {
    return new ArrayIterator();
  }

  /**
   * Determine if "this" ArrayList is the same as another provided list.
   * @return boolean is true if the contents are same, otherrwise false
   */
  @SuppressWarnings({"unchecked"})
  public boolean equals(Object list) {
    // TODO: Implement a complete equals method
    // Reminder: please refer to code in SinglyLinkedList for an example
  }

  /**
   * Produces a string representation of the contents of the indexed list.
   * This exists for debugging purposes only.
   *
   * @return textual representation of the array list
   */
  public String toString() {
    // TODO: Implement a complete toString method
    // Reminder: please refer to code in SinglyLinkedList for an example
  }

  /**
   * Create a small ArrayList, remove some elements, and carefully display.
   */
  public static void main(String[] args) {
    final int demonstrationListSize = 10;
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < demonstrationListSize; i++) {
      list.add(0, Integer.toString(i));
    }
    // TODO: Add source code to ensure that the output looks as requested
  }

}
