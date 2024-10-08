/****
 *   one method of class OpenHashTable so that the modified class Q00000000
 *   uses quadratic probing.  Quadratic probing is described in Section 10.2 of the textbook on page 419.
 *   You must decide which method should be overridden and write code to override it.
 ***/

	import java.util.ArrayList;
	import java.util.Iterator;

	public class Q23654004 <E> extends OpenHashTable<E> {
	  public Q23654004(int cap, E ghostEntry) {
	    super(cap, ghostEntry);
	  }
	  
	  public int resolve(int a, int step) {
		  return (a+step*step) % capacity;
	  }
	  
	}

	class OpenHashTable<E> implements Set<E> {
	  int size;
	  int capacity;
	  E seats[];
	  E ghost;   // marks departed entries in the table

	  public OpenHashTable(E ghostEntry) {
	    this(1000, ghostEntry);
	  }

	  public OpenHashTable(int cap, E ghostEntry) {
	    this.ghost = ghostEntry;
	    capacity = cap;
	    seats = (E[]) new Object[cap];
	    size = 0;
	    for (int i = 0; i < cap; i++)
	      seats[i] = null;
	  }
	  
	  public boolean contains(E k) {
	    return locate(k) != -1;        // locate finds the index for k in the table, or -1 if not present
	  }

	  public E get(E k) {
	    int i = locate(k);            
	    if (i == -1) return null;
	    return seats[i];
	  }
	  
	  public void add(E k) throws Exception {
	    int i = locate(k);            
	    if (i != -1) seats[i] = k;     // replace an existing copy of k
	    else {
	      i = findSpace(k);          // find next available seat for k
	      if (i != -1) seats[i] = k;
	      else throw new Exception("Hash Table is Full");
	    }
	  }

	  public void remove(E k) {
	    int i = locate(k);
	    if (i == -1) return;
	    seats[i] = ghost;
	  }
	  
	  // hashing and collision resolution by linear probing
	  public int locate(E k) {
	    int h = k.hashCode() % capacity;
	    int step = 0;
	    while (step < capacity) {
	      int index = resolve(h, step);
	      if (seats[index] == null) return -1;
	      if (k != ghost && k.equals(seats[index]))
	        return index;
	      step++;
	    }
	    return -1;
	  }

	  public int findSpace(E k) {
	    int h = k.hashCode() % capacity;
	    int step = 0;
	    while (step < capacity) {
	      int index = resolve(h, step);
	      if (seats[index] == null) return index;
	      if (seats[index] == ghost) return index;
	      step++;
	    }
	    return -1;
	  }

	  // linear probing for collision resolution
	  public int resolve(int h, int step) {
	    return (h + step) % capacity;
	  }

	  public void dumpData() {
	    for (int i = 0; i < capacity; i++) {
	      if (seats[i] != null && seats[i] != ghost) {
	        System.out.println("" + i + ": " + seats[i].toString());
	      }
	    }
	  }

	  public Iterator<E> iterator() {
	    ArrayList<E> content = new ArrayList<E>();
	    for (int i = 0; i < capacity; i++) {
	      if (seats[i] != null && seats[i] != ghost) {
	        content.add(seats[i]);
	      }
	    }
	    return content.iterator();
	  }

	  public int size() {
	    return size;
	  }

	  public boolean isEmpty() {
	    return size == 0;
	  }
	}

	interface Set<E> extends Iterable<E> {
	  public int size();

	  public boolean isEmpty();

	  public boolean contains(E k);

	  public E get(E k);

	  public void add(E k) throws Exception;

	  public void remove(E k) throws Exception;

	  public Iterator<E> iterator();

	  public void dumpData();
	}

