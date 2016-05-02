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
					
					s+=preProcess(line);
					s+= " ";
				}
				
				convertToSentences(s);

				textFiles.add(new TextFile(sentences));
			}

			//print();
			compare();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	private void compare()
	{
		for (int i = 0; i < textFiles.size(); i++)
		{
			for (int j = i+1; j < textFiles.size(); j++)
			{
				if (textFiles.get(i).compare(textFiles.get(j).getSentences()))
				{
					System.out.println("Equal sentence(s) found in " + (i+1) +" and " + (j+1)); // 2 and 8 has same paragraph
				}

			}
		}
		
	}

	private String preProcess(String s)
	{
		String newString = "";
		newString = s.replaceAll("Mrs. ", "Mrs");
		newString = newString.replaceAll("Dr. ", "Dr");
		newString = newString.replaceAll("Mr. ", "Mr");
		newString = newString.replace("\"", "");
		newString = newString.replace("?", "");
		newString = newString.replace("!", "");
		newString = newString.replace("'", "");
		newString = newString.replace("-", "");
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
			sentences.add(processSentence(sentence.toLowerCase()));
		}
	}

	private String processSentence(String s)
	{
		s = s.replaceAll("[^a-zA-Z ]", "");
		s =	s.replaceAll("\\.", "");
		s = s.replaceAll("\\,", "");
		
		return s.replaceAll(" ", "");
	}

	public static void main(String[] args)
	{
		TextComparison textComparison = new TextComparison();
	}
	
}