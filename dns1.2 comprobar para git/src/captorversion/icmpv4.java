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
public class icmpv4 {
    public static int contIcmp;
    public String TipoICMP(byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Tipo de ICMP: ");
        int i=34, iarray;
        iarray=bytes[i] & 0xff;
        sb.append(iarray);
        return sb.toString();
    }

    public String CodigoICMP(byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Código de error de ICMP: ");
        int i=35, iarray;    
        iarray=bytes[i] & 0xff;
        sb.append(iarray);        
        return sb.toString();
    }

    public String ChecksumICMP(byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Checksum: ");
        int i, iarray;
        for(i=36;i<38;i++){
            
            iarray=bytes[i] & 0xff;
            sb.append(iarray);
        }
        contIcmp=38;
        return sb.toString();
    }
    public void switchTipoICMP(String tipoICMP){
        switch(tipoICMP){
            case "Tipo de ICMP: 0":
                System.out.println(" Echo Reply (Respuesta de Eco)");
                break;
            case "Tipo de ICMP: 3":
                System.out.println(" Destination Unreacheable (Destino inaccesible)");
                break;
            case "Tipo de ICMP: 4":
                System.out.println(" Source Quench (disminución del tráfico desde el origen)");
                break;
            case "Tipo de ICMP: 5":
                System.out.println(" Redirect (redireccionar - cambio de ruta)");
                break;
            case "Tipo de ICMP: 8":
                System.out.println(" Echo (solicitud de eco)");
                break;
            case "Tipo de ICMP: 11":
                System.out.println(" Time Exceeded (tiempo excedido para un datagrama)");
                break;
            case "Tipo de ICMP: 12":
                System.out.println(" Parameter Problem (problema de parámetros)");
                break;
            case "Tipo de ICMP: 13":
                System.out.println(" Timestamp (solicitud de marca de tiempo)");
                break;
            case "Tipo de ICMP: 14":
                System.out.println(" Timestamp Reply (respuesta de marca de tiempo)");
                break;
            case "Tipo de ICMP: 15":
                System.out.println(" Information Request (solicitud de información) - obsoleto- ");
                break;
            case "Tipo de ICMP: 16":
                System.out.println(" Information Reply (respuesta de información) - obsoleto- ");
                break;
            case "Tipo de ICMP: 17":
                System.out.println(" Addressmask (solicitud de máscara de dirección)");
                break;
            case "Tipo de ICMP: 18":
                System.out.println(" Addressmask Reply (respuesta de máscara de dirección)");
                break;
            default:
                System.out.println(" Tipo de ICMP no disponible");
                break;
        }
    }
    
        public void switchCodigoICMP(String tipoICMP){
        switch(tipoICMP){
            case "Código de error de ICMP: 0":
                System.out.println(" no se puede llegar a la red");
                break;
            case "Código de error de ICMP: 1":
                System.out.println(" no se puede llegar al host o aplicación de destino");
                break;
            case "Código de error de ICMP: 2":
                System.out.println(" el destino no dispone del protocolo solicitado ");
                break;
            case "Código de error de ICMP: 3":
                System.out.println(" no se puede llegar al puerto destino o la aplicación destino no está libre");
                break;
            case "Código de error de ICMP: 4":
                System.out.println(" se necesita aplicar fragmentación, pero el flag correspondiente indica lo contrario");
                break;
            case "Código de error de ICMP: 5":
                System.out.println(" la ruta de origen no es correcta");
                break;
            case "Código de error de ICMP: 6":
                System.out.println(" no se conoce la red destino");
                break;
            case "Código de error de ICMP: 7":
                System.out.println(" no se conoce el host destino");
                break;
            case "Código de error de ICMP: 8":
                System.out.println(" el host origen está aislado");
                break;
            case "Código de error de ICMP: 9":
                System.out.println(" la comunicación con la red destino está prohibida por razones administrativas");
                break;
            case "Código de error de ICMP: 10":
                System.out.println(" la comunicación con el host destino está prohibida por razones administrativas");
                break;
            case "Código de error de ICMP: 11":
                System.out.println(" no se puede llegar a la red destino debido al Tipo de servicio");
                break;
            case "Código de error de ICMP: 12":
                System.out.println(" no se puede llegar al host destino debido al Tipo de servicio");
                break;
            default:
                System.out.println(" Tipo de ICMP no disponible");
                break;
        }
    }
}
