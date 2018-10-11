public class Main
{
	public static void main(String[] args)
	{
		ArrayListe<String> list = new ArrayListe<String>(); 
		list.fuegeEin("was", 0);
		for(int i = 0; i < 10; i++) 
		{
			list.fuegeEin(""+ i, 0);
		}
		System.out.print (list.gibLaenge());
		list.schreibeAufKonsole();	
		
		LinkedListe<Integer> liste = new LinkedListe<Integer>(); 
		liste.fuegeEin(77, 0);
		for(int i = 0; i < 10; i++) 
		{
			liste.fuegeEin(i, 0);
		}
		for(int i = 0; i < liste.gibLaenge(); i++) 
		{
			System.out.print (liste.gibElement(i));
		}
		
	}
}
