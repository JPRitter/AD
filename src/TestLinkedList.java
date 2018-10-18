import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinkedList
{

	@Test
	public void testFuegeEinAnfang()
	{
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++)
		{
			linkedList.fuegeEin(i, 0);
		}
		linkedList.fuegeEin(11, 0);
		assertEquals(11, linkedList.gibLaenge());
		assertEquals((Integer) 11, linkedList.gibElement(0));
		assertEquals((Integer) 9, linkedList.gibElement(1));
		assertEquals((Integer) 4, linkedList.gibElement(6));
		assertEquals((Integer) 6, linkedList.gibElement(4));
		assertEquals((Integer) 0, linkedList.gibElement(10));
	}

	@Test
	public void testFuegeEinEnde()
	{
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++)
		{
			linkedList.fuegeEin(i, linkedList.gibLaenge());
		}
		linkedList.fuegeEin(11, linkedList.gibLaenge());
		assertEquals(11, linkedList.gibLaenge());
		assertEquals((Integer) 0, linkedList.gibElement(0));
		assertEquals((Integer) 1, linkedList.gibElement(1));
		assertEquals((Integer) 6, linkedList.gibElement(6));
		assertEquals((Integer) 4, linkedList.gibElement(4));
		assertEquals((Integer) 11, linkedList.gibElement(10));
	}

	@Test
	public void testeEinfuegenUndEntfernen()
	{
		LinkedList<String> linkedList = new LinkedList<String>();
		for (int i = 0; i < 10; i++)
		{
			linkedList.fuegeEin("" + i, linkedList.gibLaenge());
		}
		assertEquals(10, linkedList.gibLaenge());
		linkedList.entferne(0);
		linkedList.entferne(5);
		assertEquals(8, linkedList.gibLaenge());
		assertEquals("9", linkedList.gibElement(7));
		assertEquals("1", linkedList.gibElement(0));
		assertFalse(linkedList.enthaelt("0"));
		assertFalse(linkedList.enthaelt("6"));
		assertTrue(linkedList.enthaelt("7"));
	}

	@Test
	public void testeEntferneListenanfang()
	{
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++)
		{
			linkedList.fuegeEin(i, linkedList.gibLaenge());
		}
		linkedList.entferne(0);
		assertEquals(9, linkedList.gibLaenge());
		assertFalse("Liste darf nicht den Integer 0 enthalten", linkedList.enthaelt((Integer) 0));
		assertEquals((Integer) 1, linkedList.gibElement(0));
		assertEquals((Integer) 9, linkedList.gibElement(8));
	}
	
	@Test
	public void testeEntferneListenEnde()
	{
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++)
		{
			linkedList.fuegeEin(i, linkedList.gibLaenge());
		}
		linkedList.entferne(9);
		assertEquals(9, linkedList.gibLaenge());
		assertFalse("Liste darf nicht den Integer 9 enthalten", linkedList.enthaelt((Integer) 9));
		assertEquals((Integer) 0, linkedList.gibElement(0));
		assertEquals((Integer) 8, linkedList.gibElement(8));
	}

	@Test
	public void testeEnthaelt()
    {
		LinkedList<String> linkedList = new LinkedList<String>();
        	for (int i = 0; i < 10; i++)
    		{
    			linkedList.fuegeEin(""+i, linkedList.gibLaenge());
    		}

        assertTrue("arrayList soll den String 0 enthalten", linkedList
                .enthaelt("0"));
        assertTrue("arrayList soll den String 2 enthalten", linkedList
                .enthaelt("2"));
        assertTrue("arrayList soll den String 9 enthalten", linkedList
                .enthaelt("9"));

        assertFalse(
                "arrayList darf den String 12 nicht enthalten",
                linkedList.enthaelt("12"));
    }

}
