/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captorversion;
import jpcap.JpcapCaptor;
import jpcap.PacketReceiver;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.NetworkInterface;

/**
 *
 * @author oswal
 */
public class captorPackets implements PacketReceiver {
    public captorPackets(){
        
    }
            
    public void receivePacket(Packet packet) {
       
        if (packet instanceof TCPPacket) {
            //System.out.println(packet);
            
            TCPPacket tcp = (TCPPacket) packet;
            System.out.println("IP fuente " + tcp.src_ip
            + "\nPuerto fuente " + tcp.src_port
            + "\nIp dest " + tcp.dst_ip
            + "\nPuerto dest " + tcp.dst_port
            + "\nLongitud " + tcp.length
            + "\nHeader " +tcp.header
            + "\nDatalink " + tcp.datalink
            + "\n-----------------------------------------------");
           
            /*if(tcp.src_port == 80 || tcp.src_port == 443 || tcp.dst_port == 80 || tcp.dst_port == 443)
                System.err.println("Paquetes que pasan por web " + ++CaptorVersion.web);
            else if(tcp.src_port == 21 || tcp.dst_port == 21 || tcp.dst_port == 22 || tcp.src_port == 22)
                System.err.println("Paquetes que pasan por ftp " + ++CaptorVersion.ftp);
            else
                System.err.println("Paquetes otros " + ++CaptorVersion.otros);*/
               
        }
     
    }
    
}
