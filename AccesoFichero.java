package paquetemeteo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AccesoFichero implements Constantes{

	public static Map<String, ArrayList<Clima>> parsearXMLMeteo() {
		// TODO Auto-generated method stub
		SAXBuilder constructor=new SAXBuilder();
		Map<String, ArrayList<Clima>>  mapa=new HashMap<String, ArrayList<Clima>>();
		try {
			Document d=constructor.build(new File(RUTA_FICHERO));
			Element elemento_raiz=d.getRootElement();
			List<Element> elementos_dato_horario=elemento_raiz.getChildren();
			for(int i=0; i<elementos_dato_horario.size(); i++)
			{
				Element elm_dato_horario=elementos_dato_horario.get(i);
				String estacion=elm_dato_horario.getChild("estacion").getValue();
				String magnitud=elm_dato_horario.getChild("magnitud").getValue();
				String h01=elm_dato_horario.getChild("H01").getValue();
				String h02=elm_dato_horario.getChild("H02").getValue();
				String h03=elm_dato_horario.getChild("H03").getValue();
				String[] valores= {h01, h02, h03};
				Clima c=new Clima(magnitud, valores);
				if (mapa.containsKey(estacion))
				{
					//Cojo9 el AL, le añado mi nuevo objeto Clima
					mapa.get(estacion).add(c);
				}
				else
				{
					//Creo el objeto con el AL con un solo objeto
					ArrayList<Clima> lista=new ArrayList<Clima>();
					lista.add(c);
					mapa.put(estacion, lista);
				}
				
				
			}
		
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapa;
	}

}
