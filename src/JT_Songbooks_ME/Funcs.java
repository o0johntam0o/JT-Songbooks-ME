/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JT_Songbooks_ME;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author o0johntam0o
 */
public class Funcs
{
    public Funcs() { }

    public String[] split(char token, String aStr)
    {
        int startPos = 0;
        int strArrayLength = 0;
        for(int i = 0 ; i < aStr.length() ; i++)
        {
            if(aStr.charAt(i) == token)
            {
                strArrayLength++;
            }
        }

        strArrayLength = strArrayLength + 1;

        String[] strArray = new String[strArrayLength];
        int index = 0;
        for (int i = 0 ; i < aStr.length() ; i++)
        {
            if (aStr.charAt(i) == token)
            {
                int tokenPos = aStr.indexOf(token,startPos+1);
                strArray[index] = aStr.substring(startPos,tokenPos);
                startPos = tokenPos+1;
                index++;
            }
        }
        strArray[index] = aStr.substring(startPos,aStr.length());
        return strArray;
    }

    public String readFile(String strFileName, String strCoding)
    {
        StringBuffer sb=new StringBuffer();
        char ch;
	boolean lf = false;
        InputStream is = getClass().getResourceAsStream(strFileName);
        InputStreamReader in;
        
        try
        {
            in = new InputStreamReader(is, strCoding);
        }
        catch (UnsupportedEncodingException e1)
        {
            return e1.toString();
        }
        
        try
        {
            while (in.ready())
            {
                ch = (char)in.read();
		
		if (ch == '\r')
		{
		    lf = true;
		    sb.append('\r');
		    sb.append('\n');
		}
		else if (ch == '\n')
		{
		    if (!lf)
		    {
			sb.append('\r');
			sb.append('\n');
		    }
		    else
		    {
			lf = false;
		    }
		}
		else
		{
		    lf = false;
		    sb.append(ch);
		}
            }
        } catch(Exception e){ }
        
        return sb.toString();
    }
}
