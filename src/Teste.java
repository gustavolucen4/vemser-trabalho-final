import entidades.Filme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Teste  {
    public static void main (String [] args){
        String caminho= "C:\\Users\\Gaby\\Desktop\\GIT\\git-teste\\vemser-trabalho-final\\in.csv";
        List<Filme>filmes = new ArrayList();


        try (BufferedReader br = new BufferedReader(new FileReader(new File(caminho)))) {
            String linha = br.readLine();

            while (linha!=null){
                String linhaArquivo[] = linha.split(",");
                filmes.add(new Filme(linhaArquivo[0],linhaArquivo[1],linhaArquivo[2]));
                linha = br.readLine();
            }

        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());

        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }

        System.out.println(filmes);
        }
    }

