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
public class paqueteIPv4 {
    private String protocolo;
    public String getProtocolo(){
        return protocolo;
    }
    public void setProtocolo(String protocolo){
        this.protocolo = protocolo;
    }
    public String version (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("versión: ");
        int i=14;
        sb.append( ConverHexa.toHex(bytes[i] >> 4) );    
        return sb.toString();
    }
    public String LongCabec (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Tamaño cabecera: ");
        int i=14;
        sb.append( ConverHexa.toHex(bytes[i] ) );
        return sb.toString();
    }
    public String tipoServ (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        int i=15;
        String aux,aux1;
        byte bait=bytes[i];
        sb.append("Indicador de Urgencia: ");
        aux=String.format("%8s", Integer.toBinaryString(bait & 0xFF)).replace(' ','0');
        aux1=aux.substring(0,3);
        sb.append(aux1);
        return sb.toString();
    }
    public String tipoCarac (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        int i=15;
        String aux,aux1,aux2;
        byte bait=bytes[i];
        sb.append("Características: ");
        aux=String.format("%8s", Integer.toBinaryString(bait  & 0xFF)).replace(' ','0');
        aux1=aux.substring(3,8);
        aux2=aux.substring(3,6);
        sb.append(aux1);
        switch(aux2){
            case "000":
                sb.append(" Retardo:Normal. Rendimiento:Normal. Fiabilidad:Normal ");
                break;
            case "001":
                sb.append(" Retardo:Normal. Rendimiento:Normal. Fiabilidad:Alta ");
                break;
            case "010":
                sb.append(" Retardo:Normal. Rendimiento:Alto. Fiabilidad:Normal ");
                break;
            case "011":
                sb.append(" Retardo:Normal. Rendimiento:Alto. Fiabilidad:Alta ");
                break;
            case "100":
                sb.append(" Retardo:Alto. Rendimiento:Normal. Fiabilidad:Normal ");
                break;
            case "101":
                sb.append(" Retardo:Alto. Rendimiento:Normal. Fiabilidad:Alta ");
                break;
            case "110":
                sb.append(" Retardo:Alto. Rendimiento:Alto. Fiabilidad:Normal ");
                break;
            case "111":
                sb.append(" Retardo:Alto. Rendimiento:Alto. Fiabilidad:Alta ");
                break;
            default:
                sb.append(" Características No reconocidas");
                break;
        }
        
        return sb.toString();
    }
    public String longi (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Longitud: ");
        String aux,aux1;
        int i;
        for(i=16;i<18;i++){
            aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
            aux1=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
            sb.append(aux);
            sb.append(aux1);
        }
        sb.append(" ");
        for(i=16;i<18;i++){
            sb.append(ConverHexa.toHex(bytes[i] >> 4) );
            sb.append( ConverHexa.toHex(bytes[i] ));
        }
        return sb.toString();
    }
    public String indentifi (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Identificador: ");
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
        sb.append( ConverHexa.toHex(bytes[i] ) );
        }
        return sb.toString();
    }
    public String flag (byte[] bytes){ 
        StringBuilder sb = new StringBuilder( 1 );
        int i=20;
        String aux,aux1;
        byte bait=bytes[i];
        sb.append("bandera: ");
        aux=String.format("%8s", Integer.toBinaryString(bait  & 0xFF)).replace(' ','0');
        aux1=aux.substring(0,3);
        sb.append(aux1);
        return sb.toString();
    }
    public String posiFrag (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Posicion de fragmento: ");
        String aux,aux1,aux2;
        int i;
        for(i=20;i<22;i++){
            aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
            if(i==20){
                aux2=aux.substring(3,8);
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
    public String vida (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        String aux;
        sb.append("Tiempo de vida: ");
        int i=22;
        aux=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
        sb.append(aux);
        sb.append("b ");
        sb.append( ConverHexa.toHex(bytes[i] >>4) );
        sb.append( ConverHexa.toHex(bytes[i] ) );
        sb.append("h");
        return sb.toString();
    }
    public String protocol (byte[] bytes){
        StringBuilder sb = new StringBuilder(  );
        sb.append("Protocolo: ");
        int i=23;
        int iarray;
        iarray=bytes[i] & 0xff;
        sb.append(iarray);
        return sb.toString();
    }
    public String CtrlCabe (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("control de cabecera: ");
        String aux,aux1;
        int i;
        for(i=24;i<26;i++){
            aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
            aux1=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
            sb.append(aux);
            sb.append(aux1);
        }
        sb.append(" ");
        for(i=24;i<26;i++){
            sb.append(ConverHexa.toHex(bytes[i] >> 4) );
            sb.append( ConverHexa.toHex(bytes[i] ) );
        }
        return sb.toString();
    }
    public String DirecciIPOrigen (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Dirección IP origen: ");
        
        int i, iarray;
        for(i=26;i<30;i++){
            
            iarray=bytes[i] & 0xff;
            sb.append(iarray);
            
            if(i!=29){
                sb.append(".");
            }
        }
        return sb.toString();
    }
    public String DirecciIPDestino(byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Dirección IP destino: ");
        int i, iarray;
        for(i=30;i<34;i++){
            
            iarray=bytes[i] & 0xff;
            sb.append(iarray);
            
            if(i!=33){
                sb.append(".");
            }
        }
        return sb.toString();
    }
    public void switchTipoServ(String tipoServ){
        switch(tipoServ){
            case "Indicador de Urgencia: 000":
                System.out.println(" De rutina");
                break;
            case "Indicador de Urgencia: 001":
                System.out.println(" Prioritario");
                break;
            case "Indicador de Urgencia: 010":
                System.out.println(" Inmediato");
                break;
            case "Indicador de Urgencia: 011":
                System.out.println(" Relampago");
                break;
            case "Indicador de Urgencia: 100":
                System.out.println(" Invalidacion Relampago");
                break;
            case "Indicador de Urgencia: 101":
                System.out.println(" Procesando Llamada critica y de emergencia");
                break;
            case "Indicador de Urgencia: 110":
                System.out.println(" Control de trabajo de Internet");
                break;
            case "Indicador de Urgencia: 111":
                System.out.println(" Control de Red");
                break;
            default:
                System.out.println(" Indicador de Urgencia no disponible");
                break;
        }
    }
    public  void switchBandera(String bandera){
        switch(bandera){
            case "bandera: 000":
                System.out.println(" es Divisible y es el ultimo Fragmento");
                break;
            case "bandera: 001":
                System.out.println(" es Divisible y es un Fragmento intermedio");
                break;
            case "bandera: 010":
                System.out.println(" No es divisible y es el ultimo fragmento");
                break;
            case "bandera: 011":
                System.out.println(" No es divisible y es un Fragmento intermedio");
                break;
            default:
                System.out.println(" Bandera No reconocido");
                break;
            
        }
    }
     public void switchProtocolo(String protocolo){
        switch(protocolo){
            case "Protocolo: 1":
                System.out.println(" es ICMP");
                setProtocolo("ICMP");
                break;
            case "Protocolo: 2":
                System.out.println(" es IGMP");
                setProtocolo("");
                break;
            case "Protocolo: 3":
                System.out.println(" es GGP");
                setProtocolo("");
                break;
            case "Protocolo: 4":
                System.out.println(" es IP");
                setProtocolo("");
                break;
            case "Protocolo: 5":
                System.out.println(" es ST");
                setProtocolo("");
                break;
            case "Protocolo: 6":
                System.out.println(" es TCP");
                setProtocolo("TCP");
                break;
            case "Protocolo: 7":
                System.out.println(" es CBT");
                setProtocolo("");
                break;
            case "Protocolo: 8":
                System.out.println(" es EGP");
                setProtocolo("");
                break;
            case "Protocolo: 9":
                System.out.println(" es IGP");
                setProtocolo("");
                break;
            case "Protocolo: 10":
                System.out.println(" es BBN-RCC-MON");
                setProtocolo("");
                break;
            case "Protocolo: 17":
                System.out.println(" es UDP");
                setProtocolo("UDP");
                break;
            case "Protocolo: 18":
                System.out.println(" es MUX");
                setProtocolo("");
                break;
            case "Protocolo: 27":
                System.out.println(" es RDP");
                setProtocolo("");
                break;
            case "Protocolo: 28":
                System.out.println(" es IRTP");
                setProtocolo("");
                break;
            case "Protocolo: 45":
                System.out.println(" es IDRP");
                setProtocolo("");
                break;
            case "Protocolo: 46":
                System.out.println(" es RSVP");
                setProtocolo("");
                break;
            case "Protocolo: 47":
                System.out.println(" es GRE");
                setProtocolo("");
                break;
            case "Protocolo: 48":
                System.out.println(" es MHRP");
                setProtocolo("");
                break;
            case "Protocolo: 50":
                System.out.println(" es ESP");
                setProtocolo("");
                break;
            case "Protocolo: 51":
                System.out.println(" es AH");
                setProtocolo("");
                break;
            case "Protocolo: 54":
                System.out.println(" es NARP");
                setProtocolo("");
                break;
            case "Protocolo: 55":
                System.out.println(" es MOBILE");
                setProtocolo("");
                break;
            case "Protocolo: 88":
                System.out.println(" es EIGRP");
                setProtocolo("");
                break;
            case "Protocolo: 89":
                System.out.println(" es OSPF");
                setProtocolo("");
                break;
            case "Protocolo: 94":
                System.out.println(" es IPIP");
                setProtocolo("");
                break;
            case "Protocolo: 95":
                System.out.println(" es MICP");
                setProtocolo("");
                break;
            case "Protocolo: 97":
                System.out.println(" es ETHERIP");
                setProtocolo("");
                break;
            case "Protocolo: 98":
                System.out.println(" es ENCAP");
                setProtocolo("");
                break;
            case "Protocolo: 103":
                System.out.println(" es PIM");
                setProtocolo("");
                break;
            case "Protocolo: 112":
                System.out.println(" es VRRP");
                setProtocolo("");
                break;
            case "Protocolo: 113":
                System.out.println(" es PGM");
                setProtocolo("");
                break;
            case "Protocolo: 115":
                System.out.println(" es L2TP");
                setProtocolo("");
                break;
            case "Protocolo: 118":
                System.out.println(" es STP");
                setProtocolo("");
                break;
            case "Protocolo: 121":
                System.out.println(" es SMP");
                setProtocolo("");
                break;
            case "Protocolo: 131":
                System.out.println(" es PIPE");
                setProtocolo("");
                break;
            case "Protocolo: 132":
                System.out.println(" es SCTP");
                setProtocolo("");
                break;
            case "Protocolo: 133":
                System.out.println(" es FC");
                setProtocolo("");
                break;
            case "Protocolo: 137":
                System.out.println(" es MPLS-in-IP");
                setProtocolo("");
                break;
            case "Protocolo: 139":
                System.out.println(" es HIP");
                setProtocolo("");
                break;
            default:
                System.out.println(" Protocolo No reconocido");
                break;
            
        }
    }
    //falta opciones IP 
}