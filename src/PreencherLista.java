import entidades.Filme;
import entidades.Serie;
import manipulacao.ItemManipulacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PreencherLista {

    public static void preencherFilmes(ItemManipulacao itemManipulacao){

        String caminho= "C:\\Users\\Pichau\\Documents\\UNIPE-SPI\\SISTEMAS_PATA_INTERNET_P1\\Estágio\\GIT DBC\\asociedadedocodigo\\vemser-trabalho-final\\in.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(new File(caminho)))) {
            String linha = br.readLine();

            while (linha!=null){
                String linhaArquivo[] = linha.split(",");
                itemManipulacao.criarItemEntretenimento(new Filme(linhaArquivo[0],linhaArquivo[1],linhaArquivo[2],linhaArquivo[3],Integer.parseInt(linhaArquivo[4]),linhaArquivo[5],linhaArquivo[6]));
                linha = br.readLine();
            }

        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        itemManipulacao.listarItemEntretenimento();
    }

    public static void preencherSeries(ItemManipulacao itemManipulacao){

        String caminho= "C:\\Users\\Pichau\\Documents\\UNIPE-SPI\\SISTEMAS_PATA_INTERNET_P1\\Estágio\\GIT DBC\\asociedadedocodigo\\vemser-trabalho-final\\in.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(new File(caminho)))) {
            String linha = br.readLine();

            while (linha!=null){
                String linhaArquivo[] = linha.split(",");
                itemManipulacao.criarItemEntretenimento(new Serie(linhaArquivo[0],linhaArquivo[1],linhaArquivo[2],linhaArquivo[3],Integer.parseInt(linhaArquivo[4]),linhaArquivo[5],Integer.parseInt()linhaArquivo[6],linhaArquivo[7]));
                linha = br.readLine();
            }

        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        itemManipulacao.listarItemEntretenimento();
    }
}

//    public Serie(String nome, String genero, String sinopse, String anoLancamento, int classificacao, String plataforma,int temporadas, int episodios)
