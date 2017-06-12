package prog2.tp2_2017a;

public class AlfabetoADN implements Alfabeto<Character> 
{
	private enum Base{A, C, G, T};

	@Override
	public int tam() { return 4; }

	@Override
	public int indice(Character c)
	{
		return Base.valueOf(c.toString()).ordinal();
	}
	
	@Override
	public boolean equals(Object o)
	{
		AlfabetoADN a2 = (AlfabetoADN) o;
		
		if(a2.tam() != tam())
			return false;
		
		boolean ret = true;
		for(int i=0; i<tam(); ++i)
		{
			ret = ret && this.getCaracter(i).equals(a2.getCaracter(i));
		}
		
		return ret;
	}
	
	private Character getCaracter(int i)
	{
		return (char) (i + '0');
	}
}
