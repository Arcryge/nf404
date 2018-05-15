package com.qtu404.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileManager {
	// ��֤�ַ����Ƿ�Ϊ��ȷ·������������ʽ
	private static String matches = "[A-Za-z]:\\\\[^:?\"><*]*";
	// ͨ�� sPath.matches(matches) �����ķ���ֵ�ж��Ƿ���ȷ
	// sPath Ϊ·���ַ���
	boolean flag = false;
	File file;

	/**
	 * ����һ���ļ���
	 * 
	 * @author ����
	 * @param userID_int
	 *            �û�id
	 * @return String �ļ��������
	 */
	public static String createDir(String userID_int) {
		String destDirName = "/NF4Slides/" + userID_int;
		File dir = new File(destDirName);
		dir.setWritable(true, false);
		if (dir.exists()) {// �ж�Ŀ¼�Ƿ����
			return "����Ŀ¼ʧ�ܣ�Ŀ��Ŀ¼�Ѵ���";
		}
		if (!destDirName.endsWith(File.separator)) {// ��β�Ƿ���"/"����
			destDirName = destDirName + "/";
		}
		if (dir.mkdirs()) {// ����Ŀ��Ŀ¼
			return "����Ŀ¼�ɹ���" + destDirName;
		} else {
			return "����Ŀ¼ʧ�ܣ�" + destDirName;
		}
	}

	/**
	 * д���ļ�
	 * 
	 * @author ����
	 * @param data_String
	 *            ����
	 * @param url_String
	 *            url(userId/SlideId)
	 * @return String �ļ��������
	 */
	public static boolean writeInto(String data_String, String url_String) {
		try {
			FileWriter fw = new FileWriter("/NF4Slides/" + url_String + ".txt");
			// BufferedWriter bufw = new BufferedWriter(fw);

			File file = new File("/NF4Slides/" + url_String + ".txt");
			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));

			// ʹ�û������еķ���������д�뵽�������С�
			bufw.write(data_String);
			bufw.newLine();
			// ʹ�û������еķ�����������ˢ�µ�Ŀ�ĵ��ļ���ȥ��
			bufw.flush();
			// �رջ�����,ͬʱ�ر���fw������
			bufw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ������ӳ����
	 * 
	 * @author ����
	 * @param url_String
	 *            userId/SlideId
	 * @return String ��ӳ��ȫ��html����
	 */
	public static String readFromPlay(String url_String) {
		String result_String = "";
		try {
			// FileReader f1 = null;
			// BufferedReader br = null;
			// f1 = new FileReader("/NF4Slides/" +url_String + "_play.txt");
			// br = new BufferedReader(f1);

			File file = new File("/NF4Slides/" + url_String + "_play.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			String s;
			s = br.readLine();
			while (s != null) {
				result_String = result_String + s;
				s = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result_String;
	}

	/**
	 * �����༭����
	 * 
	 * @author ����
	 * @param url_String
	 *            userId/SlideId
	 * @return String �༭����������С�������룬�� <--nf4--> �ָ�ÿһ�Żõ�Ƭ
	 */
	public static String readFromSlide(String url_String) {
		String result_String = "";
		try {
			// FileReader f1 = null;
			// BufferedReader br = null;
			// f1 = new FileReader("/NF4Slides/" +url_String + ".txt");
			// BufferedReader br=new BufferedReader(f1);
			File file = new File("/NF4Slides/" + url_String + ".txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			String s;
			s = br.readLine();
			while (s != null) {
				result_String = result_String + s;
				s = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result_String;
	}
}
