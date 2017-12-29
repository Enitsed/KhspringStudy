package part01;

import org.springframework.transaction.support.TransactionTemplate;

public class ServiceImp implements Service {
	private MemDAO dao;
	private TransactionTemplate transactionTemplate;

	public ServiceImp() {

	}

	public void setDao(MemDAO dao) {
		this.dao = dao;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public void insertProcess() {

	}

}
