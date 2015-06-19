package net.totome.iot.web.rms.biz;

import java.util.List;

import net.totome.iot.web.rms.model.TFile;
import net.totome.iot.web.rms.util.Page;


public interface TFileBiz {
	
	public void update(TFile file);
	
	public void save(TFile file);
	
	public Integer getObject();
	
	public List<TFile> getList(TFile file, int index);
	
	public Page<TFile> FindList(TFile file,String paramrs, Integer pageIndex, Integer pageSize);
}
