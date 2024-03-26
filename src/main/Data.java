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
    static String[][] Animales = new String[100][4]; // 0)NombreID 1)Especie 2)Edad 3)HabitadID
    static int animalesAdd = 0;
    static String[][] Habitads = new String[100][4]; // 0)Nombre 1)TipoDeHambiente 2)CapacidadTot 3)CapacidadAct
    static int habitatsAdd = 0;
    public static void AnimalesData(String Nombre, String Especie, String Edad, String HabitadID) {
        Animales[animalesAdd][0] = Nombre;
        Animales[animalesAdd][1] = Especie;
        Animales[animalesAdd][2] = Edad;
        Animales[animalesAdd][3] = HabitadID;
        animalesAdd += 1;
        
        /*System.out.println(Animales[animalesAdd][0]);
        System.out.println(Animales[animalesAdd][1]);
        System.out.println(Animales[animalesAdd][2]);
        System.out.println(Animales[animalesAdd][3]);
        animalesAdd += 1;
        System.out.println("-----------------------");
        System.out.println(Animales[0][0]);
        System.out.println(Animales[0][1]);
        System.out.println(Animales[0][2]);
        System.out.println(Animales[0][3]);
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        */
        
    }
    public void HabitatsData() {
        
    }
    
    
}
