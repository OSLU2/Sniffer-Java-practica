/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captorversion;

/**
 *
 * @author oswal
 */
public class ipv6 {
    public static int contIPv6;
     private String protocolo = "ICMPV6"; 
    public String getProtocolo(){
        return protocolo;
    }
    public void setProtocolo(String protocolo){
        this.protocolo = protocolo;
    }
    public String version(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("versión: ");
        int i=14;
        sb.append( ConverHexa.toHex(bytes[i] >> 4) );    
        return sb.toString();
    }
    public String trafficClass(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("Clase de Tráfico: ");
        String aux,aux1,aux2,aux3,aux4,aux5;
        int i;
        aux2="";
        aux3="";
        aux5="";
        for(i=14;i<16;i++){
            aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
            if(i==14){
                aux2=aux.substring(4,7);
                aux3=aux.substring(7,8);
                sb.append(aux2);
                sb.append(aux3);
            }
            if(i==15){
                aux4=aux.substring(0,4);
                aux5=aux.substring(0,2);
                sb.append(aux4);
            }
        }
        aux1=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
        sb.append(aux1);
        sb.append("\n");
        sb.append("Indicador de Urgencia:");
        switch(aux2){
            case "000":
                sb.append(" De rutina");
                break;
            case "001":
                sb.append(" Prioritario");
                break;
            case "010":
                sb.append(" Inmediato");
                break;
            case "011":
                sb.append(" Relampago");
                break;
            case "100":
                sb.append(" Invalidacion Relampago");
                break;
            case "101":
                sb.append(" Procesando Llamada critica y de emergencia");
                break;
            case "110":
                sb.append(" Control de trabajo de Internet");
                break;
            case "111":
                sb.append(" Control de Red");
                break;
            default:
                sb.append(" Indicador de Urgencia no disponible");
                break;
        }
        sb.append("\n");
        switch(aux3){
            case "0":
                sb.append("Retardo: normal");
                break;
            case "1":
                sb.append("Retardo: bajo");
                break;
            default:
                sb.append("Retardo: no reconocido");
                break;
        }
        sb.append(", ");
        switch(aux5){
            case "00":
                sb.append("Rendimiento: normal, Fiabilidad: normal");
                break;
            case "01":
                sb.append("Rendimiento: normal, Fiabilidad: alta");
                break;
            case "10":
                sb.append("Rendimiento: alto, Fiabilidad: normal");
                break;
            case "11":
                sb.append("Rendimiento: alto, Fiabilidad: alta");
                break;
            default:
                sb.append(" Rendimiento: no reconocido, Fiabilidad, no reconocida");
                break;
        }
        return sb.toString();
    }
    public String flowLabel(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("Etiqueta de Flujo: ");
        String aux,aux1,aux2;
        int i;
        for(i=15;i<18;i++){
            aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
            if(i==15){
                aux2=aux.substring(4,8);
                sb.append(aux2);
            }
            else{
                sb.append(aux);
            }
            aux1=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');            
            sb.append(aux1);
            sb.append(" ");
        }
        return sb.toString();
    }
    public String payloadLength(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("Tamaño de Carga Útil: ");
        String aux,aux1;
        int i;
        for(i=18;i<20;i++){
            aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
            aux1=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
            sb.append(aux);
            sb.append(aux1);
        }
        sb.append(" ");
        for(i=18;i<20;i++){
            sb.append(ConverHexa.toHex(bytes[i] >> 4) );
            sb.append( ConverHexa.toHex(bytes[i] ));
        }
        return sb.toString();
    }
    public String nextHeader(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("Encabezado siguiente: ");
        int i=20;
        int iarray;
        iarray=bytes[i] & 0xff;
        sb.append(iarray);
        return sb.toString();
    }
    public String hopLimit(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        String aux;
        sb.append("Límite de Salto: ");
        int i=21;
        aux=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
        sb.append(aux);
        sb.append("b ");
        sb.append( ConverHexa.toHex(bytes[i] >>4) );
        sb.append( ConverHexa.toHex(bytes[i] ) );
        sb.append("h");
        return sb.toString();
    }
    public String sourceAddress(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("Dirección MAC origen: ");
        
        int i, limite;
        limite=38;
        for(i=22;i<limite;i++){
             sb.append( ConverHexa.toHex(bytes[i] >> 4) );
            if(i<limite-1){
                sb.append( ConverHexa.toHex(bytes[i])+ ":" );
            }
            else{
                sb.append( ConverHexa.toHex(bytes[i]) );
            }
        
        }
        return sb.toString();
    }
    public String destinationAddres(byte[] bytes){
        StringBuilder sb = new StringBuilder(bytes.length );
        sb.append("Dirección MAC destino: ");
        int i, limite;
        limite=54;
        for(i=38;i<limite;i++){
                         sb.append( ConverHexa.toHex(bytes[i] >> 4) );
            if(i<limite-1){
                sb.append( ConverHexa.toHex(bytes[i])+ ":" );
            }
            else{
                sb.append( ConverHexa.toHex(bytes[i]) );
            }
        contIPv6=58;
        }
        return sb.toString();
    }
}

