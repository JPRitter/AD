import java.util.Random;

public class PerformanceTest
{

	private ArrayListe<Integer> _arrayList;

	public PerformanceTest()
	{
		_arrayList = new ArrayListe<Integer>();
	}

	public void testArrayListe()
	{	
		long startZeit = System.nanoTime();
		long mStartZeit = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++)
		{
			_arrayList.fuegeEin(i, 0);
		}
		long endZeit = System.nanoTime();
		long mEndZeit = System.currentTimeMillis();
		System.out.println("Einfuegen am Anfang in Ns:  " +  (endZeit-startZeit));
		System.out.println("Einfuegen am Anfang in Ms:  " +  (mEndZeit-mStartZeit));
		_arrayList.leere(); 
		
		Random zufall = new Random(); 
		long startZeit1 = System.nanoTime();
		long mStartZeit1 = System.currentTimeMillis(); 
		_arrayList.fuegeEin(0, 0);
		for (int i = 1; i < 10000; i++)
		{
			_arrayList.fuegeEin(i, Math.abs(zufall.nextInt()) % _arrayList.gibLaenge());
		}
		long endZeit1 = System.nanoTime();
		long mEndZeit1 = System.currentTimeMillis(); 
		System.out.println("Einfuegen als Zufall in Ns:  " +  (endZeit1-startZeit1));
		System.out.println("Einfuegen als Zufall in Ms:  " +  (mEndZeit1-mStartZeit1));
		_arrayList.leere(); 
		
		long startZeit2 = System.nanoTime();
		long mStartZeit2 = System.currentTimeMillis(); 
		for (int i = 0; i < 10000; i++)
		{
			_arrayList.fuegeEin(i, _arrayList.gibLaenge());
		}
		long endZeit2 = System.nanoTime();
		long mEndZeit2 = System.currentTimeMillis(); 
		System.out.println("Einfuegen am Ende in Ns:  " +  (endZeit2-startZeit2));
		System.out.println("Einfuegen am Anfang in Ms:  " +  (mEndZeit2-mStartZeit2));
		_arrayList.leere(); 
	}

}
