package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class SemDesconto implements Descontos{
	
	public SemDesconto(){
		
	}
	
	@Override
	public	BigDecimal	aplicarDescontoSobre(BigDecimal	precoOriginal)	{
					return	precoOriginal;
	}

	@Override
	public String getDescricao() {
		return "Normal";
	}

}
