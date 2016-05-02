import java.util.*;
import java.io.*;
import java.text.*;
public class TextComparison
{


	private ArrayList<TextFile> textFiles;
	private HashSet<String> sentences;
	public TextComparison()
	{
		textFiles = new ArrayList<TextFile>();
		run();
	}
	private void print()
	{
		//for (int i = 0; i < textFiles.size(); i++)
		//{
			textFiles.get(9).print();
		//}
	}
	private void run()
	{
		try 
		{
			BufferedReader bufferedReader;
			for (int i = 1; i < 11; i++)
			{
				if (i < 10)
				{
					bufferedReader = new BufferedReader(new FileReader("0" + i + ".txt"));
				}
				else
				{
					bufferedReader = new BufferedReader(new FileReader(i + ".txt"));
				}
				String line = null;
				String s = "";

				ArrayList<String> newLines = new ArrayList<String>();
				while((line = bufferedReader.readLine()) != null)
				{
					s+=removeAbbreviations(line.toLowerCase());
				}
				
				convertToSentences(s);

				textFiles.add(new TextFile(sentences));
			}

			print();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	private String removeAbbreviations(String s)
	{
		String newString = "";
		newString = s.replaceAll("Mrs. ", "");
		newString = newString.replaceAll("Mr. ", "");
		return newString;
	}
	private void convertToSentences(String s)
	{
		sentences = new HashSet<String>();
		Locale currentLocale = new Locale("en", "US");
		BreakIterator bIterator = BreakIterator.getSentenceInstance(currentLocale);
		bIterator.setText(s);
		int start = bIterator.first();
		for (int end = bIterator.next(); end != BreakIterator.DONE; start = end, end = bIterator.next())
		{
			String sentence = s.substring(start, end);
			sentences.add(processSentence(sentence));
		}
	}

	private String processSentence(String s)
	{
		return s.replaceAll("[^a-zA-Z ]", "");
	}

	public static void main(String[] args)
	{
		TextComparison textComparison = new TextComparison();
	}
	
}