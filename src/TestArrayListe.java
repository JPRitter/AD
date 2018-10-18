import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayListe
{

	@Test
	public void testFuegeEinAnfang()
	{
		LinkedList<Integer> arrayList = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++)
		{
			arrayList.fuegeEin(i, 0);
		}
		arrayList.fuegeEin(11, 0);
		assertEquals(11, arrayList.gibLaenge());
		assertEquals((Integer) 11, arrayList.gibElement(0));
		assertEquals((Integer) 9, arrayList.gibElement(1));
		assertEquals((Integer) 4, arrayList.gibElement(6));
		assertEquals((Integer) 6, arrayList.gibElement(4));
		assertEquals((Integer) 0, arrayList.gibElement(10));
	}

	@Test
	public void testFuegeEinEnde()
	{
		LinkedList<Integer> arrayList = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++)
		{
			arrayList.fuegeEin(i, arrayList.gibLaenge());
		}
		arrayList.fuegeEin(11, arrayList.gibLaenge());
		assertEquals(11, arrayList.gibLaenge());
		assertEquals((Integer) 0, arrayList.gibElement(0));
		assertEquals((Integer) 1, arrayList.gibElement(1));
		assertEquals((Integer) 6, arrayList.gibElement(6));
		assertEquals((Integer) 4, arrayList.gibElement(4));
		assertEquals((Integer) 11, arrayList.gibElement(10));
	}

	@Test
	public void testeEinfuegenUndEntfernen()
	{
		LinkedList<String> arrayList = new LinkedList<String>();
		for (int i = 0; i < 10; i++)
		{
			arrayList.fuegeEin("" + i, arrayList.gibLaenge());
		}
		assertEquals(10, arrayList.gibLaenge());
		arrayList.entferne(0);
		arrayList.entferne(5);
		assertEquals(8, arrayList.gibLaenge());
		assertEquals("9", arrayList.gibElement(7));
		assertEquals("1", arrayList.gibElement(0));
		assertFalse(arrayList.enthaelt("0"));
		assertFalse(arrayList.enthaelt("6"));
		assertTrue(arrayList.enthaelt("7"));
	}

	@Test
	public void testeEntferneListenanfang()
	{
		LinkedList<Integer> arrayList = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++)
		{
			arrayList.fuegeEin(i, arrayList.gibLaenge());
		}
		arrayList.entferne(0);
		assertEquals(9, arrayList.gibLaenge());
		assertFalse("Liste darf nicht den Integer 0 enthalten", arrayList.enthaelt((Integer) 0));
		assertEquals((Integer) 1, arrayList.gibElement(0));
		assertEquals((Integer) 9, arrayList.gibElement(8));
	}
	
	@Test
	public void testeEntferneListenEnde()
	{
		LinkedList<Integer> arrayList = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++)
		{
			arrayList.fuegeEin(i, arrayList.gibLaenge());
		}
		arrayList.entferne(9);
		assertEquals(9, arrayList.gibLaenge());
		assertFalse("Liste darf nicht den Integer 9 enthalten", arrayList.enthaelt((Integer) 9));
		assertEquals((Integer) 0, arrayList.gibElement(0));
		assertEquals((Integer) 8, arrayList.gibElement(8));
	}

	@Test
	public void testeEnthaelt()
    {
		LinkedList<String> arrayList = new LinkedList<String>();
        	for (int i = 0; i < 10; i++)
    		{
    			arrayList.fuegeEin(""+i, arrayList.gibLaenge());
    		}

        assertTrue("arrayList soll den String 0 enthalten", arrayList
                .enthaelt("0"));
        assertTrue("arrayList soll den String 2 enthalten", arrayList
                .enthaelt("2"));
        assertTrue("arrayList soll den String 9 enthalten", arrayList
                .enthaelt("9"));

        assertFalse(
                "arrayList darf den String 12 nicht enthalten",
                arrayList.enthaelt("12"));
    }

}
