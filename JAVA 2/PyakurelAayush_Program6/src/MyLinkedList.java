// Name: Mandeep Aryal
// Instructor: Madhav Lolla
// Course: CSC 360
import java.util.NoSuchElementException;

public class MyLinkedList<E> extends MyAbstractList<E> {
  private Node<E> head, tail;

  /** Create a default list */
  public MyLinkedList() {
  }

  /** Create a list from an array of objects */
  public MyLinkedList(E[] objects) {
        super(objects);
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
    	throw new NoSuchElementException();
    }
    else {
      return tail.element;
    }
  }

  /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newNode = new Node<E>(e); // Create a new node
    newNode.next = head; // Link the new node with the head
    head = newNode; // head points to the new node
    size++; // Increase list size

    if (tail == null) // If the new node is the only node in list
      tail = head;
  }

  /** Add an element to the end of the list */
  public void addLast(E e) {
    Node<E> newNode = new Node<E>(e); // Create a new for element e

    if (tail == null) {
      head = tail = newNode; // The new node is the only node in list
    }
    else {
      tail.next = newNode; // Link the new with the last node
      tail = tail.next; // tail now points to the last node
    }

    size++; // Increase size
  }

  @Override /** Add a new element at the specified index
   * in this list. The index of the head element is 0 */
  public void add(int index, E e) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    else if (index == 0) {
      addFirst(e);
    }
    else if (index == size) {
      addLast(e);
    }
    else {
      Node<E> current = head;
      for (int i = 1; i < index; i++) { // Traverse list to position before insertion point
        current = current.next;
      }
      Node<E> temp = current.next; // Insert new node between current and current.next
      current.next = new Node<E>(e);
      (current.next).next = temp;
      size++;
    }
  }

  /** Remove the head node and
   *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    else {
      Node<E> temp = head;
      head = head.next;
      size--;
      if (head == null) {
        tail = null;
      }
      return temp.element;
    }
  }

  /** Remove the last node and
   * return the object that is contained in the removed node. */
  public E removeLast() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    else if (size == 1) {
      Node<E> temp = head;
      head = tail = null;
      size = 0;
      return temp.element;
    }
    else {
      Node<E> current = head;

      for (int i = 0; i < size - 2; i++) { // Traverse list elements until current is second to last node in list
        current = current.next;
      }

      Node<E> temp = tail;
      tail = current;
      tail.next = null;
      size--;
      return temp.element;
    }
  }

  @Override /** Remove the element at the specified position in this
   *  list. Return the element that was removed from the list. */
  public E remove(int index) {
    checkIndex(index);

    if (index == 0) {
      return removeFirst();
    }
    else if (index == size - 1) {
      return removeLast();
    }
    else {
      Node<E> previous = head;

      for (int i = 1; i < index; i++) {
        previous = previous.next;
      }

      Node<E> current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }

  @Override /** Override toString() to return elements in the list */
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", "); // Separate two elements with a comma
      }
    }
    result.append("]"); // Insert the closing ] in the string
    return result.toString();
  }

  @Override /** Clear the list */
  public void clear() {
    size = 0;
    head = tail = null;
  }

  @Override /** Return true if this list contains the element e */
  public boolean contains(E e) {
    Node<E> current = head;
    while (current != null) {
      if (current.element.equals(e)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  @Override /** Return the element at the specified index */
  public E get(int index) {
    checkIndex(index);
    Node<E> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.element;
  }

  @Override /** Return the index of the first matching element in
   *  this list. Return -1 if no match. */
  public int indexOf(E e) {
    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      if (current.element.equals(e)) {
        return i;
      }
      current = current.next;
    }
    return -1;
  }

  @Override /** Return the index of the last matching element in
   *  this list. Return -1 if no match. */
  public int lastIndexOf(E e) {
    int lastIndex = -1;
    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      if (current.element.equals(e)) {
        lastIndex = i;
      }
      current = current.next;
    }
    return lastIndex;
  }

  @Override /** Replace the element at the specified position
   *  in this list with the specified element. Return the old element. */
  public E set(int index, E e) {
    checkIndex(index);
    Node<E> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    E oldElement = current.element;
    current.element = e;
    return oldElement;
  }

  @Override /** Reverses this list's elements in place.
   For the linked list, this is done by changing the direction of the node links.*/
  public void reverse() {
    if (size <= 1) {
      return; // No need to reverse if the list is empty or has only one element
    }

    Node<E> one = null;
    Node<E> two = head;
    Node<E> three = head.next;
    tail = head;

    while (three != null) {
      two.next = one;
      one = two;
      two = three;
      three = three.next;
    }

    two.next = one;

    head = two;
    tail.next = null;
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
  }

  @Override /** Override iterator() defined in Iterable */
  public java.util.Iterator<E> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements java.util.Iterator<E> {
    private Node<E> current = MyLinkedList.this.head; // Node of the next element in the iteration

    @Override
    public boolean hasNext() {
       return (this.current != null);
    }

    @Override
    public E next() {
      if (!hasNext())
    	throw new NoSuchElementException();
      E e = current.element;
      current = current.next;
      return e;
    }

    @Override
    public void remove() {
      System.out.println("Implementation left as OPTIONAL exercise (7)");
    }
  }

  private static class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
      this.element = element;
    }
  }
}
