package WC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {
	int c = 0;
	String s;
	BufferedReader bin;
	
	public Function(String File) throws FileNotFoundException 
	{   
		
		File file = new File(File);
		if(file.exists()==false)
		{
		 System.out.println(File+"������");
		 return ;
		}
		else System.out.println(File+":");
	InputStreamReader fis = new InputStreamReader(new FileInputStream(File));
	this.bin = new BufferedReader(fis);
	}
   
	public void LCount() throws IOException {
    	int LineCount = 0;
	 while((s=bin.readLine())!=null)
		 LineCount = LineCount + 1;
	System.out.println("����Ϊ:"+LineCount);
	bin.close();
     }
   
    public void WCount() throws IOException 
    {
    	int WordCount = 0;
	String REX = "\\w+";
	Pattern p = Pattern.compile(REX);
	while((s=bin.readLine())!=null)
	{
		Matcher m = p.matcher(s);
		while(m.find()) WordCount++;
	}
	System.out.println("������Ϊ:"+WordCount);
	bin.close();
}
    
    public void CCount() throws IOException {
    	int CharsCount = 0;
	while((s=bin.readLine())!=null)
	{
		char[] s1 = s.toCharArray();
		for(char s2 :s1)
			if(s2 ==' ') continue;
			else CharsCount=CharsCount+1;
	}
	System.out.println("�ַ���Ϊ:"+CharsCount);
	bin.close();
	}
	
    public void ALLCount() throws IOException {
		int CodeLine = 0;
	    int BlankLine = 0;
	    int ExplainLine = 0;
	    while((s=bin.readLine())!=null)
		{
			if(s.matches("\\s*\\S?\\s*")) BlankLine++;
			else if(s.matches("\\s*\\S?\\s*\\/\\/.*"))  ExplainLine++;
			else if(s.matches("\\s*\\S?\\s*\\/\\*.*")) {
				ExplainLine++;
				while(s.matches(".*\\*\\/")==false)
				{
					s = bin.readLine();
					ExplainLine++;
				}
			}
			else CodeLine++ ;
		}
		System.out.println("�հ����У�"+BlankLine+"��");
		System.out.println("�������У�"+CodeLine+"��");
		System.out.println("ע�����У�"+ExplainLine+"��");
		bin.close();
	}
}
