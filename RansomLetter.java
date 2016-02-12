import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RansomLetter
{
	private Map<Character,Integer> letterBag;

	public RansomLetter(String text)
	{
		if (text == null)
			throw new NullPointerException("text");
			
		this.letterBag = retrieveCharacterCounts(text);
	}
	

	private static Map<Character, Integer> retrieveCharacterCounts(String text)
	{
		Map<Character,Integer> map = new HashMap<>();
		for (char c : text.toCharArray())
		{
			if (!map.containsKey(c))
			{
				map.put(c, 0);
			}
			Integer count = map.get(c);
			map.put(c, count + 1);
		}
		return map;		
	}
	
	public boolean canCreateString(String text)
	{
		if (text == null)
			throw new NullPointerException("text");
		
		Map<Character,Integer> lettersNeeded = retrieveCharacterCounts(text);
		
		for (Entry<Character, Integer> ent  : lettersNeeded.entrySet())
		{
			Integer count = this.letterBag.get(ent.getKey());
			if (count == null || count < ent.getValue())
				return false;		
		}
			
		return true;
	}

	public static void main(String[] args)
	{
		String s1 = "yohoyohoapirateslifeforme";
		String s2 = "matisrife";
		
		//RansomLetter ransom = new RansomLetter(s1);
		//boolean canCreate = ransom.canCreateString(s2);
		
		System.out.println(new RansomLetter(s1).canCreateString(s2));
		
		
	}

}
