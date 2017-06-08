package prog2.tp2_2017a;

import java.util.List;

public class TrieChar<V>
{
	private Nodo<V> raiz;
	private Alfabeto<Character> alf;

	public TrieChar(Alfabeto<Character> alf) 
	{
		//hay que preguntarle al profe si podemos lo siguiente:
		this.raiz = new Nodo<V>(alf.tam()); //nosotro agregamos esto, podemos?
		this.alf = alf;
	}

	public void agregar(String clave, V valor) 
	{
		if ( raiz == null){
			throw new RuntimeException ( "no se ha podido agregar");
		}
		agregar ( clave , valor , raiz);
		
	}
	private void agregar ( String clave , V valor , Nodo<V> nodo)
	{
		//caso base, encontramos el final
		if ( clave.equals("") ){
			nodo.val = valor;
			
		}else{

			Character caracterActual = clave.charAt(0);
			int indice = alf.indice(caracterActual);
		
			//esta comparacion es valida? le mandamos un mail al profe?
			//siempre que los nodos existan
			if ( nodo.hijo(indice) != null ){
				// substring (1) , ingnoramos el primer valor
				agregar ( clave.substring(1) , valor , nodo.hijo(indice));
			}else{
				Nodo<V> nuevoHijo = new Nodo<V>( alf.tam() );
				nodo.setHijo(indice, nuevoHijo);
				agregar ( clave.substring(1) , valor , nodo.hijo(indice));
			}
		//throw new RuntimeException("cannot resolve");
	}
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
//	public static void main ( String [] args ){
//
//		Digitos digitos = new Digitos();
//		TrieChar diccionario = new TrieChar(digitos);
//		diccionario.agregar("12", "Harry Potter");
//		System.out.println(diccionario.obtener("12"));
//		
//	}
}
