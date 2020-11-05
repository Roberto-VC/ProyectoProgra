/******************************************************************
almacen.java
Autores: Stefano Aragoni, Rebecca Smith, Roberto Vallecillos, Cayetano molina, Daniel Cabrera, Diego Ruiz
Última modificación: 2020-11-02

******************************************************************/

import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.io.*; 


public class Main {


  public static void main(String[] args) {

    //llaman a las clases
    ActLectura ALec = new ActLectura();
    ActMate AMate = new ActMate();
    brain Brain = new brain();
    escaner Scan = new escaner();
    Verificador verify = new Verificador();
    Asker ask = new Asker();

    usuario UsuarioActual = null;

    int opcion = 0;
    String nombre = "";
    String apellido = "";
    String correo = "";
    int age = 0;
    String usuario = "";
    String pass = "";
    String user = "";
    String contra = "";
    int opcion2 = 0;
    int correctasL = 0;
    int correctasM = 0;
    int incorrectasL = 0;
    int incorrectasM = 0;


    while(opcion != 3){
      System.out.println("\n¡Bienvenid@ a TutoGuate! Elige una opcion");
      System.out.println("1. Nuevo usuario");
      System.out.println("2. Iniciar sesion");
      System.out.println("3. Salir");
      opcion = ask.nextInt();

      // el usuario ingresa su opcion
      int seguro5 = 1;

      if (opcion == 1){

        //Esta opcion llama al metodo new usuario para hacer un usuario nuevo
        UsuarioActual = Brain.newUsu();
        seguro5 = 0;
        
      }
      else if(opcion == 2){
        //Aqui se llama al metodo login para que el usuario inicie sesion
        UsuarioActual = Brain.logIn();
        if(UsuarioActual != null){
          boolean prueba = Brain.logIn2(UsuarioActual);
          if(prueba){
            seguro5 = 0;
          }
          
        } 
      }else if(opcion == 3){

          System.out.println("Gracias por usar TutoGuate, ¡vuelve pronto!");
      }
      else{
        System.out.println("Ingresa una opcion valida");
      }


      while(seguro5==0){
        try {
          TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
           System.out.println("");
        }

        int decision = 0;
        System.out.println("Ingrese la opcion que desea hacer ahora:");
        System.out.println("1. Hacer actividades de matematica");
        System.out.println("2. Hacer actividades de lectura");
        System.out.println("3. Ver Historial de Actividades");
        System.out.println("4. Salir");

        decision = ask.nextInt();

        if(decision ==1){
          try {
            TimeUnit.SECONDS.sleep(1);
          }catch (InterruptedException e) {
            System.out.println("");
          }
          System.out.println("\n\n--PREGUNTAS DE MATEMATICA--");
          //llama a las preguntas de matematica

          int levelMate = UsuarioActual.getNivelMat();

          AMate.MenuNivel(levelMate);

          //verificar que sea entre 1 y 4. 
          int NivelPregunta = ask.nextInt();
          
          if(NivelPregunta == 4){
            System.out.println("\nRegresando al menu principal...\n\n");
          }
          else if(levelMate == 1){
            UsuarioActual.agregar("Realizo Actividad Matematica Nivel 1.");
            int RespuestaCorrecta = AMate.Nivel1(NivelPregunta);
            int respuestaUsu = ask.nextInt();
            if(verify.Respuestas2(RespuestaCorrecta, respuestaUsu)){
              AMate.CambioNotas(true,levelMate);
              correctasM = correctasM + 1;
              if(correctasM == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeMat(2);
                System.out.println("Felicidades! Haz subido al nivel 2! \n Sigue asi.\n");
              }
            }else{
              AMate.CambioNotas(false,levelMate);

            }
          }else if(levelMate == 2){
            UsuarioActual.agregar("Realizo Actividad Matematica Nivel 2.");
            int RespuestaCorrecta = AMate.Nivel2(NivelPregunta);
            int respuestaUsu = ask.nextInt();
            
            if(verify.Respuestas2(RespuestaCorrecta, respuestaUsu)){
              AMate.CambioNotas(true,levelMate);
              correctasM = correctasM + 1;
              if(correctasM == 3){
                correctasM = 0;
                incorrectasM = 0;
                UsuarioActual.nivelUpgradeMat(3);
                System.out.println("Felicidades! Haz subido al nivel 3! \n Sigue asi.\n");
              }
            }else{
              AMate.CambioNotas(false,levelMate);
              incorrectasM = incorrectasM + 1;

              if(incorrectasM == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeMat(1);
                System.out.println("Oh no! Haz bajado al nivel 1! \n Intenta de nuevo.\n");
              }
            }
          }else if(levelMate == 3){
            UsuarioActual.agregar("Realizo Actividad Matematica Nivel 3.");
            int RespuestaCorrecta = AMate.Nivel3(NivelPregunta);
            int respuestaUsu = ask.nextInt();
            
            if(verify.Respuestas2(RespuestaCorrecta, respuestaUsu)){
              AMate.CambioNotas(true,levelMate);
              correctasM = correctasM + 1;
              if(correctasM == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeMat(4);
                System.out.println("Felicidades! Haz subido al nivel 4! \n Sigue asi.\n");
              }
            }else{
              AMate.CambioNotas(false,levelMate);
              incorrectasM = incorrectasM + 1;

              if(incorrectasM == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeMat(2);
                System.out.println("Oh no! Haz bajado al nivel 2! \n Intenta de nuevo.\n");
              }

            }
          }
          
          else if(levelMate == 4){
            UsuarioActual.agregar("Realizo Actividad Matematica Nivel 4.");
            int RespuestaCorrecta = AMate.Nivel4(NivelPregunta);
            int respuestaUsu = ask.nextInt();
    
            if(verify.Respuestas2(RespuestaCorrecta, respuestaUsu)){
              AMate.CambioNotas(true,levelMate);
              correctasM = correctasM + 1;
              if(correctasM == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeMat(5);
                System.out.println("Felicidades! Haz subido al nivel 5! \n Sigue asi.\n");
              }
            }else{
              AMate.CambioNotas(false,levelMate);
              incorrectasM = incorrectasM + 1;

              if(incorrectasM == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeMat(2);
                System.out.println("Oh no! Haz bajado al nivel 3! \n Intenta de nuevo.\n");
              }

            }
          }

          else if(levelMate == 5){
             UsuarioActual.agregar("Realizo Actividad Matematica Nivel 5.");
            int RespuestaCorrecta = AMate.Nivel5(NivelPregunta);
            int respuestaUsu = ask.nextInt();
            
            if(verify.Respuestas2(RespuestaCorrecta, respuestaUsu)){
              AMate.CambioNotas(true,levelMate);
              
            }else{
              AMate.CambioNotas(false,levelMate);
              incorrectasM = incorrectasM + 1;

              if(incorrectasM == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeMat(4);
                System.out.println("Oh no! Haz bajado al nivel 4! \n Intenta de nuevo.\n");
              }

            }
          }

        }else if (decision == 2){
          try {
            TimeUnit.SECONDS.sleep(2);
          } catch (InterruptedException e) {
            System.out.println("");
          }
          
          System.out.println("\n\n--PREGUNTAS DE LECTURA--");

          //llama a las preguntas de lectura
          int levelLec = UsuarioActual.getNivelLec();

          ALec.MenuNivel(levelLec);

          int NivelPregunta = ask.nextInt();

          if(NivelPregunta == 4){
            System.out.println("\nRegresando al menu principal...\n\n");
          }else if(levelLec == 1){
             UsuarioActual.agregar("Realizo Actividad Lectura Nivel 1.");
            int RespuestaCorrecta = ALec.Nivel1(NivelPregunta);
            int respuestaUsu = ask.nextInt();
            
            if(verify.Respuestas2(RespuestaCorrecta, respuestaUsu)){
              ALec.CambioNotas(true, levelLec);
              correctasL = correctasL + 1;
              if(correctasL == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeLec(2);
                System.out.println("Felicidades! Haz subido al nivel 2! \n Sigue asi.\n");
              }
            }else{
              ALec.CambioNotas(false, levelLec);
            }
          }
          else if(levelLec == 2){
             UsuarioActual.agregar("Realizo Actividad Lectura Nivel 2.");
            int RespuestaCorrecta = ALec.Nivel2(NivelPregunta);
            int respuestaUsu = ask.nextInt();
            
            if(verify.Respuestas2(RespuestaCorrecta, respuestaUsu)){
              ALec.CambioNotas(true, levelLec);
              correctasL = correctasL + 1;
              if(correctasL == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeLec(3);
                System.out.println("Felicidades! Haz subido al nivel 3! \n Sigue asi.\n");
              }
            }else{
              ALec.CambioNotas(false, levelLec);
              incorrectasL = incorrectasL + 1;

              if(incorrectasL == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeLec(1);
                System.out.println("Oh no! Haz bajado al nivel 1! \n Intenta de nuevo.\n");
              }

            }
          }
          else if(levelLec == 3){
             UsuarioActual.agregar("Realizo Actividad Lectura Nivel 3.");
            int RespuestaCorrecta = ALec.Nivel3(NivelPregunta);
            int respuestaUsu = ask.nextInt();
            
            if(verify.Respuestas2(RespuestaCorrecta, respuestaUsu)){
              ALec.CambioNotas(true, levelLec);
              correctasL = correctasL + 1;
              if (correctasL == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeLec(4);
                System.out.println("Felicidades! Haz subido al nivel 4! \n Sigue asi.\n");
                
              }
            }else{
              ALec.CambioNotas(false, levelLec);
              incorrectasL = incorrectasL + 1;

              if(incorrectasL == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeLec(2);
                System.out.println("Oh no! Haz bajado al nivel 2! \n Intenta de nuevo.\n");
              }
              
            }
          }else if(levelLec == 4){
             UsuarioActual.agregar("Realizo Actividad Lectura Nivel 4.");
            int RespuestaCorrecta = ALec.Nivel4(NivelPregunta);
            int respuestaUsu = ask.nextInt();
            
            if(verify.Respuestas2(RespuestaCorrecta, respuestaUsu)){
              ALec.CambioNotas(true, levelLec);
              correctasL = correctasL + 1;
              if (correctasL == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeLec(5);
                System.out.println("Felicidades! Haz subido al nivel 5! \n Sigue asi.\n");
                
              }
            }else{
              ALec.CambioNotas(false, levelLec);
              incorrectasL = incorrectasL + 1;

              if(incorrectasL == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeLec(3);
                System.out.println("Oh no! Haz bajado al nivel 3! \n Intenta de nuevo.\n");
              }
              
            }
          }else if(levelLec == 5){
            UsuarioActual.agregar("Realizo Actividad Lectura Nivel 5.");
            int RespuestaCorrecta = ALec.Nivel5(NivelPregunta);
            int respuestaUsu = ask.nextInt();
            
            if(verify.Respuestas2(RespuestaCorrecta, respuestaUsu)){
              ALec.CambioNotas(true, levelLec);
              
            }else{
              ALec.CambioNotas(false, levelLec);
              incorrectasL = incorrectasL + 1;

              if(incorrectasL == 3){
                incorrectasM = 0;
                correctasM = 0;
                UsuarioActual.nivelUpgradeLec(4);
                System.out.println("Oh no! Haz bajado al nivel 4! \n Intenta de nuevo.\n");
              }
              
            }
          }
        }else if (decision == 3){
          System.out.println(UsuarioActual.getHistorial());
        }else if (decision == 4){
          seguro5 = 1;
        }else{
          System.out.println("Ingrese una opcion valida");
        }
     }

        

    }
 }
}
