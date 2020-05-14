package br.com.senac.feiravirtual.web.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.senac.feiravirtual.domain.UF;
import br.com.senac.feiravirtual.domain.Vaga;
import br.com.senac.feiravirtual.service.VagaService;

@Controller
@RequestMapping("/vagas")
public class VagaController {

	@Autowired
	private VagaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Vaga vaga) {
		return "/vaga/cadastro";
	}

	@GetMapping("/listar")
	public String listar(Vaga vaga, ModelMap model) {
		model.addAttribute("vagas", service.buscarTodos());
		return "/vaga/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Vaga vaga, RedirectAttributes attr) {
		service.salvar(vaga);
		attr.addFlashAttribute("success", "Vaga inserida com sucesso.");
		return "redirect:/vagas/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("vaga", service.buscarPorId(id));
		return "vaga/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Vaga vaga, RedirectAttributes attr) {
		service.editar(vaga);
		attr.addFlashAttribute("success", "Vaga editada com sucesso.");
		return "redirect:/vagas/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.excluir(id);
		attr.addFlashAttribute("success", "Vaga removida com sucesso.");
		return "redirect:/vagas/listar";
	}

	@GetMapping("/buscar/descricao")
	public String getPorDescricao(@RequestParam("descricao") String descricao, ModelMap model) {
		model.addAttribute("vagas", service.buscarPorDescricao(descricao));
		return "vaga/lista";
	}

	@GetMapping("/buscar/codigoSenac")
	public String getPorCodigoSenac(@RequestParam("codigoSenac") String codigoSenac, ModelMap model) {
		model.addAttribute("vaga", service.buscarPorCodigoSenac(codigoSenac));
		return "vaga/lista";
	}

	@GetMapping("/buscar/inicio")
	public String getInicioDaVaga(
			@RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
			ModelMap model) {
		model.addAttribute("vagas", service.buscarInicioDaVaga(inicio));
		return "vaga/lista";
	}
	
	@GetMapping("/buscar/fim")
	public String getFimDaVaga(
			@RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
			ModelMap model) {
		model.addAttribute("vagas", service.buscarFimDaVaga(fim));
		return "vaga/lista";
	}
	
	

	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}

}
