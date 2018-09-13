package WC;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String Path;
		//判断传入参数数量是否合规
if(args.length!=2&&args.length!=3&&args.length!=4)
	System.out.println("传入参数数量不合规");
		//将文件地址传入函数
if(args[0].equals("-s"))
	Path = new String(args[2]);
else     
    Path = new String(args[1]);
	//判断各种命令进而执行不同的函数
 if(args[0].equals("-s"))
{
	 FindandCarry search = new FindandCarry(Path,args[3]);
	search.GetTargetFilePath(search.Path, search.MenuPath);
	search.Carry(args[1]);
	}
 else {
	 Function F = new Function(Path);
	  if(args[0].equals("-c"))	F.CCount();
 else if(args[0].equals("-w"))	F.WCount();
 else if(args[0].equals("-l")) 	F.LCount();
 else if(args[0].equals("-a"))  F.ALLCount();
}
	}
}
