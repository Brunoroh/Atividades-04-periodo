package br.com.bruno.bll;

import java.util.List;

import br.com.bruno.dal.ImagemDAO;
import br.com.bruno.model.Imagem;

public class ImagemBs {

	ImagemDAO dao;

	public ImagemBs(ImagemDAO dao) {
		this.dao = dao;
	}

	public ImagemBs() {
		dao = new ImagemDAO();
	}

	public Imagem salvar(Imagem imagem) {
		if(imagem.getCodigo() == 0){
			dao.incluir(imagem);
		}else{
			dao.alterar(imagem);
		}
		
		return dao.consultarPorNome(imagem.getNome());
	}

	public Imagem consultar(int codigo) {
		return dao.consultar(codigo);
	}

	public List<Imagem> listar() {
		return dao.listarTodos();
	}
	
	
	
}
