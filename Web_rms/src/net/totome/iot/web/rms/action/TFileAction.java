package net.totome.iot.web.rms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import net.totome.iot.web.rms.biz.TFileBiz;
import net.totome.iot.web.rms.model.TFile;
import net.totome.iot.web.rms.util.Page;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class TFileAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TFile tf;
	private TFileBiz tfbiz;
	private String Format;
	private String result;
	private HttpServletRequest request;
	private Page<TFile>pageList;
	private int pageSize;
	private int pageCount;
	private int count;
	private int pageIndex=1;
	private File file; // 上传的文件
	private String fileName;
	private String fileFileName; // 文件名称
	private String fileContentType; // 文件类型
	private InputStream inputStream;

	
	public InputStream getInputStream() {
		return inputStream;
	}




	/**
	 * 文件上传
	 * 
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public String uploadFile() throws Exception{
		//ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/Files");
		System.out.println(realpath);
		String newFileName = null;
		File dir = new File(realpath);
		file.length();
		if (file != null) {
			if (!dir.exists()) {
				dir.mkdirs();
			}
			/*int pos = fileFileName.lastIndexOf(".");
			String uuid = UUID.randomUUID().toString();
			fileFileName+=uuid;
			fileContentType = fileFileName.substring(pos +1);
			System.out.println(fileContentType);
			newFileName=uuid+"."+fileContentType;*/
			InputStream is = new FileInputStream(file);
			OutputStream os = new FileOutputStream(new File(dir, fileFileName));
			byte[] buf = new byte[1024];
			int len = -1;
			while ((len = is.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
			is.close();
			os.close();
		}
		
		Long length=file.length();
		
		//String path=realpath+"\\"+newFileName;
		TFile t=new TFile();
		t.setFileName(fileName);
		Integer len=length.intValue();
		t.setSize(len);
		t.setType(Format);
		t.setUrl(fileFileName);
		t.setDescription(description);
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String NewDate=df.format(date);
		t.setCdate(NewDate);
		tfbiz.save(t);
		
		try {
			//将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
	        Map<String,Object> map = new HashMap<String,Object>();
	        map.put("message", "上传成功");
	        JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
	        result = json.toString();//给result赋值，传递给页面
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return SUCCESS;

	}
	
	
	//文件下载
	public String downFile() throws FileNotFoundException{
		ServletContext servletContext=ServletActionContext.getServletContext();
		String realpath = servletContext.getRealPath(
				"/Files/"+fileName);
		inputStream = new FileInputStream(realpath);
		return SUCCESS;
	
		
	}
	
	public String FindList() {
		if (Format.equals("app")) {
			Page<TFile> pageList = tfbiz.FindList(tf, Format, pageIndex,
					5);

			try {

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("pageList", pageList);
				JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
				result = json.toString();//给result赋值，传递给页面

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return SUCCESS;

		}

		if(Format.equals("firmware")) {
			Page<TFile> pageList = tfbiz.FindList(tf, Format, pageIndex,
					5);
			try {

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("pageList", pageList);
				JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
				result = json.toString();//给result赋值，传递给页面

			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
		}
		return ERROR;

	}
	
	

	
	/**
	 * getter setter
	 * @param request
	 */
	
	public Page<TFile> getPageList() {
		return pageList;
	}

	public void setPageList(Page<TFile> pageList) {
		this.pageList = pageList;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private String description;


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public TFile getTf() {
		return tf;
	}

	public void setTf(TFile tf) {
		this.tf = tf;
	}

	public TFileBiz getTfbiz() {
		return tfbiz;
	}

	public void setTfbiz(TFileBiz tfbiz) {
		this.tfbiz = tfbiz;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	


}
