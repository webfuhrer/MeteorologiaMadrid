package paquetemeteo;

import java.util.Arrays;

public class Clima {
private String magnitud;
private String[] valores=new String[3];
public Clima(String magnitud, String[] valores) {
	super();
	this.magnitud = magnitud;
	this.valores = valores;
}
@Override
public String toString() {
	return "magnitud=" + magnitud + ", valores=" + Arrays.toString(valores) ;
}

}
