package prog2.tp2_2017a;

import java.util.List;

public class TrieChar<V>
{
	private Nodo<V> raiz;
	private Alfabeto<Character> alf;

	public TrieChar(Alfabeto<Character> alf) 
	{
		this.raiz = new Nodo<V>(alf.tam());
		this.alf = alf;
	}

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

	public V obtener(String clave) 
	{
		return obtener(clave, raiz);
	}
	
	private V obtener(String clave, Nodo<V> nodoActual)
	{
		if(clave.equals(""))
			return nodoActual.val;
		
		Character caracterActual = clave.charAt(0);
		return obtener(clave.substring(1, clave.length()), nodoActual.hijo(alf.indice(caracterActual)));
	}
	
	public List<V> busqueda(String prefijo) 
	{
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
