package br.com.caelum.ingresso.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {
	private List<Sessao> sessoesDaSala;

	public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}

	private boolean horarioIsConflitante(Sessao sessaoNova, Sessao sessaoExistente){
		LocalDate hoje = LocalDate.now();
		
		LocalDateTime inicioSessaoNova = sessaoNova.getHorario().atDate(hoje);
		LocalDateTime terminoSessaoNova = inicioSessaoNova.plus(sessaoNova.getFilme().getDuracao());
		
		LocalDateTime inicioSessaoExistente = sessaoNova.getHorario().atDate(hoje);
		LocalDateTime terminoSessaoExistente= inicioSessaoExistente.plus(sessaoNova.getFilme().getDuracao());
		
		boolean novaTerminaAntes = terminoSessaoNova.isBefore(inicioSessaoExistente);
		boolean novaComecaDepois =inicioSessaoNova.isAfter(terminoSessaoExistente);
		
		if (novaTerminaAntes || novaComecaDepois) {
			return false;
		}
		
		return true;
	}
	
	public boolean cabe(Sessao sessaoNova){
		return this.sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioIsConflitante(sessaoExistente, sessaoNova));
	}
	
}
