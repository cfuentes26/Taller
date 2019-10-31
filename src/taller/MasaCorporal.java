/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

/**
 *
 * @author estudiante
 */
public class MasaCorporal {
     private int edad;
     private double peso;
     private double altura;
    
       private static double calcularIMC(double altura, double peso){
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
       }



