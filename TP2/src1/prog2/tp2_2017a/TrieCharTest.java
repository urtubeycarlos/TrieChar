package prog2.tp2_2017a;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrieCharTest 
{
	@Test
	public void agregarTest()
	{
		Digitos digitos = new Digitos();
		TrieChar diccionario = new TrieChar(digitos);
		diccionario.agregar("12", "Harry Potter");
		diccionario.agregar("12232", "librakostosl");
		assertEquals(diccionario.obtener("12") , "Harry Potter");
		assertEquals(diccionario.obtener("12232"), "librakostosl");
	}

}
