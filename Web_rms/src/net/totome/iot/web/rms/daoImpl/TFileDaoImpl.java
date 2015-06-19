package net.totome.iot.web.rms.daoImpl;

import java.util.List;

import net.totome.iot.web.rms.dao.BaseDao;
import net.totome.iot.web.rms.dao.TFileDao;
import net.totome.iot.web.rms.model.TFile;
import net.totome.iot.web.rms.util.Page;


public class TFileDaoImpl extends BaseDao implements TFileDao {
	
	public void update(TFile file){
		super.update(file);
	}
	
	public void save(TFile file){
		super.Save(file);
	}


	public Integer getObject() {
		String hql = "Select Count(*) From TFile where type='app'";
		Long s=(Long) super.getCount(hql);
		return s.intValue();
	}

	public Page<TFile> FindList(TFile file,String paramrs, Integer pageIndex, Integer pageSize) {
		
		String hql="Select count(*) From TFile where type='"+paramrs+"'";
		String selectHql="From TFile where type='"+paramrs+"'";
		
		List<TFile>fileList=super.FindList(selectHql, pageIndex, pageSize);
		
		Long s=(Long)super.getCount(hql);
		int count=s.intValue();
		
		
		Page<TFile> page= new Page<TFile>(pageIndex, pageSize);
		page.setList(fileList);
		page.setCount(count);
		return page;
	}

	public List<TFile> getList(TFile file, int index) {
		String hql="From TFile where type='app'";
		List<TFile> objectList = super.getList(index, hql);
		return objectList;
	}

}
