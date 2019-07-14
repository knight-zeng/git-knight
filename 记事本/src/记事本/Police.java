package ���±�;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class Police implements ActionListener,UndoableEditListener{
	private JTextArea area;
	private JFrame frame;
	JFileChooser fc=new JFileChooser();
	File file=new File("�ޱ���.txt");
	private UndoManager undomg=new UndoManager();//���ڳ���
	void setTextArea(JTextArea textArea){//���ڴ�JTextArea
		area=textArea;
	}
	void setFrame(JFrame jf){//���ڴ�JFrame
		frame=jf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String item=e.getActionCommand();
		if(item.equals("�½�(N)")){
			if(area.getText()!=null){
				
				int n=JOptionPane.showConfirmDialog(frame, "�Ƿ񽫸��ı��浽�ޱ��⣿","���±�", JOptionPane.YES_NO_CANCEL_OPTION);
				if(n==JOptionPane.YES_OPTION){//��������
					try{
						FileOutputStream out=new FileOutputStream(file.getAbsoluteFile());//�������������
						byte a[]=area.getText().getBytes();//��ȡ�ı�������ݣ���תΪ�ֽ�����
						out.write(a);
						out.close();
					}
					catch(Exception exp){
						exp.printStackTrace();
					}
					
				}
				else if(n==JOptionPane.NO_OPTION){
					area.setText(null);
				}
			}
		}
		if(item.equals("��(O)")){
			
			int returnVal=fc.showOpenDialog(frame);//�򿪵ĶԻ���
			if(returnVal==JFileChooser.APPROVE_OPTION){
				file=fc.getSelectedFile();
				try{
					frame.setTitle(file.getName()+"---���±�");
					FileInputStream in =new FileInputStream(file);//��������������
					//FileReader in=new FileReader(file); 
					//BufferedReader br=new BufferedReader(in);
					int len=(int)file.length();//��ѡ��ȡ�ļ��ĳ���
					byte a[]=new byte[len];
					//char a[]=new char[len];
					//String a=null;
					//if((a=br.readLine())!=null){
					in.read(a, 0, len);
						//area.setText(a);
					//}
					//br.close();
					in.close();
					area.setText(new String(a));
				}
				catch(Exception exp){
					exp.printStackTrace();
				}
			}

		}
		
		if(item.equals("����(S)")){
			if(file!=null){
				try{
					FileOutputStream out=new FileOutputStream(file.getAbsoluteFile());//�������������
					byte a[]=area.getText().getBytes();//��ȡ�ı�������ݣ���תΪ�ֽ�����
					out.write(a);
					out.close();
					JOptionPane.showMessageDialog(frame, "����ɹ���");
				}
				catch(Exception exp){
					exp.printStackTrace();
				}
			}
		}
		if(item.equals("���Ϊ(A)")){
			int state=fc.showSaveDialog(frame);//����ĶԻ���
			if(state==JFileChooser.APPROVE_OPTION){
				file=fc.getSelectedFile();
				try{
					FileOutputStream out =new FileOutputStream(file);
					//FileWriter out=new FileWriter(file);
					//BufferedWriter bw=new BufferedWriter(out);
					byte a[]=area.getText().getBytes();
					//char a[]=area.getText().toCharArray();
					//String a=area.getText();
					//bw.write(a);
					//bw.close();
					out.write(a);
					out.close();
				}
				catch(Exception exp){
					exp.printStackTrace();
				}
			}
		}
		if(item.equals("��ӡ(P)")){
			
		}
		if(item.equals("�˳�(X)")){
			if(area.getText()!=null){
				int n=JOptionPane.showConfirmDialog(frame, "�Ƿ񽫸��ı��浽�ޱ��⣿","���±�", JOptionPane.YES_NO_CANCEL_OPTION);
				if(n==JOptionPane.YES_OPTION){//��������
					try{
						FileOutputStream out=new FileOutputStream(file.getAbsoluteFile());
						byte a[]=area.getText().getBytes();
						out.write(a);
						out.close();
					}
					catch(Exception exp){
						exp.printStackTrace();
					}
					 System.exit(0);//�˳�
				}
				else if(n==JOptionPane.NO_OPTION){
					 System.exit(0);
				}
			}
	       
		}
		if(item.equals("����(U)")){
		       area.requestFocus();
               try{
	              undomg.undo();
               }
               catch(CannotUndoException ex){
            	   ex.printStackTrace();
              }

		}
		if(item.equals("����(T)")){
			area.cut();
		}
		if(item.equals("����(C)")){
			area.copy();
			
		}
		
		if(item.equals("ճ��(P)")){
			area.paste();
		}
		
		if(item.equals("ɾ��(L)")){
		    String selectedStr = area.getSelectedText();//ѡ������
            String newStr = area.getText().replace(selectedStr,"");//���ı��������б�ѡ�еĲ����ÿգ����������õ��ı���
            area.setText(newStr);
		}
		if(item.equals("����(F)")){
			
		}
		if(item.equals("������һ��(N)")){
	
		}
		if(item.equals("�滻(R)")){
	
		}
		if(item.equals("ת��(G)")){
			
		}
		if(item.equals("ȫѡ(A)")){
			area.selectAll();
		}
		if(item.equals("ʱ��/����(D)")){
			Calendar calendar=Calendar.getInstance();
			int year=calendar.get(Calendar.YEAR);
			int month=calendar.get(Calendar.MONTH)+1;
			int day=calendar.get(Calendar.DAY_OF_MONTH);
			int hour=calendar.get(Calendar.HOUR_OF_DAY);
			int minute=calendar.get(Calendar.MINUTE);
			String date=hour+":"+minute+"  "+year+"/"+month+"/"+day;
			area.setText(date);
		}
		
		if(item.equals("�Զ�����(W)")){
			
		}
		if(item.equals("������ɫ(F)")){
					Color newColor=JColorChooser.showDialog(null,"��ɫ��", Color.gray);
					area.setForeground(newColor); 

		}
		if(item.equals("״̬��(S)")){
			
		}
		if(item.equals("���Ұ���(H)")){
			
		}
		if(item.equals("���ڼ��±�(A)")){
			area.requestFocus();
			 JOptionPane.showMessageDialog(frame,
			 "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n"+
			 " ��д�ߣ�ZZP\n"+
			 " ��дʱ�䣺2017-12-18      \n"+
			 "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n",
			 "���±�",JOptionPane.INFORMATION_MESSAGE);

		}
	}
	@Override
	public void undoableEditHappened(UndoableEditEvent e) {
		// TODO �Զ����ɵķ������
		undomg.addEdit(e.getEdit());

	}

}
