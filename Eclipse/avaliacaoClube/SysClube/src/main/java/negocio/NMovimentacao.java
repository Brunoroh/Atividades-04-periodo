package negocio;

import entidade.EMovimentacao;
import persistencia.PMovimentacao;

public class NMovimentacao {

	private PMovimentacao dao;

	public NMovimentacao() {
		dao  = new PMovimentacao();
	}
	
	public NMovimentacao(PMovimentacao dao){
		this.dao = dao;
	}

	public boolean registrarMovimentacao(EMovimentacao entidade) {
		if(entidade != null){
			if(entidade.getCodigo() == 0){
				return dao.incluir(entidade);
			}else{
				return dao.alterar(entidade);
			}
		}
		return false;
	}
	
	private boolean verificarMensalidade(){
		return true;
	}
	
	
	
	
}
