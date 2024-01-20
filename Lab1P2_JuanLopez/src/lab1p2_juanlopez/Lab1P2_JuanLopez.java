/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_juanlopez;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author jjlm1
 */
public class Lab1P2_JuanLopez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*********************REGISTRO DE USUARIOS*********************");
        System.out.println("");
        System.out.println("1. Registrarse");
        System.out.println("2. Listar todos los registros");
        System.out.println("3. Listar mediante dominio");
        System.out.println("4. Salir");
        Scanner leer =new Scanner(System.in);
        int opcion=leer.nextInt();
       String correo;
       Date hoy =new Date();
       ArrayList <String> registrados =new ArrayList<>();
        while (opcion!=4){
            switch (opcion){
                case 1:
                    System.out.println("Ingrese nombre y apellido");
                    leer.nextLine();
                    String nombre =leer.nextLine();
                    
                    System.out.println("Ingrese fecha de nacimiento. Realícelo en el formato Mes/Día/Año");

                    String born=leer.nextLine();
                    String nums[]=born.split("/");
                    int años=Integer.parseInt(nums[2]);
                    años=hoy.getYear()+1900;
                    int meses=Integer.parseInt(nums[0]);
                    meses=meses-hoy.getMonth()+1-12;
                    int dias=Integer.parseInt(nums[1]);
                    dias=hoy.getDate()-dias;
                    Date naci=new Date(Integer.parseInt(nums[2])-1900, Integer.parseInt(nums[0])-1, Integer.parseInt(nums[1]));
                    Date min=new Date(2011-1900, 0, 19);
                    
                    long minimo=min.getTime();
                    long fecha =naci.getTime();
                    long año=minimo-fecha;
                    long añito=año/1000/60/60/24/365+13;
                    System.out.println(añito);
//                    long months=año/(1000*60*60*24*30);
//                    System.out.println(months);
                    String registro=nombre+"  "+String.valueOf(añito)+" años/ "+String.valueOf(meses)+" meses/ "+String.valueOf(dias)+" dias";
                    if(fecha<=minimo){
                        System.out.println("Es mayor a 13 años. Puede ingresar");
                        System.out.println("Ingresar correo electronico");
                        correo=leer.nextLine();
                        String regex= "^[a-zA-Z0-9._%&$+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                        Pattern mail=Pattern.compile(regex);
                        Matcher verificar =mail.matcher(correo);
                        boolean posible =verificar.matches();
                        int contp=0;
                        for(int i=0;i<registrados.size();i++){
                            String []dominio=registrados.get(i).split("@");
                            String []correos=correo.split("@");
                            if (dominio[0].contains(correos[0])){
//                                System.out.println(registrados.get(i));
                            contp++;
                            }
                        }
//                        boolean posible=verificar.find();
                        if (posible&&contp==0){
                            registro+="  "+correo;
                            System.out.println("Correo válido");
                            System.out.println("Ingrese contraseña");
                            String contra=leer.nextLine();
//                            String regex = "^[a-zA-Z0-9._%&$+-?<>!]{8,}$";
                        String regexx = "^[a-zA-Z0-9._%&$+-?<>!]{8,}$";        
                        Pattern pattern = Pattern.compile(regexx);
                                Matcher matcher = pattern.matcher(contra);
                                boolean possible=matcher.matches();
//                                int contmay=0;
//                                int contmin=0;
//                                
//                            for (int i=0;i<contra.length();i++){
//                             if((int)contra.charAt(i)>=65 && (int)contra.charAt(i)<=90){
//                                 
//                        }
                            if (possible&&contra.length()>=8){
                                System.out.println("Contraseña correcta");
                                System.out.println("Registro completo");
                                registro+="  "+contra;
                                registrados.add(registro);
                                
                            }else{
                                System.out.println("Contraseña no válida");
                            }
                        }else{
                            System.out.println("Correo no válido");
                        }
                    }else{
                        System.out.println("Usted es menor de 13 años. No puede entrar ");
                    
                    }
                        
                    
                    
                    break;
                    
                case 2:
                    for (int i=0;i<registrados.size();i++){
                        System.out.println(registrados.get(i));
                    }
                    break;
                    
                case 3:
//                    System.out.println("Qué dominio quiere ver?");
//                    System.out.println("1. gmail");
//                    System.out.println("2. outlook");
//                    System.out.println("3. yahoo");
//                    System.out.println("4. icloud");
//                    System.out.println("5. Protonmail");
//                    System.out.println("6. fastmail");
//                    int dom=leer.nextInt();
//                switch (dom){
//                    case 1:
                        for(int i=0;i<registrados.size();i++){
                            String []dominio=registrados.get(i).split("@");
                            if (dominio[1].contains("gmail")){
                                System.out.println(registrados.get(i));
                            }
                            
                        }
//                        break;
//                        case 2:
                        for(int i=0;i<registrados.size();i++){
                            String []dominio=registrados.get(i).split("@");
                            if (dominio[1].contains("outlook")){
                                System.out.println(registrados.get(i));
                            }
                            
                        }
//                        break;
//                        case 3:
                        for(int i=0;i<registrados.size();i++){
                            String []dominio=registrados.get(i).split("@");
                            if (dominio[1].contains("yahoo")){
                                System.out.println(registrados.get(i));
                            }
                            
                        }
//                        break;
//                        case 4:
                        for(int i=0;i<registrados.size();i++){
                            String []dominio=registrados.get(i).split("@");
                            if (dominio[1].contains("icloud.com")){
                                System.out.println(registrados.get(i));
                            }
                            
                        }
//                        break;
//                        case 5:
                        for(int i=0;i<registrados.size();i++){
                            String []dominio=registrados.get(i).split("@");
                            
                            if (dominio[1].contains("protonmail")){
                                System.out.println(registrados.get(i));
                            }
                            
                        }
//                        break;
//                        case 6:
                        for(int i=0;i<registrados.size();i++){
                            String []dominio=registrados.get(i).split("@");
                            if (dominio[1].contains("fastmail")){
                                System.out.println(registrados.get(i));
                            }
                            
                        }
//                        break;
                        
                        
                }
                    
            
            System.out.println("*********************REGISTRO DE USUARIOS*********************");
        System.out.println("");
        System.out.println("1. Registrarse");
        System.out.println("2. Listar todos los registros");
        System.out.println("3. Listar mediante dominio");
        System.out.println("4. Salir");
        opcion=leer.nextInt();
        }
        }
    }
    

