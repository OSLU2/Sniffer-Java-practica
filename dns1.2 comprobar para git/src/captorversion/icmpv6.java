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
public class icmpv6 {
    // lo que se tendra que modificar es en el contador de cada funcion el cual iniciara en 54 y no en 34
    
    public static int contIcmp;
    public String TipoICMPv6(byte[] bytes){
        StringBuilder sb = new StringBuilder( bytes.length );
        sb.append("Tipo de ICMP: ");
        int i=54, iarray;
        iarray=bytes[i] & 0xff;
        sb.append(iarray);
        return sb.toString();
    }

    public String CodigoICMPv6(byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Código de error de ICMP: ");
        int i=55, iarray;    
        iarray=bytes[i] & 0xff;
        sb.append(iarray);        
        return sb.toString();
    }

    public String ChecksumICMPv6(byte[] bytes){
        StringBuilder sb = new StringBuilder( 1 );
        sb.append("Checksum: ");
        int i, iarray;
        for(i=56;i<58;i++){
            
            iarray=bytes[i] & 0xff;
            sb.append(iarray);
        }
        contIcmp=58;
        return sb.toString();
    }
    public void switchTipoICMPv6(String tipoICMPv6){
        switch(tipoICMPv6){
            case "Tipo de ICMP: 1":
                System.out.println("Destino inaccesible");
                break;
            case "Tipo de ICMP: 10":
                System.out.println(" No existe ruta al destino");
                break;
            case "Tipo de ICMP: 12":
                System.out.println("No asignado ");
                break;
            case "Tipo de ICMP: 13":
                System.out.println("Direccion inalcanzable");
                break;
            case "Tipo de ICMP: 14":
                System.out.println("Puesrto inalcanzable");
                break;
            case "Tipo de ICMP: 2":
                System.out.println("Paquete demaciado grande");
                break;
            case "Tipo de ICMP: 3":
                System.out.println(" Tiempo excedido");
                break;
            case "Tipo de ICMP: 30":
                System.out.println(" Limite de saltos excedido");
                break;
            case "Tipo de ICMP: 31":
                System.out.println(" Tiempo excedido en el rensamble del paquete ");
                break;
            case "Tipo de ICMP: 4":
                System.out.println(" Problema de paràmetros ");
                break;
            case "Tipo de ICMP: 40":
                System.out.println(" Error en el campo de encabezados ");
                break;
            case "Tipo de ICMP: 41":
                System.out.println(" Tipo de siguiente encabezado desconocido ");
                break;
            case "Tipo de ICMP: 42":
                System.out.println(" Opción IPV6 desconocida");
                break;
            
            case "Tipo de ICMP: 128":
                System.out.println(" Solicitud de eco");
                break;
            case "Tipo de ICMP: 129":
                System.out.println(" Respuesta de eco");
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

