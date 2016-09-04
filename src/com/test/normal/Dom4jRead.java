package com.test.normal;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * dom4j���ѧϰ�� ��ȡ������xml
 * 
 * 
 */
public class Dom4jRead {

	public static void main(String[] args) {

		SAXReader reader = new SAXReader();
		// ��reader��ȡdocument
		try {
			Document document = reader.read(new File("D:\\test.xml"));
			// ��ȡroot�ڵ�
			Element root = document.getRootElement();
			System.out.println("���ڵ�����֣�" + root.getName());
			// ��ȡ������Ԫ��
			List<Element> list = root.elements();
			System.out.println("�ӽڵ�ĸ���" + list.size());
			// ָ���ӽڵ���������
			List<Element> list2 = root.elements("student");
			System.out.println("�ӽڵ�ĸ���" + list2.size());

			for (int i = 0; i < list.size(); i++) {
				Element element = list.get(i);
				for (int j = 0; j < element.nodeCount(); j++) {
					if (element.node(j) instanceof Element) {
						System.out.println(element.node(j).getName() + " " + element.node(j).getText());
					}

				}

				// int attributecout = element.attributeCount();
				// for (int j = 0; j < attributecout; j++) {
				// System.out.println(element.attribute(j).getName() +
				// element.attribute(j).getValue());
				// System.out.println(element.elementText("name"));
				// System.out.println(element.elementText("age"));
				// }
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

}
