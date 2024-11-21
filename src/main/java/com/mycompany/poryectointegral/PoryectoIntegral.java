/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poryectointegral;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

public class PoryectoIntegral {
    
static Personal[] personal= new Personal[10];
static int numPersonas=0;


    public static void main(String[] args) {
    boolean[] person= new boolean[10];
          
          
int opcion;
        do {
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

          opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {

                case 1:
                    registrarPersonal();
                    break;
                case 2:
                    elimarPersonal();
                    break;
                case 3:
                    verPersonasRegistradas();
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    throw new AssertionError();
            }
        } while (opcion !=8);
    }
    

    
    public static void registrarPersonal() {
        if (numPersonas< personal.length) {
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
            
            int opcion = JOptionPane.showConfirmDialog(null, formulario,"registro de persona:",JOptionPane.OK_CANCEL_OPTION);
            if (opcion==JOptionPane.OK_OPTION) {
                String nombre = nombreField.getText();
                String apellido =apelliField.getText();
                String cedula=cedulaField.getText();
                String fechaNacimiento = fechaNacimientoField.getText();
                String direccion = direccionField.getText();
                
              personal[numPersonas]=new Personal(nombre, apellido, cedula, fechaNacimiento, direccion);
                numPersonas++;

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
            StringBuilder personasEliminar=new StringBuilder("Persona a eliminar:\n");
            
            for (int i = 0; i < numPersonas; i--) {
                personasEliminar.append("Persona").append(i-1).append(":")
                .append(personal[i].getNombre());
            }
        }
 JOptionPane.showInputDialog(personal.length);
        }
    
    public static void verPersonasRegistradas() {
        if (numPersonas==0) {
                    
           JOptionPane.showInputDialog("No hay clientes registrados");
        }
        else{
        StringBuilder listadoPersonas= new StringBuilder("Persona registrada:\n");
            for (int i = 0; i < numPersonas; i++) {
                listadoPersonas.append("persona: ").append(i+1).append(": ")
                .append(personal[i].getNombre()).append(" ")
                .append(personal[i].getApellido()).append(", ")
                .append("Cedula: ").append(personal[i].getCedula()).append(", ")
                .append("Fecha de Nacimiento: ").append(personal[i].getFechaNacimiento()).append(", ")        
                .append("Dirección: ").append(personal[i].getDireccion()).append("\n");
            }
        JOptionPane.showMessageDialog(null, listadoPersonas.toString());
        }
    }
    }
   

    
   
    class Personal {
    private String nombre;
    private String apellido;
    private String cedula;
    private String fechaNacimiento;
    private String direccion;
    
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
    

    
}

