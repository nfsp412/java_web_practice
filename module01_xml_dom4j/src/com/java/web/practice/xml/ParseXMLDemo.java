package com.java.web.practice.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class ParseXMLDemo {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();

        InputStream is = ParseXMLDemo.class.getClassLoader().getResourceAsStream("jdbc.xml");
        Document document = saxReader.read(is);

        Element rootElement = document.getRootElement();

        //获取根节点元素
        String rootElementName = rootElement.getName();
        System.out.println(rootElementName);

        //获取子节点元素
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            System.out.println(element.getName());
            //获取元素属性
            Attribute id = element.attribute("id");
            System.out.println(id.getName() + "=>" + id.getValue());

            List<Element> elements1 = element.elements();
            for (Element element1 : elements1) {
                //获取元素值
                System.out.println(element1.getName() + "=>" + element1.getText());
            }

        }


    }
}
