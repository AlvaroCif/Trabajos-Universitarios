package Modelodediseño.Presentacion.Controlador.comandos.Departamento;

import java.util.Collection;

import Modelodediseño.Negocio.Departamento.SADepartamento.SADepartamento;
import Modelodediseño.Negocio.Empleado.Empleado;
import Modelodediseño.Negocio.FactoriaSA.FactoriaSA;
import Modelodediseño.Presentacion.Controlador.comandos.Comando;
import Modelodediseño.Presentacion.Controlador.comandos.RespuestaComando;

public class ComandoEmpleadosPorDepartamento implements Comando
{
	
	private Object datos;
	
	static final int idVistas = 47;

	@Override
	public RespuestaComando execute() {
		// TODO Auto-generated method stub
		SADepartamento sa = FactoriaSA.getInstancia().crearSADepartamento();
		int id = (Integer) datos;
		Collection<Empleado> lista = sa.empleadosPorDepartamento(id);
		RespuestaComando rComando = new RespuestaComando ();
		rComando.setDatos(lista);
		rComando.setId(idVistas);
		return rComando;
	}

	@Override
	public void setdata(Object datos) {
		// TODO Auto-generated method stub
		this.datos = datos;
	}

}
