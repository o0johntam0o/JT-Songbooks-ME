/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JT_Songbooks_ME;

import com.sun.lwuit.List;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.list.DefaultListModel;

/**
 *
 * @author o0johntam0o
 */
public class Lyrics
{
    String LyricsDir = "/JT_Songbooks_ME/Lyrics/";
    int PreviousGroup = 0;
    int PreviousList = 0;
    
    public Lyrics() { }

    public List GetGroup()
    {
        String[] group = {"A-B-C", "D-E-F", "G-H-I", "J-K-L", "M-N-O", "P-Q-R-S", "T-U-V", "W-X-Y-Z", "Other"};
        return new List(new DefaultListModel(group));
    }

    public List GetList(int group)
    {
	String gr;
	switch (group)
	{
	    case 0:
		gr = "A-B-C";
		break;
	    case 1:
		gr = "D-E-F";
		break;
	    case 2:
		gr = "G-H-I";
		break;
	    case 3:
		gr = "J-K-L";
		break;
	    case 4:
		gr = "M-N-O";
		break;
	    case 5:
		gr = "P-Q-R-S";
		break;
	    case 6:
		gr = "T-U-V";
		break;
	    case 7:
		gr = "W-X-Y-Z";
		break;
	    case 8:
		gr = "OTHER";
		break;
	    default:
		gr = "A-B-C";
		break;
	}
	
        gr = LyricsDir + gr + ".txt";
        List list = new List(new DefaultListModel());
        Funcs strFunc = new Funcs();
        String contents = strFunc.readFile(gr, "UTF-8");
        String[] strArr = strFunc.split('#', contents.trim());
        for (int i = 0; i < strArr.length; i++)
        {
            list.addItem(strArr[i].replace('\n', ' '));
        }

        return list;
    }

    public TextArea GetView(String lyrics)
    {
        lyrics = LyricsDir + "Items/" + lyrics.trim() + ".txt";
        Funcs strFunc = new Funcs();
        String contents = strFunc.readFile(lyrics, "UTF-8");
        return new TextArea(contents);
    }
}
