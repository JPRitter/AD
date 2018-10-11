/**
 * Diese Klasse modelliert doppelt verkettbare Knoten, die jeweils ein Element
 * enthalten koennen.
 * 
 * @author P.Aguilar Bremer & J.P.Ritter
 * @version Oktober 2018
 */

public class DoppelKnoten<E>
{
	// Der vorherige Knoten
	private DoppelKnoten<E> _vorgaenger;

	// Der nachfolgende Knoten
	private DoppelKnoten<E> _nachfolger;

	// Das Element des Knotens, ein Titel
	private E _element;

	/**
	 * Erzeuge einen neuen Knoten ohne Element und Verkettungsinformationen.
	 */
	public DoppelKnoten()
	{
	}

	/**
	 * Erzeuge einen neuen Knoten und setze gleich Vorgaenger, Nachfolger und
	 * Element.
	 * 
	 * @param element
	 *            Das Element, das der Knoten tragen soll
	 * @param vorgaenger
	 *            Der vorherige Knoten
	 * @param nachfolger
	 *            Der naechste Knoten
	 */
	public DoppelKnoten(E element, DoppelKnoten<E> vorgaenger, DoppelKnoten<E> nachfolger)
	{
		_element = element;
		_vorgaenger = vorgaenger;
		_nachfolger = nachfolger;
	}

	/**
	 * Gib den nachfolgenden Knoten zurueck.
	 * 
	 * @return den Nachfolgerknoten
	 */
	public DoppelKnoten<E> gibNachfolger()
	{
		return _nachfolger;
	}

	/**
	 * Setze den nachfolgenden Knoten.
	 * 
	 * @param nachfolger
	 *            der Nachfolgerknoten.
	 */
	public void setzeNachfolger(DoppelKnoten<E> nachfolger)
	{
		_nachfolger = nachfolger;
	}

	/**
	 * Gib den vorherigen Knoten zurueck.
	 * 
	 * @return den Vorgaenger dieses Knotens
	 */
	public DoppelKnoten<E> gibVorgaenger()
	{
		return _vorgaenger;
	}

	/**
	 * Setze den Vorgaenger dieses Knotens.
	 * 
	 * @param vorgaenger
	 *            der Vorgaengerknoten.
	 */
	public void setzeVorgaenger(DoppelKnoten<E> vorgaenger)
	{
		_vorgaenger = vorgaenger;
	}

	/**
	 * Gib das (Daten-)Element dieses Knotens.
	 * 
	 * @return den gespeicherten Element dieses Knotens.
	 */
	public E gibElement()
	{
		return _element;
	}

	/**
	 * Setze das (Daten-)Element dieses Knotens.
	 * 
	 * @param element
	 *            Ein Element.
	 */
	public void setzeTitel(E element)
	{
		_element = element;
	}

	/**
	 * Diese Methode faengt einen typischen Fehler ab, der in SE hin und wieder
	 * gemacht wird. Der Fehler tritt auf, wenn in der Klasse LinkedTitelListe
	 * versehentlich ein Kettenglied mit einem Element verglichen wird.
	 */
	public boolean equal(E element)
	{
		throw new IllegalArgumentException("Fehler: DoppelKnoten mit Element zu vergleichen ist nicht sinnvoll!");
	}
}
