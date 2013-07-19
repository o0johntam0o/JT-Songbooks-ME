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
public class Chords
{
    int PreviousGroup = 0;
    int PreviousList = 0;
    
    public Chords() { }
    
    public List GetGroup()
    {
	String[] group = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
	return new List(new DefaultListModel(group));
    }

    public List GetList(int group)
    {
	String[] list = {"", "m", "5", "6", "7", "Aug", "Dim", "Sus2", "Sus4"};
	for (int i=0; i<list.length; i++)
	{
	    switch (group)
	    {
		case 0:
		    list[i] = "A" + list[i];
		    break;
		case 1:
		    list[i] = "A#" + list[i];
		    break;
		case 2:
		    list[i] = "B" + list[i];
		    break;
		case 3:
		    list[i] = "C" + list[i];
		    break;
		case 4:
		    list[i] = "C#" + list[i];
		    break;
		case 5:
		    list[i] = "D" + list[i];
		    break;
		case 6:
		    list[i] = "D#" + list[i];
		    break;
		case 7:
		    list[i] = "E" + list[i];
		    break;
		case 8:
		    list[i] = "F" + list[i];
		    break;
		case 9:
		    list[i] = "F#" + list[i];
		    break;
		case 10:
		    list[i] = "G" + list[i];
		    break;
		case 11:
		    list[i] = "G#" + list[i];
		    break;
		default:
		    list[i] = "C" + list[i];
		    break;
	    }
	}
        return new List(new DefaultListModel(list));
    }

