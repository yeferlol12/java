/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poryectointegral;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.LocalTime;
import java.time.Duration;

public class PoryectoIntegral {
    
static Personal[] personal= new Personal[10];
static int numPersonas=0;


    public static void main(String[] args) {
    boolean[] person= new boolean[10];
          
          
int opcion;
        do {
            // Menú principal del programa, se muestra al usuario para que seleccione una opción

           String menu="""                        
                        
           Gestion de horarios
                       1.Registrar personal
                       2.Eliminar personal
                       3.Ver personas registradas
                       4.Ver horarios
                       5.Registrar hora de persona entrada
                       6.Registrar hora de salida persona
                       7.Calcular horas de persona
                       8.Salida""";

          // Se muestra el menú principal al usuario para que seleccione una opción
          opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {

                case 1:
                    // Llamada al método para registrar un nuevo personal
                    registrarPersonal();
                    break;
                case 2:
                    // Llamada al método para eliminar un personal registrado
                    elimarPersonal();
                    break;
                case 3:
                    // Llamada al método para ver la lista de personas registradas
                    verPersonasRegistradas();
                    break;
                case 4:
                    // Llamada al método para ver los horarios de las personas
                    verHorarios();
                    break;
                case 5:
                    // Llamada al método para registrar la hora de entrada de una persona
                    registrarHoraEntrada();
                    break;
                case 6:
                    // Llamada al método para registrar la hora de salida de una persona
                    registrarHoraSalida();
                    break;
                case 7:
                    // Llamada al método para calcular las horas trabajadas de una persona
                    calcularHorasPersona();
                    break;
                case 8:
                    // Mensaje de salida del sistema
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    throw new AssertionError();
            }
        } while (opcion !=8);
    }
    

    
    public static void registrarPersonal() {
        if (numPersonas< personal.length) {
            // Se crea un formulario para que el usuario ingrese los datos del nuevo personal
            JTextField nombreField=new JTextField();
            JTextField apelliField=new JTextField();
            JTextField cedulaField=new JTextField();
            JTextField fechaNacimientoField=new JTextField();
            JTextField direccionField=new JTextField();
            
            
            Object[] formulario={
                "Nombre",nombreField,
                "Apellido",apelliField,
                "Cedula",cedulaField,
                "Fecha de Nacimiento (YYYY-MM-DD",fechaNacimientoField,
                "Direccion",direccionField
            };
            
            // Se muestra el formulario al usuario para que ingrese los datos del nuevo personal
            int opcion = JOptionPane.showConfirmDialog(null, formulario,"registro de persona:",JOptionPane.OK_CANCEL_OPTION);
            if (opcion==JOptionPane.OK_OPTION) {
                // Se obtienen los datos ingresados por el usuario
                String nombre = nombreField.getText();
                String apellido =apelliField.getText();
                String cedula=cedulaField.getText();
                String fechaNacimiento = fechaNacimientoField.getText();
                String direccion = direccionField.getText();
                
                // Se crea un nuevo objeto de la clase Personal con los datos ingresados
              personal[numPersonas]=new Personal(nombre, apellido, cedula, fechaNacimiento, direccion);
                numPersonas++;

                // Se muestra un mensaje de confirmación al usuario con los datos ingresados
                JOptionPane.showMessageDialog(null,
                        "Usuario registrado con éxito:\n" +
                        "Nombre: " + nombre + " " + apellido + "\n" +
                        "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
                        "Cedula: " + cedula +"\n" +
                        "Dirección: " + direccion);
            }
        }
        else{
        JOptionPane.showMessageDialog(null, "No se pueden registrar más clientes.");
        }
    }
    
