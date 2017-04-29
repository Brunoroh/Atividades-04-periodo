package br.com.bruno.bll;

import java.util.List;

import br.com.bruno.dal.PropostaDAO;
import br.com.bruno.model.Imagem;
import br.com.bruno.model.Proposta;

public class PropostaBs {

	PropostaDAO dao;
	ImagemBs imgBs;
	
	
	public PropostaBs(PropostaDAO dao, ImagemBs imgBs) {
		this.dao = dao;
		this.imgBs = imgBs;
	}

	public PropostaBs() {
		dao = new PropostaDAO();
		imgBs = new ImagemBs();
	}

	public Proposta salvar(Proposta proposta)throws Exception {
		if(proposta != null){
			if(validarProposta(proposta)){
				Imagem imagem = imgBs.salvar(proposta.getImagem());
				proposta.setImagem(imagem);
				if(proposta.getCodigo() == 0){
					dao.incluir(proposta);
				}else{
					dao.alterar(proposta);
				}
			}
		}
		return dao.consultarPorResponsavelEDescricao(proposta);
	}

	private boolean validarProposta(Proposta proposta)throws Exception {
		
		validarDescricao(proposta.getDescricao());
		validarNome(proposta.getNome());
		return true;
	}

	private void validarNome(String nome) throws Exception {
		if(nome == null || "".equals(nome)){
			throw new Exception("O Nome está vazio");
		}
	}

	private void validarDescricao(String descricao) throws Exception {
		if(descricao == null || "".equals(descricao)){
			throw new Exception("A Descrição está vazia");
		}
	}

	public Proposta consultar(int codigo) {
		return dao.consultar(codigo);
	}

	public List<Proposta> listar() {
		return dao.listarTodos();
	}

	public void remover(int codigo) {
		dao.remover(codigo);
		
	}
	
	
	
}
