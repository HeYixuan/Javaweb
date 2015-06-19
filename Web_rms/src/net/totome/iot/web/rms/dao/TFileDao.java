package net.totome.iot.web.rms.dao;

import java.util.List;

import net.totome.iot.web.rms.model.TFile;
import net.totome.iot.web.rms.util.Page;


public interface TFileDao {
	public void update(TFile file);
	
	public void save(TFile file);
	
	public List<TFile> getList(TFile file, int index);
	
	public Integer getObject();
	
	public Page<TFile> FindList(TFile file,String paramrs,Integer pageIndex, Integer pageSize);
}
