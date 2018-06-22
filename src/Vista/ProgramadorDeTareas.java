/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author MAGM
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class ProgramadorDeTareas {
    private static long unaHora = 3600000;
   private static long unMinuto = 60000;
   private static long unSegundo = 1000;
      public static final int HORAS = 0;
   public static final int MINUTOS = 1;
   public static final int SEGUNDOS = 2;
       
    public static void ejecutaTareaCadaXTiempo(int cantidad, int medida){
         
         //Primero calculo cada cuanto ha de lanzarse(una hora, dos minutos...)
         long periodo = 0;
         switch (medida) {
               case HORAS:
                     periodo = cantidad*unaHora;
                     break;
               case MINUTOS:
                     periodo = cantidad*unMinuto;
                     break;
               case SEGUNDOS:
                     periodo = cantidad*unSegundo;
                     break;
               default:
                     periodo = -1;
         }
         
         //Si ya tenemos un intervalo, lo lanzamos
         if(periodo!=-1){
               Timer tareaEnIntervalo = new Timer();
               
               //Creamos la tarea
               AccionProgramada accionProgramada = new
                          AccionProgramada("lanzaTareaCadaXTiempo - ");
               
               //La programamos
               tareaEnIntervalo.scheduleAtFixedRate(
                          accionProgramada,
                          Calendar.getInstance().getTime(),
                          periodo);
         }else{
               System.out.println("No se lanzará ninguna tarea.");
         }
   }
    
    
    
    
   
   private static Calendar getHoraEjecucion(int hora, int minutos){
         Calendar horaDeEjecucionDiaria = new GregorianCalendar();
         horaDeEjecucionDiaria.set(Calendar.HOUR_OF_DAY, hora);
         horaDeEjecucionDiaria.set(Calendar.MINUTE, minutos);
         horaDeEjecucionDiaria.set(Calendar.SECOND, 0);
         horaDeEjecucionDiaria.set(Calendar.MILLISECOND, 0);
         return horaDeEjecucionDiaria;
   }
}

class AccionProgramada extends TimerTask{

   private String nombre;
   public AccionProgramada(String nombre){
         this.nombre = nombre;
   }
 
    @Override
   public void run() {
         System.out.println(nombre + " se ha ejecutado a las "+Calendar.getInstance().getTime());
  
   }
}