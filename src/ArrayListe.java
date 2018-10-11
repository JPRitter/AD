/**
 * Diese Klasse implementiert das Interface ListenInter mit einer Array Liste.
 * 
 * @author P.Aguilar Bremer & J.P.Ritter
 * @version Oktober 2018
 */
public class ArrayListe<E> implements ListenInter<E>
{
	// In diesem Array sind die Referenzen auf die enthaltenen Titel abgelegt.
	// Die Laenge des Arrays entspricht der Kapazitaet der Liste und muss daher
	// nicht separat gespeichert werden.
	private Object[] _elementArray;

	// Die Kardinalitaet der Liste
	private int _anzahlElemente;

	/**
	 * Initialisiert eine neue ArrayListe
	 */
	public ArrayListe()
	{
		_elementArray = new Object[10];
		_anzahlElemente = 0;
	}

	/**
     * Fuege ein Element an der Position in die Titelliste
     * ein. Alle folgenden Eintraege werden um eine Position verschoben.
     * Wenn die position gleich der Laenge der Titelliste ist, dann
     * fuege das Element am Ende an.
     * 
     * @param titel Der einzufuegende Titel (darf nicht null sein).
     * @param position Die Position, an welcher der Titel eingefuegt werden soll.
     */
	@Override
	public void fuegeEin(E element, int position)
	{
		darfNichtNullSein(element);
		mussGueltigeEinfuegepositionSein(position);

		stelleGenuegendKapazitaetSicher();
		fuegeEndlichEin(element, position);

	}

	private void stelleGenuegendKapazitaetSicher()
	{
		if (kapazitaetErschoepft())
		{
			erhoeheKapazitaet();
		}
	}

	private boolean kapazitaetErschoepft()
	{
		return _anzahlElemente == _elementArray.length;
	}

	private void erhoeheKapazitaet()
	{
		_elementArray = java.util.Arrays.copyOf(_elementArray, _anzahlElemente * 2);
	}

	private void fuegeEndlichEin(E element, int position)
	{
		schiebeNachHintenAb(position);
		_elementArray[position] = element;
		++_anzahlElemente;
	}

	private void schiebeNachHintenAb(int position)
	{
		System.arraycopy(_elementArray, position, _elementArray, position + 1, _anzahlElemente - position);
	}

	   /**
     * Entferne das Element an der angegebenen Position. Alle folgenden Eintraege
     * werden um eine Position verschoben.
     * 
     * @param position Die Position des Elements, das entfernt werden soll.
     */
	@Override
	public void entferne(int position)
	{
		mussGueltigePositionSein(position);

		schiebeNachVorneAb(position + 1);
		--_anzahlElemente;
		_elementArray[_anzahlElemente] = null;

		// if (position <9) //Für Position 10 wird nur die Titelanzahl dekrementiert
		// {
		// for( int i = position; i< _titelArray.length-1; i++)
		// {
		// _titelArray[i] = _titelArray[i+1];
		// }
		// }
		// _anzahlTitel--;

	}

	private void schiebeNachVorneAb(int position)
	{
		System.arraycopy(_elementArray, position, _elementArray, position - 1, _anzahlElemente - position);
	}


    /**
     * Pruefe, ob ein Element in der Liste enthalten ist.
     * 
     * @param element das Element, welches in der Liste gesucht werden soll.
     * @return true wenn das Element in der Liste ist, ansonsten false.
     */
	@Override
	public boolean enthaelt(E element)
	{
		darfNichtNullSein(element);

		for (int i = 0; i < _anzahlElemente; ++i)
		{
			if (_elementArray[i].equals(element))
			{
				return true;
			}
		}

		return false;

		// Alternative Loesung ohne Schleife und Fallunterscheidung:
		// return java.util.Arrays.asList(_titelArray).subList(0,
		// _anzahlTitel).contains(titel);
	}

	   /**
     * Gibt das Element an der angegebenen Position zurueck.
     * 
     * @param position Die Position des Elements, das zurueckgeben werden soll.
     * @return Das Element an der Position.
     */
	@SuppressWarnings("unchecked")
	@Override
	public E gibElement(int position)
	{
		mussGueltigePositionSein(position);

		return (E) _elementArray[position];
	}

	/**
	 * Gib die Laenge der Liste zurueck.
	 * 
	 * @return Anzahl der Elemente in der Liste.
	 */
	@Override
	public int gibLaenge()
	{
		return _anzahlElemente;
	}

	/**
	 * Entferne alle Elemente aus der Liste.
	 */
	@Override
	public void leere()
	{
		_elementArray = new Object[10];
		_anzahlElemente = 0;
	}

	/**
	 * Schreibt den Array-Inhalt auf die Konsole (als Debugging-Hilfe gedacht).
	 */
	public void schreibeAufKonsole()
	{
		System.out.println(java.util.Arrays.toString(_elementArray));
	}

	/**
	 * Liefert true fuer alle gueltigen Positionen innerhalb der Liste.
	 */
	public boolean istGueltigePosition(int position)
	{
		return (position >= 0) && (position < gibLaenge());
	}

	/**
	 * Wirft eine IndexOutOfBoundsException, falls es sich um eine ungueltige
	 * Position handelt.
	 */
	private void mussGueltigePositionSein(int position)
	{
		if (!istGueltigePosition(position))
		{
			throw new IndexOutOfBoundsException(position + " ist keine gueltige Position");
		}
	}

	/**
	 * Liefert true fuer alle gueltigen Einfuegepositionen innerhalb der Liste.
	 */
	public boolean istGueltigeEinfuegeposition(int position)
	{
		return (position >= 0) && (position <= gibLaenge());
	}

	/**
	 * Wirft eine IndexOutOfBoundsException, falls es sich um eine ungueltige
	 * Einfuegeposition handelt.
	 */
	private void mussGueltigeEinfuegepositionSein(int position)
	{
		if (!istGueltigeEinfuegeposition(position))
		{
			throw new IndexOutOfBoundsException(position + " ist keine gueltige Einfuegeposition");
		}
	}

	/**
	 * Wirft eine IllegalArgumentException, falls die uebergebene Titel-Referenz
	 * null ist.
	 */
	private void darfNichtNullSein(E element)
	{
		if (element == null)
		{
			throw new IllegalArgumentException("Die Titel-Referenz darf nicht null sein.");
		}
	}

}
