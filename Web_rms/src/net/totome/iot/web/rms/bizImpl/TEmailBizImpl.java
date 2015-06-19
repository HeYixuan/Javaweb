package net.totome.iot.web.rms.bizImpl;

import net.totome.iot.web.rms.biz.TEmailBiz;
import net.totome.iot.web.rms.dao.TEmailDao;
import net.totome.iot.web.rms.model.TEmail;

public class TEmailBizImpl implements TEmailBiz {
	
	private TEmailDao emailDao;
	public TEmailDao getEmailDao() {
		return emailDao;
	}
	public void setEmailDao(TEmailDao emailDao) {
		this.emailDao = emailDao;
	}
	public void Save(TEmail entity) {
		emailDao.Save(entity);
	}

}
