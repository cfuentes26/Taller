/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author estudiante
 */
public class Controller {

    ArrayList<Persona> classroom = new ArrayList();
    ArrayList<MasaCorporal> historial = new ArrayList();

    static Scanner sc = new Scanner(System.in);

    public Controller() {

        this.loadmenu();
    }

    public void loadmenu() {
        try {
            System.out.println("*****************************************************");
            System.out.println("1.Crear Array\n"
                    + "2.Mostrar Array\n"
                    + "3.Historial Masa corporal\n"
                    + "4.Salir");
            System.out.println("*****************************************************");
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
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Arreglo vacio");
                    this.loadmenu();
                }

                break;
            case 3:

                System.out.println("*****************************************************");
                System.out.println("1.Agregar registro\n"
                        + "2.Mostrar historial\n");
                int opc = sc.nextInt();
                System.out.println("*****************************************************");

                switch (opc) {
                    case 1:
                        this.addhistorial();

                        break;
                    case 2:
                        try {
                            this.showhistorial();
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Arreglo vacio");
                            this.loadmenu();
                        }

                        break;
                    default:
                        System.out.println("Introduzca una opcion valida");
                        break;

                }

                break;
            case 4:
                System.exit(0);
                break;

            default:
                System.out.println("Introduzca una opcion valida");
                this.loadmenu();
                break;

        }

    }

    public void createArray() {
        int tam = 1;
        System.out.println("Ingrese tamaño");
        tam = sc.nextInt();

        System.out.println("*****************************************************");
        for (int i = 0; i < tam; i++) {
            System.out.println("*****************************************************");
            System.out.println("Escribe un nombre");
            String nombre = sc.nextLine();
            String nombrew = sc.nextLine();
            validatename(nombrew);

            System.out.println("*****************************************************");
            System.out.println("Escribe un apellido");

            String apellido = sc.nextLine();
            validatename(apellido);
            System.out.println("*****************************************************");
            System.out.println("Escriba fecha de nacimiento");

            String fecha_nacimiento = sc.nextLine();

            validatedate(fecha_nacimiento);
            System.out.println("*****************************************************");
            System.out.println("Escriba identificacion");

            String identificacion = sc.nextLine();
            validatenumber(identificacion);
            System.out.println("*****************************************************");
            System.out.println("Escriba el genero");

            String genero = sc.nextLine();
            System.out.println("*****************************************************");
            System.out.println("Escriba una direccion");

            String direccion = sc.nextLine();
            System.out.println("*****************************************************");
            System.out.println("Escriba un email");

            String email = sc.nextLine();
            validateEmail(email);
            System.out.println("*****************************************************");
            System.out.println("Escriba un telefono");
            String telefono = sc.nextLine();
            validatenumber(telefono);
            System.out.println("*****************************************************");
            System.out.println("Escriba un celular");
            String celular = sc.nextLine();
            validatenumber(celular);
            System.out.println("*****************************************************");
            classroom.add(new Persona(nombrew, apellido, fecha_nacimiento,
                    identificacion, genero, direccion, email, telefono, celular));

        }
        this.loadmenu();
    }

    public void showArray() {
        for (int i = 0; i <= classroom.size(); i++) {

            System.out.println(classroom.get(i).getNombre()
                    + "/" + classroom.get(i).getApellidos()
                    + "/" + classroom.get(i).getFecha_nacimiento()
                    + "/" + classroom.get(i).getIdentificacion()
                    + "/" + classroom.get(i).getGenero()
                    + "/" + classroom.get(i).getDireccion()
                    + "/" + classroom.get(i).getEmail()
                    + "/" + classroom.get(i).getTelefono()
                    + "/" + classroom.get(i).getCelular() + "\n");

        }
        this.loadmenu();
    }

    public void addhistorial() {
        int tam = 1;
        System.out.println("ingrese tamaño");
        tam = sc.nextInt();

        for (int i = 0; i <= tam; i++) {
            System.out.println("*****************************************************");
            System.out.println("Escriba peso");
            double peso = sc.nextDouble();
            System.out.println("*****************************************************");
            System.out.println("Escriba altura");
            double altura = sc.nextDouble();
            System.out.println("*****************************************************");
            double imc = calcularIMC(peso, altura);
            historial.add(new MasaCorporal(peso, altura, imc));

        }
    }

    public void showhistorial() {
        for (int i = 0; i < historial.size(); i++) {

            System.out.println(historial.get(i).getPeso()
                    + "/" + historial.get(i).getAltura()
                    + "/" + historial.get(i).getImc());

        }

    }

    public static boolean validateEmail(String email) {

        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            /*System.out.println("El email ingresado es válido.");*/
        } else {
            System.out.println("El email ingresado es inválido.");
            System.out.println("Escriba un nuevo email");
            email = sc.nextLine();
            validateEmail(email);

        }

        return mather.matches();

    }

    public static boolean validatedate(String fecha) {

        Pattern pattern = Pattern.compile("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$");

        Matcher mather = pattern.matcher(fecha);

        if (mather.find() == true) {
            /* System.out.println("La fecha es valida");*/
        } else {
            System.out.println("La fecha no es valida");
            System.out.println("Escriba una nueva fecha");
            fecha = sc.nextLine();
            validatedate(fecha);
        }

        return mather.matches();
    }

    public static boolean validatename(String nombre) {

        Pattern pt = Pattern.compile("[A-Za-z]+");
        Matcher mt = pt.matcher(nombre);
        if (mt.matches()) {
            /*System.out.println("Nombre validado correctamente");*/
        } else {
            System.out.println("opcion invalida");
            System.out.println("Escriba una nueva entrada");
            nombre = sc.nextLine();
            validatename(nombre);

        }
        return mt.matches();
    }

    public static boolean validatenumber(String number) {

        Pattern pt = Pattern.compile("[0-9]+");
        Matcher mt = pt.matcher(number);
        if (mt.matches()) {
            /*System.out.println("numero validado correctamente");*/
        } else {
            System.out.println("opcion invalida");
            System.out.println("Escriba una nueva entrada");
            number = sc.nextLine();
            validatenumber(number);

        }
        return mt.matches();
    }

    public static double calcularIMC(double peso, double altura) {
        double imc = peso / (altura * altura) * 10000;
        validarimc(imc);
        return imc;

    }

    public static void validarimc(double imc) {

        String clasificacion = "";
        if (imc < 16) {
            clasificacion = "Infrapeso: Delgadez severa";
        } else if (imc < 17) {
            clasificacion = "Infrapeso: Delgadez moderada";
        } else if (imc < 18.50) {
            clasificacion = "Infrapeso: Delgadez aceptable";
        } else if (imc < 25) {
            clasificacion = "Peso normal";
        } else if (imc < 30) {
            clasificacion = "Sobrepeso";
        } else if (imc < 35) {
            clasificacion = "Obeso: Tipo 1";
        } else if (imc < 40) {
            clasificacion = "Obeso: Tipo 2";
        } else {
            clasificacion = "Obeso: Tipo 3";
        }

        System.out.println("\nTu índice de masa corporal es: " + imc);
        System.out.println("Atendiendo al IMC, tiene: " + clasificacion);

    }

}
