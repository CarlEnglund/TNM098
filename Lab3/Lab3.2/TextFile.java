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
			System.out.println(iter.next());
			System.out.println("SLUT");
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
			System.out.println(wordsInSentences.get(i).values());
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
	public boolean compare(HashMap<Integer, String> map)
	{
		//System.out.println(map.values());
		for (int i = 0; i < wordsInSentences.size(); i++)
		{
				//System.out.println(wordsInSentences.get(i).values());


				if (wordsInSentences.get(i).keySet().equals(map.keySet()))
				{
					List<String> values1 = new ArrayList<String>(wordsInSentences.get(i).values());
					List<String> values2 = new ArrayList<String>(map.values());
					Collections.sort(values1);
					Collections.sort(values2);

					if (values1.equals(values2))
					{
						System.out.println(values1);
						System.out.println(values2);
						
						return true;
					}

				}

		}
		return false;
	}


}