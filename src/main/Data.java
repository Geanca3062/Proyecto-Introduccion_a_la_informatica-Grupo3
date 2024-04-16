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

    static String[][] Animales = new String[100][6]; // 0)Nombre 1)Especie 2)Edad 3)Habitat 4)HabitatID 5)AnimalID ...
    static int animalesAdd = 0;
    static int animalesID = 0;
    static String[][] Habitads = new String[100][5]; // 0)Nombre 1)TipoDeHambiente 2)CapacidadTot 3)CapacidadAct 4)HabitatID
    static int habitatsAdd = 0;
    static int habitatsID = 0;
    static String[][] GestionAlimentacion = new String[100][4];
    static int GestionAdd = 0;
    static String[][] eventos = new String[100][4];
    static int cantidadEventos = 0;

    public static void DefauldDataAnimales(String Nombre, String Especie, String Edad) {
        Animales[animalesAdd][0] = Nombre;
        Animales[animalesAdd][1] = Especie;
        Animales[animalesAdd][2] = Edad;
        Animales[animalesAdd][3] = "Sabana1";
        Animales[animalesAdd][4] = "0";
        Animales[animalesAdd][5] = String.valueOf(animalesID);
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

    public static void AnimalesData(String Nombre, String Especie, String Edad, String Habitat) {
        for (int x = 0; x < habitatsAdd; x++) {
            String ID = Habitads[x][4];
            if (Habitat.equals(ID)) {// Busca el habitat con el mismo ID
                int CantActual = Integer.parseInt(Habitads[x][3]);
                int CantTot = Integer.parseInt(Habitads[x][2]);
                if (CantActual >= CantTot) { //Verifica si esta lleno, si no esta lleno, carga los datos del animal
                    JOptionPane.showMessageDialog(null, "El habitat seleccionado esta lleno");
                } else {
                    Animales[animalesAdd][0] = Nombre;
                    Animales[animalesAdd][1] = Especie;
                    Animales[animalesAdd][2] = Edad;
                    Animales[animalesAdd][3] = Habitads[x][0]; //Nombre del habitat
                    Animales[animalesAdd][4] = Habitads[x][4]; //ID del habitat
                    Animales[animalesAdd][5] = String.valueOf(animalesID);

                    Habitads[x][3] = String.valueOf((CantActual + 1));
                    JOptionPane.showMessageDialog(null, "Datos agregados correctamente");
                    animalesAdd += 1;
                    animalesID += 1;
                }
            }
        }

        /*
        //animalesAdd += 1;
        //animalesID += 1;
        System.out.println(Animales[animalesAdd - 1][0]);
        System.out.println(Animales[animalesAdd - 1][1]);
        System.out.println(Animales[animalesAdd - 1][2]);
        System.out.println(Animales[animalesAdd - 1][3]);
        System.out.println(Animales[animalesAdd - 1][4]);
        System.out.println(Animales[animalesAdd - 1][5]);
        /*
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

    public static void AnimalesDataDelete() {
        String deleteID = JOptionPane.showInputDialog("Ingrese el ID del animal a eliminar");
        boolean find = false;
        for (int x = 0; x < animalesAdd; x++) {
            String ID = Animales[x][5]; //ID del animal
            String HabitatID = Animales[x][4]; //ID del habitat donde esta el animal
            if (deleteID.equals(ID)) {// Busca el habitat con el mismo ID
                for (int y = x; y <= animalesAdd; y++) {
                    Animales[y][0] = Animales[(y + 1)][0]; //Nombre
                    Animales[y][1] = Animales[(y + 1)][1]; // Especie
                    Animales[y][2] = Animales[(y + 1)][2]; //Edad
                    Animales[y][3] = Animales[(y + 1)][3]; //Habitat
                    Animales[y][4] = Animales[(y + 1)][4]; //HabitatID
                    Animales[y][5] = Animales[(y + 1)][5]; //AnimalID
                    find = true;
                }
                x -= 1;
                animalesAdd -= 1;
                for (int z = 0; z < habitatsAdd; z++) {
                    ID = Habitads[z][4];
                    if (HabitatID.equals(ID)) {
                        int CantActual = Integer.parseInt(Habitads[z][3]); //Cantidad actual de animales en el habitat
                        Habitads[z][3] = String.valueOf((CantActual - 1));
                    }
                }
                //Habitads[z][3] = String.valueOf((CantActual - 1));
                JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
            }
        }
        if (find == false) {
            JOptionPane.showMessageDialog(null, "Dato no encontrado");
        }
    }

    public static void AnimalesDataModify(String Nombre, String Especie, String Edad, String HabitatID, String AnimalID) { //0)Nombre 1)Especie 2)Edad 3)Habitat 4)HabitatID 5)AnimalID
        for (int x = 0; x < animalesAdd; x++) {                                                                            // 0)Nombre 1)TipoDeHambiente 2)CapacidadTot 3)CapacidadAct 4)HabitatID
            String ID = Animales[x][5]; //Se confirma el ID del animal a modificar
            if (AnimalID.equals(ID)) {
                String habitat = Animales[x][4]; //INdica el ID del habitat donde vive el animal en estos momentos
                if (HabitatID.equals(habitat)) {// Verifica si el animal se mantiene en el mismo habitat
                    Animales[x][0] = Nombre;
                    Animales[x][1] = Especie;
                    Animales[x][2] = Edad;
                    JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
                } else {//Si el animal se cambia de habitat, se verifica si hay espacio en el nuevo
                    for (int y = 0; y < habitatsAdd; y++) {
                        ID = Habitads[y][4];
                        if (HabitatID.equals(ID)) {//Se busca el nuevo habitat
                            int CantActual = Integer.parseInt(Habitads[y][3]);
                            int CantTot = Integer.parseInt(Habitads[y][2]);
                            if (CantActual >= CantTot) { //Verifica si esta lleno, si no esta lleno, carga los datos del animal
                                JOptionPane.showMessageDialog(null, "El nuevo habitat seleccionado esta lleno");
                            } else {
                                Animales[x][0] = Nombre;
                                Animales[x][1] = Especie;
                                Animales[x][2] = Edad;
                                Animales[x][3] = Habitads[y][0]; //Nombre del habitat
                                Animales[x][4] = HabitatID;
                                JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
                            }
                        }
                    }
                }
            }
        }
    }

    public static void AnimalesDataSearch(String Searching, int type) {
        String Display = "";
        for (int x = 0; x < animalesAdd; x++) {//0)Nombre 1)Especie 2)Edad 3)Habitat 4)HabitatID 5)AnimalID
            switch (type) {
                case 1:
                    String Name = Animales[x][0];
                    if (Searching.equals(Name)) {
                        Display += "Nombre: " + Animales[x][0] + "\nEspecie: " + Animales[x][1] + "\nEdad: " + Animales[x][2] + "\nHabitat: " + Animales[x][3] + "\nAnimal ID: " + Animales[x][5];
                        Display += "\n-----------------------\n";
                    }
                    break;
                case 2:
                    String Especie = Animales[x][1];
                    if (Searching.equals(Especie)) {
                        Display += "Nombre: " + Animales[x][0] + "\nEspecie: " + Animales[x][1] + "\nEdad: " + Animales[x][2] + "\nHabitat: " + Animales[x][3] + "\nAnimal ID: " + Animales[x][5];
                        Display += "\n-----------------------\n";
                    }
                    break;
                case 3:
                    String Edad = Animales[x][2];
                    if (Searching.equals(Edad)) {
                        Display += "Nombre: " + Animales[x][0] + "\nEspecie: " + Animales[x][1] + "\nEdad: " + Animales[x][2] + "\nHabitat: " + Animales[x][3] + "\nAnimal ID: " + Animales[x][5];
                        Display += "\n-----------------------\n";
                    }
                    break;
                case 4:
                    String HabitatName = Animales[x][3];
                    if (Searching.equals(HabitatName)) {
                        Display += "Nombre: " + Animales[x][0] + "\nEspecie: " + Animales[x][1] + "\nEdad: " + Animales[x][2] + "\nHabitat: " + Animales[x][3] + "\nAnimal ID: " + Animales[x][5];
                        Display += "\n-----------------------\n";
                    }
                    break;
                case 5:
                    String HabitatID = Animales[x][4];
                    if (Searching.equals(HabitatID)) {
                        Display += "Nombre: " + Animales[x][0] + "\nEspecie: " + Animales[x][1] + "\nEdad: " + Animales[x][2] + "\nHabitat: " + Animales[x][3] + "\nAnimal ID: " + Animales[x][5];
                        Display += "\n-----------------------\n";
                    }
                    break;
                case 6:
                    String AnimalID = Animales[x][5];
                    if (Searching.equals(AnimalID)) {
                        Display += "Nombre: " + Animales[x][0] + "\nEspecie: " + Animales[x][1] + "\nEdad: " + Animales[x][2] + "\nHabitat: " + Animales[x][3] + "\nAnimal ID: " + Animales[x][5];
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

    public static void HabitatsData(String Nombre, String TipoH, String Capacidad, String CantActual) {
        Habitads[habitatsAdd][0] = Nombre;
        Habitads[habitatsAdd][1] = TipoH;
        Habitads[habitatsAdd][2] = Capacidad;
        Habitads[habitatsAdd][3] = CantActual;
        Habitads[habitatsAdd][4] = String.valueOf(habitatsID); //ID
        JOptionPane.showMessageDialog(null, "Datos agregados correctamente");
        //habitatsAdd += 1;
        //habitatsID += 1;
        /*
        System.out.println(Habitads[habitatsAdd][0]);
        System.out.println(Habitads[habitatsAdd][1]);
        System.out.println(Habitads[habitatsAdd][2]);
        System.out.println(Habitads[habitatsAdd][3]);
        System.out.println(Habitads[habitatsAdd][4]);
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        habitatsAdd += 1;
        habitatsID += 1;
         */
    }

    public static void HabitatsDataModify(String Nombre, String TipoH, String Capacidad, String SearchingID) {
        for (int x = 0; x < habitatsAdd; x++) {
            String ID = Habitads[x][4];
            if (SearchingID.equals(ID)) {
                int CantActual = Integer.parseInt(Habitads[x][3]); //Cantidad actual de animales
                int newCap = Integer.parseInt(Capacidad); //Nueva capacidad de animales
                if (newCap < CantActual) {
                    JOptionPane.showMessageDialog(null, "La nueva capacidad es menor a la cantidad de animales actuales, no se pudo modificar la data");
                } else {
                    Habitads[x][0] = Nombre;
                    Habitads[x][1] = TipoH;
                    Habitads[x][2] = Capacidad;
                    JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
                }

            }
        }


        /*
        System.out.println(Habitads[ID][0]);
        System.out.println(Habitads[ID][1]);
        System.out.println(Habitads[ID][2]);
        System.out.println(Habitads[ID][3]);
        System.out.println(Habitads[ID][4]);
        System.out.println("-----------------------");
        System.out.println("-----------------------");
         */
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
        boolean find = false;
        for (int x = 0; x < habitatsAdd; x++) {
            String ID = Habitads[x][4];
            if (deleteID.equals(ID)) {
                for (int y = x; y < habitatsAdd; y++) {
                    Habitads[y][0] = Habitads[(y + 1)][0];
                    Habitads[y][1] = Habitads[(y + 1)][1];
                    Habitads[y][2] = Habitads[(y + 1)][2];
                    Habitads[y][3] = Habitads[(y + 1)][3];
                    Habitads[y][4] = Habitads[(y + 1)][4]; //ID
                    find = true;
                }
                x -= 1;
                habitatsAdd -= 1;
                JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
            }

        }
        if (find == false) {
            JOptionPane.showMessageDialog(null, "Dato no encontrado");
        }

    }

    public static void GestionAlimentacionData(String Id_Animal, String Horario, String Frecuencia, String Alimentos) {
        GestionAlimentacion[GestionAdd][0] = Id_Animal;
        GestionAlimentacion[GestionAdd][1] = Horario;
        GestionAlimentacion[GestionAdd][2] = Frecuencia;
        GestionAlimentacion[GestionAdd][3] = Alimentos;
        String AnimalNombre = "";
        for (int i = 0; i <= GestionAdd; i++) {
            for (var animal : Animales) {
                if (animal[5] == GestionAlimentacion[i][0]) {
                    AnimalNombre = animal[0];
                }
            }
            String mensaje = "Animal: " + AnimalNombre + "\n"
                    + "Horario: " + GestionAlimentacion[i][1] + "\n"
                    + "Frecuencia: " + GestionAlimentacion[i][2] + "\n"
                    + "Alimentos: " + GestionAlimentacion[i][3];
            JOptionPane.showMessageDialog(null, mensaje);
        }
        GestionAdd++;
    }

    public static void EventoData(String NombreEvento, String DescripcionEvento, String LugarEvento, String FechaHoraEvento) {
        eventos[cantidadEventos][0] = NombreEvento;
        eventos[cantidadEventos][1] = DescripcionEvento;
        eventos[cantidadEventos][2] = LugarEvento;
        eventos[cantidadEventos][3] = FechaHoraEvento;
        cantidadEventos++;
        JOptionPane.showMessageDialog(null, "Datos agregados correctamente");

    }

    public static void MostrarEvento() {
        String Mostrar = "";
        for (int x = 0; x < cantidadEventos; x++) {
            Mostrar += "Nombre Evento: " + eventos[x][0] + "\nDescripcion Evento: " + eventos[x][1] + "\nLugar Evento: " + eventos[x][2] + "\nFecha y Hora: " + eventos[x][3];
            Mostrar += "\n-----------------------\n";
        }
        JOptionPane.showMessageDialog(null, Mostrar);
    }
}
