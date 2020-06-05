/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captorversion;
import java.math.BigInteger;
/**
 *
 * @author Thag
 */
public class TCP 
{
    public static int contTcp;
    public String PuertoOrigen(byte[] bytes)
    {
        StringBuilder hx = new StringBuilder( bytes.length );
        StringBuilder sb = new StringBuilder( bytes.length );
        int i, iarray;
        for(i=34;i<36;i++){
            hx.append(ConverHexa.toHex(bytes[i] >> 4) );
            hx.append( ConverHexa.toHex(bytes[i] ));
        }
        iarray = Integer.parseInt(hx.toString(), 16);

        sb.append("Puerto Origen: ");
        sb.append(iarray);

        sb.append(TipoPuerto(iarray));

        return sb.toString();
    }
    public String PuertoDestino(byte[] bytes)
    {
        StringBuilder hx = new StringBuilder( bytes.length );
        StringBuilder sb = new StringBuilder( bytes.length );
        int i, iarray;
        for(i=36;i<38;i++){
            hx.append(ConverHexa.toHex(bytes[i] >> 4) );
            hx.append( ConverHexa.toHex(bytes[i] ));
        }
        iarray = Integer.parseInt(hx.toString(), 16);

        sb.append("Puerto Destino: ");
        sb.append(iarray);

        sb.append(TipoPuerto(iarray));

        return sb.toString();
    }
    public String NumSecuencia(byte[] bytes)
    {
        StringBuilder hx = new StringBuilder( bytes.length );
        StringBuilder sb = new StringBuilder( bytes.length );
        int i;
        BigInteger iarray;
        for(i=38;i<42;i++){
            hx.append(ConverHexa.toHex(bytes[i] >> 8) );
            hx.append( ConverHexa.toHex(bytes[i] ));
        }
        sb.append("En hexadecimal: ");
        sb.append(hx);
        sb.append(" ");
        try{
            iarray = new BigInteger(hx.toString(), 16);
            sb.append("Numero de secuencia: ");
            sb.append(iarray);
        }catch(NumberFormatException ex){ // handle your exception
           System.out.println("not a number"); 
        }

        return sb.toString();
    }
    public String NumAcuse(byte[] bytes)
    {
        StringBuilder hx = new StringBuilder( bytes.length );
        StringBuilder sb = new StringBuilder( bytes.length );
        int i; 
        BigInteger iarray;
        for(i=42;i<46;i++){
            hx.append(ConverHexa.toHex(bytes[i] >> 4) );
            hx.append( ConverHexa.toHex(bytes[i] ));
        }
        sb.append("En hexadecimal: ");
        sb.append(hx);
        sb.append(" ");
        try{
            iarray = new BigInteger(hx.toString(), 16);
            sb.append("Numero de acuse: ");
            sb.append(iarray);
        }catch(NumberFormatException ex){ // handle your exception
           System.out.println("not a number"); 
        }

        return sb.toString();
    }
    public String LongCabecera(byte[] bytes)
    {
        StringBuilder hx = new StringBuilder( 1 );
        int i;
        i=46;

        hx.append("Longitud de Cabecera: ");
        hx.append(ConverHexa.toHex(bytes[i] >> 4) );

        return hx.toString();
    }
    public String Reservado(byte[] bytes)
    {
        StringBuilder hx = new StringBuilder( 1 );
        int i;
        i=46;
        byte bait=bytes[i];
        String aux, aux1;

        aux=String.format("%8s", Integer.toBinaryString(bait & 0xFF)).replace(' ','0');
        hx.append("Reservado: ");
        aux1=aux.substring(4,7);
        hx.append(aux1);

        return hx.toString();
    }
    public String Banderas(byte[] bytes)
    {
        StringBuilder hx = new StringBuilder( 1 );
        int i;
        i=46;
        byte bait=bytes[i];
        String aux, aux1;

        aux=String.format("%8s", Integer.toBinaryString(bait & 0xFF)).replace(' ','0');
        hx.append("NS: ");
        aux1=aux.substring(7,8);
        if("1".equals(aux1))
        {
            hx.append(aux1);
            hx.append(" Activo\n");
        }else
        {
            hx.append(aux1);
            hx.append(" Inactivo\n");
        }
        i=47;
        bait = bytes[i];

        aux=String.format("%8s", Integer.toBinaryString(bait & 0xff)).replace(' ', '0');
        hx.append("CWR: ");
        aux1=aux.substring(0,1);
        if("1".equals(aux1))
        {
            hx.append(aux1);
            hx.append(" Activo\n");
        }else
        {
            hx.append(aux1);
            hx.append(" Inactivo\n");
        }

        aux=String.format("%8s", Integer.toBinaryString(bait & 0xff)).replace(' ', '0');
        hx.append("ECE: ");
        aux1=aux.substring(1,2);
        if("1".equals(aux1))
        {
            hx.append(aux1);
            hx.append(" Activo\n");
        }else
        {
            hx.append(aux1);
            hx.append(" Inactivo\n");
        }

        aux=String.format("%8s", Integer.toBinaryString(bait & 0xff)).replace(' ', '0');
        hx.append("URG: ");
        aux1=aux.substring(2,3);
        if("1".equals(aux1))
        {
            hx.append(aux1);
            hx.append(" Activo\n");
        }else
        {
            hx.append(aux1);
            hx.append(" Inactivo\n");
        }

        aux=String.format("%8s", Integer.toBinaryString(bait & 0xff)).replace(' ', '0');
        hx.append("ACK: ");
        aux1=aux.substring(3,4);
        if("1".equals(aux1))
        {
            hx.append(aux1);
            hx.append(" Activo\n");
        }else
        {
            hx.append(aux1);
            hx.append(" Inactivo\n");
        }

        aux=String.format("%8s", Integer.toBinaryString(bait & 0xff)).replace(' ', '0');
        hx.append("PSH: ");
        aux1=aux.substring(4,5);
        if("1".equals(aux1))
        {
            hx.append(aux1);
            hx.append(" Activo\n");
        }else
        {
            hx.append(aux1);
            hx.append(" Inactivo\n");
        }

        aux=String.format("%8s", Integer.toBinaryString(bait & 0xff)).replace(' ', '0');
        hx.append("RST: ");
        aux1=aux.substring(5,6);
        if("1".equals(aux1))
        {
            hx.append(aux1);
            hx.append(" Activo\n");
        }else
        {
            hx.append(aux1);
            hx.append(" Inactivo\n");
        }

        aux=String.format("%8s", Integer.toBinaryString(bait & 0xff)).replace(' ', '0');
        hx.append("SYN: ");
        aux1=aux.substring(6,7);
        if("1".equals(aux1))
        {
            hx.append(aux1);
            hx.append(" Activo\n");
        }else
        {
            hx.append(aux1);
            hx.append(" Inactivo\n");
        }

        aux=String.format("%8s", Integer.toBinaryString(bait & 0xff)).replace(' ', '0');
        hx.append("FIN: ");
        aux1=aux.substring(7,8);
        if("1".equals(aux1))
        {
            hx.append(aux1);
            hx.append(" Activo");
        }else
        {
            hx.append(aux1);
            hx.append(" Inactivo");
        }        

        return hx.toString();
    }
    public String TamVentana(byte[] bytes)
    {
        StringBuilder hx = new StringBuilder( bytes.length );
        StringBuilder sb = new StringBuilder( bytes.length );
        int i, iarray;
        for(i=48;i<50;i++){
            hx.append(ConverHexa.toHex(bytes[i] >> 4) );
            hx.append( ConverHexa.toHex(bytes[i] ));
        }
        iarray = Integer.parseInt(hx.toString(), 16);

        sb.append("Tamaño de Ventana: ");
        sb.append(iarray);

        return sb.toString();
    }
    public String ChecksumTcp(byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Checksum: ");
        int i;
        for(i=50;i<52;i++){
            sb.append(ConverHexa.toHex(bytes[i] >> 4) );
            sb.append( ConverHexa.toHex(bytes[i] ));
        }

        return sb.toString();
    }
    public String PunteroUrgente(byte[] bytes)
    {
        StringBuilder hx = new StringBuilder( bytes.length );
        StringBuilder sb = new StringBuilder( bytes.length );
        int i, iarray;
        for(i=52;i<54;i++){
            hx.append(ConverHexa.toHex(bytes[i] >> 4) );
            hx.append( ConverHexa.toHex(bytes[i] ));
        }
        iarray = Integer.parseInt(hx.toString(), 16);

        sb.append("Puntero Urgente: ");
        sb.append(iarray);

        contTcp = 54;
        return sb.toString();
    }
    public String TipoPuerto(int puerto){
        String port;
        switch(puerto){
            case 80:
                port = " Es HTTP";
                break;
            case 443:
                port = " Es HTTPS";
                break;
            case 1900:
                port = " Es SSDP";
                break;
            case 3544:
                port = " Es Teredo";
                break;
            case 5353:
                port = " Es mdns";
                break;
            default:
                port = " Puerto No reconocido";
                break;
            
        }
        return port;
    }
}
