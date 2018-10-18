import java.util.Random;

/**
 * Ein Performance Test für die beiden Listen
 * 
 * @author J.P.Ritter & P.Aguilar Bremer
 * @version Oktober 2018
 *
 */

public class PerformanceTest
{

	private ArrayListe<Double> _arrayList;
	private LinkedListe<Double> _linkedList;

	public PerformanceTest()
	{
		_arrayList = new ArrayListe<Double>();
		_linkedList = new LinkedListe<Double>();
	}

	public void testArrayListe()
	{
		long mZeit = 0;
		long zeit = 0;

		for (int j = 0; j < 10; ++j)
		{
			long startZeit = System.nanoTime();
			long mStartZeit = System.currentTimeMillis();
			for (int i = 0; i < 10000; i++)
			{
				_arrayList.fuegeEin(Math.random() * 10000, 0);
			}
			long endZeit = System.nanoTime();
			long mEndZeit = System.currentTimeMillis();
			mZeit += (mEndZeit - mStartZeit);
			zeit += (endZeit - startZeit);
			_arrayList.leere();
		}
		System.out.println("Einfuegen am Anfang der Arrayliste in Ns:  " + (zeit / 10));
		System.out.println("Einfuegen am Anfang der Arrayliste in Ms:  " + (mZeit / 10));
		System.out.println();

		long mZeit1 = 0;
		long zeit1 = 0;
		for (int j = 0; j < 10; ++j)
		{
			Random zufall = new Random();
			long startZeit1 = System.nanoTime();
			long mStartZeit1 = System.currentTimeMillis();
			_arrayList.fuegeEin(Math.random() * 10000, 0);
			for (int i = 1; i < 10000; i++)
			{
				_arrayList.fuegeEin(Math.random() * 10000, Math.abs(zufall.nextInt()) % _arrayList.gibLaenge());
			}
			long endZeit1 = System.nanoTime();
			long mEndZeit1 = System.currentTimeMillis();
			mZeit1 += (mEndZeit1 - mStartZeit1);
			zeit1 += (endZeit1 - startZeit1);
			_arrayList.leere();
		}
		System.out.println("Einfuegen als Zufall der Arrayliste in Ns:  " + (zeit1 / 10));
		System.out.println("Einfuegen als Zufall der Arrayliste in Ms:  " + (mZeit1 / 10));
		System.out.println();

		long mZeit2 = 0;
		long zeit2 = 0;
		for (int j = 0; j < 10; ++j)
		{
			long startZeit2 = System.nanoTime();
			long mStartZeit2 = System.currentTimeMillis();
			for (int i = 0; i < 10000; i++)
			{
				_arrayList.fuegeEin(Math.random() * 10000, _arrayList.gibLaenge());
			}
			long endZeit2 = System.nanoTime();
			long mEndZeit2 = System.currentTimeMillis();
			mZeit2 += (mEndZeit2 - mStartZeit2);
			zeit2 += (endZeit2 - startZeit2);
			_arrayList.leere();
		}
		System.out.println("Einfuegen am Ende der Arrayliste in Ns:  " + (zeit2 / 10));
		System.out.println("Einfuegen am Ende der Arrayliste in Ms:  " + (mZeit2 / 10));
		System.out.println();

		ArrayListe<Double> zufallsListe = new ArrayListe<Double>();
		for (int i = 0; i < 10000; i++)
		{
			zufallsListe.fuegeEin(Math.random() * 10000, 0);
		}

		long zeit3 = 0;
		long mZeit3 = 0;
		for (int j = 1; j < 10; ++j)
		{
			for (int i = 0; i < 10000; i++)
			{
				_arrayList.fuegeEin(zufallsListe.gibElement(i), 0);
			}
			long startZeit3 = System.nanoTime();
			long mStartZeit3 = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++)
			{
				_arrayList.entferne(0);
			}
			long endZeit3 = System.nanoTime();
			long mEndZeit3 = System.currentTimeMillis();
			zeit3 += endZeit3 - startZeit3;
			mZeit3 += mEndZeit3 - mStartZeit3;
			_arrayList.leere();
		}
		System.out.println("Entfernen am Anfang der Arrayliste in Ns:  " + (zeit3 / 10));
		System.out.println("Entfernen am Anfang der Arrayliste in Ms:  " + (mZeit3 / 10));
		System.out.println();

