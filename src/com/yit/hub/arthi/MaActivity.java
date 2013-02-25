package com.yit.hub.arthi;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.view.Menu;

public class MaActivity extends Activity {
	public String pre_element="";
	public String current_element="";
	public String stack="";
	public String element="";
	public float output=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ma);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ma, menu);
		return true;
	}
	
	public float getVal(String st)
    {
	String s="";
	String [] allElements=st.split(",");
	float outp=0;
	while(allElements.length>=3)
	{
	s="";
	float operant1=0,operant2=0;
	String operator="";
	int i;
	for(i=allElements.length-1;i>=0;i--)
	{
	if(allElements[i].equals("+")||allElements[i].equals("-")||allElements[i].equals("x")||allElements[i].equals("/"))
	{
	operator=allElements[i];
	operant1=Float.parseFloat(allElements[i+1]);
	operant2=Float.parseFloat(allElements[i+2]);
	break;
	}
	}
	if(!operator.equals(""))
	{
    	if(operator.equals("+"))
    	{
    	outp=operant2+operant1;
    	}
    	if(operator.equals("-"))
    	{
    		outp=operant2-operant1;
    	}
    	if(operator.equals("x"))
    	{
    		outp=operant2*operant1;
    	}
    	if(operator.equals("/"))
    	{
    		outp=operant2/operant1;
    	}
	}
	
		for(int e=0;e<i;e++)
		{		
		if(s.equals(""))
		{
			s=allElements[e];
		}
		else
		{
			s=s+","+allElements[e];
		}
		}
		
		if(s.equals(""))
		{
			s=outp+"";
		}
		else
		{
			s=s+","+outp;
		}
		
		for(int el=i+3;el<allElements.length;el++)
		{		
		if(s.equals(""))
		{
			s=allElements[el];
		}
		else
		{
			s=s+","+allElements[el];
		}
		}
		
	allElements=null;
	allElements=s.split(",");
	}
    	return outp;
    }
	 public int getPriority(String ele)
    {
	int priority=0;
	    if(ele.equals("0")||ele.equals("1")||ele.equals("2")||ele.equals("3")||ele.equals("4")||ele.equals("5")||ele.equals("6")||ele.equals("7")||ele.equals("8")||ele.equals("9"))
		{
    		priority=1;
    	}
    	if(ele.equals("/")||ele.equals("x"))
		{
    		priority=2;
    	}
		else if(ele.equals("+")||ele.equals("-"))
		{
    		priority=3;
    	}		
		/*else
		{
    		priority=4;
    	}*/
		return priority;
    }
    public void calculate(View view)
    {
    	if (view.getId() == R.id.okButton)
		{
    		String stack_inverse="";
    		String[] aStackEle=stack.split(",");
    		for(int si=aStackEle.length-1;si>=0;si--)
    		{
    		if(stack_inverse.equals(""))
    		{
    			stack_inverse=aStackEle[si];
    		}
    		else
    		{
    			stack_inverse=stack_inverse+","+aStackEle[si];
    		}
    		}
    		output=getVal(stack_inverse);
    		stack=output+"";
    		EditText input=(EditText)findViewById(R.id.displOutput);
    		input.setText(output+"");
    	}
    }
    public void refresh(View view)
    {
    	if (view.getId() == R.id.ButtonAC)
		{
    		MaActivity c=new MaActivity();
    		EditText input=(EditText)findViewById(R.id.displOutput);
    		input.setText("");
    		pre_element="";
    		current_element="";
    		stack="";
    		element="";
    		output=0;
    	}
    }
    public void calculatorText(View view)
    {
	  EditText input=(EditText)findViewById(R.id.displOutput);
	  if(view.getId()==R.id.Buttonzero)
	  {
		 element="0";
	  }
	  if(view.getId()==R.id.Buttonone)
	  {
		 element="1";
	  }
	  if(view.getId()==R.id.Buttontwo)
	  {
		 element="2";
	  }
	  if(view.getId()==R.id.Buttonthree)
	  {
		 element="3";
	  }
	  if(view.getId()==R.id.Buttonfour)
	  {
		 element="4";
	  }
	  if(view.getId()==R.id.Buttonfive)
	  {
		 element="5";
	  }
	  if(view.getId()==R.id.Buttonsix)
	  {
		 element="6";
	  }
	  if(view.getId()==R.id.Buttonseven)
	  {
		 element="7";
	  }
	  if(view.getId()==R.id.Buttoneight)
	  {
		 element="8";
	  }
	  if(view.getId()==R.id.Buttonnine)
	  {
		 element="9";
	  }
	  if(view.getId()==R.id.Buttonopen)
	  {
		 element="(";
	  }
	  if(view.getId()==R.id.Buttonclose)
	  {
		 element=")";		 
	  }
	  if(view.getId()==R.id.Buttondot)
	  {
		 element=".";
	  }
	  
if(view.getId()==R.id.Buttonadd||view.getId()==R.id.Buttonsubtract||view.getId()==R.id.Buttonmultiply||view.getId()==R.id.Buttondivide)
{
		if(view.getId()==R.id.Buttonadd)
		  {
			element="+";
		  }
    	if(view.getId()==R.id.Buttonsubtract)
    	  {
			element="-";
    	  }
    	if(view.getId()==R.id.Buttonmultiply)
    	  {
			element="x";
    	  }
    	if(view.getId()==R.id.Buttondivide)
    	  {
			element="/";
    	  }
}

String prev_element=pre_element;
pre_element=current_element;
current_element=element;
if((pre_element.equals("+")||pre_element.equals("-")||pre_element.equals("x")||pre_element.equals("/")) && (element.equals("+")||element.equals("-")||element.equals("x")||element.equals("/")))
{
	if((pre_element.equals("+") && element.equals("+"))||(pre_element.equals("-") && element.equals("-")))
	{
		element="+";		
	}
	else if(((pre_element.equals("x")||pre_element.equals("/")) && pre_element.equals(element))||(pre_element.equals("x")||pre_element.equals("/")) && !pre_element.equals(element))
	{
		element=element;
	}
	else
	{
		element="-";		
	}
	String [] allStackElements=stack.split(",");
	stack="";
	for(int n=0;n<allStackElements.length-1;n++)
	{
		if(stack.equals(""))
		{
			stack=allStackElements[n];
		}
		else
		{
			stack=stack+","+allStackElements[n];
		}
	}
	
	pre_element=prev_element;
	current_element=element;
}
if(view.getId()==R.id.Buttonclose)
{
	String [] allStackElements=stack.split(",");
	String temp="";
	for(int i=allStackElements.length-1;i>=0;i--)
	{
	if(!allStackElements[i].equals("("))
	{
if(temp.equals(""))
{
	temp=element;
}
else
{
	temp=temp+","+element;
}
   }
   
   if(allStackElements[i].equals("("))
	{
		float curr_op=getVal(temp);
   for(int c=0;c<i;c++)
	{
		if(stack.equals(""))
	{
		stack=allStackElements[i];
	}
	   else
	{
		stack=stack+","+allStackElements[i];
	}
	}
		if(stack.equals(""))
	{
		stack=curr_op+"";
	}
	   else
	{
		stack=stack+","+curr_op;
	}
		
	}
	}
}

else
{
	String operatorExists="";
	String sta="";
	String temp="";
	float t_output=0;
	int priority=getPriority(element);
	String havePut="no";
	int o=0;
	if(stack.equals(""))
	{
		stack=element;
	}
	
	else if((pre_element.equals("0")||pre_element.equals("1")||pre_element.equals("2")||pre_element.equals("3")||pre_element.equals("4")||pre_element.equals("5")||pre_element.equals("6")||pre_element.equals("7")||pre_element.equals("8")||pre_element.equals("9"))&&(element.equals("0")||element.equals("1")||element.equals("2")||element.equals("3")||element.equals("4")||element.equals("5")||element.equals("6")||element.equals("7")||element.equals("8")||element.equals("9")))
	{
		String [] allStackElements=stack.split(",");
		for(int n=0;n<allStackElements.length;n++)
		{
			if(priority<getPriority(allStackElements[n]))
			{
			for(int sp=0;sp<n;sp++)
			{
			if(sta.equals(""))
			{
				sta=allStackElements[sp];
			}
			else
			{
				sta=sta+","+allStackElements[sp];
			}
			}
			
			if(sta.equals(""))
			{
				sta=element;
			}
			else
			{
				sta=sta+element;
			}
			
			for(int l=n;l<allStackElements.length;l++)
			{
			if(sta.equals(""))
			{
				sta=allStackElements[l];
			}
			else
			{
				sta=sta+","+allStackElements[l];
			}
			}
			havePut="yes";
			stack=sta;
			break;
			}
			
			else if(havePut.equals("no") && n==allStackElements.length-1)
			{
				stack=stack+element;
			}		
		}
	}
	
	else
	{
	String [] allStackElements=stack.split(",");
	for(o=0;o<allStackElements.length;o++)
	{
	if(allStackElements[o].equals("+")||allStackElements[o].equals("-")||allStackElements[o].equals("x")||allStackElements[o].equals("/"))
	{
		operatorExists="yes";
		break;
	}
	}
	
	for(int p=0;p<allStackElements.length;p++)
	{		
	allStackElements=stack.split(",");

	if(operatorExists.equals("yes") && getPriority(allStackElements[o])<=priority && (element.equals("+")||element.equals("-")||element.equals("x")||element.equals("/")))
	{
	temp=allStackElements[o]+","+allStackElements[o-1]+","+allStackElements[o-2];
	t_output=getVal(temp);	
	input.setText(t_output+"");
	for(int s=0;s<o-2;s++)
	{
	if(sta.equals(""))
	{
		sta=allStackElements[s];
	}
	else
	{
		sta=sta+","+allStackElements[s];
	}
	}
	
	if(sta.equals(""))
	{
		sta=t_output+"";
	}
	else
	{
		sta=sta+","+t_output;
	}
	
	for(int ss=o+1;ss<allStackElements.length;ss++)
	{
	if(sta.equals(""))
	{
		sta=allStackElements[ss];
	}
	else
	{
		sta=sta+","+allStackElements[ss];
	}
	}
	stack=sta;
	allStackElements=stack.split(",");
	}
	
	if(priority<getPriority(allStackElements[p]))
	{
	for(int sp=0;sp<p;sp++)
	{
	if(sta.equals(""))
	{
		sta=allStackElements[sp];
	}
	else
	{
		sta=sta+","+allStackElements[sp];
	}
	}
	
	if(sta.equals(""))
	{
		sta=element;
	}
	else
	{
		sta=sta+","+element;
	}
	
	for(int l=p;l<allStackElements.length;l++)
	{
	if(sta.equals(""))
	{
		sta=allStackElements[l];
	}
	else
	{
		sta=sta+","+allStackElements[l];
	}
	}
	havePut="yes";
	stack=sta;
	break;
	}
	
	else if(havePut.equals("no") && p==allStackElements.length-1)
	{
		stack=stack+","+element;
	}
	}
	
	if(element.equals("0")||element.equals("1")||element.equals("2")||element.equals("3")||element.equals("4")||element.equals("5")||element.equals("6")||element.equals("7")||element.equals("8")||element.equals("9"))
	{
		allStackElements=stack.split(",");
		String operatorsExists="";
		for(o=0;o<allStackElements.length;o++)
		{
			if(o!=allStackElements.length-1)
			{
		if((allStackElements[o+1].equals("+")||allStackElements[o+1].equals("-")||allStackElements[o+1].equals("x")||allStackElements[o+1].equals("/"))&&(allStackElements[o].equals("+")||allStackElements[o].equals("-")||allStackElements[o].equals("x")||allStackElements[o].equals("/")))
		{
			operatorsExists="yes";
			break;
		}
			}
		}
		
	if(operatorsExists.equals("yes") && getPriority(allStackElements[o])!=getPriority(allStackElements[o+1]))
	{	
		sta="";	
		temp=allStackElements[o]+","+allStackElements[o-1]+","+allStackElements[o-2];
		float temp_output=getVal(temp);	
		for(int s=0;s<o-2;s++)
		{
		if(sta.equals(""))
		{
			sta=allStackElements[s];
		}
		else
		{
			sta=sta+","+allStackElements[s];
		}
		}
		
		if(sta.equals(""))
		{
			sta=temp_output+"";
		}
		else
		{
			sta=sta+","+temp_output;
		}
		
		for(int ss=o+1;ss<allStackElements.length;ss++)
		{
		if(sta.equals(""))
		{
			sta=allStackElements[ss];
		}
		else
		{
			sta=sta+","+allStackElements[ss];
		}
		}
		stack=sta;	
	}
	}
	
	}
	
	if((element.equals("+")||element.equals("-")||element.equals("x")||element.equals("/")) && t_output==0)
	{
	input.setText("");
	}
}

if((element.equals("0")||element.equals("1")||element.equals("2")||element.equals("3")||element.equals("4")||element.equals("5")||element.equals("6")||element.equals("7")||element.equals("8")||element.equals("9")) && (!pre_element.equals("+")&&!pre_element.equals("-")&&!pre_element.equals("x")&&!pre_element.equals("/")))
{
	if(stack.equals(""))
	{
		input.setText(element);
	}
	else
	{
        input.setText(input.getText().toString()+element);
	}
}
else if(!element.equals("+")&&!element.equals("-")&&!element.equals("x")&&!element.equals("/"))
{
input.setText(""+element);
}
}
}