    public static void elimarPersonal() {
        if (numPersonas==0) {
            JOptionPane.showMessageDialog(null, "No hay personas para eliminar");
        }
        else{
            // Se muestra una lista de las personas registradas para que el usuario seleccione a quién eliminar
            StringBuilder personasEliminar=new StringBuilder("Persona a eliminar:\n");
            
            for (int i = 0; i < numPersonas; i++) {
                personasEliminar.append("Persona ").append(i+1).append(": ")
                .append(personal[i].getNombre()).append(" ")
                .append(personal[i].getApellido()).append("\n");
            }
            
            int personaAEliminar = Integer.parseInt(JOptionPane.showInputDialog(personasEliminar.toString()));
            if(personaAEliminar > 0 && personaAEliminar <= numPersonas){
                // Si el usuario selecciona a una persona válida, se elimina de la lista
                for(int i = personaAEliminar - 1; i < numPersonas - 1; i++){
                    personal[i] = personal[i + 1];
                }
                numPersonas--;
                JOptionPane.showMessageDialog(null, "Persona eliminada con éxito.");
            }else{
                JOptionPane.showMessageDialog(null, "Persona seleccionada no válida.");
            }
        }
    }
    
    public static void verPersonasRegistradas() {
        if (numPersonas==0) {
                    
           JOptionPane.showInputDialog("No hay clientes registrados");
        }
        else{
        // Se muestra una lista de las personas registradas
        StringBuilder listadoPersonas= new StringBuilder("Persona registrada:\n");
            for (int i = 0; i < numPersonas; i++) {
                listadoPersonas.append("Persona ").append(i+1).append(": ")
                .append(personal[i].getNombre()).append(" ")
                .append(personal[i].getApellido()).append(", ")
                .append("Cedula: ").append(personal[i].getCedula()).append(", ")
                .append("Fecha de Nacimiento: ").append(personal[i].getFechaNacimiento()).append(", ")        
                .append("Dirección: ").append(personal[i].getDireccion()).append("\n");
            }
        JOptionPane.showMessageDialog(null, listadoPersonas.toString());
        }
    }
    
    public static void verHorarios() {
        if (numPersonas==0) {
            JOptionPane.showMessageDialog(null, "No hay personas para ver horarios.");
        }
        else{
            // Se muestra una lista de los horarios de las personas
            StringBuilder horariosPersonas= new StringBuilder("Horarios de las personas:\n");
            for (int i = 0; i < numPersonas; i++) {
                horariosPersonas.append("Persona ").append(i+1).append(": ")
                .append(personal[i].getNombre()).append(" ")
                .append(personal[i].getApellido()).append("\n");
                // Aquí se deberían agregar los horarios, pero como no hay implementación de horarios, se omite.
            }
            JOptionPane.showMessageDialog(null, horariosPersonas.toString());
        }
    }
    
