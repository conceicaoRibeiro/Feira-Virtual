package br.com.senac.feiravirtual.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.feiravirtual.dao.VagaDao;
import br.com.senac.feiravirtual.domain.Vaga;

@Service
@Transactional(readOnly = true)
public class VagaServiceDaoImpl implements VagaService {
	@Autowired
	private VagaDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Vaga vaga) {
		dao.save(vaga);
		
	}
	@Transactional(readOnly = false)
	@Override
	public void editar(Vaga vaga) {
		dao.update(vaga);
		
	}
	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Vaga buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Vaga> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Vaga> buscarPorDescricao(String descricao) {
		return dao.findByDescricao(descricao);
	}

	@Override
	public List<Vaga> buscarPorCodigoSenac(String codigoSenac) {
		return dao.findByCodigoSenac(codigoSenac);
	}

	@Override
	public List<Vaga> buscarInicioDaVaga(LocalDate inicio) {
		return dao.findByInicioDaVaga(inicio);
	}

	@Override
	public List<Vaga> buscarFimDaVaga(LocalDate fim) {
		return dao.findByFimDaVaga(fim);
	}

	@Override
	public List<Vaga> buscarPorCargo(String cargo) {
		return dao.findByCargo(cargo);
	}



}
