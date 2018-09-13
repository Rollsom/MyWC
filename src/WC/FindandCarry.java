package WC;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindandCarry {
	List<String> Path = new ArrayList<String>();
	String menu;
	File MenuPath ;
	String Type;
	public FindandCarry(String Path,String Type) {
		menu = Path;
		this.MenuPath = new File(menu);
		String px,py;
		px = Type.replaceAll("\\*", ".*");
		py = px.replaceAll("\\?", ".?");
		this.Type = ".*"+py+".*";		
		}

	public void GetTargetFilePath(List<String> Path,File MenuPath) {
	File[] files = MenuPath.listFiles();
	if(files == null) return ;
	for(File f1 : files)
	{
		if(f1.isFile()&&f1.getName().matches(this.Type))  Path.add(f1.getPath());
		else if(f1.isDirectory())  GetTargetFilePath(Path,f1); 
		}
}
	
	public void Carry(String order) throws IOException {
		for(String FilePath : this.Path)
		{
			Function F = new Function(FilePath);
		  if(order.equals("-c"))	F.CCount();
	 else if(order.equals("-w"))	F.WCount();
	 else if(order.equals("-l")) 	F.LCount();
	 else if(order.equals("-a"))  F.ALLCount();}
		}
}


 

