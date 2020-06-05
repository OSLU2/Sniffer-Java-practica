/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captorversion;

/**
 *
 * @author Thag
 */
public class UDP {
    public static int contUDP;
    public String PuertoOrigen(byte[] bytes)
    {
        StringBuilder hx = new StringBuilder( bytes.length );
        int i, iarray;
        for(i=34;i<36;i++){
            hx.append(ConverHexa.toHex(bytes[i] >> 4) );
            hx.append( ConverHexa.toHex(bytes[i] ));
        }
        iarray = Integer.parseInt(hx.toString(), 16);
        
        StringBuilder sb = new StringBuilder( bytes.length );

        sb.append("Puerto Origen: ");
        sb.append(iarray);

        sb.append(TipoPuerto(sb.toString()));

        return sb.toString();
    }
    public String PuertoDestino(byte[] bytes)
    {
        StringBuilder hx = new StringBuilder( bytes.length );
        int i, iarray;
        for(i=36;i<38;i++){
            hx.append(ConverHexa.toHex(bytes[i] >> 4) );
            hx.append( ConverHexa.toHex(bytes[i] ));
        }
        iarray = Integer.parseInt(hx.toString(), 16);
        
        StringBuilder sb = new StringBuilder( bytes.length );

        sb.append("Puerto Destino: ");
        sb.append(iarray);

        sb.append(TipoPuerto(sb.toString()));

        return sb.toString();
    }
    public String LongTotal(byte[] bytes)
    {
        StringBuilder hx = new StringBuilder( bytes.length );
        int i, iarray;
        for(i=38;i<40;i++){
            hx.append(ConverHexa.toHex(bytes[i] >> 4) );
            hx.append( ConverHexa.toHex(bytes[i] ));
        }
        iarray = Integer.parseInt(hx.toString(), 16);
        
        StringBuilder sb = new StringBuilder( bytes.length );

        sb.append("Longitud Total: ");
        sb.append(iarray);

        return sb.toString();
    }
    public String ChecksumUDP(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("Checksum: ");
        int i;
        for(i=40;i<42;i++){
            sb.append(ConverHexa.toHex(bytes[i] >> 4) );
            sb.append( ConverHexa.toHex(bytes[i] ));
        }
        contUDP=42;
        return sb.toString();
    }
    public String TipoPuerto(String puerto){
        String port;
        switch(puerto){
            case "Puerto Destino: 1900":
                port = " Es SSDP";
                break;
            case "Puerto Destino: 3544":
                port = " Es Teredo";
                break;
            case "Puerto Destino: 80":
                port = " Es HTTP";
                break;
            case "Puerto Destino: 443":
                port = " Es HTTPS";
                break;
            case "Puerto Destino: 5353":
                port = " Es mdns";
                break;
            default:
                port = " Puerto No reconocido";
                break; 
        }
        return port;
    }
}
