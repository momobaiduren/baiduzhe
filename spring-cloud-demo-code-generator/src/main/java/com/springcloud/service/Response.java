package com.springcloud.service;

import com.springcloud.comm.Cfg;
import com.springcloud.utils.FileUtils;
import com.springcloud.utils.Utils;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Response {
	
	/**
	 * ����Response
	 */
	public static List<String> generateResponse(String tableName){
		List<String> retList = new ArrayList<String>();
		retList.add("package "+ Cfg.responsePackage+"."+Cfg.MODULE_EN_NAME+";");
		retList.add("\r");
		retList.add("import com.yh.csx.bsf.core.base.model.GeneralResponse;");
		retList.add("import io.swagger.annotations.ApiModel;");
		retList.add("import io.swagger.annotations.ApiModelProperty;");
		retList.add("import lombok.Data;");
		retList.add("\r");
		retList.add("/**" + Cfg.MODULE_CN_NAME + "DO");
		retList.add("  * @author " + Cfg.author);
		retList.add("  * @version " + Cfg.version);
		retList.add("  * @description ");
		retList.add("  * @date " + LocalDateTime.now());
		retList.add("  */");
		retList.add("\r");
		retList.add("@Data");
		retList.add("@ApiModel(value = \""+Cfg.MODULE_CN_NAME+"\")");
		retList.add("\r");
		retList.add("public class "+ Utils.getFirstUpperCase(Cfg.MODULE_EN_NAME)+"Response extends GeneralResponse {");
		List<Map<String, String>> list = Utils.getTableInfo(tableName);
		for (Map<String, String> map : list) {
			retList.add("	@ApiModelProperty(value = \""+map.get("columnComment")+"\")");
			retList.add("	private " + map.get("javaType") + " " + map.get("beanColumnName") + ";");
		}	
		retList.add("}");
		
		//�����ļ���
//		String filePath = Cfg.PROJECT_ROOT_PATH + "/csx-b2b-"+Cfg.PROJECT_NAME+"-service";
//		filePath += "/src/main/java/com/yh/csx/"+Cfg.PROJECT_NAME+"/service/response/";
		StringBuffer filePath = new StringBuffer(Cfg.PROJECT_ROOT_PATH).append("/")
			.append(Cfg.serviceProjectName.replace(".", "/")).append("/src/main/java/")
			.append(Cfg.responsePackage.replace(".", "/")).append("/").append(Cfg.MODULE_EN_NAME).append("/");

		File file = new File(filePath.toString());
		if(!file.exists()){
			file.mkdir();
		}
//		filePath += Cfg.MODULE_EN_NAME + "/";
//		file = new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
		FileUtils.writeFile(filePath + Utils.getFirstUpperCase(Cfg.MODULE_EN_NAME) +"Response.java", retList);
				
		for (String s : retList) {
			System.out.println(s);
		}
		return retList;
	}
	
}
