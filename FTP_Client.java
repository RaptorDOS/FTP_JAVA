import java.io.*;
import java.net.*;

public class FTP_Client
{


public static void main(String[] args) throws Exception
{
String option;
DataInputStream in=new DataInputStream(System.in);
Socket s=new Socket("172.17.0.1",Integer.parseInt(args[0]));
DataInputStream cin=new DataInputStream(s.getInputStream());
DataOutputStream cout=new DataOutputStream(s.getOutputStream());
System.out.println("MENU");
System.out.println("1.SEND");
System.out.println("2.RECEIVE");
FTP_Client ftp=new FTP_Client();
while(true)
{
option=in.readLine();
if(option.equals("1")){
System.out.println("SEND Command Received..");
ftp.sendfile(s);
}

else if(option.equals("2")){
System.out.println("RECEIVE Command Received..");
ftp.receivefile(s);
}

}
}

public void sendfile(Socket s) throws Exception
{
Socket ssock=s;

DataInputStream in=new DataInputStream(System.in);

DataInputStream cin=new DataInputStream(ssock.getInputStream());
DataOutputStream cout=new DataOutputStream(ssock.getOutputStream());

cout.writeUTF("RECEIVE");

String filename=in.readLine();
System.out.println("Reading File "+filename);
cout.writeUTF(filename);
File f=new File(filename);
FileInputStream fin=new FileInputStream(f);
int ch;
do
{
ch=fin.read();
cout.writeUTF(String.valueOf(ch));
}while(ch!=-1);
fin.close();
System.out.println("File Sent");
}

public void receivefile(Socket s) throws Exception
{
Socket ssock=s;
DataInputStream in=new DataInputStream(System.in);
DataInputStream cin=new DataInputStream(ssock.getInputStream());
DataOutputStream cout=new DataOutputStream(ssock.getOutputStream());

cout.writeUTF("SEND");

String filename=in.readLine();
cout.writeUTF(filename);
System.out.println("Receiving File "+filename);
File f=new File(filename);
FileOutputStream fout=new FileOutputStream(f);
int ch;
do
{
ch=Integer.parseInt(cin.readUTF());
if(ch!=-1) fout.write(ch);
}while(ch!=-1);
System.out.println("Received File...");
fout.close();
}
}  