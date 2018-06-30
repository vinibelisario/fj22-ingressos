package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoForm {
	private Integer Id;
	@NotNull
	private Integer filmeId;
	@NotNull
	private Integer salaId;
	public Integer getSalaId() {
		return salaId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	@DateTimeFormat(pattern="HH:mm")
	@NotNull
	private	LocalTime horario;
	
	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao){
		Sala sala = salaDao.findOne(salaId);
		Filme filme = filmeDao.findOne(filmeId);
		Sessao sessao = new Sessao(this.horario, filme, sala);
		return sessao;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getFilmeId() {
		return filmeId;
	}

	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
}
