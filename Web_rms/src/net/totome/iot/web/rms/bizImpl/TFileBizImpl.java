package net.totome.iot.web.rms.bizImpl;

import java.util.List;

import net.totome.iot.web.rms.biz.TFileBiz;
import net.totome.iot.web.rms.dao.TFileDao;
import net.totome.iot.web.rms.model.TFile;
import net.totome.iot.web.rms.util.Page;


public class TFileBizImpl implements TFileBiz {
	private TFileDao tfdao;

	public TFileDao getTfdao() {
		return tfdao;
	}

	public void setTfdao(TFileDao tfdao) {
		this.tfdao = tfdao;
	}

	public void update(TFile file) {
		tfdao.update(file);
	}

	public void save(TFile file) {
		tfdao.save(file);
	}


	public Integer getObject() {
		return tfdao.getObject();
	}


	public List<TFile> getList(TFile file, int index) {
		return tfdao.getList(file, index);
	}

	public Page<TFile> FindList(TFile file, String paramrs, Integer pageIndex,
			Integer pageSize) {
		return tfdao.FindList(file, paramrs, pageIndex, pageSize);
	}

}
