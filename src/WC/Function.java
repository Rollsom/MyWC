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
		 System.out.println(File+"不存在");
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
	System.out.println("行数为:"+LineCount);
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
	System.out.println("单词数为:"+WordCount);
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
	System.out.println("字符数为:"+CharsCount);
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
		System.out.println("空白行有："+BlankLine+"行");
		System.out.println("代码行有："+CodeLine+"行");
		System.out.println("注释行有："+ExplainLine+"行");
		bin.close();
	}
}
