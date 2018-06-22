/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author luism
 */
public class HiloSync {
    
 File documento = new File("src/Modelo/Consulta.txt");
ConecRemoto remoto = new ConecRemoto();
Timer exe = new Timer();
    TimerTask timerTask = new TimerTask() 
     { 
         @Override
         public void run()  
         { 
                 remoto.importarQuery(documento);
         } 
     }; 

}
