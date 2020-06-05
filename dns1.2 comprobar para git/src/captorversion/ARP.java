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
public class ARP {// funciona para ARP y RARP
    private int longIP;
    public int getLongIP(){
        return longIP;
    }
    public void setLongIP(int longIP){
        this.longIP=longIP;
    }
    public static int contArp;
    public String tipoHard (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Tipo de Hardware: ");
        int i;
        int iarray;
        for(i=14;i<16;i++){            
            iarray=bytes[i] & 0xff;
            sb.append(iarray);
        }
        return sb.toString();
    }
    public String tipoProto(byte[] z){//tipo de trama
        StringBuilder o = new StringBuilder( 2 );
        int i;
        int limite=18;
        o.append("Tipo: ");
        for(i=16;i<limite;i++)
        {
            o.append( ConverHexa.toHex(z[i] >> 4) );
            if(i<limite-1){
                o.append( ConverHexa.toHex(z[i])+ ":" );
            }
            else{
                o.append( ConverHexa.toHex(z[i]) );
            }
        }
        return o.toString();
    }
    public void switchTipoPro(String tipo){
        switch(tipo){
            case "Tipo: 08:06":
                System.out.println(" es ARP");
                
                break;
            case "Tipo: 08:00":
                System.out.println(" es IPv4");
                
                break;
            case "Tipo: 08:35":
                System.out.println(" es RARP");
                
                break;
            case "Tipo: 86:DD":
                System.out.println(" es IPv6");
                
                break;
            default:
                System.out.println(" Tipo de trama No reconocido");
                break;            
        }
    }
    public String LongMac(byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Longitud de Direccion MAC: ");
        int i=18;
        int iarray;
        iarray=bytes[i] & 0xff;
        sb.append(iarray);
        return sb.toString();
    }
    public String LongIp(byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Longitud de Direccion MAC: ");
        int i=19;
        int iarray;
        iarray=bytes[i] & 0xff;
        setLongIP(iarray);
        sb.append(iarray);
        return sb.toString();
    }
    public String CodeOpera(byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Código de Operación: ");
        int i;
        int iarray;
        for(i=20;i<22;i++){            
            iarray=bytes[i] & 0xff;
            sb.append(iarray);
        }
        return sb.toString();
    }
    public String origenMac(byte[] z){//direccion mac origen
        StringBuilder o = new StringBuilder( z.length*2 );
        int i;
        int limite=28;
        o.append("Dirección origen Mac: ");
        for(i=22;i<limite;i++)
        {
            o.append( ConverHexa.toHex(z[i] >> 4) );
            if(i<limite-1){
                o.append( ConverHexa.toHex(z[i])+ ":" );
            }
            else{
                o.append( ConverHexa.toHex(z[i]) );
            }
        }
        return o.toString();
    }
    public String origenIp (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Dirección IP origen: ");
        
        int i, iarray;
        int limite=28+getLongIP();
        for(i=28;i<limite;i++){//limite es 32
            
            iarray=bytes[i] & 0xff;
            sb.append(iarray);
            
            if(i!=limite-1){
                sb.append(".");
            }
        }
        contArp=28+getLongIP();
        return sb.toString();
    }
    public String destinoMac(byte[] z){//direccion mac origen
        StringBuilder o = new StringBuilder( z.length*2 );
        int i;
        int limite=contArp+6;
        o.append("Dirección Destino Mac: ");
        for(i=contArp;i<limite;i++)//limite es 28
        {
            o.append( ConverHexa.toHex(z[i] >> 4) );
            if(i<limite-1){
                o.append( ConverHexa.toHex(z[i])+ ":" );
            }
            else{
                o.append( ConverHexa.toHex(z[i]) );
            }
        }
        contArp=limite;
        return o.toString();
    }
    public String destinoIp (byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Dirección IP receptor: ");
        
        int i, iarray;
        int limite=contArp+4;
        for(i=contArp;i<limite;i++){//limite 42
            
            iarray=bytes[i] & 0xff;
            sb.append(iarray);
            
            if(i!=limite-1){
                sb.append(".");
            }
        }
        contArp=limite;
        
        return sb.toString();
    }
    public void switchTipoHw(String tipo){
        switch(tipo){
            case "Tipo de Hardware: 00":
                System.out.println(" Reserved");
                break;
            case "Tipo de Hardware: 01":
                System.out.println(" Ethernet (10Mb)");
                break;
            case "Tipo de Hardware: 02":
                System.out.println(" Experimental Ethernet (3Mb)");
                break;
            case "Tipo de Hardware: 03":
                System.out.println(" Amateur Radio AX2.5");
                break;
            case "Tipo de Hardware: 04":
                System.out.println(" Proteon ProNET Token Ring");
                break;
            case "Tipo de Hardware: 05":
                System.out.println(" Chaos");
                break;
            case "Tipo de Hardware: 06":
                System.out.println(" IEEE 802 Networks");
                break;
            case "Tipo de Hardware: 07":
                System.out.println(" ARCNET");
                break;
            case "Tipo de Hardware: 08":
                System.out.println(" Hyperchannel");
                break;
            case "Tipo de Hardware: 09":
                System.out.println(" Lanstar");
                break;
            case "Tipo de Hardware: 10":
                System.out.println(" Autonet Short Address");
                break;
            case "Tipo de Hardware: 11":
                System.out.println(" LocalTalk");
                break;
            case "Tipo de Hardware: 12":
                System.out.println(" LocalNet (IBM PCNet or SYTEK LocalNET)");
                break;
            case "Tipo de Hardware: 13":
                System.out.println(" Ultra link");
                break;
            case "Tipo de Hardware: 14":
                System.out.println(" SMDS");
                break;
            case "Tipo de Hardware: 15":
                System.out.println(" Frame Relay");
                break;
            case "Tipo de Hardware: 16":
                System.out.println(" Asynchronous Transmission Mode (ATM)");
                break;
            case "Tipo de Hardware: 17":
                System.out.println(" HDLC");
                break;
            case "Tipo de Hardware: 18":
                System.out.println(" Fibre Channel");
                break;
            case "Tipo de Hardware: 19":
                System.out.println(" Asynchronous Transmission Mode (ATM)");
                break;
            case "Tipo de Hardware: 20":
                System.out.println(" Serial Line");
                break;
            case "Tipo de Hardware: 21":
                System.out.println(" Asynchronous Transmission Mode (ATM)");
                break;
            case "Tipo de Hardware: 22":
                System.out.println(" MIL-STD-188-220");
                break;
            case "Tipo de Hardware: 23":
                System.out.println(" Metricom");
                break;
            case "Tipo de Hardware: 24":
                System.out.println(" IEEE 1394.1995");
                break;
            case "Tipo de Hardware: 25":
                System.out.println(" MAPOS");
                break;
            case "Tipo de Hardware: 26":
                System.out.println(" Twinaxial");
                break;
            case "Tipo de Hardware: 27":
                System.out.println(" EUI-64");
                break;
            case "Tipo de Hardware: 28":
                System.out.println(" HIPARP");
                break;
            case "Tipo de Hardware: 29":
                System.out.println(" IP and ARP over ISO 7816-3");
                break;
            case "Tipo de Hardware: 30":
                System.out.println(" ASPSec");
                break;
            case "Tipo de Hardware: 31":
                System.out.println(" IPsec Tunnel");
                break;
            case "Tipo de Hardware: 32":
                System.out.println(" InfiniBand (TM)");
                break;
            case "Tipo de Hardware: 33":
                System.out.println(" TIA-102 Project 25 Common Air Interface (CAI)");
                break;
            case "Tipo de Hardware: 34":
                System.out.println(" Wiegand Interface");
                break;
            case "Tipo de Hardware: 35":
                System.out.println(" Pure IP");
                break;
            case "Tipo de Hardware: 36":
                System.out.println(" HW_EXP1");
                break;
            case "Tipo de Hardware: 37":
                System.out.println(" HFI");
                break;
            default:
                System.out.println("Tipo no válido");
                break;
        }
    }
    public void switchCodeOpera(String codeOpera){
        switch(codeOpera){
            case "Código de Operación: 01":
                System.out.println(" Solicitud ARP");
            
                break;
            case "Código de Operación: 02":
                System.out.println(" Respuesta ARP");
                
                break;
            case "Código de Operación: 03":
                System.out.println(" Solicitud RARP");
                
                break;
            case "Código de Operación: 04":
                System.out.println(" Respuesta RARP");
                
                break;
            default:
                System.out.println(" Codigo no válido");
                
                break;
        }
    }
}
