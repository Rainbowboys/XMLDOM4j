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
		// 第一种方式：创建文档，并创建根元素
		// 创建文档:使用了一个Helper类
		Document document = DocumentHelper.createDocument();
		// 创建根节点
		Element root = DocumentHelper.createElement("person");
		// 给document设置跟节点
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
		// 创建xml文件写到文件中
		OutputFormat format = new OutputFormat(" ", true);
		// FileOutputStream fileOutputStream = new FileOutputStream(file);
		// XMLWriter writer = new XMLWriter(fileOutputStream, format);

		// 另一种输出方式，记得要调用flush()方法,否则输出的文件中显示空白
		XMLWriter writer = new XMLWriter(new FileWriter(file), format);
		writer.write(document);
		writer.flush();
		// close()方法也可以

	}
}
