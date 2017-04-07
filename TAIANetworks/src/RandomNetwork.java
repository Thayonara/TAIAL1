import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RandomNetwork {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o número de nós: ");
		int n = in.nextInt();
		ArrayList v1 = getRandomNetwork(n);
		ArrayList v2 = getRandomNetwork(n);
		
		try{

			//Criação de um buffer para a escrita em uma stream
			BufferedWriter StrWNodes = new BufferedWriter(new FileWriter("C:\\arquivo\\Nodes.csv"));

			//Escrita dos dados da tabela
			StrWNodes.write("id;label\n");
			
			for(int i = 1; i<= n; i++){
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
			BufferedWriter StrW = new BufferedWriter(new FileWriter("C:\\arquivo\\randomNetwork.csv"));

			//Escrita dos dados da tabela
			StrW.write("Source;Target;Type\n");
			
			for(int i = 0; i< n; i++){
				StrW.write("\n"+ v1.get(i)+";" + v2.get(i)+ ";undirected");
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
	
	public static ArrayList getRandomNetwork(int nodes){
		
		ArrayList<Integer> v = new ArrayList<Integer>();
        Random random = new Random();
        
        for(int i = 0; i< nodes; i++){
        	v.add(random.nextInt(nodes));
        }
        
        return v;
		
	}
	

}
