/******************************************************************

usuario.java
Autores: Stefano Aragoni, Rebecca Smith, Roberto Vallecillos, Cayetano molina, Daniel Cabrera, Diego Ruiz
Última modificación: 2020-11-05

******************************************************************/

import java.util.*;

//se crea la clase
class usuario{
  //se declaran los atributos
  private String nombre;
  private String apellido;
  private String correo;
  private int age = 0;
  private String usuario;
  private String pass;
  private ArrayList<String> historial;

  private int nivelLec;
  private int nivelMat;

  //constructor que le asigna valores a varios atributos.
  public usuario(String nombre, String apellido, String correo, int age, String usuario, String pass, int nivelLec, int nivelMat){
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.age = age;
    this.usuario = usuario;
    this.pass = pass;
    this.nivelLec = nivelLec;
    this.nivelMat = nivelMat;
    this.historial = new ArrayList<String>();

  }

  //setter que cambia el nivel de lectura de una persona
  public void nivelUpgradeLec(int a){
    nivelLec = a;
  }

  //setter que cambia el nivel de matemática de una persona
  public void nivelUpgradeMat(int a){
    nivelMat = a;
  }

  //getter que retorna el nivel de lectura
  public int getNivelLec(){
      return nivelLec;
  }

  //getter que retorna el nivel de matemática
  public int getNivelMat(){
      return nivelMat;
  }

  //getter que retorna la contrase;a del usuario
  public String getContra(){

      return pass;
  }
 
  //getter que retorna el nombre de usuario. 
  public String getNombre(){
    return usuario;
  }

  //Método string que obtiene el historial completo
  //En caso que no se encuentra alguna actividad, devuelve que no ha hecho alguna actividad
  public String getHistorial(){
    String r = "Historial: \n";
    if(historial.size() == 0){
      r += "Aun no ha hecho alguna actividad. \n";
    }else{
      for(int x = 0; x < historial.size(); x++){
        String evento = historial.get(x);
        r += evento + "\n";
      }
    }
    return r;
  }
  
  //Método que agrega información al historial
  public void agregar(String evento){
    historial.add(evento);
  }


}