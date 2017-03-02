package sum1;

import java.util.Scanner;

public class sum1 {
	//对于整数来书：建立两个int型的数组，储存信息，便于计算和判断
	//对于真分数来书，建立两个数组，比较数组的大小，大的赋值r1[i]
    static int[] r1;
    static int[] r2;
   //对于真分数来书，建立两个数组，比较数组的大小，大的赋值n3[i]
    static int[] n3;
    static int[] n4;
    //结果设置成double型的，因为整数相除容易出double
    static double[]S1;
    //计算真分数的计算结果，进行化简，储存信息
    static int[]S2;
    static int[]S3;
    
    static String[] r3={"+","-","*","/"};
    //将运算符储存在是s1[i]中，便于比较算式，生成不一样的数据
    static String s1[];
    //比较不同所需要用到的循环参数；
    static int j;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		while(true)
		{
			Scanner scan1=new Scanner(System.in);
			System.out.println("请输入选项：");
			System.out.println("1、整数计算  2、真分数计算 3、退出");
			
			int choose=scan1.nextInt();
			
			if(choose==1)
			{
				System.out.print("请输入定制数量：");
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
								 System.out.println(r1[i]+" ÷ "+r2[i]+" =");
								 break;
							}
							else 
								r2[i]=(int)(1+Math.random()*100);
						}	
					}
					//for
				}
				
				System.out.println("是否输出定制结果？（1.输出    其他： 不输出）");
				Scanner scan3=new Scanner(System.in);
				int judge1=scan3.nextInt();
				
				if(judge1==1)
				{
					for(int i=0;i<number;i++)
					{
						System.out.println("第"+(i+1)+"个算式的结果为："+S1[i]);
					}
				}
				//choose
			}
			
			
			 if(choose==2)
			{
				System.out.print("请输入定制数量：");
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
					
					//返回最大公约数
					int gy1=simple(r1[i],r2[i]);
					
					r1[i]=r1[i]/gy1;
					r2[i]=r2[i]/gy1;
					
					//建立真分数
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
					
					//返回最大公约数
					int gy2=simple(n3[i],n4[i]);
					n3[i]=n3[i]/gy2;
					n4[i]=n4[i]/gy2;
					
					//建立真分数
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
					   //返回最大公约数
						gy1=simple(S2[i],S3[i]);
						
						S2[i]=S2[i]/gy1;
						S3[i]=S3[i]/gy1;
					   
					   System.out.println(r1[i]+"/"+r2[i]+" + "+n3[i]+"/"+n4[i]+" =");
					}
					else if(s1[i].equals("-"))
					{
						S2[i]=r1[i]*n4[i]-r2[i]*n3[i];
						
						//结果为负数
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
						   //返回最大公约数
						gy1=simple(S2[i],S3[i]);
							
						S2[i]=S2[i]/gy1;
						S3[i]=S3[i]/gy1;
						
					   System.out.println(r1[i]+"/"+r2[i]+" - "+n3[i]+"/"+n4[i]+" =");
					}
					else if(s1[i].equals("*"))
					{
						S2[i]=r1[i]*n3[i];
					    S3[i]=r2[i]*n4[i];
						   //返回最大公约数
						gy1=simple(S2[i],S3[i]);
							
						S2[i]=S2[i]/gy1;
						S3[i]=S3[i]/gy1;
						
					   System.out.println(r1[i]+"/"+r2[i]+" x "+n3[i]+"/"+n4[i]+" =");
					}
					else if(s1[i].equals("/"))
					{
						S2[i]=r1[i]*n4[i];
					    S3[i]=r2[i]*n3[i];
						   //返回最大公约数
						gy1=simple(S2[i],S3[i]);
							
						S2[i]=S2[i]/gy1;
						S3[i]=S3[i]/gy1;
						
					   System.out.println(r1[i]+"/"+r2[i]+" ÷  "+n3[i]+"/"+n4[i]+" =");
					}
					//for
				}
				
				System.out.print("是否输出定制结果？（1.输出    其他： 不输出）");
				Scanner scan4=new Scanner(System.in);
				int judge2=scan4.nextInt();
				
				if(judge2==1)
				{
					for(int i=0;i<number;i++)
					{
						System.out.println("第"+(i+1)+"个算式的结果为："+S2[i]+"/"+S3[i]);
					}
				}
				//choose
			}
			else if(choose==3)
			{
				System.out.println("成功退出！");
				break;
			}
			else 
			{
				System.out.println("输入有误，请重新输入！");
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
