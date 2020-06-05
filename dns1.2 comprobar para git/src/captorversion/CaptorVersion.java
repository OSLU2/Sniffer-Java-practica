/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captorversion;
import java.util.Scanner;

/**
 *
 * @author oswal
 */
public class CaptorVersion {

    public static final String ARCHIVO_A_DESENCRIPTAR = "pruebapaquete.bin";
    public static final int SALIR = 2;
    public static final int DESENCRIPTAR = 1;
    
    
    public static void main(String[] args) {
        Archivo Administrador = new Archivo();
        ConverHexa Lector = new ConverHexa();
        Sniffer sniffer = new Sniffer();
        Scanner Leer = new Scanner(System.in);
        int opcion = 0;
        int opcionDisp =1;  // Aqui esta por default el ethernet;
        while(opcion!=SALIR)
        {
            //impresion de menu
            System.out.println("menu");
            System.out.println("1. leer Paquetes");
            System.out.println("2. Salir");
            System.out.print("Elige una opcion: ");
            opcion = Leer.nextInt();
            switch(opcion)
            {
                case DESENCRIPTAR:
                    // la funcion de abajo es para mostrar el cambio de dispositivo.
                    /*System.out.println("seleciona dispositivo:(donde esta conectado) ");
                    System.out.println("0. Ethernet");
                    System.out.println("1. Wifi");
                    System.out.print("Elige una opcion: ");
                    opcionDisp = Leer.nextInt();*/
                    sniffer.disp=opcionDisp;
                    sniffer.run();
                    desencriptar(Lector,Administrador,sniffer);
                    break;
                case SALIR:  
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }
    
    public static void desencriptar(ConverHexa Lector, Archivo Administrador,Sniffer sniffer){
        byte[] archivo;
        String hexaorigen,destino,origen;
        String tipo,datos;
        archivo=sniffer.b;
        DNS paqDns = new DNS();
        //archivo = Administrador.leer(ARCHIVO_A_DESENCRIPTAR,0);
        if(archivo!=null){
            System.out.println("archivo leido");
            
            hexaorigen=Lector.toHexString(archivo);
            destino=Lector.destino(archivo);
            origen=Lector.origen(archivo);
            tipo=Lector.tipo(archivo);        
            

            System.out.println(hexaorigen);
            System.out.println(destino);
            System.out.println(origen);
            System.out.print(tipo);
            Lector.switchTipo(tipo);

            TipoTrama(Lector.getTipo(),archivo,Lector);//muestra datos segun la trama
            datos=Lector.datos(archivo,Lector.cont);
            System.out.println(datos);
            System.gc();
        }
        else{
            System.out.println("No se encontro archivo");
        }
    }
    // movi los switch a las clases correspondientes
    //estos switch son para que lea segun el tipo de trama o protocolo
    // son casi igual a los switch de tipo y protocol pero esos deben ir en medio y estos datos al final
    public static void TipoTrama(String trama,byte[] archivo,ConverHexa Lector){
        switch(trama){
            case "ARP":
                ARP paqArp = new ARP();
                String tipoHard,tipoProto,longMac;
                String longIp,codeOpera,origenMac;
                String origenIp,destinoMac,destinoIp;
                tipoHard=paqArp.tipoHard(archivo);
                tipoProto=paqArp.tipoProto(archivo);
                longMac=paqArp.LongMac(archivo);
                longIp=paqArp.LongIp(archivo);
                codeOpera=paqArp.CodeOpera(archivo);
                origenMac=paqArp.origenMac(archivo);
                origenIp=paqArp.origenIp(archivo);
                destinoMac=paqArp.destinoMac(archivo);
                destinoIp=paqArp.destinoIp(archivo);
                System.out.println(tipoHard);
                paqArp.switchTipoHw(tipoHard);
                System.out.print(tipoProto);
                paqArp.switchTipoPro(tipoProto);
                System.out.println(longMac);
                System.out.println(longIp);
                System.out.println(codeOpera);
                paqArp.switchCodeOpera(codeOpera);
                System.out.println(origenMac);
                System.out.println(origenIp);
                System.out.println(destinoMac);
                System.out.println(destinoIp);
                Lector.cont=paqArp.contArp;//actualiza
                break;
            case "IPv4":
                paqueteIPv4 paqIPv4 =new paqueteIPv4();
                String version,tamCab,tipoServ,tipoCarac;
                String longi,identifi,flag,posifrag;
                String vida,proto,crtlcabe,direOrigen,direDestino;

                version=paqIPv4.version(archivo);
                tamCab=paqIPv4.LongCabec(archivo);
                tipoServ=paqIPv4.tipoServ(archivo);
                tipoCarac=paqIPv4.tipoCarac(archivo);
                longi=paqIPv4.longi(archivo);
                identifi=paqIPv4.indentifi(archivo);
                flag=paqIPv4.flag(archivo);
                posifrag=paqIPv4.posiFrag(archivo);
                vida=paqIPv4.vida(archivo);
                proto=paqIPv4.protocol(archivo);
                direOrigen=paqIPv4.DirecciIPOrigen(archivo);
                direDestino=paqIPv4.DirecciIPDestino(archivo);
                crtlcabe=paqIPv4.CtrlCabe(archivo);

                System.out.println(version);
                System.out.println(tamCab);
                System.out.print(tipoServ);
                paqIPv4.switchTipoServ(tipoServ);
                System.out.println(tipoCarac);
                System.out.println(longi);
                System.out.println(identifi);
                System.out.print(flag);
                paqIPv4.switchBandera(flag);
                System.out.println(posifrag);
                System.out.println(vida);
                System.out.print(proto);
                paqIPv4.switchProtocolo(proto);
                
                System.out.println(crtlcabe);
                System.out.println(direOrigen);
                System.out.println(direDestino);
                TipoProto(paqIPv4.getProtocolo(),archivo,Lector);//muestra datos segun el protocolo
                break;
            case "RARP":
                
                break;
            case "IPv6":
                ipv6 paqipv6 = new ipv6();
                String vrs,claseTrafico,etiquetaFlujo,tamañoCarga;
                String encabezadoSig,limiteSalto,origen,destino;
                vrs=paqipv6.version(archivo);
                claseTrafico=paqipv6.trafficClass(archivo);
                etiquetaFlujo=paqipv6.flowLabel(archivo);
                tamañoCarga=paqipv6.payloadLength(archivo);
                encabezadoSig=paqipv6.nextHeader(archivo);
                limiteSalto=paqipv6.hopLimit(archivo);
                origen=paqipv6.sourceAddress(archivo);
                destino=paqipv6.destinationAddres(archivo);
                System.out.println(vrs);
                System.out.println(claseTrafico);
                System.out.println(etiquetaFlujo);
                System.out.println(tamañoCarga);
                System.out.println(encabezadoSig);
                System.out.println(limiteSalto);
                System.out.println(origen);
                System.out.println(destino);
                
                Lector.cont=paqipv6.contIPv6;
                System.out.println("Valor del protocolo: -----------------");
                System.out.println(paqipv6.getProtocolo());
                
                
                TipoProto(paqipv6.getProtocolo(),archivo,Lector);//muestra datos segun el protocolo
                break;
            default:
                System.out.println("Checar que exite archivo");
                break;
        }
    }
    public static void TipoProto(String protocolo,byte[] archivo, ConverHexa Lector){
        DNS paqDns = new DNS();
        String id, qr, opCode, aa, tc, rd, ra, z, rcode, qdCount, anCount, nsCount, arCount;
        switch(protocolo){
            case "ICMP":
                System.out.println("para leer el protocolo");
                System.out.println(protocolo);
                       
                icmpv4 paqIcmpv4 = new icmpv4();
                String tipoicmp, codigoicmp, checksumicmp;
        
                tipoicmp = paqIcmpv4.TipoICMP(archivo);
                codigoicmp = paqIcmpv4.CodigoICMP(archivo);
                checksumicmp = paqIcmpv4.ChecksumICMP(archivo);

                System.out.print(tipoicmp);
                paqIcmpv4.switchTipoICMP(tipoicmp);
                System.out.print(codigoicmp);
                paqIcmpv4.switchCodigoICMP(codigoicmp);
                System.out.println(checksumicmp);
                Lector.cont=paqIcmpv4.contIcmp;//actualiza el contador
                break;
            case "ICMPV6":
                System.out.println("para leer el protocolo");
                System.out.println(protocolo);
                       
                icmpv6 paqIcmpv6 = new icmpv6();
                String tipoicmpv6, codigoicmpv6, checksumicmpv6;
        
                tipoicmpv6 = paqIcmpv6.TipoICMPv6(archivo);
                codigoicmpv6 = paqIcmpv6.CodigoICMPv6(archivo);
                checksumicmpv6 = paqIcmpv6.ChecksumICMPv6(archivo);

                System.out.print(tipoicmpv6);
                paqIcmpv6.switchTipoICMPv6(tipoicmpv6);
                System.out.print(codigoicmpv6);
                paqIcmpv6.switchCodigoICMP(codigoicmpv6);
                System.out.println(checksumicmpv6);
                Lector.cont=paqIcmpv6.contIcmp;//actualiza el contador
                break;
            case "IGMP":
                
                break;
            case "GGP":
                
                break;
            case "IP":
                
                break;
            case "ST":
                
                break;
            case "TCP":
                System.out.println("para leer el protocolo");
                System.out.println(protocolo);
                       
                TCP paqTcp = new TCP();
                String PuertoOrigen, PuertoDestino, numSec, numAcu, longcab;
                String reserv, band, tamVen, Check, PuntUrg;
        
                PuertoOrigen = paqTcp.PuertoOrigen(archivo);
                System.out.println(PuertoOrigen);

                PuertoDestino = paqTcp.PuertoDestino(archivo);
                System.out.println(PuertoDestino);

                numSec = paqTcp.NumSecuencia(archivo);
                System.out.println(numSec);

                numAcu = paqTcp.NumAcuse(archivo);
                System.out.println(numAcu);
                
                longcab = paqTcp.LongCabecera(archivo);
                System.out.println(longcab);

                reserv = paqTcp.Reservado(archivo);
                System.out.println(reserv);
                
                band = paqTcp.Banderas(archivo);
                System.out.println(band);
                
                tamVen = paqTcp.TamVentana(archivo);
                System.out.println(tamVen);

                Check = paqTcp.ChecksumTcp(archivo);
                System.out.println(Check);

                PuntUrg = paqTcp.PunteroUrgente(archivo);
                System.out.println(PuntUrg);
                Lector.cont=paqTcp.contTcp;
                //Lectura DNS
                if(Lector.cont+1!=0){
                id = paqDns.id(archivo, paqTcp.contTcp);
                System.out.println(id);
                
                qr = paqDns.qr(archivo);
                System.out.println(qr);
                
                opCode = paqDns.opCode(archivo);
                System.out.println(opCode);
                
                aa = paqDns.aa(archivo);
                System.out.println(aa);
                
                tc = paqDns.tc(archivo);
                System.out.println(tc);
                
                rd = paqDns.rd(archivo);
                System.out.println(rd);
                
                ra = paqDns.ra(archivo);
                System.out.println(ra);
                
                z = paqDns.z(archivo);
                System.out.println(z);
                
                rcode = paqDns.rcode(archivo);
                System.out.println(rcode);
                
                qdCount = paqDns.qr(archivo);
                System.out.println(qdCount);
                
                anCount = paqDns.anCount(archivo);
                System.out.println(anCount);
                
                nsCount = paqDns.nsCount(archivo);
                System.out.println(nsCount);
                
                arCount = paqDns.arCount(archivo);
                System.out.println(arCount);
                }
                break;
            case "CBT":
                
                break;
            case "EGP":
                
                break;
            case "IGP":
                
                break;
            case "Protocolo: 10":
                System.out.println(" es BBN-RCC-MON");
                break;
            case "UDP":
                System.out.println("para leer el protocolo");
                System.out.println(protocolo);
                       
                UDP paqUdp = new UDP();
                String POrigen, PDestino, longitudTotal, suma;
        
                POrigen = paqUdp.PuertoOrigen(archivo);
                System.out.println(POrigen);

                PDestino = paqUdp.PuertoDestino(archivo);
                System.out.println(PDestino);

                longitudTotal = paqUdp.LongTotal(archivo);
                System.out.println(longitudTotal);

                suma = paqUdp.ChecksumUDP(archivo);
                System.out.println(suma);
                Lector.cont=paqUdp.contUDP;
                //Lectura DNS
                 if(Lector.cont+1!=0){
                id = paqDns.id(archivo, paqUdp.contUDP);
                System.out.println(id);
                
                qr = paqDns.qr(archivo);
                System.out.println(qr);
                
                opCode = paqDns.opCode(archivo);
                System.out.println(opCode);
                
                aa = paqDns.aa(archivo);
                System.out.println(aa);
                
                tc = paqDns.tc(archivo);
                System.out.println(tc);
                
                rd = paqDns.rd(archivo);
                System.out.println(rd);
                
                ra = paqDns.ra(archivo);
                System.out.println(ra);
                
                z = paqDns.z(archivo);
                System.out.println(z);
                
                rcode = paqDns.rcode(archivo);
                System.out.println(rcode);
                
                qdCount = paqDns.qr(archivo);
                System.out.println(qdCount);
                
                anCount = paqDns.anCount(archivo);
                System.out.println(anCount);
                
                nsCount = paqDns.nsCount(archivo);
                System.out.println(nsCount);
                
                arCount = paqDns.arCount(archivo);
                System.out.println(arCount);
                 }
                break;
            case "Protocolo: 18":
                System.out.println(" es MUX");
                break;
            case "Protocolo: 27":
                System.out.println(" es RDP");
                break;
            case "Protocolo: 28":
                System.out.println(" es IRTP");
                break;
            case "Protocolo: 45":
                System.out.println(" es IDRP");
                break;
            case "Protocolo: 46":
                System.out.println(" es RSVP");
                break;
            case "Protocolo: 47":
                System.out.println(" es GRE");
                break;
            case "Protocolo: 48":
                System.out.println(" es MHRP");
                break;
            case "Protocolo: 50":
                System.out.println(" es ESP");
                break;
            case "Protocolo: 51":
                System.out.println(" es AH");
                break;
            case "Protocolo: 54":
                System.out.println(" es NARP");
                break;
            case "Protocolo: 55":
                System.out.println(" es MOBILE");
                break;
            case "Protocolo: 88":
                System.out.println(" es EIGRP");
                break;
            case "Protocolo: 89":
                System.out.println(" es OSPF");
                break;
            case "Protocolo: 94":
                System.out.println(" es IPIP");
                break;
            case "Protocolo: 95":
                System.out.println(" es MICP");
                break;
            case "Protocolo: 97":
                System.out.println(" es ETHERIP");
                break;
            case "Protocolo: 98":
                System.out.println(" es ENCAP");
                break;
            case "Protocolo: 103":
                System.out.println(" es PIM");
                break;
            case "Protocolo: 112":
                System.out.println(" es VRRP");
                break;
            case "Protocolo: 113":
                System.out.println(" es PGM");
                break;
            case "Protocolo: 115":
                System.out.println(" es L2TP");
                break;
            case "Protocolo: 118":
                System.out.println(" es STP");
                break;
            case "Protocolo: 121":
                System.out.println(" es SMP");
                break;
            case "Protocolo: 131":
                System.out.println(" es PIPE");
                break;
            case "Protocolo: 132":
                System.out.println(" es SCTP");
                break;
            case "Protocolo: 133":
                System.out.println(" es FC");
                break;
            case "Protocolo: 137":
                System.out.println(" es MPLS-in-IP");
                break;
            case "Protocolo: 139":
                System.out.println(" es HIP");
                break;
            default:
                System.out.println(" Protocolo No reconocido");
                break;
            
        }
    }
}
