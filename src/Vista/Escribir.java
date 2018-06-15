/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.*;

/**
 *
 * @author luism
 */
public class Escribir {
  
    public void escribir(String nombreArchivo)

    {

File f;
f = new File("Imagenes\\Consultas.txt");
try{
FileWriter w = new FileWriter(f);
BufferedWriter bw = new BufferedWriter(w);
PrintWriter wr = new PrintWriter(bw);  
wr.write(nombreArchivo);//escribimos en el archivo
wr.append(""); //concatenamos en el archivo sin borrar lo existente
wr.close();
bw.close();
}catch(IOException e){};
 }

}
