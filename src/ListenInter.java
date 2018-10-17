/**
 * Eine Schnittstelle fuer lineare Listen. Eine Liste enthaelt eine Reihe von
 * Elementen.
 * 
 * @author J.P.Ritter & P.Aguilar Bremer
 * @version Oktober 2018
 *
 */
public interface ListenInter<E>
{
	/**
	 * Fuege ein Element an der Position position in die Liste ein. Alle folgenden
	 * Eintraege werden um eine Position verschoben. Wenn position gleich der Laenge
	 * der Liste ist, dann fuege das Element am Ende an.
	 * 
	 * @param element
	 *            Das einzufuegende Element (darf nicht null sein).
	 * @param position
	 *            Die Position, an welcher das Element eingefuegt werden soll.
	 */
	public void fuegeEin(E element, int position);

	/**
	 * Entferne das Element an der angegebenen Position. Alle folgenden Eintraege
	 * werden um eine Position verschoben.
	 * 
	 * @param position
	 *            Die Position des Elements, das entfernt werden soll.
	 */
	public void entferne(int position);

	/**
	 * Pruefe, ob ein Element in der Liste enthalten ist.
	 * 
	 * @param element
	 *            das Element, welches in der Liste gesucht werden soll.
	 * @return true wenn das Element in der Liste ist, ansonsten false.
	 */
	public boolean enthaelt(E element);

	/**
	 * Gibt das Element an der angegebenen Position zurueck.
	 * 
	 * @param position
	 *            Die Position des Elements, das zurueckgeben werden soll.
	 * @return Das Element an der Position.
	 */
	public E gibElement(int position);

	/**
	 * Gib die Laenge der Liste zurueck.
	 * 
	 * @return Anzahl der Elemente in der Liste.
	 */
	public int gibLaenge();

	/**
	 * Entferne alle Elemente aus der Liste.
	 */
	public void leere();

}
