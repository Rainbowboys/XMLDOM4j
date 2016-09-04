package com.test.normal;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Dom4jReadbyIterator {

	public static Document prase(String url) throws DocumentException {
		File file = new File(url);
		Document document = null;
		if (file.exists()) {
			SAXReader reader = new SAXReader();
			document = reader.read(file);
		}
		return document;
	}

	public static void Read(Document document) {
		// 获取根节点 root
		Element root = document.getRootElement();
		for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			int nodecount = element.nodeCount();
			for (int i = 0; i < nodecount; i++) {
				Node node = element.node(i);
				if (node instanceof Element) {
					System.out.println(node.getName() + " " + node.getText());
				}
			}

		}

	}

	public static void Readbyname(Document document) {
		// 获取根节点 root
		Element root = document.getRootElement();
		for (Iterator iterator = root.elementIterator("student"); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			int nodecount = element.nodeCount();
			for (int i = 0; i < nodecount; i++) {
				Node node = element.node(i);
				if (node instanceof Element) {
					System.out.println(node.getName() + " " + node.getText());
				}
			}

		}
	}

	// 获取属性的值等
	public static void ReadbyAttr(Document document) {
		// 获取根节点 root
		Element root = document.getRootElement();
		for (Iterator iterator = root.elementIterator("student"); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			for (Iterator i = element.attributeIterator(); i.hasNext();) {
				Attribute attribute = (Attribute) i.next();
				System.out.println(attribute.getName() + " " + attribute.getText());
			}
		}

	}

	// Powerful Navigation with XPath
	public static void ReadByXpath(Document document) {
		List list = document.selectNodes("//person/student");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			for (int i = 0; i < element.nodeCount(); i++) {
				if (element.node(i) instanceof Element) {
					// System.out.println(element.node(i).getName() + " " +
					// element.node(i).getText());
					System.out.println(element.node(i).valueOf("@name"));
				}
			}
		}
	}

	public static void main(String[] args) throws DocumentException {

		ReadByXpath(prase("D://test.xml"));
	}

}
