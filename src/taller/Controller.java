/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
   
    ArrayList<Persona> classroom = new ArrayList();
      ArrayList<MasaCorporal> historial = new ArrayList();

    static Scanner sc = new Scanner(System.in);

    public Controller() {

        this.loadmenu();
    }

    public void loadmenu() {
        try {

            System.out.println("1.Crear Array\n "
                             + "2.Mostrar Array\n "
                             + "3.Historial masa corporal\n"
                             + "4.Salir");
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
                }
                System.out.println("Arreglo vacio");
                this.loadmenu();
                break;
            case 3:
          System.out.println("Escribe peso");
          double peso = sc.nextDouble();
           System.out.println("Escrube altura");
            double altura = sc.nextDouble();
           historial.add(new MasaCorporal( peso, altura));
            double imc = calcularIMC(altura, peso);
                this.validarimc(imc);
             
                ;
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
       
/*String nombre=JOptionPane.showInputDialog("Escribe un nombre");*/
            System.out.println("Escribe un nombre");
            String nombre = sc.nextLine();

            System.out.println("Escribe un apellido");
            String apellido = sc.nextLine();
            System.out.println("Escriba fecha de nacimiento");
            String fecha_nacimiento = sc.nextLine();
            validatedate(fecha_nacimiento);
            System.out.println("Escriba identificacion");
            String identificacion = sc.nextLine();
            System.out.println("Escriba el genero");
            String genero = sc.nextLine();
            System.out.println("Escriba una direccion");
            String direccion = sc.nextLine();
            System.out.println("Escriba un email");
            String email = sc.nextLine();
            validateEmail(email);
            
            System.out.println("Escriba un telefono");
            String telefono = sc.nextLine();
            System.out.println("Escriba un celular");
            String celular = sc.nextLine();
            classroom.add(new Persona(nombre, apellido, fecha_nacimiento, 
                    identificacion, genero, direccion,email , telefono, celular));
            
        
        this.loadmenu();
    }

    public void showArray() {
        for (int i = 0; i <= classroom.size(); i++) {

            System.out.println(classroom.get(i).getNombre() + "/" + classroom.get(i).getApellidos() + "/" + classroom.get(i).getFecha_nacimiento() + "/" + classroom.get(i).getIdentificacion() + "/" + classroom.get(i).getGenero() + "/" + classroom.get(i).getDireccion() + "/" + classroom.get(i).getEmail() + "/" + classroom.get(i).getTelefono() + "/" + classroom.get(i).getCelular());
            
         
        }
        this.loadmenu();
    }
 
          public static boolean validateEmail(String email){
     
     Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            System.out.println("El email ingresado es válido." );
        } else {
            System.out.println("El email ingresado es inválido.");
            System.out.println("escriba un nuevo email");
            email=sc.nextLine();
            validateEmail(email);
           
        }
        
        return mather.matches();
    
}
        public static boolean validatedate(String fecha) {
        boolean res=true;
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
            if(res==true){
            System.out.println("La fecha es valida");
             }else
                 System.out.println("La fecha no es valida");
        } catch (ParseException e) {
            return false;
        }
        return true;
        }  
        
        public void showdate(){
                      String fecha;
       
   
        System.out.println("Dame la fecha");
         boolean res=true;
        res=validatedate(sc.nextLine());
        if(res==true){
            System.out.println("La fecha es valida");
             }else
                 System.out.println("La fecha no es valida");
         }
        
    /**
     *
     */
    public int calculateEdad() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(sc.nextLine(), fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);

    
           return periodo.getYears();
    }
       
    
    public static double calcularIMC(double altura, double peso){
        double imc = peso/(Math.pow(altura, 2));
        return Math.rint(imc*100)/100;
        
    }
       public void validarimc(double imc){
          
           String clasificacion = "";
           if(imc < 16){
            clasificacion = "Infrapeso: Delgadez severa";
        } else if(imc < 17){
            clasificacion = "Infrapeso: Delgadez moderada";
        } else if(imc < 18.50){
            clasificacion = "Infrapeso: Delgadez aceptable";
        } else if(imc < 25){
            clasificacion = "Peso normal";
        } else if(imc < 30){
            clasificacion = "Sobrepeso";
        } else if(imc < 35){
            clasificacion = "Obeso: Tipo 1";
        } else if(imc < 40){
            clasificacion = "Obeso: Tipo 2";
        } else {
            clasificacion = "Obeso: Tipo 3";
        }
 
        System.out.println("\nTu índice de masa corporal es: " + imc);
        System.out.println("Atendiendo al IMC, tiene: " + clasificacion);
 
    }
        
     
    /*private  static Object[]  deleteArray (Object[] arrayObjetos, int i) {
    Object[] nuevoArray = new Object[arrayObjetos.length - 1];
     if (i > 0){
           System.arraycopy(arrayObjetos, 0, nuevoArray, 0, i);
     }
     if (nuevoArray.length > i){
      System.arraycopy(arrayObjetos, i + 1, nuevoArray, i, nuevoArray.length - i);
     }
     return nuevoArray;
   }*/
}
