/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JOptionPane;

/**
 *
 * @author gean3
 */
public class Data {

    static String[][] Animales = new String[100][4]; // 0)NombreID 1)Especie 2)Edad 3)AnimalID
    static int animalesAdd = 0;
    static int animalesID = 0;
    static String[][] Habitads = new String[100][5]; // 0)Nombre 1)TipoDeHambiente 2)CapacidadTot 3)CapacidadAct 4)HabitatID
    static int habitatsAdd = 0;
    static int habitatsID = 0;

    public static void DefauldDataAnimales(String Nombre, String Especie, String Edad) {
        Animales[animalesAdd][0] = Nombre;
        Animales[animalesAdd][1] = Especie;
        Animales[animalesAdd][2] = Edad;
        Animales[animalesAdd][3] = String.valueOf(animalesID);
        animalesAdd += 1;
        animalesID += 1;
    }

    public static void DefauldDataHabitats(String Nombre, String TipoH, String Capacidad, String CantActual) {
        Habitads[habitatsAdd][0] = Nombre;
        Habitads[habitatsAdd][1] = TipoH;
        Habitads[habitatsAdd][2] = Capacidad;
        Habitads[habitatsAdd][3] = CantActual;
        Habitads[habitatsAdd][4] = String.valueOf(habitatsID);
        habitatsAdd += 1;
        habitatsID += 1;
    }

    public static void AnimalesData(String Nombre, String Especie, String Edad) {
        Animales[animalesAdd][0] = Nombre;
        Animales[animalesAdd][1] = Especie;
        Animales[animalesAdd][2] = Edad;
        Animales[animalesAdd][3] = String.valueOf(animalesID);
        //animalesAdd += 1;
        //animalesID += 1;
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
        animalesID += 1;

    }

    public static void HabitatsData(String Nombre, String TipoH, String Capacidad, String CantActual) {
        Habitads[habitatsAdd][0] = Nombre;
        Habitads[habitatsAdd][1] = TipoH;
        Habitads[habitatsAdd][2] = Capacidad;
        Habitads[habitatsAdd][3] = CantActual;
        Habitads[habitatsAdd][4] = String.valueOf(habitatsID); //ID
        JOptionPane.showMessageDialog(null, "Datos agregados correctamente");
        //habitatsAdd += 1;
        //habitatsID += 1;

        System.out.println(Habitads[habitatsAdd][0]);
        System.out.println(Habitads[habitatsAdd][1]);
        System.out.println(Habitads[habitatsAdd][2]);
        System.out.println(Habitads[habitatsAdd][3]);
        System.out.println(Habitads[habitatsAdd][4]);
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        habitatsAdd += 1;
        habitatsID += 1;
    }

    public static void HabitatsDataModify(String Nombre, String TipoH, String Capacidad, int ID) {
        Habitads[ID][0] = Nombre;
        Habitads[ID][1] = TipoH;
        Habitads[ID][2] = Capacidad;
        JOptionPane.showMessageDialog(null, "Datos agregados correctamente");

        System.out.println(Habitads[ID][0]);
        System.out.println(Habitads[ID][1]);
        System.out.println(Habitads[ID][2]);
        System.out.println(Habitads[ID][3]);
        System.out.println(Habitads[ID][4]);
        System.out.println("-----------------------");
        System.out.println("-----------------------");
    }

    public static void HabitatsDataSearch(String Searching, int type) { // Types: 1Nombre)  2)Habitad  3)ID // 0)Nombre 1)TipoDeHambiente 2)CapacidadTot 3)CapacidadAct 4)HabitatID
        String Display = "";
        for (int x = 0; x < habitatsAdd; x++) {
            switch (type) {
                case 1:
                    String Name = Habitads[x][0];
                    if (Searching.equals(Name)) {
                        Display += "Nombre: " + Habitads[x][0] + "\nTipo de habitat: " + Habitads[x][1] + "\nCapacidad: " + Habitads[x][3] + " / " + Habitads[x][2] + "\nID del habitat: " + Habitads[x][4];
                        Display += "\n-----------------------\n";
                    }
                    break;
                case 2:
                    String Habitat = Habitads[x][1];
                    if (Searching.equals(Habitat)) {
                        Display += "Nombre: " + Habitads[x][0] + "\nTipo de habitat: " + Habitads[x][1] + "\nCapacidad: " + Habitads[x][3] + " / " + Habitads[x][2] + "\nID del habitat: " + Habitads[x][4];
                        Display += "\n-----------------------\n";
                    }
                    break;
                case 3:
                    String ID = Habitads[x][4];
                    if (Searching.equals(ID)) {
                        Display += "Nombre: " + Habitads[x][0] + "\nTipo de habitat: " + Habitads[x][1] + "\nCapacidad: " + Habitads[x][3] + " / " + Habitads[x][2] + "\nID del habitat: " + Habitads[x][4];
                        Display += "\n-----------------------\n";
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (Display.equals("")) {
            Display = "No se han encontrado datos";
        }
        JOptionPane.showMessageDialog(null, Display);
    }

    public static void HabitatsDataDelete() {
        String deleteID = JOptionPane.showInputDialog("Ingrese el ID del habitat a eliminar");
        for (int x = 0; x < habitatsAdd; x++) {
            String ID = Habitads[x][4];
            if (deleteID.equals(ID)) {
                for (int y = x; y < habitatsAdd; y++) {
                    Habitads[y][0] = Habitads[(y+1)][0];
                    Habitads[y][1] = Habitads[(y+1)][1];
                    Habitads[y][2] = Habitads[(y+1)][2];
                    Habitads[y][3] = Habitads[(y+1)][3];
                    Habitads[y][4] = Habitads[(y+1)][4]; //ID
                }
                x -= 1;
                habitatsAdd -= 1;
                JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
            }
            

        }
        
    }

}
