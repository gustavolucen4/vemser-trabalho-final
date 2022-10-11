package metodosmain;

import entidades.Administrador;
import entidades.Cliente;
import entidades.Filme;
import entidades.Serie;
import manipulacao.ItemManipulacao;
import manipulacao.UsuarioManipulacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PreencherLista {

    public static void preencherFilmes(ItemManipulacao itemManipulacao){

        //Coloque o caminho do seu filmes.csv
        String caminho= "C:\\Users\\Pichau\\Documents\\UNIPE-SPI\\SISTEMAS_PATA_INTERNET_P1\\Estágio\\GIT DBC\\asociedadedocodigo\\vemser-trabalho-final\\filmes.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(new File(caminho)))) {
            String linha = br.readLine();

            while (linha!=null){
                String linhaArquivo[] = linha.split(",");
                itemManipulacao.criarItemEntretenimento(new Filme(linhaArquivo[0],linhaArquivo[1],linhaArquivo[2],(linhaArquivo[3]),Integer.parseInt(linhaArquivo[4]),linhaArquivo[5],linhaArquivo[6]));
                linha = br.readLine();
            }

        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void preencherSeries(ItemManipulacao itemManipulacao){

        //Coloque o caminho do seu series.csv
        String caminho= "C:\\Users\\Pichau\\Documents\\UNIPE-SPI\\SISTEMAS_PATA_INTERNET_P1\\Estágio\\GIT DBC\\asociedadedocodigo\\vemser-trabalho-final\\series.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(new File(caminho)))) {
            String linha = br.readLine();

            while (linha!=null){
                String linhaArquivo[] = linha.split(",");
                itemManipulacao.criarItemEntretenimento(new Serie(linhaArquivo[0],linhaArquivo[1],linhaArquivo[2],linhaArquivo[3],Integer.parseInt(linhaArquivo[4]),linhaArquivo[5],Integer.parseInt(linhaArquivo[6]),Integer.parseInt(linhaArquivo[7])));
                linha = br.readLine();
            }

        }catch (FileNotFoundException ex){
            System.err.println("errou aqui3");
            System.out.println(ex.getMessage());
        }catch (Exception ex){
            System.err.println("errou aqui4");
            System.out.println(ex.getMessage());
        }
    }

    public static void preencherAdmins(UsuarioManipulacao usuarioManipulacao){

        //Coloque o caminho do seu admin.csv
        String caminho= "C:\\Users\\Pichau\\Documents\\UNIPE-SPI\\SISTEMAS_PATA_INTERNET_P1\\Estágio\\GIT DBC\\asociedadedocodigo\\vemser-trabalho-final\\admin.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(new File(caminho)))) {
            String linha = br.readLine();

            while (linha!=null){
                String linhaArquivo[] = linha.split(",");
                usuarioManipulacao.criarUsuario(new Administrador(linhaArquivo[0],Integer.parseInt(linhaArquivo[1]),linhaArquivo[2],linhaArquivo[3]));
                linha = br.readLine();
            }

        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
   }

    public static void preencherClientes(UsuarioManipulacao usuarioManipulacao){

        //Coloque o caminho do seu cliente.csv
        String caminho= "C:\\Users\\Pichau\\Documents\\UNIPE-SPI\\SISTEMAS_PATA_INTERNET_P1\\Estágio\\GIT DBC\\asociedadedocodigo\\vemser-trabalho-final\\cliente.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(new File(caminho)))) {
            String linha = br.readLine();

            while (linha!=null){
                String linhaArquivo[] = linha.split(",");
                usuarioManipulacao.criarUsuario(new Cliente(linhaArquivo[0],Integer.parseInt(linhaArquivo[1]),linhaArquivo[2],linhaArquivo[3]));
                linha = br.readLine();
            }

        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

