package com.test.normal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Dom4j {
	public static void main(String[] args) throws IOException {
		// ��һ�ַ�ʽ�������ĵ�����������Ԫ��
		// �����ĵ�:ʹ����һ��Helper��
		Document document = DocumentHelper.createDocument();
		// �������ڵ�
		Element root = DocumentHelper.createElement("person");
		// ��document���ø��ڵ�
		document.setRootElement(root);
		for (int i = 0; i < 10; i++) {
			Element ele = root.addElement("student");
			ele.addAttribute("id", i + "");
			Element name = ele.addElement("name");
			Element age = ele.addElement("age");
			name.setText("xiaozhang" + i);
			age.setText("2" + i);
		}

		File file = new File("D:\\test.xml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ����xml�ļ�д���ļ���
		OutputFormat format = new OutputFormat(" ", true);
		// FileOutputStream fileOutputStream = new FileOutputStream(file);
		// XMLWriter writer = new XMLWriter(fileOutputStream, format);

		// ��һ�������ʽ���ǵ�Ҫ����flush()����,����������ļ�����ʾ�հ�
		XMLWriter writer = new XMLWriter(new FileWriter(file), format);
		writer.write(document);
		writer.flush();
		// close()����Ҳ����

	}
}
