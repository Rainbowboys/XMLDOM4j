package com.test.normal;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * dom4j框架学习： 读取并解析xml
 * 
 * 
 */
public class Dom4jRead {

	public static void main(String[] args) {

		SAXReader reader = new SAXReader();
		// 用reader获取document
		try {
			Document document = reader.read(new File("D:\\test.xml"));
			// 获取root节点
			Element root = document.getRootElement();
			System.out.println("根节点的名字：" + root.getName());
			// 获取所有子元素
			List<Element> list = root.elements();
			System.out.println("子节点的个数" + list.size());
			// 指定子节点的名字输出
			List<Element> list2 = root.elements("student");
			System.out.println("子节点的个数" + list2.size());

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
