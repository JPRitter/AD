/**
 * Diese Klasse implementiert das Interface ListenInter mit einer doppelt
 * verketteten Liste.
 * 
 * @author P.Aguilar Bremer & J.P.Ritter
 * @version Oktober 2018
 */
public class LinkedListe<E> implements ListenInter<E>
{
	// Der Kopf der verketteten Liste
	private DoppelKnoten<E> _listenkopf;

	// Das Ende der verketteten Liste
	private DoppelKnoten<E> _listenende;

	// Die logische Laenge der Liste (Kardinalitaet).
	private int _anzahlElemente;

	/**
	 * Initialisiert eine neue LinkedListe.
	 */
	public LinkedListe()
	{
		// Diese Implementierung verwendet zwei Waechter-Knoten,
		// einen fuer den Listenanfang, einen fuer das Ende.
		// Sie markieren technisch die Grenzen der Liste und enthalten keine Elemente.
		// Sie erleichtern das Einfuegen und Entfernen von Titeln,
		// weil viele Sonderfaelle entfallen.
		_listenkopf = new DoppelKnoten<E>();
		_listenende = new DoppelKnoten<E>();
		_listenkopf.setzeNachfolger(_listenende);
		_listenende.setzeVorgaenger(_listenkopf);
		_anzahlElemente = 0;
	}

	/**
	 * Fuege ein Element an der Position position in die LinkedListe
	 * ein. Alle folgenden Eintraege werden um eine Position verschoben. Wenn
	 * position gleich der Laenge der LinkedListe ist, dann fuege das
	 * Element am Ende an.
	 * 
	 * @param element
	 *            Das einzufuegende Element (darf nicht null sein).
	 * @param position
	 *            Die Position, an welcher das Element eingefuegt werden soll.
	 */
	@Override
	public void fuegeEin(E element, int position)
	{
		darfNichtNullSein(element);
		mussGueltigeEinfuegepositionSein(position);

		DoppelKnoten<E> rechts = knotenAnPosition(position);
		DoppelKnoten<E> links = rechts.gibVorgaenger();
		DoppelKnoten<E> neu = new DoppelKnoten<E>(element, links, rechts);
		links.setzeNachfolger(neu);
		rechts.setzeVorgaenger(neu);

		++_anzahlElemente;

	}

	private DoppelKnoten<E> knotenAnPosition(int position)
	{
		DoppelKnoten<E> result;
		if (position < _anzahlElemente / 2)
		{
			result = knotenAnPositionAufsteigend(position);
		}
		else
		{
			result = knotenAnPositionAbsteigend(position);
		}
		return result;
	}

	private DoppelKnoten<E> knotenAnPositionAufsteigend(int position)
	{
		DoppelKnoten<E> knoten = _listenkopf;
		for (int i = 0; i <= position; ++i)
		{
			knoten = knoten.gibNachfolger();
		}
		return knoten;
	}

	private DoppelKnoten<E> knotenAnPositionAbsteigend(int position)
	{
		DoppelKnoten<E> knoten = _listenende;
		for (int i = _anzahlElemente; i > position; --i)
		{
			knoten = knoten.gibVorgaenger();
		}
		return knoten;
	}

	/**
	 * Entferne das Element an der angegebenen Position. Alle folgenden Eintraege
	 * werden um eine Position verschoben.
	 * 
	 * @param position
	 *            Die Position des Elmentes, das entfernt werden soll.
	 */
	@Override
	public void entferne(int position)
	{
		mussGueltigePositionSein(position);

		DoppelKnoten<E> knoten = knotenAnPosition(position);
		DoppelKnoten<E> links = knoten.gibVorgaenger();
		DoppelKnoten<E> rechts = knoten.gibNachfolger();
		links.setzeNachfolger(rechts);
		rechts.setzeVorgaenger(links);

		--_anzahlElemente;
	}

	/**
	 * Pruefe, ob ein Element in der Liste enthalten ist.
	 * 
	 * @param element
	 *            Das Element, welches in der Liste gesucht werden soll.
	 * @return true wenn das Element in der Liste ist, ansonsten
	 *         false.
	 */
	@Override
	public boolean enthaelt(E element)
	{
		darfNichtNullSein(element);

		DoppelKnoten<E> knoten = _listenkopf;
		while ((knoten = knoten.gibNachfolger()) != _listenende)
		{
			if (knoten.gibElement().equals(element))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Gibt das Element an der angegebenen Position zurueck.
	 * 
	 * @param position
	 *            Die Position des Elements, das zurueckgeben werden soll.
	 * @return Das Element an der Position position.
	 */
	@Override
	public E gibElement(int position)
	{
		mussGueltigePositionSein(position);

		return knotenAnPosition(position).gibElement();
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
		_listenkopf.setzeNachfolger(_listenende);
		_listenende.setzeVorgaenger(_listenkopf);
		_anzahlElemente = 0;
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
	 * Wirft eine IllegalArgumentException, falls die uebergebene Element-Referenz
	 * null ist.
	 */
	private void darfNichtNullSein(E elemente)
	{
		if (elemente == null)
		{
			throw new IllegalArgumentException("Die Titel-Referenz darf nicht null sein.");
		}
	}

}
