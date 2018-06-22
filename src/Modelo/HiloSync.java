/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.util.Calendar;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author luism
 */
public class HiloSync {
    
static File documento = new File("src/Modelo/Consulta.txt");
static ConecRemoto remoto = new ConecRemoto();
static Timer tiempo = new Timer();  
   
public static void ejecutaTareaCadaXTiempo(){
             AccionProgramada accionProgramada = new AccionProgramada();  //La programamos
             
             tiempo.scheduleAtFixedRate(accionProgramada,0,60000);
         }

    
static class AccionProgramada extends TimerTask{
 
    @Override
   public void run() {
         remoto.importarQuery(documento);
  
   }
   
    

}}
