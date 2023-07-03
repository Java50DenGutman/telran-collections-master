package telran.util.test;

import static org.junit.Assert.*;
import java.util.Iterator;
import telran.util.ArrayList;
import telran.util.List;

class ArrayListTest {
	public void testAdd() {
	    List<String> list = new ArrayList<>();

	    list.add("Telran");
	    list.add("Java");
	    list.add("CSS");

	    assertEquals(3, list.size());
	    assertEquals("Telran", list.get(0));
	    assertEquals("Java", list.get(1));
	    assertEquals("CSS", list.get(2));
	}
	public void testRemove() {
	    List<String> list = new ArrayList<>();

	    list.add("Telran");
	    list.add("Java");
	    list.add("CSS");

	    assertTrue(list.remove("Java"));
	    assertEquals(2, list.size());
	    assertEquals("Telran", list.get(0));
	    assertEquals("CSS", list.get(1));
	    assertFalse(list.remove("Python"));
	}
	public void testToArray() {
	    List<String> list = new ArrayList<>();

	    list.add("Telran");
	    list.add("Java");
	    list.add("CSS");

	    String[] array = list.toArray(new String[0]);

	    assertEquals(3, array.length);
	    assertEquals("Telran", array[0]);
	    assertEquals("Java", array[1]);
	    assertEquals("CSS", array[2]);
	}
	public void testRemoveIf() {
	    List<String> list = new ArrayList<>();

	    list.add("Telran");
	    list.add("Java");
	    list.add("CSS");

	    assertTrue(list.removeIf(s -> s.startsWith("J")));
	    assertEquals(2, list.size());
	    assertEquals("Telran", list.get(0));
	    assertEquals("CSS", list.get(1));
	    assertFalse(list.removeIf(s -> s.startsWith("P")));
	}
	public void testAddAll() {
	    List<String> list = new ArrayList<>();

	    List<String> otherList = new ArrayList<>();
	    otherList.add("Telran");
	    otherList.add("Java");
	    otherList.add("CSS");

	    assertTrue(list.addAll(otherList));
	    assertEquals(3, list.size());
	    assertEquals("Telran", list.get(0));
	    assertEquals("Java", list.get(1));
	    assertEquals("CSS", list.get(2));
	}
	public void testRemoveAll() {
	    List<String> list = new ArrayList<>();

	    list.add("Telran");
	    list.add("Java");
	    list.add("CSS");

	    List<String> otherList = new ArrayList<>();
	    otherList.add("Java");
	    otherList.add("Python");

	    assertTrue(list.removeAll(otherList));
	    assertEquals(2, list.size());
	    assertEquals("Telran", list.get(0));
	    assertEquals("CSS", list.get(1));
	    assertFalse(list.removeAll(otherList));
	}
	public void testIterator() {
	    List<String> list = new ArrayList<>();

	    list.add("Telran");
	    list.add("Java");
	    list.add("CSS");

	    Iterator<String> iterator = list.iterator();

	    assertTrue(iterator.hasNext());
	    assertEquals("Telran", iterator.next());
	    assertTrue(iterator.hasNext());
	    assertEquals("Java", iterator.next());
	    assertTrue(iterator.hasNext());
	    assertEquals("CSS", iterator.next());
	    assertFalse(iterator.hasNext());
	}
	public void testAddGetSetRemove() {
	    List<String> list = new ArrayList<>();

	    list.add("Telran");
	    list.add("Java");
	    list.add("CSS");

	    assertEquals(3, list.size());
	    assertEquals("Telran", list.get(0));
	    assertEquals("Java", list.get(1));
	    assertEquals("CSS", list.get(2));

	    list.add(1, "Python");
	    assertEquals(4, list.size());
	    assertEquals("Telran", list.get(0));
	    assertEquals("Python", list.get(1));
	    assertEquals("Java", list.get(2));
	    assertEquals("CSS", list.get(3));

	    assertEquals("Python", list.set(1, "JavaScript"));
	    assertEquals(4, list.size());
	    assertEquals("Telran", list.get(0));
	    assertEquals("JavaScript", list.get(1));
	    assertEquals("Java", list.get(2));
	    assertEquals("CSS", list.get(3));

	    assertEquals("Java", list.remove(2));
	    assertEquals(3, list.size());
	    assertEquals("Telran", list.get(0));
	    assertEquals("JavaScript", list.get(1));
	    assertEquals("CSS", list.get(2));
	}
	public void testIndexOfLastIndexOf() {
	    List<String> list = new ArrayList<>();

	    list.add("Telran");
	    list.add("Java");
	    list.add("CSS");
	    list.add("Java");

	    assertEquals(1, list.indexOf("Java"));
	    assertEquals(3, list.lastIndexOf("Java"));

	    assertEquals(2, list.indexOf(s -> s.startsWith("C")));
	    assertEquals(-1, list.lastIndexOf(s -> s.startsWith("P")));
	}
}