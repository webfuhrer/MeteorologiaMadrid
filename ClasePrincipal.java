package paquetemeteo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, ArrayList<Clima>> mapa= AccesoFichero.parsearXMLMeteo();
		Set<String> claves=mapa.keySet();
		Iterator it=claves.iterator();
		while(it.hasNext())
		{
			String clave=(String)it.next();
			System.out.println("*********************");
			System.out.println("Estacion: "+clave);
			 ArrayList<Clima> lista_climas=mapa.get(clave);
			 for (Clima clima : lista_climas) {
				System.out.println(clima);
			}
		}
		
	}

	

}
