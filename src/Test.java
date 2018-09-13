package WC;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if(args[0].equals("-w"))
		{
		W w = new W(args[1]);
		}
if(args[0].equals("-c"))
 {
  C c = new C(args[1]);
  }
if(args[0].equals("-l"))
{
L l = new L(args[1]);	
}
	
	}
}