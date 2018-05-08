package com.chao;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.Text;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPBinding;



public class CheckLoginClient {

	public static SOAPMessage formartSoapString(String soapString) {
		MessageFactory msgFactory;
        try {
			msgFactory = MessageFactory.newInstance();
			SOAPMessage reqMsg = msgFactory.createMessage(new MimeHeaders(),new ByteArrayInputStream(soapString.getBytes("UTF-8")));
			reqMsg.saveChanges();
			return reqMsg;
        } catch (Exception e) {
            return null;
        }
    }
	
	public static SOAPMessage getSOAPMessage(String username ,String password) {
		StringBuffer body = new StringBuffer();
		body.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"); 
		body.append("<soapenv:Header/>");
		body.append("<soapenv:Body>");
		body.append("<Header>");
		body.append("<ActionCode>123</ActionCode>");
		body.append("<ReqTime>123</ReqTime>");
		body.append("<ServiceCode>URP_CHECKLOGIN</ServiceCode>");
		body.append("<ServiceContractVer>123</ServiceContractVer>");
		body.append("<ServiceLevel>123</ServiceLevel>");
		body.append("<SrcSysID>123</SrcSysID>");
		body.append("<TransactionID>123</TransactionID>");
		body.append("</Header>");
		body.append("<Request>");
		//body.append("<SERVICE_TICKET_KEY>TGT-20160509204223P2PWLFVVQYIGYIWP5HS4EO-cas</SERVICE_TICKET_KEY>");
		body.append("<USERNAME>" + username + "</USERNAME>");
		body.append("<PASSWORD>" + password + "</PASSWORD>");
		body.append("</Request>");
		body.append("<Bottom>");
		body.append("<SVC_CONT_VER>11</SVC_CONT_VER>");
		body.append("<PAGE_SIZE>11</PAGE_SIZE>");
		body.append("<PAGE_INDEX>11</PAGE_INDEX>");
		body.append("</Bottom>");
		body.append("</soapenv:Body></soapenv:Envelope>");
		return formartSoapString( body.toString());
	}	
	
	// 名字空间 
    public static final String targetNamespace = "CheckLoginService";
    //服务名
    public static final String serName = "CheckLoginService";
    //端口名
    public static final String pName = "CheckLoginPort";
    //服务地址
    //public static final String endpointAddress = "http://10.128.90.165:8101/URP/URP.ws/CheckLoginService?wsdl";
    public static final String endpointAddress = "http://10.128.90.163:9088/URP/URP.ws/CheckLoginService?wsdl";
    //public static final String endpointAddress = "http://10.1.12.10/URP/URP.ws/CheckLoginService?wsdl";

	public static void main(String[] args) {
		try {
			//Map sent = sent("shxmjl01", "af8a6dee935e28a67532f57e6571a978");
			Map sent = sent("shxmjl01", "af8a6dee935e28a67532f57e6571a978");
			Map map = (Map) sent.get("entityMap");
			String name = (String) map.get("ORG_NAME");
			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public static Map sent(String username,String password) throws MalformedURLException, Exception {
		QName serviceName = new QName(targetNamespace, serName);
        QName portName = new QName(targetNamespace, pName);
        Service service = Service.create(serviceName);
        service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);
		dispatch.getRequestContext().put("com.sun.xml.ws.request.timeout", 2000);
		dispatch.getRequestContext().put("Content-Type", "text/xml;charset=UTF-8");

        SOAPMessage soap = null;
        try {
        	soap = dispatch.invoke(CheckLoginClient.getSOAPMessage(username,password));
        } catch (WebServiceException e) {
    		e.printStackTrace();
        }
     	return parseRequest(soap);
        /*SOAPBody soapBody = soap.getSOAPBody();
        SOAPBodyElement nextSoapBodyElement = (SOAPBodyElement)soapBody.getChildElements().next ();              
        SOAPElement soapElement = (SOAPElement)nextSoapBodyElement.getChildElements().next();
        System.out.println("获取回应信息为：" + soapElement.getValue());*/
	}
	
	public static Map parseRequest(SOAPMessage source) {
		try {
			Map<String ,Map> resultMap = new HashMap<String,Map>(0);
			SOAPEnvelope envelope = source.getSOAPPart().getEnvelope();
			SOAPElement body = envelope.getBody();
			SOAPElement headerElement = (SOAPElement) body.getChildElements(envelope.createName("Header")).next();
			SOAPElement responseElement = (SOAPElement) body.getChildElements(envelope.createName("Response")).next();
			SOAPElement bottomElement = (SOAPElement) body.getChildElements(envelope.createName("Bottom")).next();
			Map<String, String> headerMap = new HashMap<String, String>(0); // Request数据
			printNode(headerMap, headerElement);
			resultMap.put("headerMap", headerMap);
			SOAPElement entityElement = (SOAPElement)responseElement.getChildElements(envelope.createName("Entity")).next();
			Map<String, String> entityMap = new HashMap<String, String>(0); // Request数据
			printNode(entityMap, entityElement);
			resultMap.put("entityMap", entityMap);
			Map<String, String> bottomMap = new HashMap<String, String>(0); // Request数据
			printNode(bottomMap, bottomElement);
			resultMap.put("bottomMap", bottomMap);
			return resultMap;
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException("parse SOAPMessage failed!", e);
		}
	}	
	
	/**
	 * 遍历节点数据，存入Map中
	 * 
	 * @param mapNode
	 * @param element
	 */
	public static void printNode(Map<String, String> mapNode,
			SOAPElement element) {
		Object childElements = element.getFirstChild();
		while (childElements != null) {
			if (childElements instanceof Text) {
				Text obj = (Text) childElements;
				printText(obj.getLocalName(), mapNode, obj.getData());
				childElements = obj.getNextSibling();
			} else if (childElements instanceof SOAPElement) {
				SOAPElement obj = (SOAPElement) childElements;
				printText(obj.getLocalName(), mapNode, obj.getValue());
				childElements = obj.getNextSibling();
			}
		}
	}

	public static void printText(String nK, Map<String, String> mapNode,
			String nodeValue) {
		if (null != nodeValue && !"".equals(nodeValue.trim())) {
			mapNode.put(nK, nodeValue);
		}
	}

	public static String getNodeAttributes(SOAPElement svcElement,
			SOAPEnvelope envelope) throws SOAPException {
		SOAPElement sso = (SOAPElement) svcElement.getFirstChild();
		return sso.getAttributeValue(envelope.createName("type"));

	}

}