		long zeit4 = 0;
		long mZeit4 = 0;
		for (int j = 1; j < 10; ++j)
		{
			for (int i = 0; i < 10000; i++)
			{
				_arrayList.fuegeEin(zufallsListe.gibElement(i), 0);
			}

			Random zufall1 = new Random();
			long startZeit4 = System.nanoTime();
			long mStartZeit4 = System.currentTimeMillis();
			for (int i = 1; i < 1000; i++)
			{
				_arrayList.entferne(Math.abs(zufall1.nextInt()) % _arrayList.gibLaenge());
			}
			long endZeit4 = System.nanoTime();
			long mEndZeit4 = System.currentTimeMillis();
			zeit4 += endZeit4 - startZeit4;
			mZeit4 += mEndZeit4 - mStartZeit4;
			_arrayList.leere();
		}
		System.out.println("Entfernen als Zufall der Arrayliste in Ns:  " + (zeit4 / 10));
		System.out.println("Entfernen als Zufall der Arrayliste in Ms:  " + (mZeit4 / 10));
		System.out.println();

		long zeit5 = 0;
		long mZeit5 = 0;
		for (int j = 1; j < 10; ++j)
		{
			for (int i = 0; i < 10000; i++)
			{
				_arrayList.fuegeEin(zufallsListe.gibElement(i), 0);
			}

			long startZeit5 = System.nanoTime();
			long mStartZeit5 = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++)
			{
				_arrayList.entferne(_arrayList.gibLaenge() - 1);
			}
			long endZeit5 = System.nanoTime();
			long mEndZeit5 = System.currentTimeMillis();
			zeit5 += endZeit5 - startZeit5;
			mZeit5 += mEndZeit5 - mStartZeit5;
			_arrayList.leere();
		}
		System.out.println("Entfernen am Ende der Arrayliste in Ns:  " + (zeit5));
		System.out.println("Entfernen am Ende der Arrayliste in Ms:  " + (mZeit5));

	}

	public void testLinkedListe()
	{
		long mZeit = 0;
		long zeit = 0;

		for (int j = 0; j < 10; ++j)
		{
			long startZeit = System.nanoTime();
			long mStartZeit = System.currentTimeMillis();
			for (int i = 0; i < 10000; i++)
			{
				_linkedList.fuegeEin(Math.random() * 10000, 0);
			}
			long endZeit = System.nanoTime();
			long mEndZeit = System.currentTimeMillis();
			mZeit += (mEndZeit - mStartZeit);
			zeit += (endZeit - startZeit);
			_linkedList.leere();
		}
		System.out.println("Einfuegen am Anfang der Linkedliste in Ns:  " + (zeit / 10));
		System.out.println("Einfuegen am Anfang der Linkedliste in Ms:  " + (mZeit / 10));
		System.out.println();

		long mZeit1 = 0;
		long zeit1 = 0;
		for (int j = 0; j < 10; ++j)
		{
			Random zufall = new Random();
			long startZeit1 = System.nanoTime();
			long mStartZeit1 = System.currentTimeMillis();
			_linkedList.fuegeEin(Math.random() * 10000, 0);
			for (int i = 1; i < 10000; i++)
			{
				_linkedList.fuegeEin(Math.random() * 10000, Math.abs(zufall.nextInt()) % _linkedList.gibLaenge());
			}
			long endZeit1 = System.nanoTime();
			long mEndZeit1 = System.currentTimeMillis();
			mZeit1 += (mEndZeit1 - mStartZeit1);
			zeit1 += (endZeit1 - startZeit1);
			_linkedList.leere();
		}
		System.out.println("Einfuegen als Zufall der Linkedliste in Ns:  " + (zeit1 / 10));
		System.out.println("Einfuegen als Zufall der Linkedliste in Ms:  " + (mZeit1 / 10));
		System.out.println();

		long mZeit2 = 0;
		long zeit2 = 0;
		for (int j = 0; j < 10; ++j)
		{
			long startZeit2 = System.nanoTime();
			long mStartZeit2 = System.currentTimeMillis();
			for (int i = 0; i < 10000; i++)
			{
				_linkedList.fuegeEin(Math.random() * 10000, _linkedList.gibLaenge());
			}
			long endZeit2 = System.nanoTime();
			long mEndZeit2 = System.currentTimeMillis();
			mZeit2 += (mEndZeit2 - mStartZeit2);
			zeit2 += (endZeit2 - startZeit2);
			_linkedList.leere();
		}
		System.out.println("Einfuegen am Ende der Linkedliste in Ns:  " + (zeit2 / 10));
		System.out.println("Einfuegen am Ende der Linkedliste in Ms:  " + (mZeit2 / 10));
		System.out.println();

		ArrayListe<Double> zufallsListe = new ArrayListe<Double>();
		for (int i = 0; i < 10000; i++)
		{
			zufallsListe.fuegeEin(Math.random() * 10000, 0);
		}

		long zeit3 = 0;
		long mZeit3 = 0;
		for (int j = 1; j < 10; ++j)
		{
			for (int i = 0; i < 10000; i++)
			{
				_linkedList.fuegeEin(zufallsListe.gibElement(i), 0);
			}
			long startZeit3 = System.nanoTime();
			long mStartZeit3 = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++)
			{
				_linkedList.entferne(0);
			}
			long endZeit3 = System.nanoTime();
			long mEndZeit3 = System.currentTimeMillis();
			zeit3 += endZeit3 - startZeit3;
			mZeit3 += mEndZeit3 - mStartZeit3;
			_linkedList.leere();
		}
		System.out.println("Entfernen am Anfang der Linkedliste in Ns:  " + (zeit3 / 10));
		System.out.println("Entfernen am Anfang der Linkedliste in Ms:  " + (mZeit3 / 10));
		System.out.println();

		long zeit4 = 0;
		long mZeit4 = 0;
		for (int j = 1; j < 10; ++j)
		{
			for (int i = 0; i < 10000; i++)
			{
				_linkedList.fuegeEin(zufallsListe.gibElement(i), 0);
			}

			Random zufall1 = new Random();
			long startZeit4 = System.nanoTime();
			long mStartZeit4 = System.currentTimeMillis();
			for (int i = 1; i < 1000; i++)
			{
				_linkedList.entferne(Math.abs(zufall1.nextInt()) % _linkedList.gibLaenge());
			}
			long endZeit4 = System.nanoTime();
			long mEndZeit4 = System.currentTimeMillis();
			zeit4 += endZeit4 - startZeit4;
			mZeit4 += mEndZeit4 - mStartZeit4;
			_linkedList.leere();
		}
		System.out.println("Entfernen als Zufall der Linkedliste in Ns:  " + (zeit4 / 10));
		System.out.println("Entfernen als Zufall der Linkedliste in Ms:  " + (mZeit4 / 10));
		System.out.println();

		long zeit5 = 0;
		long mZeit5 = 0;
		for (int j = 1; j < 10; ++j)
		{
			for (int i = 0; i < 10000; i++)
			{
				_linkedList.fuegeEin(zufallsListe.gibElement(i), 0);
			}

			long startZeit5 = System.nanoTime();
			long mStartZeit5 = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++)
			{
				_linkedList.entferne(_linkedList.gibLaenge() - 1);
			}
			long endZeit5 = System.nanoTime();
			long mEndZeit5 = System.currentTimeMillis();
			zeit5 += endZeit5 - startZeit5;
			mZeit5 += mEndZeit5 - mStartZeit5;
			_linkedList.leere();
		}
		System.out.println("Entfernen am Ende der Linkedliste in Ns:  " + (zeit5));
		System.out.println("Entfernen am Ende der Linkedliste in Ms:  " + (mZeit5));

	}
}
