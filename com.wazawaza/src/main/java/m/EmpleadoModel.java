package m;

import jakarta.persistence.*;


@Entity
@Table(name = "empleados")

public class EmpleadoModel {
	@Id
	@Column(name = "IdEmpleado")
	private int IdEmpleado;
	
	@Column(name = "Apellidos")
	private String Apellidos;
	
	@Column(name = "Nombres")
	private String Nombres;
	
	@Column(name = "Edad")
	private int Edad;
	
	@Column(name = "Sexo")
	private String Sexo;
	
	@Column(name = "Salario")
	private Double Salario;

	public EmpleadoModel() {
	}
	
	public EmpleadoModel(String apellidos, String nombres, int edad, String sexo, Double salario) {
		Apellidos = apellidos;
		Nombres = nombres;
		Edad = edad;
		Sexo = sexo;
		Salario = salario;
	}

	public int getIdEmpleado() {
		return IdEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		IdEmpleado = idEmpleado;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public Double getSalario() {
		return Salario;
	}

	public void setSalario(Double salario) {
		Salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [IdEmpleado=" + IdEmpleado + ", Apellidos=" + Apellidos + ", Nombres=" + Nombres + ", Edad="
				+ Edad + ", Sexo=" + Sexo + ", Salario=" + Salario + "]";
	}

}