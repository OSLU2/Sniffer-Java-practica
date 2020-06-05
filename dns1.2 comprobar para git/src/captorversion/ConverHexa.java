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
public class ConverHexa {//renombrar a Trama
    private  String tipo;// variable donde se guardara el nombre del tipo de trama 
    
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public int cont;
    
    public String destino(byte[] z){//direccion mac destino
        StringBuilder o = new StringBuilder( z.length*2 );
        int i;
        int limite=6;
        o.append("Dirección Destino: ");
        for(i=0;i<limite;i++)
        {
            o.append( toHex(z[i] >> 4) );
            if(i<limite-1){
                o.append( toHex(z[i])+ ":" );
            }
            else{
                o.append( toHex(z[i]) );
            }
        }
        return o.toString();
    }
    public String origen(byte[] z){//direccion mac origen
        StringBuilder o = new StringBuilder( z.length*2 );
        int i;
        int limite=12;
        o.append("Dirección origen: ");
        for(i=6;i<limite;i++)
        {
            o.append( toHex(z[i] >> 4) );
            if(i<limite-1){
                o.append( toHex(z[i])+ ":" );
            }
            else{
                o.append( toHex(z[i]) );
            }
        }
        return o.toString();
    }
    public String tipo(byte[] z){//tipo de trama
        StringBuilder o = new StringBuilder( z.length );
        int i;
        int limite=14;
        o.append("Tipo: ");
        for(i=12;i<limite;i++)
        {
            o.append( toHex(z[i] >> 4) );
            if(i<limite-1){
                o.append( toHex(z[i])+ ":" );
            }
            else{
                o.append( toHex(z[i]) );
            }
        }
        return o.toString();
    }
    public String datos(byte[] z, int conta){//datos de la trama actualmente los datos son desde el byte 38
        StringBuilder o = new StringBuilder( z.length*2 );
        int i;
        int limite=z.length;
        o.append("Datos: ");
        for(i=conta;i<limite;i++)
        {
            o.append( toHex(z[i] >> 4) );
            if(i<limite-1){
                o.append( toHex(z[i])+ ":" );
            }
            else{
                o.append( toHex(z[i]) );
            }
        }
        return o.toString();
    }
    public  String toHexString( byte[] bytes )
    {
      StringBuilder sb = new StringBuilder( 12 );
      sb.append("Trama completa: ");
      for( int i = 0; i < bytes.length; i++ )
      {
          sb.append( toHex(bytes[i] >> 4) );
          sb.append( toHex(bytes[i]) );
      }

      return sb.toString();
    }
    public static char toHex(int nibble)// funcion de bytes a hexa
    {
      final char[] hexDigit =
      {
          '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'
      };
      return hexDigit[nibble & 0xF];
    }
        public void switchTipo(String tipo){
        switch(tipo){
            case "Tipo: 08:06":
                System.out.println(" es ARP");
                setTipo("ARP");
                break;
            case "Tipo: 08:00":
                System.out.println(" es IPv4");
                setTipo("IPv4");
                break;
            case "Tipo: 08:35":
                System.out.println(" es RARP");
                setTipo("RARP");
                break;
            case "Tipo: 86:DD":
                System.out.println(" es IPv6");
                setTipo("IPv6");
                break;
            default:
                System.out.println(" Tipo de trama No reconocido");
                break;
            
        }
    }
}
