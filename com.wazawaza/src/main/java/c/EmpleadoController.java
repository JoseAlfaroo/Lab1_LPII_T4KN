package c;

import org.hibernate.*;
import org.hibernate.cfg.*;

import m.EmpleadoModel;

public class EmpleadoController {
	
	
	@SuppressWarnings("deprecation")
	public String createEmpleado(String apellidos, String nombres, int edad, String sexo, Double salario) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmpleadoModel.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			EmpleadoModel empleado = new EmpleadoModel(apellidos, nombres, edad, sexo, salario);
			
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
			
			
			sessionFactory.close(); 
			
			return "Empleado " + nombres + " " + apellidos + " creado correctamente";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "No se puedo registrar al empleado.";
	}
	
	@SuppressWarnings("deprecation")
	public String deleteEmpleado(int idempleado) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmpleadoModel.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			EmpleadoModel empleado = session.get(EmpleadoModel.class, idempleado);
			session.delete(empleado);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Empleado " + idempleado + " eliminado correctamente";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "No se encontró al empleado " + idempleado;
	}
	
	@SuppressWarnings("deprecation")
	public String updateEmpleado(int idempleado, String apellidos, String nombres, int edad, String sexo, Double salario) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmpleadoModel.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {

			session.beginTransaction();
			EmpleadoModel empleado = session.get(EmpleadoModel.class, idempleado);
			empleado.setApellidos(apellidos);
			empleado.setNombres(nombres);
			empleado.setEdad(edad);
			empleado.setSexo(sexo);
			empleado.setSalario(salario);			
			session.update(empleado);
			session.getTransaction().commit();
			
			
			sessionFactory.close(); 
			
			return "Empleado " + idempleado + " actualizado con éxito" + "\n\n" +
					"Apellido: " + apellidos + "\n" +
					"Nombre: " + nombres + "\n" +
					"Edad: " + edad + "\n" +
					"Sexo: " + sexo + "\n" +
					"Salario: " + salario;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al actualizar empleado " + idempleado;
	}

	public String readEmpleado(int idempleado) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmpleadoModel.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			EmpleadoModel empleado = session.get(EmpleadoModel.class, idempleado);
			
			session.getTransaction().commit();
			sessionFactory.close();
			
			return empleado.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Empleado " + idempleado + " no encontrado";
	}
}