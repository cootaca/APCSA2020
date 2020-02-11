package Unit5;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
   public static String go( String a )
	{
	   if(a.substring(0,1).toLowerCase().equals("a")||a.substring(0,1).toLowerCase().equals("e")||a.substring(0,1).toLowerCase().equals("i")||a.substring(0,1).toLowerCase().equals("o")||a.substring(0,1).toLowerCase().equals("u")||
			   a.substring(a.length()-1).toLowerCase().equals("a")||a.substring(a.length()-1).toLowerCase().equals("e")||a.substring(a.length()-1).toLowerCase().equals("i")||a.substring(a.length()-1).toLowerCase().equals("o")||a.substring(a.length()-1).toLowerCase().equals("u")) {
		   return "yes";
		   
	   }
	
	   else {
		   return "no";
   		}
	}
}