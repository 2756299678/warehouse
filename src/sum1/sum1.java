package sum1;

import java.util.Scanner;

public class sum1 {
	//�����������飺��������int�͵����飬������Ϣ�����ڼ�����ж�
	//������������飬�����������飬�Ƚ�����Ĵ�С����ĸ�ֵr1[i]
    static int[] r1;
    static int[] r2;
   //������������飬�����������飬�Ƚ�����Ĵ�С����ĸ�ֵn3[i]
    static int[] n3;
    static int[] n4;
    //������ó�double�͵ģ���Ϊ����������׳�double
    static double[]S1;
    //����������ļ����������л��򣬴�����Ϣ
    static int[]S2;
    static int[]S3;
    
    static String[] r3={"+","-","*","/"};
    //���������������s1[i]�У����ڱȽ���ʽ�����ɲ�һ��������
    static String s1[];
    //�Ƚϲ�ͬ����Ҫ�õ���ѭ��������
    static int j;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		while(true)
		{
			Scanner scan1=new Scanner(System.in);
			System.out.println("������ѡ�");
			System.out.println("1����������  2����������� 3���˳�");
			
			int choose=scan1.nextInt();
			
			if(choose==1)
			{
				System.out.print("�����붨��������");
				Scanner scan2=new Scanner(System.in);
				int number=scan2.nextInt();
				
				r1=new int[number];
				r2=new int[number];
				S1=new double[number];
				s1=new String[number];
				
				for(int i=0;i<number;i++)
				{
					int a=(int)(0+Math.random()*4);
					
					s1[i]=r3[a];
					
					r1[i]=(int)(1+Math.random()*100);
					
					r2[i]=(int)(1+Math.random()*100);

					
					if(s1[i].equals("+"))
					{
						
						S1[i]=(r1[i]+r2[i]);
						
						System.out.println(r1[i]+" + "+r2[i]+" =");
					}
					
					else if(s1[i].equals("-"))
					{ 
						
                       if(r1[i]>r2[i])
                       {
                    	   S1[i]=(r1[i]-r2[i]);
                    	   System.out.println(r1[i]+" - "+r2[i]+" =");
                       }
						  
					   else
					   {
						    int c;
						    
						    c=r2[i];
							r2[i]=r1[i];
							r1[i]=c;
							
							S1[i]=(r1[i]-r2[i]);
							
						   System.out.println(r1[i]+" - "+r2[i]+" =");
					   }
					}
					else if(s1[i].equals("*"))
					{
						S1[i]=(r1[i]*r2[i]);
						System.out.println(r1[i]+" x "+r2[i]+" =");
					}
					else if(s1[i].equals("/"))
					{
						S1[i]=(r1[i]/r2[i]);
						while(true)
						{
							if(r2[i]!=0)
							{
								 System.out.println(r1[i]+" �� "+r2[i]+" =");
								 break;
							}
							else 
								r2[i]=(int)(1+Math.random()*100);
						}	
					}
					//for
				}
				
				System.out.println("�Ƿ�������ƽ������1.���    ������ �������");
				Scanner scan3=new Scanner(System.in);
				int judge1=scan3.nextInt();
				
				if(judge1==1)
				{
					for(int i=0;i<number;i++)
					{
						System.out.println("��"+(i+1)+"����ʽ�Ľ��Ϊ��"+S1[i]);
					}
				}
				//choose
			}
			
			
			 if(choose==2)
			{
				System.out.print("�����붨��������");
				Scanner scan2=new Scanner(System.in);
				int number=scan2.nextInt();
				
				r1=new int[number];
				r2=new int[number];
				n3=new int[number];
				n4=new int[number];
				
				S2=new int[number];
				S3=new int[number];
				
				for(int i=0;i<number;i++)
				{
					r1[i]=(int)(1+Math.random()*100);
					r2[i]=(int)(1+Math.random()*100);
					
                    n3[i]=(int)(1+Math.random()*100);
					n4[i]=(int)(1+Math.random()*100);
					
					int a=(int)(0+Math.random()*4);
					
                    s1[i]=r3[a];
					
					for(j=0;j<i;j++)
					{
						if(r1[i]==r1[j]&&r1[i]==r1[j]&&s1[i].equals(s1[j])
								&&n3[i]==n3[j]&&n4[i]==n4[j])
						{
                            r1[i]=(int)(1+Math.random()*100);
							r2[i]=(int)(1+Math.random()*100);
							n3[i]=(int)(1+Math.random()*100);
							n4[i]=(int)(1+Math.random()*100);
							j=0;
						}
					}
					while(r2[i]==0)
					{
						r2[i]=(int)(1+Math.random()*100);
					}
					
					//�������Լ��
					int gy1=simple(r1[i],r2[i]);
					
					r1[i]=r1[i]/gy1;
					r2[i]=r2[i]/gy1;
					
					//���������
					int c1;
					
					if(r1[i]>r2[i])
					{
						c1=r2[i];
						r2[i]=r1[i];
						r1[i]=c1;
					}
					
					while(n4[i]==0)
					{
						n4[i]=(int)(1+Math.random()*100);
					}
					
					//�������Լ��
					int gy2=simple(n3[i],n4[i]);
					n3[i]=n3[i]/gy2;
					n4[i]=n4[i]/gy2;
					
					//���������
					int c2;
					
					if(n3[i]>n4[i])
					{
						c2=n4[i];
						n4[i]=n3[i];
						n3[i]=c2;
					}
						
					
					if(s1[i].equals("+"))
					{
					   S2[i]=r1[i]*n4[i]+r2[i]*n3[i];
					   S3[i]=r2[i]*n4[i];
					   //�������Լ��
						gy1=simple(S2[i],S3[i]);
						
						S2[i]=S2[i]/gy1;
						S3[i]=S3[i]/gy1;
					   
					   System.out.println(r1[i]+"/"+r2[i]+" + "+n3[i]+"/"+n4[i]+" =");
					}
					else if(s1[i].equals("-"))
					{
						S2[i]=r1[i]*n4[i]-r2[i]*n3[i];
						
						//���Ϊ����
						if(S2[i]<0)
						{
							c2=n4[i];
							n4[i]=r2[i];
							r2[i]=c2;
							
							c2=r1[i];
							r1[i]=n3[i];
							n3[i]=c2;
						}
						
						S2[i]=r1[i]*n4[i]-r2[i]*n3[i];
					    S3[i]=r2[i]*n4[i];
						   //�������Լ��
						gy1=simple(S2[i],S3[i]);
							
						S2[i]=S2[i]/gy1;
						S3[i]=S3[i]/gy1;
						
					   System.out.println(r1[i]+"/"+r2[i]+" - "+n3[i]+"/"+n4[i]+" =");
					}
					else if(s1[i].equals("*"))
					{
						S2[i]=r1[i]*n3[i];
					    S3[i]=r2[i]*n4[i];
						   //�������Լ��
						gy1=simple(S2[i],S3[i]);
							
						S2[i]=S2[i]/gy1;
						S3[i]=S3[i]/gy1;
						
					   System.out.println(r1[i]+"/"+r2[i]+" x "+n3[i]+"/"+n4[i]+" =");
					}
					else if(s1[i].equals("/"))
					{
						S2[i]=r1[i]*n4[i];
					    S3[i]=r2[i]*n3[i];
						   //�������Լ��
						gy1=simple(S2[i],S3[i]);
							
						S2[i]=S2[i]/gy1;
						S3[i]=S3[i]/gy1;
						
					   System.out.println(r1[i]+"/"+r2[i]+" ��  "+n3[i]+"/"+n4[i]+" =");
					}
					//for
				}
				
				System.out.print("�Ƿ�������ƽ������1.���    ������ �������");
				Scanner scan4=new Scanner(System.in);
				int judge2=scan4.nextInt();
				
				if(judge2==1)
				{
					for(int i=0;i<number;i++)
					{
						System.out.println("��"+(i+1)+"����ʽ�Ľ��Ϊ��"+S2[i]+"/"+S3[i]);
					}
				}
				//choose
			}
			else if(choose==3)
			{
				System.out.println("�ɹ��˳���");
				break;
			}
			else 
			{
				System.out.println("�����������������룡");
			}
			//while
		}
		//main
	}
	
	
	public static int simple(int n1,int n2)
	{
		int max = n2;
		
		if(n1>n2)
		{
			max=n1;
		}
		
		int gongyue=1;
		
		for(int i=1;i<=max;i++)
		{
			if(n1%i==0 && n2%i==0)
			{
				gongyue=i;
			}
		}
		return gongyue;
	}
}
