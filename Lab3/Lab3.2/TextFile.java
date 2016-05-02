import java.util.*;
import java.io.*;
public class TextFile
{
	private HashSet<String> sentences;
	public TextFile(HashSet<String> theSentences)
	{
		sentences = new HashSet<String>(theSentences);


	}

	public void print()
	{
		Iterator iter = sentences.iterator();
		while (iter.hasNext()) 
		{
			System.out.println(iter.next());
		}


	}
}