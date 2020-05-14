package br.com.senac.feiravirtual.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.senac.feiravirtual.domain.Vaga;

@Repository
public class VagaDaoImpl extends AbstractDao<Vaga, Long> implements VagaDao {

	@Override
	public List<Vaga> findByDescricao(String descricao) {
		return createQuery("select v from Vaga v where v.descricao like concat('%',?1,'%') ", descricao);
	}

	@Override
	public List<Vaga> findByCodigoSenac(String codigoSenac) {
		return createQuery("select v from Vaga v where v.codigoSenac like concat('%',?1,'%') ", codigoSenac);
	}

	@Override
	public List<Vaga> findByAtividadesPrincipais(String atividadesPrincipais) {
		return createQuery("select v from Vaga v where v.atividadesPrincipais like concat('%',?1,'%') ",
				atividadesPrincipais);
	}

	@Override
	public List<Vaga> findByInicioDaVaga(LocalDate inicio) {
		String jpql = new StringBuilder("select v from Vaga v ").append("where v.inicio = ?1 ").toString();
		return createQuery(jpql, inicio);
	}

	@Override
	public List<Vaga> findByFimDaVaga(LocalDate fim) {
		String jpql = new StringBuilder("select v from Vaga v ").append("where v.fim = ?1 ").toString();
		return createQuery(jpql, fim);
	}

	@Override
	public List<Vaga> findByCargo(String cargo) {
		return createQuery("select v from Vaga v where v.cargo like concat('%',?1,'%') ", cargo);
	}

	@Override
	public List<Vaga> findByQuantidade(Integer quantidade) {
		String jpql = new StringBuilder("select v from Vaga v ").append("where v.quantidade = ?1 ").toString();
		return createQuery(jpql, quantidade);
	}

}
