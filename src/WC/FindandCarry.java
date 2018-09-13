package WC;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindandCarry {
	/*分别创建：（字符串数组）存放符合条件的文件的路径
	**         （字符串）所要搜寻的文件夹路径
	**          (文件类) 搜寻目录的文件类
	**          (类型)   搜寻的文件类型
	 */
	List<String> Path = new ArrayList<String>();
	String menu;
	File MenuPath ;
	String Type;
	public FindandCarry(String Path,String Type) {
		menu = Path;
		this.MenuPath = new File(menu);
		String px,py;
		//将搜寻的条件转换为正则表达式
		px = Type.replaceAll("\\*", ".*");
		py = px.replaceAll("\\?", ".?");
		this.Type = ".*"+py+".*";		
		}
//搜寻所有符合要求的文件路径
	public void GetTargetFilePath(List<String> Path,File MenuPath) {
	File[] files = MenuPath.listFiles();
	if(files == null) return ;
	for(File f1 : files)
	{
		if(f1.isFile()&&f1.getName().matches(this.Type))  Path.add(f1.getPath());
		else if(f1.isDirectory())  GetTargetFilePath(Path,f1); 
		}
}
//对所有符合条件的文件进行操作	
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


 

