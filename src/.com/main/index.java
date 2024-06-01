package com.main;

import com.deps.Manipula;

import java.io.IOException;

public class index {
public static void main(String[] args) throws IOException {
  
  Manipula Mp=new Manipula();
  Mp.criarDiretorio("Nicolas/ola/teste");
  Mp.CriarArquivo("Batman.txt");
  
  Mp.CriarArquivo("jw.txt");
  Mp.EscreverArquivo("Ola Mundo aqui");
 
  Mp.LerArquivo();
  //Mp.DeletarArquivo();
}
}
    