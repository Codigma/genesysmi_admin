/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.ConecRemoto;
import java.io.*;
import java.sql.PreparedStatement;

/**
 *
 * @author luism
 */
public class Texto {
  
    public void escribir(String nombreArchivo)

    {

File f;
f = new File("C:\\Users\\luism\\Desktop\\Consultas.txt");
try{
FileWriter w = new FileWriter(f,true);
BufferedWriter bw = new BufferedWriter(w);
PrintWriter wr = new PrintWriter(bw); 
wr.write(nombreArchivo);//escribimos en el archivo
wr.append("\r\n"); //concatenamos en el archivo sin borrar lo existente
wr.close();
bw.close();
}catch(IOException e){};
 }

    public void Leer(){
     File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
          ConecRemoto conex= new ConecRemoto();
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("C:\\Users\\luism\\Desktop\\Consultas.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
          PreparedStatement preparedStatement = conex.getConn().prepareStatement(linea);
          preparedStatement.execute();
         }
            
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }
    }
    

