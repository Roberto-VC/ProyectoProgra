import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

class brain{

  Scanner scan = new Scanner(System.in);
  Diagnostico DTest = new Diagnostico();
  ActLectura ALec = new ActLectura();
  almacen Almacen = new almacen();

  String nombre = "";
  String apellido = "";
  String correo = "";
  int age = 0;
  String usuario = "";
  String pass = "";
  String user = "";
  String contra = "";
  int opcion2 = 0;

  public brain(){}


  public usuario newUsu(){

    System.out.println("Hola bienvenid@, necesitamos algunos datos para comenzar");
    try{
    System.out.println("\nIngresa tu nombre");
    nombre = scan.next();

    System.out.println("\nIngresa tu apellido");
    apellido= scan.next();

    int contador1 = 0;
    while (contador1 < 1){
      System.out.println("\nIngresa tu correo");
      correo= scan.next();
      int firstIndex = correo.indexOf("@");

      if(((correo.length()) < 7) || (firstIndex == -1)){
        System.out.println("Por favor ingrese un correo valido."); 
      }
      else{
        contador1 = 1;
      }
    }

    System.out.println("\nIngresa tu edad en numeros");
    int bean = 0;
    while(bean != 7){
      try{
      age = scan.nextInt();
      bean = 7;
      }catch(Exception e){
        System.out.println("Por favor ingresa un numero correcto."); 
        scan.next();
        continue;
      }
    }
    
    int seguro1 = 0;
    while(seguro1 != 1){
      System.out.println("\nCrea un nombre de usuario");
      usuario=scan.next();
      if(Almacen.agregar(usuario)){
        seguro1 = 1;
      }
      else{
        System.out.println("Este usuario ya existe. Intente de nuevo.");
      }
    }

    int jelly = 0;
    while(jelly != 1){
      System.out.println("\nCrea una contrasena con un minimo de 5 caracteres para ingresar");
      pass=scan.next();
      if(pass.length() > 5){
        System.out.println("Contrasena valida");
        jelly +=1;
        
      }else{
        System.out.println("Ingrese una contrasena valida");
        
      }

    }
    }catch(Exception e){
      System.out.println("\nHubo un error. Ingrese sus datos de nuevo");
      
    }
    System.out.println("\nYa se creo tu usuario. ¡Bienvenid@!");
  

     System.out.println("\nAhora se realizará un examen de diagnóstico para evaluar tu conocimiento. ¡Suerte!\n\n");

    try {
      TimeUnit.SECONDS.sleep(4);
      } catch (InterruptedException e) {
      System.out.println("");
      }

    System.out.println("--Sección de Matemática--");
    System.out.println("\nLeer los siguientes incisos y responder las preguntas correspondientes.\n");

    int seguro = 0;
    while(seguro != 5){
        DTest.examenInicialMate(seguro);
        DTest.RespuestasMate();
        seguro = seguro +1;
        try {
          TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
            System.out.println("");
        }
    }

    try {
      TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
      System.out.println("");
      }

    System.out.println("--Seccion de Lectura--"); 
      System.out.println("\nLeer los siguientes incisos y responder las preguntas correspondientes. \n"); 

    seguro = 0;
    while(seguro != 5){
        DTest.examenInicialLectura(seguro);
        DTest.RespuestasLectura();
        seguro = seguro +1;
        try {
          TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
            System.out.println("");
        }
    }

      try {
      TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
      System.out.println("");
      }

      System.out.println("¡Felicidades! Ya completaste el diagnóstico.\nTus resultados son los siguientes:");

      int nivelInt = DTest.getNivel();


      usuario Usu1 = new usuario(nombre, apellido, correo, age, usuario, pass, nivelInt);
      
      Almacen.agregar1(Usu1);

      return Usu1;
  }

  public usuario logIn(){
    int seguro5 = 1;
    usuario Log = null;
    System.out.println("\nIngresa tu usuario");
    user = scan.next();
    if(Almacen.obtener(user) != null){
      Log = Almacen.obtener(user);
      System.out.println("Ingresa tu contrasena");
      contra = scan.next();
      if(contra == Log.getContra()){
          System.out.println("bienvenid@...");
          seguro5 = 0;
      }else{
        System.out.println("Contraseña incorrecta...\n");
        try {
          TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e) {
          System.out.println("");
        }
      }

    }
    else{
      System.out.println("Este usuario no existe...\n");
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        System.out.println("");
      }
    }
    return Log;
    }

}



  
  

    
      
      

      
       

      
       
        
         
        

          
          
          
          
        
      

      
      
        
         
          
          
           
          
          
          
        
      

      
        
        
          
          
          
          
          
        
      

      
        
        
          
          
          
           

          
          

        

         

    

    
    
      
      
      
       
      
        
      
        
      
    
    
    

      
      
      
       
      
        
      
        
      

    
    
    

    

    

    

    

         
        
             
  