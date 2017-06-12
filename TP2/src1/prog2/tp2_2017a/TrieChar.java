package prog2.tp2_2017a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TrieChar<V>
{
	private Nodo<V> raiz;
	private Alfabeto<Character> alf;
	private HashSet<String> claves;

	public TrieChar(Alfabeto<Character> alf) 
	{
		this.raiz = new Nodo<V>(alf.tam()); 
		this.alf = alf;
		this.claves = new HashSet<String>();
	}

	public void agregar(String clave, V valor) 
	{
		if (raiz == null)
			throw new RuntimeException ("No se ha podido agregar");
		
		agregar(clave, valor, raiz);
	}
	private void agregar (String clave , V valor, Nodo<V> nodo)
	{
		//caso base, encontramos el final
		if (clave.equals(""))
		{
			nodo.val = valor;
		}else{

			Character caracterActual = clave.charAt(0);
			int indice = alf.indice(caracterActual);
		
			//esta comparacion es valida? le mandamos un mail al profe?
			if (nodo.hijo(indice) != null)
			{
				agregar ( clave.substring(1) , valor , nodo.hijo(indice));
				
			}else {
				
				Nodo<V> nuevoHijo = new Nodo<V>(alf.tam());
				nodo.setHijo( indice, nuevoHijo );
				
				agregar ( clave.substring(1) , valor , nodo.hijo(indice) );
			}
		}
	}

	public V obtener(String clave) 
	{
		return obtener(clave, raiz);
	}
	
	private V obtener(String clave, Nodo<V> nodoActual)
	{
		if(clave.equals(""))
		{
			return nodoActual.val;
		}
		
		Character caracterActual = clave.charAt(0);
		int indice = alf.indice(caracterActual);

		return obtener(clave.substring(1) , nodoActual.hijo(indice) );
	}
	
	public List<V> busqueda(String prefijo) 
	{
		return busqueda (prefijo, raiz);
	}
	
	
	private ArrayList <V> obtenerTodos (Nodo<V> nodo , ArrayList<V> arreglo)
	{
		//tiene que tener complejidad O(c) donde C es la cantidad de claves
		//usar un for significaria que la complejidad es O (k), donde K es la cantidadd de letras del alfabeto
		//podriamos asumir que en el peor de los casos la cantidad de claves es cuando todos los array estan llenos
		//entonces O(c) == O (k)
		
		if (nodo.val != null)
		{
			arreglo.add(nodo.val);
		}
		
		for (int i=0 ; i<alf.tam(); i++)
		{
	
			if ( nodo.hijo(i) != null )
			{
				obtenerTodos ( nodo.hijo(i) , arreglo );
			}
		}
		
		return arreglo;
	}
	
	public List<V> busqueda(String prefijo, Nodo<V> nodo )
	{	
		ArrayList<V> listaClaves = new ArrayList<V>();
		
		if (prefijo.equals(""))
		{
			listaClaves = obtenerTodos( nodo , listaClaves );
			return listaClaves;
		}
		
		Character caracterActual = prefijo.charAt(0);
		return busqueda ( prefijo.substring(1) , nodo.hijo( alf.indice( caracterActual) ) );
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		
		@SuppressWarnings("unchecked")
		TrieChar<V> t2 = (TrieChar<V>) obj;
		
		if(!(alf.equals(t2.alf)))
			return false;
		
		if(claves.size() != t2.claves.size() || !claves.equals(t2.claves))
			return false;
		
		boolean ret = true;
		
		for(String c : claves)
		{
				ret = ret && this.obtener(c).equals(t2.obtener(c));
		}
		
		return ret;
	}
}
