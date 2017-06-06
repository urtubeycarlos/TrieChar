package prog2.tp2_2017a;

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
}