    public TextArea GetView(String chord)
    {
        chord = chord.trim();
        int[] map;
	
	// Major
	if (chord.equals("A")) { map = new int[]{99,0,2,2,2,0}; }
	else if (chord.equals("A#")) { map = new int[]{99,1,3,3,3,1}; }
	else if (chord.equals("B")) { map = new int[]{99,2,4,4,4,2}; }
	else if (chord.equals("C")) { map = new int[]{99,3,2,0,1,0}; }
	else if (chord.equals("C#")) { map = new int[]{99,4,3,1,2,1}; }
	else if (chord.equals("D")) { map = new int[]{99,99,0,2,3,2}; }
	else if (chord.equals("D#")) { map = new int[]{99,99,1,3,4,3}; }
	else if (chord.equals("E")) { map = new int[]{0,2,2,1,0,0}; }
	else if (chord.equals("F")) { map = new int[]{99,99,3,2,1,1}; }
	else if (chord.equals("F#")) { map = new int[]{99,99,4,3,2,2}; }
	else if (chord.equals("G")) { map = new int[]{3,2,0,0,0,3}; }
	else if (chord.equals("G#")) { map = new int[]{4,3,1,1,1,4}; }
	// Minor
	else if (chord.equals("Am")) { map = new int[]{99,0,2,2,1,0}; }
	else if (chord.equals("A#m")) { map = new int[]{99,1,3,3,2,1}; }
	else if (chord.equals("Bm")) { map = new int[]{99,2,4,4,3,2}; }
	else if (chord.equals("Cm")) { map = new int[]{99,3,5,5,4,3}; }
	else if (chord.equals("C#m")) { map = new int[]{99,4,2,1,2,0}; }
	else if (chord.equals("Dm")) { map = new int[]{99,99,0,2,3,1}; }
	else if (chord.equals("D#m")) { map = new int[]{99,99,1,3,4,2}; }
	else if (chord.equals("Em")) { map = new int[]{0,2,2,0,0,0}; }
	else if (chord.equals("Fm")) { map = new int[]{99,99,3,1,1,1}; }
	else if (chord.equals("F#m")) { map = new int[]{99,99,4,2,2,2}; }
	else if (chord.equals("Gm")) { map = new int[]{3,1,0,0,3,3}; }
	else if (chord.equals("G#m")) { map = new int[]{4,2,1,1,4,4}; }
	// 5
	else if (chord.equals("A5")) { map = new int[]{99,0,2,2,5,5}; }
	else if (chord.equals("A#5")) { map = new int[]{99,1,3,3,99,99}; }
	else if (chord.equals("B5")) { map = new int[]{99,2,4,4,99,99}; }
	else if (chord.equals("C5")) { map = new int[]{99,3,5,5,99,99}; }
	else if (chord.equals("C#5")) { map = new int[]{99,4,99,99,2,4}; }
	else if (chord.equals("D5")) { map = new int[]{99,99,0,2,3,5}; }
	else if (chord.equals("D#5")) { map = new int[]{99,99,1,3,4,99}; }
	else if (chord.equals("E5")) { map = new int[]{0,2,2,99,99,99}; }
	else if (chord.equals("F5")) { map = new int[]{1,3,3,99,99,99}; }
	else if (chord.equals("F#5")) { map = new int[]{2,4,4,99,99,99}; }
	else if (chord.equals("G5")) { map = new int[]{99,99,99,0,3,3}; }
	else if (chord.equals("G#5")) { map = new int[]{99,99,99,1,4,4}; }
	// 6
	else if (chord.equals("A6")) { map = new int[]{99,0,2,2,2,2}; }
	else if (chord.equals("A#6")) { map = new int[]{99,1,3,0,3,3}; }
	else if (chord.equals("B6")) { map = new int[]{99,2,1,1,0,2}; }
	else if (chord.equals("C6")) { map = new int[]{99,3,5,5,5,5}; }
	else if (chord.equals("C#6")) { map = new int[]{99,4,3,3,99,4}; }
	else if (chord.equals("D6")) { map = new int[]{99,99,0,2,0,2}; }
	else if (chord.equals("D#6")) { map = new int[]{99,99,1,3,1,3}; }
	else if (chord.equals("E6")) { map = new int[]{0,2,2,1,2,0}; }
	else if (chord.equals("F6")) { map = new int[]{99,99,3,5,3,5}; }
	else if (chord.equals("F#6")) { map = new int[]{2,1,1,3,2,99}; }
	else if (chord.equals("G6")) { map = new int[]{3,2,0,0,0,0}; }
	else if (chord.equals("G#6")) { map = new int[]{4,3,1,1,1,1}; }
	// 7
	else if (chord.equals("A7")) { map = new int[]{99,0,2,0,2,0}; }
	else if (chord.equals("A#7")) { map = new int[]{99,1,3,1,3,1}; }
	else if (chord.equals("B7")) { map = new int[]{99,2,1,2,0,2}; }
	else if (chord.equals("C7")) { map = new int[]{99,3,5,3,5,3}; }
	else if (chord.equals("C#7")) { map = new int[]{99,4,3,1,0,4}; }
	else if (chord.equals("D7")) { map = new int[]{99,99,0,2,1,2}; }
	else if (chord.equals("D#7")) { map = new int[]{99,99,1,3,2,3}; }
	else if (chord.equals("E7")) { map = new int[]{0,2,2,1,3,0}; }
	else if (chord.equals("F7")) { map = new int[]{99,99,3,5,4,5}; }
	else if (chord.equals("F#7")) { map = new int[]{99,99,4,3,2,0}; }
	else if (chord.equals("G7")) { map = new int[]{3,2,0,0,0,1}; }
	else if (chord.equals("G#7")) { map = new int[]{4,3,1,1,1,2}; }
	// Aug
	else if (chord.equals("AAug")) { map = new int[]{99,0,3,2,2,1}; }
	else if (chord.equals("A#Aug")) { map = new int[]{99,1,0,3,3,2}; }
	else if (chord.equals("BAug")) { map = new int[]{99,2,1,0,0,3}; }
	else if (chord.equals("CAug")) { map = new int[]{99,3,2,1,1,0}; }
	else if (chord.equals("C#Aug")) { map = new int[]{99,4,3,2,2,5}; }
	else if (chord.equals("DAug")) { map = new int[]{99,99,0,3,3,2}; }
	else if (chord.equals("D#Aug")) { map = new int[]{99,99,1,0,0,3}; }
	else if (chord.equals("EAug")) { map = new int[]{0,3,2,1,1,0}; }
	else if (chord.equals("FAug")) { map = new int[]{99,99,3,2,2,1}; }
	else if (chord.equals("F#Aug")) { map = new int[]{99,99,4,3,3,2}; }
	else if (chord.equals("GAug")) { map = new int[]{3,2,1,0,0,3}; }
	else if (chord.equals("G#Aug")) { map = new int[]{99,99,99,1,1,0}; }
	// Dim
	else if (chord.equals("ADim")) { map = new int[]{99,0,1,5,4,5}; }
	else if (chord.equals("A#Dim")) { map = new int[]{99,1,2,3,2,0}; }
	else if (chord.equals("BDim")) { map = new int[]{99,2,0,4,3,1}; }
	else if (chord.equals("CDim")) { map = new int[]{99,99,99,5,4,2}; }
	else if (chord.equals("C#Dim")) { map = new int[]{99,4,2,0,2,0}; }
	else if (chord.equals("DDim")) { map = new int[]{99,99,0,1,3,1}; }
	else if (chord.equals("D#Dim")) { map = new int[]{99,99,1,2,4,2}; }
	else if (chord.equals("EDim")) { map = new int[]{99,99,2,3,5,2}; }
	else if (chord.equals("FDim")) { map = new int[]{99,99,3,2,0,2}; }
	else if (chord.equals("F#Dim")) { map = new int[]{99,99,4,2,1,2}; }
	else if (chord.equals("GDim")) { map = new int[]{99,99,5,3,2,3}; }
	else if (chord.equals("G#Dim")) { map = new int[]{4,2,0,1,0,4}; }
	// Sus2
	else if (chord.equals("ASus2")) { map = new int[]{99,0,2,2,0,0}; }
	else if (chord.equals("A#Sus2")) { map = new int[]{99,1,3,3,1,1}; }
	else if (chord.equals("BSus2")) { map = new int[]{99,2,4,4,2,2}; }
	else if (chord.equals("CSus2")) { map = new int[]{99,3,0,0,3,3}; }
	else if (chord.equals("C#Sus2")) { map = new int[]{99,4,1,1,4,4}; }
	else if (chord.equals("DSus2")) { map = new int[]{99,99,0,2,3,0}; }
	else if (chord.equals("D#Sus2")) { map = new int[]{99,99,1,3,4,1}; }
	else if (chord.equals("ESus2")) { map = new int[]{0,2,2,4,5,2}; }
	else if (chord.equals("FSus2")) { map = new int[]{99,99,3,0,1,1}; }
	else if (chord.equals("F#Sus2")) { map = new int[]{99,99,4,1,2,4}; }
	else if (chord.equals("GSus2")) { map = new int[]{3,0,0,0,3,3}; }
	else if (chord.equals("G#Sus2")) { map = new int[]{4,1,1,1,4,4}; }
	// Sus4
	else if (chord.equals("ASus4")) { map = new int[]{99,0,0,2,3,0}; }
	else if (chord.equals("A#Sus4")) { map = new int[]{99,1,1,3,4,1}; }
	else if (chord.equals("BSus4")) { map = new int[]{99,2,2,4,5,2}; }
	else if (chord.equals("CSus4")) { map = new int[]{99,3,3,0,1,1}; }
	else if (chord.equals("C#Sus4")) { map = new int[]{99,4,4,1,2,2}; }
	else if (chord.equals("DSus4")) { map = new int[]{99,99,0,2,3,3}; }
	else if (chord.equals("D#Sus4")) { map = new int[]{99,99,1,3,4,4}; }
	else if (chord.equals("ESus4")) { map = new int[]{0,0,2,2,0,0}; }
	else if (chord.equals("FSus4")) { map = new int[]{99,99,3,3,1,1}; }
	else if (chord.equals("F#Sus4")) { map = new int[]{99,99,4,4,2,2}; }
	else if (chord.equals("GSus4")) { map = new int[]{3,3,0,0,3,3}; }
	else if (chord.equals("G#Sus4")) { map = new int[]{4,4,1,1,4,4}; }
	
	else { map = new int[]{0,0,0,0,0,0}; }
        return new TextArea(ChordsMap(map));
    }

