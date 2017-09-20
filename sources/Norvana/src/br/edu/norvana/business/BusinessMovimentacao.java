package br.edu.norvana.business;

import br.edu.norvana.Dao.FactoryDao;
import br.edu.norvana.Dao.InterfaceDao;
import br.edu.norvana.entity.Movimentacao;

public class BusinessMovimentacao {
	public void salvar (Movimentacao m) throws BusinessException{
		
		if (m.getJustificativa() == null || m.getJustificativa().equals("")){
			
			throw new BusinessException("Movimenatação inválida");
		}
		
		InterfaceDao<Movimentacao> movimentacaoDao = 
				FactoryDao.createMovimentacaoDao();
		movimentacaoDao.salvar(m);
		
	}
}
