package com.springcloud.listener;

import com.springcloud.comm.Cfg;
import com.springcloud.dao.Mapper;
import com.springcloud.dao.Repository;
import com.springcloud.pojo.Pojo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.springframework.util.StringUtils;


public class GenerateServiceActionListener implements ActionListener{

	Cfg cfg = null;

	public GenerateServiceActionListener(Cfg cfg){
		this.cfg = cfg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Cfg.DB_URL = mainFrame.dbUrlText.getText();
//		Cfg.PROJECT_ROOT_PATH = mainFrame.projectRooPathText.getText();
//		Cfg.corePackage = mainFrame.projectNameText.getText();
//		Cfg.TABLE_NAME = mainFrame.tableNameText.getText();
//		Cfg.MODULE_EN_NAME = mainFrame.moduleEnNameText.getText();
//		Cfg.MODULE_CN_NAME = mainFrame.moduleCnNameText.getText();
//		Cfg.COLUMN_SELECT_OBJ = mainFrame.columnSelectObjText.getText();
//		System.out.println("���ݿ�URL��" + Cfg.DB_URL);
//		System.out.println("����·����" + Cfg.PROJECT_ROOT_PATH);
//		System.out.println("���������ƣ�" + Cfg.corePackage);
//		System.out.println("������" + Cfg.TABLE_NAME);
//		System.out.println("ģ��Ӣ�����ƣ�" + Cfg.MODULE_EN_NAME);
//		System.out.println("ģ���������ƣ�" + Cfg.MODULE_CN_NAME);
//		System.out.println("�в�ѯ����" + Cfg.COLUMN_SELECT_OBJ);
//
		if (!StringUtils.isEmpty(Cfg.tableNames)) {
			String[] tableNames = Cfg.tableNames.split(",");
			for (int i = 0; i < tableNames.length; i++) {
				//1������DO
				Pojo.generateDo(tableNames[i]);
				//2������mapper
				Mapper.generateMapper(tableNames[i]);
				//3������Repository��RepositoryImpl
				Repository.generateRepository(tableNames[i]);
				Repository.generateRepositoryImpl(tableNames[i]);
			}
		}

//		Date date = new Date();
//		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		mainFrame.logText.setText(fm.format(date) + "���������");
	}

}
