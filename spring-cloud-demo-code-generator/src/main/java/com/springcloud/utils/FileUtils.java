package com.springcloud.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	
	/**
	 * ���ļ�
	 * @param filePath
	 * @return
	 */
	public static List<String> readFile(String filePath){
		List<String> list = new ArrayList<String>();
		BufferedReader br = null;
		try {
			//����BufferedReader����
			br = new BufferedReader(new FileReader(new File(filePath)));
			String line = null;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			//�ر�BufferedReader
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	/**
	 * д�ļ�
	 * @param filePath
	 * @param list
	 */
	public static void writeFile(String filePath, List<String> list){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf-8")); 
			for (String string : list) {
				bw.write(string);
				bw.write("\n");
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//�ر�BufferedWriter
			if (bw != null) {
				try {
					bw.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {

	}
}
