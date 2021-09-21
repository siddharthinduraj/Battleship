import java.io.*;
import java.util.Random;
public class practice
{
	public static int board[][]=new int[10][10];
	public static String boarddisplay[][]=new String[10][10];
	public static int points=0;
	public static int flag=0;
	public static boolean ship1=true;
	public static boolean ship2=true;
	public static boolean ship3=true;
	public static boolean ship4=true;
	public static boolean ship5=true;
	public static int ship1check=0;
	public static int ship2check=0;
	public static int ship3check=0;
	public static int ship4check=0;
	public static int ship5check=0;
	public static void main(String[]args)throws IOException//main method
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char choice='Y';
		while(choice=='Y' || choice=='y')
		{
			//calling placement methods
			Ship1();
			Ship2();
			Ship3();
			Ship4();
			Ship5();
			MonsterPlacement();
			while(ship1==true || ship2==true || ship3==true || ship4==true || ship5==true)//checks to see if all ships have been sunk
			{
				DisplayBoard();
				Shoot();
				ShipCheck();
			}
			System.out.println("You sunk all my ships");
			System.out.println("Do you want to play again?(Y/N)");
			choice=(char)br.read();
			if(choice=='y'||choice=='Y')//provides a choice to restart the game when all ships have sunk
			{
				System.out.println("Restarting game");
				Reset();
				points=0;
				ship1=true;
				ship2=true;
				ship3=true;
				ship4=true;
				ship5=true;
			}
			else if(choice=='N' || choice=='n')
			{
				System.out.println("Game Over");
				break;
			}
			else
			{
				System.out.println("Wrong input entered, game will continue");
				Reset();
				points=0;
				ship1=true;
				ship2=true;
				ship3=true;
				ship4=true;
				ship5=true;
			}
		}
	}
	public static void Reset()
	{
		//resets the board
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				board[i][j]=0;
				boarddisplay[i][j]="";
			}
		}
	}
	public static void DisplayBoard()
	{
		//displays the board and all the required prompts and values
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(board[i][j]==1)
					boarddisplay[i][j]="H";
				else if(board[i][j]==-1)
					boarddisplay[i][j]="M";
				else if(board[i][j]==5)
					boarddisplay[i][j]="K";
				else if(board[i][j]==6)
					boarddisplay[i][j]="C";
				else
					boarddisplay[i][j]="-";
				System.out.print(boarddisplay[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Number of times a place has been reshot="+flag);
		System.out.println("Points="+points);
		System.out.println();
		System.out.println("Ships status are: -");
		if (ship1==false)
		{
			System.out.println("Aircraft Carrier - sunk");
			points=points+(5*2);
		}
		else
			System.out.println("Aircraft Carrier - unsunk");
		if(ship2==false)
		{
			System.out.println("Battleship - sunk");
			points=points+(4*2);
		}
		else
			System.out.println("Battleship - unsunk");
		if(ship3==false)
		{
			System.out.println("Submarine - sunk");
			points=points+(3*2);
		}
		else
			System.out.println("Submarine - unsunk");
		if(ship4==false)
		{
			System.out.println("Destroyer - sunk");
			points=points+(3*2);
		}
		else
			System.out.println("Destroyer - unsunk");
		if(ship5==false)
		{
			System.out.println("Patrol Boat - sunk");
			points=points+(2*2);
		}
		else
			System.out.println("Patrol Boat - unsunk");
			
	}
	public static void Ship1()//places aircraft carrier
	{
		Random rand = new Random();
		int size=5;
		while (size==5)
		{
			int x = rand.nextInt(10);
			int y = rand.nextInt(10);
			if((x>=0)&&(x+size<10)&&(board[x][x+size]!=2))
			{
				for(int i=0;i<size;i++)
				{
					board[x][x+i]=15;
				}
				size--;
			}
			else if((y>0)&&(y+size<10)&&(board[y+size][y]!=2))
			{
				for(int i=0;i<size;i++)
				{
					board[y+i][y]=15;
				}
				size--;
			}
		}
	}
	public static void Ship2()//places battleship
	{
		Random rand = new Random();
		int size=4;
		while (size==4)
		{
			int x = rand.nextInt(10);
			int y = rand.nextInt(10);
			if((x>=0)&&(x+size<10)&&(board[x][x+size]!=2)&&(board[x][x+size]!=15))
			{
				for(int i=0;i<size;i++)
				{
					if((board[x][x+i]==2)||(board[x][x+size]==15));
					continue;
				}
				for(int i=0;i<size;i++)
				{
					board[x][x+i]=14;
				}
				size--;
			}
			else if((y>0)&&(y+size<10)&&(board[y+size][y]!=2)&&(board[y+size][y]!=15))
			{
				for(int i=0;i<size;i++)
				{
					if((board[y+i][y]==2)||(board[y+size][y]==15));
					continue;
				}
				for(int i=0;i<size;i++)
				{
					board[y+i][y]=14;
				}
				size--;
			}
		}
	}
	public static void Ship3()//places destroyer
	{
		Random rand = new Random();
		int size=3;
		while (size==3)
		{
			int x = rand.nextInt(10);
			int y = rand.nextInt(10);
			if((x>=0)&&(x+size<10)&&(board[x][x+size]!=2)&&(board[x][x+size]!=15)&&(board[x][x+size]!=14))
			{
				for(int i=0;i<size;i++)
				{
					if((board[x][x+i]==2)||(board[x][x+size]==15)||(board[x][x+size]!=14));
					continue;
				}
				for(int i=0;i<size;i++)
				{
					board[x][x+i]=13;
				}
				size--;
			}
			else if((y>0)&&(y+size<10)&&(board[y+size][y]!=2)&&(board[y+size][y]!=15)&&(board[y+size][y]!=14))
			{
				for(int i=0;i<size;i++)
				{
					if((board[y+i][y]==2)||(board[y+size][y]==15)||(board[y+size][y]==14));
					continue;
				}
				for(int i=0;i<size;i++)
				{
					board[y+i][y]=13;
				}
				size--;
			}
		}
	}
	public static void Ship4()//places submarine
	{
		Random rand = new Random();
		int size=3;
		while (size==3)
		{
			int x = rand.nextInt(10);
			int y = rand.nextInt(10);
			if((x>=0)&&(x+size<10)&&(board[x][x+size]!=2)&&(board[x][x+size]!=15)&&(board[x][x+size]!=14)&&(board[x][x+size]!=13))
			{
				for(int i=0;i<size;i++)
				{
					if((board[x][x+i]==2)||(board[x][x+size]==15)||(board[x][x+size]!=14)||(board[x][x+size]!=13));
					continue;
				}
				for(int i=0;i<size;i++)
				{
					board[x][x+i]=23;
				}
				size--;
			}
			else if((y>0)&&(y+size<10)&&(board[y+size][y]!=2)&&(board[y+size][y]!=15)&&(board[y+size][y]!=14)&&(board[y+size][y]!=13))
			{
				for(int i=0;i<size;i++)
				{
					if((board[y+i][y]==2)||(board[y+size][y]==15)||(board[y+size][y]==14)||(board[y+size][y]==14)||(board[y+size][y]==13));
					continue;
				}
				for(int i=0;i<size;i++)
				{
					board[y+i][y]=23;
				}
				size--;
			}
		}
	}
	public static void Ship5()//places patrol boat
	{
		Random rand = new Random();
		int size=2;
		while (size==2)
		{
			int x = rand.nextInt(10);
			int y = rand.nextInt(10);
			if((x>=0)&&(x+size<10)&&(board[x][x+size]!=2)&&(board[x][x+size]!=15)&&(board[x][x+size]!=14)&&(board[x][x+size]!=13)&&(board[x][x+size]!=23))
			{
				for(int i=0;i<size;i++)
				{
					if((board[x][x+i]==2)||(board[x][x+size]==15)||(board[x][x+size]!=14)||(board[x][x+size]!=13)||(board[x][x+size]!=23));
					continue;
				}
				for(int i=0;i<size;i++)
				{
					board[x][x+i]=12;
				}
				size--;
			}
			else if((y>0)&&(y+size<10)&&(board[y+size][y]!=2)&&(board[y+size][y]!=15)&&(board[y+size][y]!=14)&&(board[y+size][y]!=13)&&(board[y+size][y]!=23))
			{
				for(int i=0;i<size;i++)
				{
					if((board[y+i][y]==2)||(board[y+size][y]==15)||(board[y+size][y]==14)||(board[y+size][y]==14)||(board[y+size][y]==13)||(board[y+size][y]==23));
					continue;
				}
				for(int i=0;i<size;i++)
				{
					board[y+i][y]=12;
				}
				size--;
			}
		}
	}
	public static void Shoot()throws IOException//allows the user to "shoot"
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the coordinates for a shot between 0 and 9");
		System.out.println("Enter X coordinate");
		int rowshot=Integer.parseInt(br.readLine());
		while(rowshot>=10 || rowshot<0)
		{
			System.out.println("Value entered is out of bounds, please try again");
			rowshot=Integer.parseInt(br.readLine());
		}
		System.out.println("Enter Y coordinate");
		int columnshot=Integer.parseInt(br.readLine());
		while(columnshot>=10 || columnshot<0)
		{
			System.out.println("Value entered is out of bounds, please try again");
			columnshot=Integer.parseInt(br.readLine());
		}
		if(board[rowshot][columnshot]==0)
		{
			System.out.println("You missed!");
			board[rowshot][columnshot]=-1;
			points--;
		}
		else if(board[rowshot][columnshot]==-1||board[rowshot][columnshot]==1)
		{
			System.out.println("You have targeted a spot that has already been shot at XD");
			points--;
			flag++;
		}
		else if(board[rowshot][columnshot]==15 || board[rowshot][columnshot]==14 || board[rowshot][columnshot]==13 || board[rowshot][columnshot]==23 || board[rowshot][columnshot]==12 )
		{
			System.out.println("My ship was hit!");
			board[rowshot][columnshot]=1;
			points++;
		}
		else if(board[rowshot][columnshot]==3)
		{
			System.out.println("Kraken has been awakened");//subtracts all the points if kraken is hit
			board[rowshot][columnshot]=5;
			points=0;
		}
		else if(board[rowshot][columnshot]==4)
		{
			System.out.println("Cetus has been awakened");
			board[rowshot][columnshot]=6;
			Cetus();
		}
	}
	public static void ShipCheck()//checks whether ships have been sunk or not
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(board[i][j]==15)
				{
					ship1check++;
				}
				else if(board[i][j]==14)
				{
					ship2check++;
				}
				else if(board[i][j]==13)
				{
					ship3check++;
				}
				else if(board[i][j]==23)
				{
					ship4check++;
				}
				else if(board[i][j]==12)
				{
					ship5check++;
				}
		    }
		}
		if (ship1check==0)
			ship1=false;
		if(ship2check==0)
			ship2=false;
		if(ship3check==0)
			ship3=false;
		if(ship4check==0)
			ship4=false;
		if(ship5check==0)
			ship5=false;
	}
	public static void MonsterPlacement()throws IOException//places the two monsters
	{
		int krakenawaken=0;
		int cetusawaken=0;
		Random rand = new Random();
		int krakenrow = rand.nextInt(10);
		int krakencolumn = rand.nextInt(10);
		while(krakenawaken==0)
		{
			if(board[krakenrow][krakencolumn]!=15 || board[krakenrow][krakencolumn]!=14 || board[krakenrow][krakencolumn]!=13 || board[krakenrow][krakencolumn]!=23 ||board[krakenrow][krakencolumn]!=12)
			{
				board[krakenrow][krakencolumn]=3;
				krakenawaken++;
			}
			else
				continue;
		}
		int cetusrow = rand.nextInt(10);
		int cetuscolumn = rand.nextInt(10);
		while(cetusawaken==0)
		{
			if(board[cetusrow][cetuscolumn]!=15 || board[cetusrow][cetuscolumn]!=14 || board[cetusrow][cetuscolumn]!=13 || board[cetusrow][cetuscolumn]!=23 || board[cetusrow][cetuscolumn]!=12 || board[cetusrow][cetuscolumn]!=3)
			{
				board[cetusrow][cetuscolumn]=4;
				cetusawaken++;
			}
			else
				continue;
		}
	}
	public static void Cetus()//executes the movement of ships if cetus is awakened
	{
		Reset();
		if (ship1==true)
		{
			Random rand = new Random();
			int size=5;
			while (size==5)
			{
				int x = rand.nextInt(10);
				int y = rand.nextInt(10);
				if((x>=0)&&(x+size<10)&&(board[x][x+size]!=2))
				{
					for(int i=0;i<ship1check;i++)
					{
						board[x][x+i]=15;
					}
					size--;
				}
				else if((y>0)&&(y+size<10)&&(board[y+size][y]!=2))
				{
					for(int i=0;i<ship1check;i++)
					{
						board[y+i][y]=15;
					}
					size--;
				}
			}
		}
		if(ship2==true)
		{
			Random rand = new Random();
			int size=4;
			while (size==4)
			{
				int x = rand.nextInt(10);
				int y = rand.nextInt(10);
				if((x>=0)&&(x+size<10)&&(board[x][x+size]!=2)&&(board[x][x+size]!=15))
				{
					for(int i=0;i<size;i++)
					{
						if((board[x][x+i]==2)||(board[x][x+size]==15));
						continue;
					}
					for(int i=0;i<ship2check;i++)
					{
						board[x][x+i]=14;
					}
					size--;
				}
				else if((y>0)&&(y+size<10)&&(board[y+size][y]!=2)&&(board[y+size][y]!=15))
				{
					for(int i=0;i<size;i++)
					{
						if((board[y+i][y]==2)||(board[y+size][y]==15));
						continue;
					}
					for(int i=0;i<ship2check;i++)
					{
						board[y+i][y]=14;
					}
					size--;
				}
			}
		}
		if(ship3==true)
		{
			Random rand = new Random();
			int size=3;
			while (size==3)
			{
				int x = rand.nextInt(10);
				int y = rand.nextInt(10);
				if((x>=0)&&(x+size<10)&&(board[x][x+size]!=2)&&(board[x][x+size]!=15)&&(board[x][x+size]!=14))
				{
					for(int i=0;i<size;i++)
					{
						if((board[x][x+i]==2)||(board[x][x+size]==15)||(board[x][x+size]!=14));
						continue;
					}
					for(int i=0;i<ship3check;i++)
					{
						board[x][x+i]=13;
					}
					size--;
				}
				else if((y>0)&&(y+size<10)&&(board[y+size][y]!=2)&&(board[y+size][y]!=15)&&(board[y+size][y]!=14))
				{
					for(int i=0;i<size;i++)
					{
						if((board[y+i][y]==2)||(board[y+size][y]==15)||(board[y+size][y]==14));
						continue;
					}
					for(int i=0;i<ship3check;i++)
					{
						board[y+i][y]=13;
					}
					size--;
				}
			}
		}
		if(ship4==true)
		{
			Random rand = new Random();
			int size=3;
			while (size==3)
			{
				int x = rand.nextInt(10);
				int y = rand.nextInt(10);
				if((x>=0)&&(x+size<10)&&(board[x][x+size]!=2)&&(board[x][x+size]!=15)&&(board[x][x+size]!=14)&&(board[x][x+size]!=13))
				{
					for(int i=0;i<size;i++)
					{
						if((board[x][x+i]==2)||(board[x][x+size]==15)||(board[x][x+size]!=14)||(board[x][x+size]!=13));
						continue;
					}
					for(int i=0;i<ship4check;i++)
					{
						board[x][x+i]=23;
					}
					size--;
				}
				else if((y>0)&&(y+size<10)&&(board[y+size][y]!=2)&&(board[y+size][y]!=15)&&(board[y+size][y]!=14)&&(board[y+size][y]!=13))
				{
					for(int i=0;i<size;i++)
					{
						if((board[y+i][y]==2)||(board[y+size][y]==15)||(board[y+size][y]==14)||(board[y+size][y]==14)||(board[y+size][y]==13));
						continue;
					}
					for(int i=0;i<ship4check;i++)
					{
						board[y+i][y]=23;
					}
					size--;
				}
			}
		}
		if(ship5==true)
		{
			Random rand = new Random();
			int size=2;
			while (size==2)
			{
				int x = rand.nextInt(10);
				int y = rand.nextInt(10);
				if((x>=0)&&(x+size<10)&&(board[x][x+size]!=2)&&(board[x][x+size]!=15)&&(board[x][x+size]!=14)&&(board[x][x+size]!=13)&&(board[x][x+size]!=23))
				{
					for(int i=0;i<size;i++)
					{
						if((board[x][x+i]==2)||(board[x][x+size]==15)||(board[x][x+size]!=14)||(board[x][x+size]!=13)||(board[x][x+size]!=23));
						continue;
					}
					for(int i=0;i<ship5check;i++)
					{
						board[x][x+i]=12;
					}
					size--;
				}
				else if((y>0)&&(y+size<10)&&(board[y+size][y]!=2)&&(board[y+size][y]!=15)&&(board[y+size][y]!=14)&&(board[y+size][y]!=13)&&(board[y+size][y]!=23))
				{
					for(int i=0;i<size;i++)
					{
						if((board[y+i][y]==2)||(board[y+size][y]==15)||(board[y+size][y]==14)||(board[y+size][y]==14)||(board[y+size][y]==13)||(board[y+size][y]==23));
						continue;
					}
					for(int i=0;i<ship5check;i++)
					{
						board[y+i][y]=12;
					}
					size--;
				}
			}
		}
	}
}