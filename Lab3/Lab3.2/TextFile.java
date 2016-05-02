import java.util.*;
import java.io.*;
public class TextFile
{
	private HashSet<String> sentences;
	private HashMap<Integer, String> wordsInSentences;
	public TextFile(HashSet<String> theSentences)
	{
		sentences = new HashSet<String>(theSentences);
		wordsInSentences = new HashMap<Integer, String>();
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