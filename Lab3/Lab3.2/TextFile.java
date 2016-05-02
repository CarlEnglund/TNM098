import java.util.*;
import java.io.*;
public class TextFile
{
	private HashSet<String> sentences;
	private ArrayList<HashMap<Integer, String>> wordsInSentences;
	public TextFile(HashSet<String> theSentences)
	{
		sentences = new HashSet<String>(theSentences);
		wordsInSentences = new ArrayList<HashMap<Integer, String> >();
		processWords();
		//printWords();
	}

	public void print()
	{
		Iterator iter = sentences.iterator();
		while (iter.hasNext()) 
		{
			/*System.out.println(iter.next());
			System.out.println("SLUT");*/
		}
		//printWords();
	}

	public void printWords()
	{
		for (int i = 0; i < 1; i++)
		{
			/*Iterator iter = wordsInSentences.get(i).iterator();
			while (iter.hasNext())
			{
				System.out.println(iter.next());
			}*/
			//System.out.println(wordsInSentences.get(i).values());
		}
	}
	private void processWords()
	{
		Iterator iter = sentences.iterator();
		while (iter.hasNext())
		{

			HashMap<Integer, String> wordsMap = new HashMap<Integer, String>();
			String sentence = (String) iter.next();
			
			String[] words = sentence.split(" ");
			for (int i = 0; i < words.length; i++)
			{	
				wordsMap.put(i, words[i]);
			}
			wordsInSentences.add(wordsMap);
		}
	}
	public ArrayList<HashMap<Integer, String>> getHashMaps()
	{
		return wordsInSentences;
	}

	public boolean compare(HashSet<String> theSentences)
	{
		Iterator it = theSentences.iterator();
		boolean found = false;
		while (it.hasNext())
		{
			String sentence = (String) it.next();
			/*System.out.println(sentence);
			System.out.println("SLUT");*/
			/*System.out.println(sentence);
			System.out.println("SLUT");*/
			if (sentences.contains(sentence))
			{
				System.out.println(sentence);
				found = true;
				//return true;
			}	
		}
		return found;

	}

	public HashSet<String> getSentences()
	{
		return sentences;
	}




}