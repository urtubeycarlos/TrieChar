package prog2.tp2_2017a;

import java.util.List;

public class TrieChar<V>
{
	private Nodo<V> raiz;
	private Alfabeto<Character> alf;

	public TrieChar(Alfabeto<Character> alf) {
		this.alf = alf;
	}

	/**
	 * Agrega una cadena a la estructura, asociándole un determinado valor.
	 *
	 * Si la clave ya existía, se reemplaza su valor asociado.
	 */
	public void agregar(String clave, V valor) 
	{
		int i = 0;
		Nodo<V> nodo = raiz; 
		while(i > 0)
		{
			int indice = alf.indice(clave.charAt(i));
			nodo = raiz.hijo(indice);
			++i;
		}
		
		nodo.val = valor;
	}

	/**
	 * Devuelve el valor asociado a una clave, o null si no existe.
	 */
	public V obtener(String clave) {
		return null;
	}

	/**
	 * Devuelve una lista con todos los valores cuyas claves
	 * empiezan por un determinado prefijo.
	 */
	public List<V> busqueda(String prefijo) {
		return null;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return false;
	}
	
	public Nodo<V> getRaiz()
	{
		return raiz;
	}
}
