import java.io.*;
import java.net.*;

public class test2
{


public static void main(String[] args) throws Exception
{
int i=0;
String option;
DataInputStream in=new DataInputStream(System.in);
Socket s=new Socket("192.168.9.64",Integer.parseInt(args[0]));
DataInputStream cin=new DataInputStream(s.getInputStream());
DataOutputStream cout=new DataOutputStream(s.getOutputStream());
System.out.println("Enter the password");
String password=in.readLine();
cout.writeUTF(password);

}	
}