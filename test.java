import java.io.*;
import java.net.*;
class test
{
	public static void main(String[] args) throws Exception
	{   
		ServerSocket Sock=new ServerSocket(Integer.parseInt(args[0]));
Socket s=Sock.accept();

		
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream cin=new DataInputStream(s.getInputStream());
		DataOutputStream cout=new DataOutputStream(s.getOutputStream());
		test ftp=new test();
		while(true)
		{
			String message="12345";
			String pass=cin.readUTF();
			System.out.println(pass);
			
			if(pass.compareTo(message)==0)
			{
				System.out.println("sucess");
				break;
			}
			else 
				System.out.println("fail");
				break;

		}
		
	} 
}