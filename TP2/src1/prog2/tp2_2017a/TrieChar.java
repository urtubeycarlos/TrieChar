package prog2.tp2_2017a;

import java.util.ArrayList;
import java.util.List;

public class TrieChar<V>
{
	private Nodo<V> raiz;
	private Alfabeto<Character> alf;
	//agregar el private claves Hashset

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
			if ( nodo.hijo(indice) != null ){
				
				agregar ( clave.substring(1) , valor , nodo.hijo(indice));
				
			}else {
				
				Nodo<V> nuevoHijo = new Nodo<V>( alf.tam() );
				
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
	
	public List<V> busqueda(String prefijo) {
		return busqueda ( prefijo  , raiz );
	}
	
	//private o public ??? queda a tu gusto.. creo q mejor private, no?
	public ArrayList <V> ObtenerTodos ( Nodo<V> nodo , ArrayList<V> array ){
		//tiene que tener complejidad O(c) donde C es la cantidad de claves
		//usar un for significaria que la complejidad es O (k), donde K es la cantidadd de letras del alfabeto
		//podriamos asumir que en el peor de los casos la cantidad de claves es cuando todos los array estan llenos
		//entonces O(c) == O (k)
		
		if ( nodo.val != null ){
			array.add(nodo.val);
		}
		
		for ( int i = 0 ; i < alf.tam() ; i++ ){
	
			if ( nodo.hijo(i) != null ){
				ObtenerTodos ( nodo.hijo(i) , array );
			}
		}
		
		return array;
	}
	
	public List<V> busqueda(String prefijo, Nodo<V> nodo ) {
		
		ArrayList<V> listaclaves = new ArrayList<V> ();
		
		if ( prefijo.equals("") ){
			
			listaclaves = ObtenerTodos( nodo , listaclaves );
			return listaclaves;
		}
		
		Character caracterActual = prefijo.charAt(0);
		return busqueda ( prefijo.substring(1) , nodo.hijo( alf.indice( caracterActual) ) );
	
	}
	
	// boolean equals, agregado por nosotros.
	@Override
	public boolean equals(Object obj)
	{
		return false;
	}
	// hay q sacar el getraiz() despues!!
	public Nodo<V> getRaiz()
	{
		return raiz;
	}
	public static void main ( String [] args ){

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
