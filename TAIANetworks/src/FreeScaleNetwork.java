import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FreeScaleNetwork {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o número de nós: ");
		int n = in.nextInt();
		getFreeScaleNetwork(n);
		

		
	}
	
	public static void getFreeScaleNetwork(int nodes){
		ArrayList<Integer> v = new ArrayList<Integer>();
		ArrayList<Integer> es = new ArrayList<Integer>();
		ArrayList<Integer> es1 = new ArrayList<Integer>();

		int[] degree = new int[nodes+1];
        Random random = new Random();
        
        for(int i = 1; i<= nodes; i++){
        	v.add(i);
        	degree[i] = 1;
        	
        	int r = random.nextInt(i);
        	int r1 = random.nextInt(i);
        	
        	int getDegreeNode = degree[r];
        	
        	if((random.nextDouble() * getDegreeNode ) > 0.6){
        		es.add(i);
        		es1.add(r);
        		degree [i] = degree[i] +1;
        		degree [r] = degree[r] +1;

        	}
        	
        	getDegreeNode = degree[r1];
        	if((random.nextDouble() * getDegreeNode ) > 0.6){
        		es.add(i);
        		es1.add(r1);
        		degree [i] = degree[i] +1;
        		degree [r1] = degree[r1] +1;
        	}
        	
        }
        
    	try{

			//Criação de um buffer para a escrita em uma stream
			BufferedWriter StrWNodes = new BufferedWriter(new FileWriter("C:\\arquivo\\NodesFS.csv"));

			//Escrita dos dados da tabela
			StrWNodes.write("id;label\n");
			
			for(int i = 1; i<= v.size(); i++){
				StrWNodes.write("\n" +i + ";" +i +"");
			}

			StrWNodes.close();
			}catch (FileNotFoundException ex)
			{
			ex.printStackTrace();
			}catch (IOException e)
			{
			e.printStackTrace();
		}
    	
    	
    	try{

			//Criação de um buffer para a escrita em uma stream
			BufferedWriter StrW = new BufferedWriter(new FileWriter("C:\\arquivo\\FreeScaleNetwork.csv"));

			//Escrita dos dados da tabela
			StrW.write("Source;Target;Type\n");
			
			for(int i = 0; i< es.size(); i++){
				StrW.write("\n"+ es.get(i)+";" + es1.get(i)+ ";undirected");
			}

			//Fechamos o buffer
			StrW.close();
			}catch (FileNotFoundException ex)
			{
			ex.printStackTrace();
			}catch (IOException e)
			{
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
