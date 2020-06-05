/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captorversion;

/**
 *
 * @author casti
 */
public class DNS {
    public static int contDns;
    public int inicio = 0;
    
    public String id(byte[] bytes, int begin){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("ID: ");
        inicio = begin;
        int i, beg = inicio;
        for(i = beg; i < inicio + 2; i++){
            sb.append( ConverHexa.toHex(bytes[i] >> 4) );
            sb.append( ConverHexa.toHex(bytes[i]) );
        }
        inicio = i;
        return sb.toString();
    }
    
    public String qr(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("QR: ");
        int i = inicio;
        String aux,aux2;
        aux2 = "";
        aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
        aux2 = aux.substring(0,1);
        sb.append(aux);
        switch(aux2){
            case "0":
                sb.append("Consulta");
                break;
            case "1":
                sb.append("Respuesta");
                break;
            default:
                sb.append("Desconocido");
        }
        inicio = i;
        return sb.toString();
    }
    
    public String opCode(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("Opcode: ");
        int i = inicio;
        String aux,aux2;
        aux2 = "";
        aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
        aux2 = aux.substring(1,5);
        sb.append(aux);
        switch(aux2){
            case "0000":
                sb.append("consulta estandar (QUERY)");
                break;
            case "0001":
                sb.append("consulta inversa (IQUERY)");
                break;
            case "0010":
                sb.append("solicitud del estado del servidor (STATUS)");
                break;
            default:
                sb.append("desconocido");
                break;
        }
        inicio = i;
        return sb.toString();
    }
    
    public String aa(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("AA: ");
        int i = inicio;
        String aux,aux2;
        aux2 = "";
        aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
        aux2 = aux.substring(5,6);
        sb.append(aux);
        switch(aux2){
            case "0":
                sb.append("Activo");
                break;
            case "1":
                sb.append("Inactivo");
                break;
            default:
                sb.append("Desconocido");
        }
        inicio = i;
        return sb.toString();
    }
    
    public String tc(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("TC: ");
        int i = inicio;
        String aux,aux2;
        aux2 = "";
        aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
        aux2 = aux.substring(6,7);
        sb.append(aux);
        switch(aux2){
            case "0":
                sb.append("Activo");
                break;
            case "1":
                sb.append("Inactivo");
                break;
            default:
                sb.append("Desconocido");
        }
        inicio = i;
        return sb.toString();
    }
    
    public String rd(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("RD: ");
        int i = inicio;
        String aux,aux2;
        aux2 = "";
        aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
        aux2 = aux.substring(7,8);
        sb.append(aux);
        switch(aux2){
            case "0":
                sb.append("Activo");
                break;
            case "1":
                sb.append("Inactivo");
                break;
            default:
                sb.append("Desconocido");
        }
        inicio = i + 1;
        return sb.toString();
    }
    
    public String ra(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("RA: ");
        int i = inicio;
        String aux,aux2;
        aux2 = "";
        aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
        aux2 = aux.substring(0,1);
        sb.append(aux);
        switch(aux2){
            case "0":
                sb.append("Consulta");
                break;
            case "1":
                sb.append("Respuesta");
                break;
            default:
                sb.append("Desconocido");
        }
        inicio = i;
        return sb.toString();
    }
    
    public String z(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("Z: ");
        int i = inicio;
        String aux,aux2;
        aux2 = "";
        aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
        aux2 = aux.substring(1,4);
        sb.append(aux);
        if(aux2 == "0"){
            sb.append("000");
        }
        inicio = i;
        return sb.toString();
    }
    
    public String rcode(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("RCODE: ");
        int i = inicio;
        String aux,aux2;
        aux2 = "";
        aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
        aux2 = aux.substring(4,8);
        sb.append(aux);
        switch(aux2){
            case "0000":
                sb.append("Ningún error");
                break;
            case "0001":
                sb.append("Error de formato");
                break;
            case "0010":
                sb.append("Fallo en el servidor");
                break;
            case "0011":
                sb.append("Error en nombre");
                break;
            case "0100":
                sb.append("No implementado");
                break;
            case "0101":
                sb.append("Rechazado");
                break;
            default:
                sb.append("Desconocido");
        }
        inicio = i;
        return sb.toString();
    }
    
    public String qdCount(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("QDCount: ");
        String aux, aux1;
        int i, beg = inicio;
        for(i = beg; i < inicio + 2; i++){
            aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
            aux1=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
            sb.append(aux);
            sb.append(aux1);
        }
        inicio = i;
        return sb.toString();
    }
    
    public String anCount(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("ANCount: ");
        String aux, aux1;
        int i, beg = inicio;
        for(i = beg; i < inicio + 2; i++){
            aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
            aux1=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
            sb.append(aux);
            sb.append(aux1);
        }
        inicio = i;
        return sb.toString();
    }
    
    public String nsCount(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("NSCount: ");
        String aux, aux1;
        int i, beg = inicio;
        for(i = beg; i < inicio + 2; i++){
            aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
            aux1=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
            sb.append(aux);
            sb.append(aux1);
        }
        inicio = i;
        return sb.toString();
    }
    
    public String arCount(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("ARCount: ");
        String aux, aux1;
        int i, beg = inicio;
        for(i = beg; i < inicio + 2; i++){
            aux=String.format("%8s", Integer.toBinaryString(bytes[i] >>4 & 0xFF)).replace(' ','0');
            aux1=String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ','0');
            sb.append(aux);
            sb.append(aux1);
        }
        inicio = i;
        return sb.toString();
    }
}
