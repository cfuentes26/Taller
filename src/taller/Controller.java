/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiante
 */
public class Controller {

    Persona classroom[] = new Persona[1];
    Scanner sc = new Scanner(System.in);

    public Controller() {

        this.loadmenu();
    }

    public void loadmenu() {
        try {

            System.out.println("1.Crear Array\n "
                             + "2.Mostrar Array\n "
                             + "3.Salir");
            Scanner sc = new Scanner(System.in);

            this.optionselected(sc.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Opcion erronea");
        }
        this.loadmenu();
    }

    public void optionselected(int op) {

        switch (op) {

            case 1:

                this.createArray();

                break;
            case 2:
                try {

                    this.showArray();
                } catch (NullPointerException e) {
                }
                System.out.println("Arreglo vacio");
                this.loadmenu();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Introduzca una opcion valida");
                this.loadmenu();
                break;

        }

    }

    public void createArray() {
        for (int i = 0; i < classroom.length; i++) {

            System.out.println("Escribe un nombre");
            String nombre = sc.nextLine();

            System.out.println("Escribe un apellido");
            String apellido = sc.nextLine();
            System.out.println("Escriba fecha de nacimiento");
            String fecha_nacimiento = sc.nextLine();
            System.out.println("Escriba identificacion");
            String identificacion = sc.nextLine();
            System.out.println("Escriba el genero");
            String genero = sc.nextLine();
            System.out.println("Escriba una direccion");
            String direccion = sc.nextLine();
            System.out.println("Escriba un email");
            String email = sc.nextLine();
            System.out.println("Escriba un telefono");
            String telefono = sc.nextLine();
            System.out.println("Escriba un celular");
            String celular = sc.nextLine();

            classroom[i] = new Persona(nombre, apellido, fecha_nacimiento, identificacion, genero, direccion, email, telefono, celular);

        }
        this.loadmenu();
    }

    public void showArray() {
        for (int i = 0; i < classroom.length; i++) {

            System.out.println(classroom[i].getNombre() + "/" + classroom[i].getApellidos() + "/" + classroom[i].getFecha_nacimiento() + "/" + classroom[i].getIdentificacion() + "/" + classroom[i].getGenero() + "/" + classroom[i].getDireccion() + "/" + classroom[i].getEmail() + "/" + classroom[i].getTelefono() + "/" + classroom[i].getCelular());

        }
        this.loadmenu();
    }

}
