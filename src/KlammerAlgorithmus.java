import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class KlammerAlgorithmus
{
	private Stack<String> _stack;
	int _ergebnis;
	
	public KlammerAlgorithmus()
	{
		_stack = new Stack<String>();	
		_ergebnis = 0;
	}
	
	/**
	 * Werte einen algebraischen Ausdruck ohne Berücksichtigung von Punkt- vor Strichrechnung aus
	 * Voraussetzungen: Operationen haben genau 2 Operanden, Ausdrücke sind vollständig geklammert und Operanden sind Zahlen
	 * oder Klammerausdrücke
	 * 
	 * @param algebraischerAusdruck Ein String der aus positiven Zahlen, Klammern und/oder Grundoperationen (+-*\/) besteht
	 */
	public String auswerten(String algebraischerAusdruck)
	{

		while(!algebraischerAusdruck.isEmpty())
		{
		while(algebraischerAusdruck.charAt(0) != ')')
		{
			_stack.push(algebraischerAusdruck.substring(0, 1));
			algebraischerAusdruck = algebraischerAusdruck.substring(1);
		}
		algebraischerAusdruck = algebraischerAusdruck.substring(1);
		String operand2 = "";
		String operand1 = "";                   
		String operator = "";
		
        while(_stack.top().matches("\\d+"))
        {
        	operand2 = _stack.pop() + operand2; 
        }
        operator = _stack.pop();
        while(!_stack.top().equals("("))
        {
        	operand1 = _stack.pop() + operand1;       	
        }
        if(!(operand1.matches("-?\\d+") && operand2.matches("-?\\d+") && operator.matches("[\\*\\+-/]")))
        {
        	throw new IllegalArgumentException("ungültiger Ausdruck");
        }
        _stack.pop();
        
        switch(operator)
        {
        case "+":
        	_ergebnis = Integer.parseInt(operand1) + Integer.parseInt(operand2);
        	break;
        case "-":
        	_ergebnis = Integer.parseInt(operand1) - Integer.parseInt(operand2);
        	break;
        case "*":
        	_ergebnis = Integer.parseInt(operand1) * Integer.parseInt(operand2);
        	break;
        case "/":
        	_ergebnis = Integer.parseInt(operand1) / Integer.parseInt(operand2);
        	break;     
        }
        _stack.push(String.valueOf(_ergebnis));
		}
		String ergebnis = _stack.pop();
		if(!_stack.isEmpty())
		{
			throw new IllegalArgumentException("Zu viele Klammern");
		}
		return ergebnis;
	}

	 public static void main(String[] args) throws IOException
	  {
		KlammerAlgorithmus a = new KlammerAlgorithmus();
	    InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    System.out.print("Gib was ein: ");
	    String eingabe = br.readLine();
	    System.out.println("Ergebnis: " + a.auswerten(eingabe));
	  }
}
