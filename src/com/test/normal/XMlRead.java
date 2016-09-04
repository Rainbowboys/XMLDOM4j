package com.test.normal;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMlRead {
	public static void main(String[] args) {

		try {
			// 实例化document工厂 静态方法
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder buider = factory.newDocumentBuilder();
			Document document = buider.parse(new File("src/test.xml"));
			// 获取DOM的更节点
			Element root = document.getDocumentElement();
			System.out.println(root.getTagName());

			NodeList list = root.getElementsByTagName("book");
			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element) list.item(i);
				System.out.println("category" + " -------------------" + element.getAttribute("category"));
				NodeList clList = element.getChildNodes();
				for (int j = 0; j < clList.getLength(); j++) {
					Node c = clList.item(j);
					if (c instanceof Element) {
						Element ele=(Element) c;
						System.out.println(ele.getTagName()+" " + ele.getTextContent());
					}

				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
