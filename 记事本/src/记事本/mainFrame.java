package ���±�;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class mainFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame window = new mainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		Police police=new Police();
		
		frame = new JFrame();
		frame.setTitle("���±�");
		police.setFrame(frame);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu Files = new JMenu("�ļ�(F)");
		menuBar.add(Files);
		
		JMenuItem New = new JMenuItem("�½�(N)");
		New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		New.addActionListener(police);
		Files.add(New);
		
		JSeparator separator = new JSeparator();
		Files.add(separator);
		
		JMenuItem Open = new JMenuItem("��(O)");
		Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		Open.addActionListener(police);
		Files.add(Open);
		
		JSeparator separator_1 = new JSeparator();
		Files.add(separator_1);
		
		JMenuItem Save = new JMenuItem("����(S)");
		Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		Save.addActionListener(police);
		Files.add(Save);
		
		JSeparator separator_2 = new JSeparator();
		Files.add(separator_2);
		
		JMenuItem SaveAs = new JMenuItem("���Ϊ(A)");
		SaveAs.addActionListener(police);
		Files.add(SaveAs);
		
		JSeparator separator_3 = new JSeparator();
		Files.add(separator_3);
		
		JMenuItem Print = new JMenuItem("��ӡ(P)");
		Print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		Files.add(Print);
		
		JSeparator separator_4 = new JSeparator();
		Files.add(separator_4);
		
		JMenuItem Exit = new JMenuItem("�˳�(X)");
		Exit.addActionListener(police);
		Files.add(Exit);
		
		JMenu Editor = new JMenu("�༭(E)");
		menuBar.add(Editor);
		
		JMenuItem Withdraw = new JMenuItem("����(U)");
		Withdraw.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		Withdraw.addActionListener(police);
		Editor.add(Withdraw);
		
		JSeparator separator_5 = new JSeparator();
		Editor.add(separator_5);
		
		JMenuItem Cut = new JMenuItem("����(T)");
		Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		Cut.addActionListener(police);
		Editor.add(Cut);
		
		JSeparator separator_6 = new JSeparator();
		Editor.add(separator_6);
		
		JMenuItem Copy = new JMenuItem("����(C)");
		Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		Copy.addActionListener(police);
		Editor.add(Copy);
		
		JSeparator separator_7 = new JSeparator();
		Editor.add(separator_7);
		
		JMenuItem Paste = new JMenuItem("ճ��(P)");
		Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		Paste.addActionListener(police);
		Editor.add(Paste);
		
		JSeparator separator_8 = new JSeparator();
		Editor.add(separator_8);
		
		JMenuItem Delete = new JMenuItem("ɾ��(L)");
		Delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		Delete.addActionListener(police);
		Editor.add(Delete);
		
		JSeparator separator_9 = new JSeparator();
		Editor.add(separator_9);
		
		JMenuItem Find = new JMenuItem("����(F)");
		Find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		Editor.add(Find);
		
		JSeparator separator_10 = new JSeparator();
		Editor.add(separator_10);
		
		JMenuItem FindNext = new JMenuItem("������һ��(N)");
		FindNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		Editor.add(FindNext);
		
		JSeparator separator_11 = new JSeparator();
		Editor.add(separator_11);
		
		JMenuItem Replace = new JMenuItem("�滻(R)");
		Replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		Editor.add(Replace);
		
		JSeparator separator_12 = new JSeparator();
		Editor.add(separator_12);
		
		JMenuItem GoTo = new JMenuItem("ת��(G)");
		GoTo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		Editor.add(GoTo);
		
		JSeparator separator_13 = new JSeparator();
		Editor.add(separator_13);
		
		JMenuItem All = new JMenuItem("ȫѡ(A)");
		All.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		All.addActionListener(police);
		Editor.add(All);
		
		JSeparator separator_14 = new JSeparator();
		Editor.add(separator_14);
		
		JMenuItem Date = new JMenuItem("ʱ��/����(D)");
		Date.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		Date.addActionListener(police);
		Editor.add(Date);
		
		JMenu Format = new JMenu("��ʽ(O)");
		menuBar.add(Format);
		
		JMenuItem WordWrap = new JMenuItem("�Զ�����(W)");
		Format.add(WordWrap);
		
		JSeparator separator_16 = new JSeparator();
		Format.add(separator_16);
		
		JMenuItem Font = new JMenuItem("������ɫ(F)");
		Font.addActionListener(police);
		Format.add(Font);
		
		
		JMenu View = new JMenu("����(V)");
		menuBar.add(View);
		
		JMenuItem Status = new JMenuItem("״̬��(S)");
		View.add(Status);
		
		JMenu Help = new JMenu("����(H)");
		menuBar.add(Help);
		
		JMenuItem CheckHelp = new JMenuItem("���Ұ���(H)");
		Help.add(CheckHelp);
		
		JSeparator separator_15 = new JSeparator();
		Help.add(separator_15);
		
		JMenuItem About = new JMenuItem("���ڼ��±�(A)");
		About.addActionListener(police);
		Help.add(About);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.getDocument().addUndoableEditListener(police);
		scrollPane.setViewportView(textArea);
		police.setTextArea(textArea);//����
	}

}
