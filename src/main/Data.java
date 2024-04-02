/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author gean3
 */
public class Data {

    static String[][] Animales = new String[100][4]; // 0)NombreID 1)Especie 2)Edad 3)AnimalID
    static int animalesAdd = 0;
    static String[][] Habitads = new String[100][5]; // 0)Nombre 1)TipoDeHambiente 2)CapacidadTot 3)CapacidadAct 4)HabitatID
    static int habitatsAdd = 0;

    public static void AnimalesData(String Nombre, String Especie, String Edad) {
        Animales[animalesAdd][0] = Nombre;
        Animales[animalesAdd][1] = Especie;
        Animales[animalesAdd][2] = Edad;
        Animales[animalesAdd][3] = String.valueOf(animalesAdd);
        //animalesAdd += 1;

        System.out.println(Animales[animalesAdd][0]);
        System.out.println(Animales[animalesAdd][1]);
        System.out.println(Animales[animalesAdd][2]);
        System.out.println(Animales[animalesAdd][3]);
        /*
        animalesAdd += 1;
        System.out.println("-----------------------");
        System.out.println(Animales[0][0]);
        System.out.println(Animales[0][1]);
        System.out.println(Animales[0][2]);
        System.out.println(Animales[0][3]);
        */
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        animalesAdd += 1;
 
    }

    public static void HabitatsData(String Nombre, String TipoH, String Capacidad, String CantActual) {
        Habitads[habitatsAdd][0] = Nombre;
        Habitads[habitatsAdd][1] = TipoH;
        Habitads[habitatsAdd][2] = Capacidad;
        Habitads[habitatsAdd][3] = CantActual;
        Habitads[habitatsAdd][4] = String.valueOf(habitatsAdd);
        //habitatsAdd += 1;
        
        
        System.out.println(Habitads[habitatsAdd][0]);
        System.out.println(Habitads[habitatsAdd][1]);
        System.out.println(Habitads[habitatsAdd][2]);
        System.out.println(Habitads[habitatsAdd][3]);
        System.out.println(Habitads[habitatsAdd][4]);
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        habitatsAdd += 1;
    }

}
