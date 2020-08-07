package br.com.soft.sieng.ex1;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.soft.sieng.ex1.relatorio.gerador.Gerador;
import br.com.soft.sieng.ex1.relatorio.gerador.GeradorObservacaoV2;

@SpringBootApplication
public class SiengApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiengApplication.class, args);
		
		Gerador geradorV2 =  new GeradorObservacaoV2();
		String retorno = geradorV2.geraObservacao( Arrays.asList(1, 2, 3, 4, 5, 60, 700));
		
		System.out.println(retorno);

	}

}
