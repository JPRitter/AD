/**
 * Eine Schnittstelle fuer lineare Listen. Eine Liste enthaelt eine Reihe von
 * Elementen.
 * 
 * @author PRitter
 * @version 10/2018
 *
 */
public interface ListenInter<E>
{
	public void fuegeEin(E element, int position);

	public void entferne(int position);

	public boolean enthaelt(E element);

	public E gibElement(int position);

	public int gibLaenge();

	public void leere();

}