    public static void registrarHoraEntrada() {
        if (numPersonas==0) {
            JOptionPane.showMessageDialog(null, "No hay personas para registrar hora de entrada.");
        }
        else{
            // Se muestra una lista de las personas para que el usuario seleccione a quién registrar la hora de entrada
            StringBuilder personasEntrada=new StringBuilder("Persona para registrar hora de entrada:\n");
            
            for (int i = 0; i < numPersonas; i++) {
                personasEntrada.append("Persona ").append(i+1).append(": ")
                .append(personal[i].getNombre()).append(" ")
                .append(personal[i].getApellido()).append("\n");
            }
            
            int personaEntrada = Integer.parseInt(JOptionPane.showInputDialog(personasEntrada.toString()));
            if(personaEntrada > 0 && personaEntrada <= numPersonas){
                String horaEntrada = JOptionPane.showInputDialog("Ingrese la hora de entrada (HH:MM):");
                // Validar el formato de la hora (opcional)
                if (horaEntrada.matches("\\d{2}:\\d{2}")) {
                    personal[personaEntrada - 1].setHoraEntrada(horaEntrada); // Guardar la hora de entrada
                    JOptionPane.showMessageDialog(null, "Hora de entrada registrada con éxito: " + horaEntrada);
                } else {
                    JOptionPane.showMessageDialog(null, "Formato de hora no válido. Use HH:MM.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Persona seleccionada no válida.");
            }
        }
    }
    
    public static void registrarHoraSalida() {
        if (numPersonas == 0) {
            JOptionPane.showMessageDialog(null, "No hay personas para registrar hora de salida.");
        } else {
            // Se muestra una lista de las personas para que el usuario seleccione a quién registrar la hora de salida
            StringBuilder personasSalida = new StringBuilder("Persona para registrar hora de salida:\n");

            for (int i = 0; i < numPersonas; i++) {
                personasSalida.append("Persona ").append(i + 1).append(": ")
                    .append(personal[i].getNombre()).append(" ")
                    .append(personal[i].getApellido()).append("\n");
            }

            int personaSalida = Integer.parseInt(JOptionPane.showInputDialog(personasSalida.toString()));
            if (personaSalida > 0 && personaSalida <= numPersonas) {
                String horaSalida = JOptionPane.showInputDialog("Ingrese la hora de salida (HH:MM):");
                // Validar el formato de la hora (opcional)
                if (horaSalida.matches("\\d{2}:\\d{2}")) {
                    try {
                        // Verificar que la hora de salida sea posterior a la hora de entrada
                        String horaEntrada = personal[personaSalida - 1].getHoraEntrada();
                        if (horaEntrada != null) {
                            LocalTime entrada = LocalTime.parse(horaEntrada);
                            LocalTime salida = LocalTime.parse(horaSalida);
                            if (salida.isAfter(entrada)) {
                                personal[personaSalida - 1].setHoraSalida(horaSalida); // Guardar la hora de salida
                                JOptionPane.showMessageDialog(null, "Hora de salida registrada con éxito: " + horaSalida);
                            } else {
                                JOptionPane.showMessageDialog(null, "La hora de salida debe ser posterior a la hora de entrada.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Primero debe registrar la hora de entrada.");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al registrar la hora de salida: " + e.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Formato de hora no válido. Use HH:MM.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Persona seleccionada no válida.");
            }
        }
    }
    
    public static void calcularHorasPersona() {
        if (numPersonas == 0) {
            JOptionPane.showMessageDialog(null, "No hay personas para calcular horas.");
        } else {
            // Se muestra una lista de las personas para que el usuario seleccione a quién calcular las horas trabajadas
            StringBuilder personasHoras = new StringBuilder("Persona para calcular horas:\n");

            for (int i = 0; i < numPersonas; i++) {
                personasHoras.append("Persona ").append(i + 1).append(": ")
                    .append(personal[i].getNombre()).append(" ")
                    .append(personal[i].getApellido()).append("\n");
            }

            int personaHoras = Integer.parseInt(JOptionPane.showInputDialog(personasHoras.toString()));
            if (personaHoras > 0 && personaHoras <= numPersonas) {
                String horaEntrada = personal[personaHoras - 1].getHoraEntrada(); // Obtener la hora de entrada
                String horaSalida = personal[personaHoras - 1].getHoraSalida(); // Obtener la hora de salida
                
                // Lógica para calcular las horas trabajadas
                if (horaEntrada != null && horaSalida != null) {
                    // Convertir las horas a LocalTime para calcular la diferencia
                    LocalTime entrada = LocalTime.parse(horaEntrada);
                    LocalTime salida = LocalTime.parse(horaSalida);
                    long horasTrabajadas = Duration.between(entrada, salida).toHours();
                    JOptionPane.showMessageDialog(null, "Horas trabajadas: " + horasTrabajadas);
                } else {
                    JOptionPane.showMessageDialog(null, "Faltan horas de entrada o salida para calcular.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Persona seleccionada no válida.");
            }
        }
    }
    }
   

    
   
    class Personal {
    private String nombre;
    private String apellido;
    private String cedula;
    private String fechaNacimiento;
    private String direccion;
    private String horaEntrada; // Agregar campo para hora de entrada
    private String horaSalida; // Agregar campo para hora de salida
    
    public Personal(String nombre,String apellido,String cedula,String fechaNacimiento,String direccion){
        this.nombre=nombre;
        this.apellido=apellido;
        this.cedula=cedula;
        this.fechaNacimiento=fechaNacimiento;
        this.direccion=direccion;
    }
    
    public String getNombre(){
    return nombre;
    }
    
    public String getApellido(){
    return apellido;
    }
    
    public String getCedula(){
    return cedula;
    }
    
    public String getFechaNacimiento(){
    return fechaNacimiento;
    }
    
    public String getDireccion(){
    return direccion;
    }
    
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }
    

    
}
