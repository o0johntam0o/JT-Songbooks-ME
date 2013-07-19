/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JT_Songbooks_ME;

import com.sun.lwuit.*;
import com.sun.lwuit.events.*;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.layouts.FlowLayout;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import java.io.IOException;
import javax.microedition.midlet.MIDlet;

/**
 * @author o0johntam0o
 */
public class JT_Songbooks extends MIDlet implements ActionListener
{
	Form MainForm;
	Form AboutForm;
	Form LyricsGroupForm;
	Form LyricsListForm;
	Form LyricsViewForm;
	Form ChordsGroupForm;
	Form ChordsListForm;
	Form ChordsViewForm;
	Form CircleFifthsForm;
	
	Button ButtonLyrics;
	Button ButtonChords;
	Button ButtonAbout;
	Button ButtonCircleFifths;
	
	Command BackCommand;
	Command ExitCommand;
	
	String CurrentPage = "";
	List CurrentList = null;
	
	Resources Theme;
	
	Lyrics LyricsClass = new Lyrics();
	Chords ChordsClass = new Chords();
	
	public void startApp()
	{
		Display.init(this);
		_InstallTheme();
		_MainMenu();
	}
	
	public void pauseApp() { }
	
	public void destroyApp(boolean unconditional) { }

	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == ExitCommand)
		{
			notifyDestroyed();
		}
		else if (ae.getSource() == BackCommand)
		{
			if (CurrentPage.equals("Lyrics Group") || CurrentPage.equals("Chords Group") || CurrentPage.equals("CircleFifths") || CurrentPage.equals("About"))
			{
				LyricsClass.PreviousGroup = 0;
				ChordsClass.PreviousGroup = 0;
				_MainMenu();
			}
			else if (CurrentPage.equals("Lyrics List"))
			{
				_LyricsGroup();
			}
			else if (CurrentPage.equals("Chords List"))
			{
				_ChordsGroup();
			}
			else if (CurrentPage.equals("Lyrics Viewer"))
			{
				_LyricsList(LyricsClass.PreviousGroup, true);
			}
			else if (CurrentPage.equals("Chords Viewer"))
			{
				_ChordsList(ChordsClass.PreviousGroup, true);
			}
		}
		else if (ae.getSource() == ButtonLyrics)
		{
			_LyricsGroup();
		}
		else if (ae.getSource() == ButtonChords)
		{
			_ChordsGroup();
		}
		else if (ae.getSource() == ButtonCircleFifths)
		{
			_Circle();
		}
		else if (ae.getSource() == ButtonAbout)
		{
			_About();
		}
		else
		{
			if (CurrentPage.equals("Lyrics Group"))
			{
				_LyricsList(CurrentList.getSelectedIndex(), false);
			}
			else if (CurrentPage.equals("Chords Group"))
			{
				_ChordsList(CurrentList.getSelectedIndex(), false);
			}
			else if (CurrentPage.equals("Lyrics List"))
			{
				_LyricsViewer();
			}
			else if (CurrentPage.equals("Chords List"))
			{
				_ChordsViewer();
			}
		}
	}
	
	public void _Init() { }

	private void _MainMenu()
	{
		CurrentPage = "Main Menu";
		MainForm = new Form("Main Menu");
		MainForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		ButtonLyrics = new Button("Lyrics");
		ButtonLyrics.addActionListener(this);
		MainForm.addComponent(ButtonLyrics);
		ButtonChords = new Button("Chords");
		ButtonChords.addActionListener(this);
		MainForm.addComponent(ButtonChords);
		ButtonCircleFifths = new Button("Circle of fifths");
		ButtonCircleFifths.addActionListener(this);
		MainForm.addComponent(ButtonCircleFifths);
		ButtonAbout = new Button("About");
		ButtonAbout.addActionListener(this);
		MainForm.addComponent(ButtonAbout);
		
		ExitCommand = new Command("Exit");
		MainForm.addCommand(ExitCommand);
		MainForm.addCommandListener(this);
		
		MainForm.show();
	}

	// ========================== BEGIN = LYRICS FUNC ==========================
	private void _LyricsGroup()
	{
		LyricsClass.PreviousList = 0;
	
		CurrentPage = "Lyrics Group";
		LyricsGroupForm = new Form("Lyrics Groups");
		LyricsGroupForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		CurrentList = LyricsClass.GetGroup();
		CurrentList.addActionListener(this);
		CurrentList.setSelectedIndex(LyricsClass.PreviousGroup, true);
		LyricsGroupForm.addComponent(CurrentList);
		
		BackCommand = new Command("Back");
		LyricsGroupForm.addCommand(BackCommand);
		LyricsGroupForm.addCommandListener(this);
		
		LyricsGroupForm.show();
	}
	
	private void _LyricsList(int group, boolean isBackPressed)
	{
		if (!isBackPressed)
		{
			LyricsClass.PreviousGroup = CurrentList.getSelectedIndex();
		}
	
		CurrentPage = "Lyrics List";
		LyricsListForm = new Form("Group " + (group + 1));
		LyricsListForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
	
		CurrentList = LyricsClass.GetList(group);
		CurrentList.addActionListener(this);
		CurrentList.setSelectedIndex(LyricsClass.PreviousList, true);
		LyricsListForm.addComponent(CurrentList);
		
		BackCommand = new Command("Back");
		LyricsListForm.addCommand(BackCommand);
		LyricsListForm.addCommandListener(this);
		
		LyricsListForm.show();
	}
	
	private void _LyricsViewer()
	{
		LyricsClass.PreviousList = CurrentList.getSelectedIndex();
	
		CurrentPage = "Lyrics Viewer";
		LyricsViewForm = new Form(CurrentList.getSelectedItem().toString());
		LyricsListForm.setLayout(new FlowLayout());
	
		TextArea lyricsText = LyricsClass.GetView(CurrentList.getSelectedItem().toString());
		lyricsText.getSelectedStyle().setFont(Theme.getFont("LyricsText"));
		lyricsText.getUnselectedStyle().setFont(Theme.getFont("LyricsText"));
		//lyricsText.getSelectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
		//lyricsText.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
		lyricsText.setEditable(false);
		LyricsViewForm.addComponent(lyricsText);
		
		BackCommand = new Command("Back");
		LyricsViewForm.addCommand(BackCommand);
		LyricsViewForm.addCommandListener(this);
		
		LyricsViewForm.show();
	}
	// =========================== END = LYRICS FUNC ===========================

	// ========================== BEGIN = CHORDS FUNC ==========================
	private void _ChordsGroup()
	{
		ChordsClass.PreviousList = 0;
	
		CurrentPage = "Chords Group";
		ChordsGroupForm = new Form("Chord Groups");
		ChordsGroupForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		CurrentList = ChordsClass.GetGroup();
		CurrentList.addActionListener(this);
		CurrentList.setSelectedIndex(ChordsClass.PreviousGroup, true);
		ChordsGroupForm.addComponent(CurrentList);
		
		BackCommand = new Command("Back");
		ChordsGroupForm.addCommand(BackCommand);
		ChordsGroupForm.addCommandListener(this);
		
		ChordsGroupForm.show();
	}
	
	private void _ChordsList(int group, boolean isBackPressed)
	{
		if (!isBackPressed)
		{
			ChordsClass.PreviousGroup = CurrentList.getSelectedIndex();
		}
	
		CurrentPage = "Chords List";
		ChordsListForm = new Form("Chord Lists");
		ChordsListForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		CurrentList = ChordsClass.GetList(group);
		CurrentList.addActionListener(this);
		CurrentList.setSelectedIndex(ChordsClass.PreviousList, true);
		ChordsListForm.addComponent(CurrentList);
		
		BackCommand = new Command("Back");
		ChordsListForm.addCommand(BackCommand);
		ChordsListForm.addCommandListener(this);
		
		ChordsListForm.show();
	}
	
	private void _ChordsViewer()
	{
		ChordsClass.PreviousList = CurrentList.getSelectedIndex();
	
		CurrentPage = "Chords Viewer";
		ChordsViewForm = new Form(CurrentList.getSelectedItem().toString());
		ChordsViewForm.setLayout(new FlowLayout());
		
		TextArea chordsText = ChordsClass.GetView(CurrentList.getSelectedItem().toString());
		chordsText.getSelectedStyle().setFont(Theme.getFont("FretBoard"));
		chordsText.getUnselectedStyle().setFont(Theme.getFont("FretBoard"));
		chordsText.setEditable(false);
		ChordsViewForm.addComponent(chordsText);
		
		BackCommand = new Command("Back");
		ChordsViewForm.addCommand(BackCommand);
		ChordsViewForm.addCommandListener(this);
		
		ChordsViewForm.show();
	}
	// =========================== END = CHORDS FUNC ===========================

	private void _Circle()
	{
		CurrentPage = "CircleFifths";
		CircleFifthsForm = new Form("Circle of fifths");
		CircleFifthsForm.setLayout(new BorderLayout());
		
		Image circleImage = null;
		try
		{
			circleImage = Image.createImage("/JT_Songbooks_ME/Circle.png");
		} catch (IOException ex) { }
		Label labelImage = new Label(circleImage);
		labelImage.setAlignment(Component.CENTER);
		CircleFifthsForm.addComponent(BorderLayout.CENTER, labelImage);
		
		BackCommand = new Command("Back");
		CircleFifthsForm.addCommand(BackCommand);
		CircleFifthsForm.addCommandListener(this);
		
		CircleFifthsForm.show();
	}

	private void _About()
	{
		CurrentPage = "About";
		AboutForm = new Form("About");
		AboutForm.setLayout(new BorderLayout());
		
		Image aboutImage = null;
		try
		{
			aboutImage = Image.createImage("/JT_Songbooks_ME/o0johntam0o.png");
		} catch (IOException ex) { }
		Label labelImage = new Label(aboutImage);
		//labelImage.setTextPosition(Component.RIGHT);
		labelImage.setAlignment(Component.CENTER);
		TextArea info = new TextArea("App name: [JT] Songbooks ME\nVersion: 1.0.0\nAuthor: o0johntam0o\nCopyright: [JT] Knowledge");
		info.getSelectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
		info.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
		AboutForm.addComponent(BorderLayout.NORTH, labelImage);
		AboutForm.addComponent(BorderLayout.CENTER, info);
		
		BackCommand = new Command("Back");
		AboutForm.addCommand(BackCommand);
		AboutForm.addCommandListener(this);
		
		AboutForm.show();
	}
	
	private void _InstallTheme()
	{
		/*
		UIManager uim = UIManager.getInstance();
			Hashtable ht = new Hashtable();
			ht.put("sel#" + Style.BG_COLOR, "660099");
			ht.put(Style.BG_COLOR, "330066");
			ht.put(Style.FG_COLOR, "cccccc");
			uim.setThemeProps(ht);
		*/
		try
		{
			Theme = Resources.open("/JT_Songbooks_ME/Theme.res");
			UIManager.getInstance().setThemeProps(Theme.getTheme("JT_Songbooks_ME"));
		} catch (IOException err) { }
	}
}
