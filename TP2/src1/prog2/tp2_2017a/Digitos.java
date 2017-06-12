package prog2.tp2_2017a;

/**
 * Alfabeto de ejemplo.
 */
public class Digitos implements Alfabeto<Character>
{
	@Override
	public int tam() { return 10; }

	@Override
	public int indice(Character c) {
		// Se implementa basándose en el valor ASCII de char.
		// Los caracteres '0' a '9' son adyacentes en la tabla
		// ASCII, por lo que sus valores son contiguos.
		if (c >= '0' && c <= '9')
			return c - '0';

		throw new RuntimeException("digito no válido: " + c);
	}
	
	@Override
	public boolean equals(Object o)
	{
		Digitos d2 = (Digitos) o;
		
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
		return (char) (i + '0');
	}
}
