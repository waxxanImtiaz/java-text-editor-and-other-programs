import java.awt.*;
import java.awt.event.*;
class calculator extends Frame
{
	Label lblResult;
	Button cmdDigit[],cmdAdd,cmdSub,cmdMul,cmdDiv,cmdEq,cmdDec,cmdOnAc;
        calculator()
	{
		super("Calculator");
		setSize(280,250);
		setVisible(true);
		setLayout(null);
        setBackground(Color.yellow);
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){System.exit(0);}});
		lblResult=new Label("0",Label.RIGHT);
		lblResult.setBounds(10,25,250,30);
		Font f=new Font("Arial",Font.BOLD,30);
		lblResult.setFont(f);
		lblResult.setBackground(Color.lightGray);
		add(lblResult);
		cmdDigit=new Button[10];
		for(int i=0;i<10;i++)
		{
			cmdDigit[i]=new Button(i+"");
			this.add(cmdDigit[i]);
			cmdDigit[i].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){digit_Click(e);}});
		}
		cmdOnAc=new Button("RESET");
		cmdOnAc.setBounds(205,60,65,30);
		add(cmdOnAc);
		cmdAdd=new Button("+");
		cmdAdd.setBounds(205,95,30,30);
		add(cmdAdd);
		cmdSub=new Button("-");
		cmdSub.setBounds(245,95,30,30);
		add(cmdSub);
		cmdMul=new Button("*");
		cmdMul.setBounds(205,130,30,30);
		add(cmdMul);
		cmdDiv=new Button("/");
		cmdDiv.setBounds(245,130,30,30);
		add(cmdDiv);
		cmdEq=new Button("=");
		cmdEq.setBounds(205,165,65,30);
		add(cmdEq);
		cmdDec=new Button(".");
		cmdDec.setBounds(170,165,30,30);
		add(cmdDec);

		cmdDigit[1].setBounds(100,60,30,30);
		cmdDigit[2].setBounds(135,60,30,30);
		cmdDigit[3].setBounds(170,60,30,30);
		cmdDigit[4].setBounds(100,95,30,30);
		cmdDigit[5].setBounds(135,95,30,30);
		cmdDigit[6].setBounds(170,95,30,30);
		cmdDigit[7].setBounds(100,130,30,30);
		cmdDigit[8].setBounds(135,130,30,30);
		cmdDigit[9].setBounds(170,130,30,30);
		cmdDigit[0].setBounds(135,165,30,30);

		cmdAdd.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){opr_Click(e);}});
		cmdSub.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){opr_Click(e);}});
		cmdMul.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){opr_Click(e);}});
		cmdDiv.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){opr_Click(e);}});
		cmdEq.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){eq_Click(e);}});
		cmdDec.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){dec_Click();}});
		cmdOnAc.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){OnAc_Click();}});
	}
	double op1,op2;
	String opr;
	void OnAc_Click()
	{
		op1=0;
		op2=0;
		lblResult.setText("0");
	}
	void dec_Click()
	{
		String s1=lblResult.getText();
		int pos=s1.indexOf(".");
		if(pos<0)
			lblResult.setText(s1+".");
	}
	void eq_Click(ActionEvent e)
	{
		String s=lblResult.getText();
		op2=Double.parseDouble(s);
		double ans=0;
		if(opr.equals("+"))	ans=op1+op2;
		if(opr.equals("-"))	ans=op1-op2;
		if(opr.equals("*"))	ans=op1*op2;
		if(opr.equals("/"))	ans=op1/op2;
		lblResult.setText(ans+"");
	}
	void opr_Click(ActionEvent e)
	{
		String s=lblResult.getText();
		op1=Double.parseDouble(s);
		lblResult.setText("0");
		opr=e.getActionCommand();
	}
	void digit_Click(ActionEvent e)
	{
		String s=lblResult.getText();
		String s1=e.getActionCommand();
		if(s.equals("0"))
			lblResult.setText(s1);
		else
			lblResult.setText(s+s1);
	}

}
