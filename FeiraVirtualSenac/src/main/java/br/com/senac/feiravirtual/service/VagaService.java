package br.com.senac.feiravirtual.service;

import java.time.LocalDate;
import java.util.List;

import br.com.senac.feiravirtual.domain.Vaga;

public interface VagaService {

	void salvar(Vaga vaga);

	void editar(Vaga Vaga);

	void excluir(Long id);

	Vaga buscarPorId(Long id);

	List<Vaga> buscarTodos();

	List<Vaga> buscarPorDescricao(String descricao);

	List<Vaga> buscarPorCodigoSenac(String codigoSenac);

	List<Vaga> buscarInicioDaVaga(LocalDate inicio);
	
	List<Vaga> buscarFimDaVaga(LocalDate fim);
	
	List<Vaga> buscarPorCargo(String cargo);
	
}