    public String ChordsMap(int[] in)
    {
        String[] out = {"E>", "A>", "D>", "G>", "B>", "E>"};
        String re = "";

        for (int i=0; i<=5; i++)
        {
            for (int j=0; j<=5; j++)
            {
                if (j == in[i] && j != 0)
                {
                    switch (j)
                    {
                        case 1:
                            if (i==0 || i==5) { out[i] = out[i] + "-F--|"; }
                            else if (i == 1) { out[i] = out[i] + "-A#-|"; }
                            else if (i == 2) { out[i] = out[i] + "-D#-|"; }
                            else if (i == 3) { out[i] = out[i] + "-G#-|"; }
                            else if (i == 4) { out[i] = out[i] + "-C--|"; }
                            break;
                        case 2:
                            if (i==0 || i==5) { out[i] = out[i] + "-F#-|"; }
                            else if (i == 1) { out[i] = out[i] + "-B--|"; }
                            else if (i == 2) { out[i] = out[i] + "-E--|"; }
                            else if (i == 3) { out[i] = out[i] + "-A--|"; }
                            else if (i == 4) { out[i] = out[i] + "-C#-|"; }
                            break;
                        case 3:
                            if (i==0 || i==5) { out[i] = out[i] + "-G--|"; }
                            else if (i == 1) { out[i] = out[i] + "-C--|"; }
                            else if (i == 2) { out[i] = out[i] + "-F--|"; }
                            else if (i == 3) { out[i] = out[i] + "-A#-|"; }
                            else if (i == 4) { out[i] = out[i] + "-D--|"; }
                            break;
                        case 4:
                            if (i==0 || i==5) { out[i] = out[i] + "-G#-|"; }
                            else if (i == 1) { out[i] = out[i] + "-C#-|"; }
                            else if (i == 2) { out[i] = out[i] + "-F#-|"; }
                            else if (i == 3) { out[i] = out[i] + "-B--|"; }
                            else if (i == 4) { out[i] = out[i] + "-D#-|"; }
                            break;
                        case 5:
                            if (i==0 || i==5) { out[i] = out[i] + "-A--|"; }
                            else if (i == 1) { out[i] = out[i] + "-D--|"; }
                            else if (i == 2) { out[i] = out[i] + "-G--|"; }
                            else if (i == 3) { out[i] = out[i] + "-C--|"; }
                            else if (i == 4) { out[i] = out[i] + "-E--|"; }
                            break;
                    }
                }
                else if (j == 0)
                {
                    if (in[i] == 99)
                    { out[i] = out[i] + "-XX"; }
                    else
                    { out[i] = out[i] + "-||"; }
                }
                else
                { out[i] = out[i] + "----|"; }
            }
        }
	
	for (int i=5; i>=0; i--)
	{
            re = re + out[i] + '\n';
	}
	
        return re;
    }
}
