package br.com.senac.feiravirtual.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.senac.feiravirtual.domain.Vaga;

public interface VagaDao {

	void save(Vaga vaga);

	void update(Vaga vaga);

	void delete(Long id);

	Vaga findById(Long id);

	List<Vaga> findAll();

	List<Vaga> findByDescricao(String descricao);

	List<Vaga> findByCodigoSenac(String codigoSenac);

	List<Vaga> findByAtividadesPrincipais(String atividadesPrincipais);

	List<Vaga> findByInicioDaVaga(LocalDate inicio);

	List<Vaga> findByFimDaVaga(LocalDate fim);
	
	List<Vaga>findByCargo(String cargo);
	
	List<Vaga>findByQuantidade(Integer quantidade);



}
