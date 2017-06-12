package prog2.tp2_2017a;

//FIXME: Es un copy-paste de Digitos!!!

public class Palabras implements Alfabeto<Character>
{
	
	@Override
	public int tam() { return 27; }

	@Override
	public int indice(Character elem) 
	{
		if (elem >= '0' && elem <= '9')
			return elem - '0';

		throw new RuntimeException("digito no válido: " + elem);
	}
	
	@Override
	public boolean equals(Object o)
	{
		Palabras d2 = (Palabras) o;
		
		if(d2.tam() != tam())
			return false;
		
		boolean ret = true;
		for(int i=0; i<tam(); ++i)
		{
			ret = ret && this.getCaracter(i).equals(d2.getCaracter(i));
		}
		
		return ret;
	}
	
	private Character getCaracter(int i)
	{
		if(i < 0 || i > tam())
			throw new IllegalArgumentException("Indice fuera de rango");
		
		return (char) (i + '0');
	}
}
