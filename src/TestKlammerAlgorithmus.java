import static org.junit.Assert.*;

import org.junit.Test;

public class TestKlammerAlgorithmus
{
	KlammerAlgorithmus testObjekt;
	
	/**
	 * Testobjekt für den Klammeralgorithmus
	 */
	public TestKlammerAlgorithmus()
	{
		testObjekt = new KlammerAlgorithmus();
	}

	/**
	 * Test für einen nur einmal geklammerten Ausdruck
	 */
	@Test
	public void testAuswertenEinfacherAusdruck()
	{
		assertEquals(testObjekt.auswerten("(3+3)"), "6");
		assertEquals(testObjekt.auswerten("(3*3)"), "9");
		assertEquals(testObjekt.auswerten("(3-3)"), "0");
		assertEquals(testObjekt.auswerten("(3/3)"), "1");
		
		assertEquals(testObjekt.auswerten("(10+5)"), "15");
		assertEquals(testObjekt.auswerten("(10*5)"), "50");
		assertEquals(testObjekt.auswerten("(5-10)"), "-5");
		assertEquals(testObjekt.auswerten("(10/5)"), "2");				
	}
	
	/**
	 * Test für einen mehrfach geklammerten Ausdruck
	 */
	@Test
	public void testAuswertenKomplexererAusdruck()
	{
		assertEquals(testObjekt.auswerten("(((4*(5+6))/11)-20)"), "-16");
		assertEquals(testObjekt.auswerten("(((20*(4+6))/5)-11)"), "29");
		assertEquals(testObjekt.auswerten("(((4+(5*6))-14)/20)"), "1");
		assertEquals(testObjekt.auswerten("(((20/(4+6))-5)*11)"), "-33");			
	}

}
