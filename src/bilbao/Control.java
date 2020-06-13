package bilbao;
import java.util.Vector;

public class Control {

	public Vector <Avion> listadoAviones = new Vector<Avion>(new MySql().rellenarLista());
	public Vector <Avion> llegadaAviones = new Vector<Avion>(new MySql().listadollegadas());




}
