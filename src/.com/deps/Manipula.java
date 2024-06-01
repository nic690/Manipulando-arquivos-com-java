package com.deps;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

public class Manipula   {
    public Files fl;
    private Path CaminhoDir;
    public File flArquivo;


    public Path getCaminhoDir() {
        return CaminhoDir;
    }


    public void setCaminhoDir(Path caminhoDir) {
        CaminhoDir = caminhoDir;
    }


    public void criarDiretorio(String NomeDoDiretorio) throws IOException{
    try {
        Path dir= Paths.get(NomeDoDiretorio);
    Path nwDir= Files.createDirectory(dir);
         
    System.out.println("Diretótio criado com sucesso: " + nwDir );
    setCaminhoDir(nwDir);
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println("Esse diretório já exite");
        this.CaminhoDir=Paths.get(NomeDoDiretorio);
    }    
    
    }

    public String ReturnDir() throws IOException  {
        return this.CaminhoDir.toString();

    }
    public void CriarArquivo(String NomeDoArquivo)throws IOException{
        String PathName= ReturnDir();
        PathName= PathName + "/" + NomeDoArquivo;
        System.out.println(PathName);
        try {
        File arquivo= new File(PathName);    
        boolean criado=arquivo.createNewFile();
        
        if(criado==true){
            System.out.println("Arquivo criado com sucesso");

        }else{
            System.out.println("Arquivo já existente.");
        }
        flArquivo=arquivo;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Não foi possível criar esse arquivo.");
            
        }
        


    }
    public void DeletarArquivo() throws IOException{
         try {
            flArquivo.delete();
         } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Não foi possível deletar o arquivo.");
         }
    }
    public void EscreverArquivo(String Texto) throws IOException{
        try {
        FileWriter escrevente=new FileWriter(flArquivo);
        escrevente.write(Texto);
        System.out.println("Arquivo editado com sucesso");
        escrevente.close(); 
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Não foi possível escrever");
            System.out.println(e.toString());
        }
        
    }
    public void LerArquivo() throws IOException{
        BufferedReader Bf= new BufferedReader(new FileReader(flArquivo));
        try {
        Stream<String> linhas=Bf.lines();
        linhas.forEach(System.out::println);
        linhas.close();
        Bf.close();  
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Não foi possível ler o arquivo");
        }
           
    }
}


