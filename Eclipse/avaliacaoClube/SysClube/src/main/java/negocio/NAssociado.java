package negocio;

import entidade.EAssociado;
import persistencia.PAssociado;

public class NAssociado {
	
	
	PAssociado dao;
	NMensalidade nMensalidade;

	public NAssociado(PAssociado dao, NMensalidade nMensalidade) {
		this.dao = dao;
		this.nMensalidade = nMensalidade;
	}

	public EAssociado consultar(int codigo) {
		return dao.consultar(codigo);
	}

	public boolean autenticar(EAssociado eAssociado) {
		EAssociado registro = dao.consultarPorUsuario(eAssociado.getUsuario());
		if(registro != null){
			if(registro.getSenha() == eAssociado.getSenha()){
				return true;
			}
		}
		return false;
	}

}
