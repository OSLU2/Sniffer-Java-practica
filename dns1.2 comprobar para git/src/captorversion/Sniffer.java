/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captorversion;
import jpcap.*;
import jpcap.packet.Packet;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import jpcap.packet.EthernetPacket;
/**
 *
 * @author oswal
 */
public class Sniffer {
    boolean isRunning;
    byte[] b;
    NetworkInterface [] dispositivos;
    JpcapCaptor capturador,capt2;
    public static int web, ftp, otros;
    int disp;
    public Sniffer() {
        isRunning = true;
        dispositivos = JpcapCaptor.getDeviceList();
    }
    Packet p=null;
    
    public void run() {
        try {
            capturador = JpcapCaptor.openDevice(dispositivos[disp], 65535, true, 20);
            while(isRunning) {
                
                p=capturador.getPacket();
                System.out.println(p);
                if(p!=null ){
                    
                    b= p.header;
                    isRunning=false;
                }
                
                //capturador.processPacket(1, new Receptor());
               
                /*for(int i=0;i<10;i++){
                    //capture a single packet
                    Packet packet=capturador.getPacket();
                    //save it into the opened file
                    writer.writePacket(packet);
                }
                writer.close();*/
            }
            capturador.close();
            isRunning=true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    List<Packet> packets = new ArrayList<Packet>();
    public List<Packet> getPackets(){
        return packets;
    }
}
