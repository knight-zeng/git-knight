package 记事本;

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
	File file=new File("无标题.txt");
	private UndoManager undomg=new UndoManager();//用于撤销
	void setTextArea(JTextArea textArea){//用于传JTextArea
		area=textArea;
	}
	void setFrame(JFrame jf){//用于传JFrame
		frame=jf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String item=e.getActionCommand();
		if(item.equals("新建(N)")){
			if(area.getText()!=null){
				
				int n=JOptionPane.showConfirmDialog(frame, "是否将更改保存到无标题？","记事本", JOptionPane.YES_NO_CANCEL_OPTION);
				if(n==JOptionPane.YES_OPTION){//保存内容
					try{
						FileOutputStream out=new FileOutputStream(file.getAbsoluteFile());//建立输出流对象
						byte a[]=area.getText().getBytes();//获取文本框的内容，并转为字节数组
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
		if(item.equals("打开(O)")){
			
			int returnVal=fc.showOpenDialog(frame);//打开的对话框
			if(returnVal==JFileChooser.APPROVE_OPTION){
				file=fc.getSelectedFile();
				try{
					frame.setTitle(file.getName()+"---记事本");
					FileInputStream in =new FileInputStream(file);//建立输入流对象
					//FileReader in=new FileReader(file); 
					//BufferedReader br=new BufferedReader(in);
					int len=(int)file.length();//获选中取文件的长度
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
		
		if(item.equals("保存(S)")){
			if(file!=null){
				try{
					FileOutputStream out=new FileOutputStream(file.getAbsoluteFile());//建立输出流对象
					byte a[]=area.getText().getBytes();//获取文本框的内容，并转为字节数组
					out.write(a);
					out.close();
					JOptionPane.showMessageDialog(frame, "保存成功！");
				}
				catch(Exception exp){
					exp.printStackTrace();
				}
			}
		}
		if(item.equals("另存为(A)")){
			int state=fc.showSaveDialog(frame);//保存的对话框
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
		if(item.equals("打印(P)")){
			
		}
		if(item.equals("退出(X)")){
			if(area.getText()!=null){
				int n=JOptionPane.showConfirmDialog(frame, "是否将更改保存到无标题？","记事本", JOptionPane.YES_NO_CANCEL_OPTION);
				if(n==JOptionPane.YES_OPTION){//保存内容
					try{
						FileOutputStream out=new FileOutputStream(file.getAbsoluteFile());
						byte a[]=area.getText().getBytes();
						out.write(a);
						out.close();
					}
					catch(Exception exp){
						exp.printStackTrace();
					}
					 System.exit(0);//退出
				}
				else if(n==JOptionPane.NO_OPTION){
					 System.exit(0);
				}
			}
	       
		}
		if(item.equals("撤销(U)")){
		       area.requestFocus();
               try{
	              undomg.undo();
               }
               catch(CannotUndoException ex){
            	   ex.printStackTrace();
              }

		}
		if(item.equals("剪切(T)")){
			area.cut();
		}
		if(item.equals("复制(C)")){
			area.copy();
			
		}
		
		if(item.equals("粘贴(P)")){
			area.paste();
		}
		
		if(item.equals("删除(L)")){
		    String selectedStr = area.getSelectedText();//选中内容
            String newStr = area.getText().replace(selectedStr,"");//将文本框内容中被选中的部分置空，再重新设置到文本框
            area.setText(newStr);
		}
		if(item.equals("查找(F)")){
			
		}
		if(item.equals("查找下一个(N)")){
	
		}
		if(item.equals("替换(R)")){
	
		}
		if(item.equals("转到(G)")){
			
		}
		if(item.equals("全选(A)")){
			area.selectAll();
		}
		if(item.equals("时间/日期(D)")){
			Calendar calendar=Calendar.getInstance();
			int year=calendar.get(Calendar.YEAR);
			int month=calendar.get(Calendar.MONTH)+1;
			int day=calendar.get(Calendar.DAY_OF_MONTH);
			int hour=calendar.get(Calendar.HOUR_OF_DAY);
			int minute=calendar.get(Calendar.MINUTE);
			String date=hour+":"+minute+"  "+year+"/"+month+"/"+day;
			area.setText(date);
		}
		
		if(item.equals("自动换行(W)")){
			
		}
		if(item.equals("字体颜色(F)")){
					Color newColor=JColorChooser.showDialog(null,"调色板", Color.gray);
					area.setForeground(newColor); 

		}
		if(item.equals("状态栏(S)")){
			
		}
		if(item.equals("查找帮助(H)")){
			
		}
		if(item.equals("关于记事本(A)")){
			area.requestFocus();
			 JOptionPane.showMessageDialog(frame,
			 "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n"+
			 " 编写者：ZZP\n"+
			 " 编写时间：2017-12-18      \n"+
			 "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n",
			 "记事本",JOptionPane.INFORMATION_MESSAGE);

		}
	}
	@Override
	public void undoableEditHappened(UndoableEditEvent e) {
		// TODO 自动生成的方法存根
		undomg.addEdit(e.getEdit());

	}

}
