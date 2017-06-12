package prog2.tp2_2017a;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) 
	{
		Digitos digitos = new Digitos();
		TrieChar diccionario = new TrieChar(digitos);
		diccionario.agregar("12", "Harry Potter");
		diccionario.agregar("122", "Libro uno");
		diccionario.agregar("1232" , "librakoooo");
		diccionario.agregar("12232", "librakostosl");
		List lista = new ArrayList<String>();
		lista = diccionario.busqueda("1");
		for ( int i = 0 ; i < lista.size() ; i++){
			System.out.println("lisa pos"+i+" "+lista.get(i));
		}
	}

}
