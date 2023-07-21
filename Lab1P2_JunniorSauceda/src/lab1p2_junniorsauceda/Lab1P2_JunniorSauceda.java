/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_junniorsauceda;
import java.util.Scanner;
/**
 *
 * @author Junnior Sauceda
 */
public class Lab1P2_JunniorSauceda {
static Scanner sc= new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean seguir=true;
        do{
            System.out.println("""
                                      MENU
                               1.- Newton-Raphson
                               2.- Serie de Taylor
                               3.- Salir
                               Ingrese una opcion:
                               """);
            String Opcion=sc.nextLine();
            while(num(Opcion)){
                System.out.println("""
                                   Solo debe ingresar Numeros
                                      MENU
                               1.- Newton-Raphson
                               2.- Serie de Taylor
                               3.- Salir
                               Ingrese una opcion:
                               """);
                Opcion=sc.nextLine();
            }
            
            int opcion=0;
            opcion=Integer.parseInt(Opcion);
            while(opcion<1||opcion>3){
                System.out.println("""
                           Ingrese una opcion valida
                                      MENU
                               1.- Newton-Raphson
                               2.- Serie de Taylor
                               3.- Salir
                               Ingrese una opcion:
                               """);
                opcion=sc.nextInt();
            }
            switch(opcion){
                case 1:{
                    System.out.println("Ingrese el numero a: ");
                    String A=sc.nextLine();
                    while(num(A)){
                        System.out.println("Ingrese un Numero Valido");
                        A=sc.nextLine();
                    }
                    double a=Integer.parseInt(A);
//                    System.out.println(a);
                    sc=new Scanner(System.in);
                    System.out.println("Ingrese el numero b: ");
                    String B=sc.nextLine();
                    while(num(B)){
                        System.out.println("Ingrese un Numero Valido");
                        B=sc.nextLine();
                    }
                    double b=Integer.parseInt(B);
//                    System.out.println(b);
                    sc=new Scanner(System.in);
                    System.out.println("Ingrese el numero c: ");
                    String C=sc.nextLine();
                    while(num(C)){
                        System.out.println("Ingrese un Numero Valido ");
                        C=sc.nextLine();
                    }
                    double c=Integer.parseInt(C);
//                    System.out.println(c);
                    sc=new Scanner(System.in);
                    
                    double vertice=(((double)b*(-1.0))/((double)2*a));
                    System.out.println(vertice);
                    double despla2=vertice+200.0;
                    double despla1=vertice-200.0;
                    double R1=Newton(a, b, c,despla1, 0);
                    double R2=Newton(a, b, c,despla2, 0);
                   
                    System.out.println("Ejecucion 1: x0 = "+(b*(-1))+"/"+(2*a)+" - "+200+" = "+despla1+", Raiz encontrada: "+R1);
                    System.out.println("Ejecucion 2: x0 = "+(b*(-1))+"/"+(2*a)+" + "+200+" = "+despla2+", Raiz encontrada: "+R2);
                    
                    
                    
                    
                }
                break;
                case 2:{
                    System.out.println("Ingrese x: ");
                    String X=sc.nextLine();
                    while(num(X)){
                        System.out.println("Ingrese un Numero Valido");
                        X=sc.nextLine();
                    }
                    int x=Integer.parseInt(X);
                    sc=new Scanner(System.in);
                    
                    System.out.println("Ingrese n");
                    String N=sc.nextLine();
                    while(num(N)){
                        System.out.println("Ingrese un Numero Valido");
                        N=sc.nextLine();
                    }
                    int n=Integer.parseInt(N);
                    sc=new Scanner(System.in);
                    double acum1=0;
                    double acum2=0;
                    double acum3=0;
                    System.out.println("El seno de "+x+" es: "+sen(x, n,0,acum1));
                    System.out.println("El coseno de "+x+" es: "+cos(x, n,0,acum2));
                    if(x>90){
                        System.out.println("La tangente de "+x+" es: 0");
                    }
                    else{
                      System.out.println("El coseno de "+x+" es: "+tan(x, n,1,acum3));  
                    }
                    
                    
                    
                }
                break;
                case 3:{
                    seguir=false;
                }
                break;
            }
            
            
            
        }while(seguir);
        
        
    }
    public static double sen(int x,int n,int cont,double acum){
       
        if(cont==n){
            
//            acum+=Math.pow(-1, cont)/factorial((2*cont)+1)*Math.pow(x, (2*cont+1));
            acum+=(((Math.pow(-1, cont))/factorial(((2*cont)+1)))*Math.pow(x, ((2*n)+1)));
           

            return acum;
        }
        else{
            
            acum+=sen(x,n,cont+1,acum);
            
            return acum;
        }
        
    }
    public static double cos(int x,int n,int cont,double acum){
        
        if(cont==n){
            
            acum+=(((Math.pow(-1, cont))/factorial((2*cont)))*Math.pow(x, (2*cont)));
//            acum+=(Math.pow(-1,cont)/factorial(2*cont))*Math.pow(x,(2*cont));
            
            
            return acum;
        }
        else{
            
            acum+=cos(x,n,cont+1,acum);
            
            //Math.pow(-1,cont)/factorial(2*cont)*Math.pow(x,(2*cont))
            return acum;
        }
        
    }
    public static double tan(int x,int n,int cont,double acum){
        
        if(cont==n){
            
            acum+=(((Math.pow(2, cont)*(Math.pow(-4, cont)*(1-(Math.pow(4, cont)))))/factorial((2*cont)))*(Math.pow(x, ((2*cont)-1))));
//            acum+=Math.pow(2, cont)*Math.pow(-4, cont)*(1-Math.pow(4, cont))/factorial(2*cont)*Math.pow(x, (2*cont-1));
            return acum;
        }
        else{
            
         acum+=tan(x,n,cont+1,acum);
         
            return acum;
        }
        
    }
    public static double factorial(int numero){
        int acumulador=1;
        for(int contador=1;contador<=numero;contador++){
            acumulador=acumulador*contador;
        }
        return acumulador;
    }
    public static double Newton(double a,double b,double c,double desplazamiento,int cont){
        double N;
        if(cont<99){
            desplazamiento=desplazamiento-((a*Math.pow(desplazamiento,2)+(b*desplazamiento)+c)/(2*a*(desplazamiento*b)));
            
            N=Newton(a,b,c,desplazamiento,cont+1);
            return N;
        }
        else{
            
//            
            N=desplazamiento-((a*Math.pow(desplazamiento,2)+(b*desplazamiento)+c)/(2*a*(desplazamiento*b)));
            

            return N;
        }
        
    }
    public static boolean num(String Num){
        boolean valido=false;
        int cha=0;
        for(int x=0;x<Num.length();x++){
            char carac=Num.charAt(x);
            int ascii=carac;
            if(x==0){
                if(carac<48||carac>57){
                    if(x==0&&ascii==45){
                        
                    }
                    else{
                        cha++;
                    }
                }
                
                    
            }
            else{
                if(ascii<48||ascii>57){
                        cha++;
                }
            }
            
            
        }
        if(cha>0){
            valido=true;
        }
        return valido;
    }
    public static boolean Mnum(String Num){
        boolean valido=false;
        int cha=0;
        for(int x=0;x<Num.length();x++){
            char carac=Num.charAt(x);
            int ascii=carac;
            
                if(ascii<48||ascii>57){
                        cha++;
                }
            
        }
        if(cha>0){
            valido=true;
        }
        return valido;
    }
    
}
