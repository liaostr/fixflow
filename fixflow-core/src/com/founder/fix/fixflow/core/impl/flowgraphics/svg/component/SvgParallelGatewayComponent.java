package com.founder.fix.fixflow.core.impl.flowgraphics.svg.component;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;


import com.founder.fix.fixflow.core.impl.flowgraphics.svg.FlowSvgUtil;
import com.founder.fix.fixflow.core.impl.flowgraphics.svg.SvgBench;
import com.founder.fix.fixflow.core.impl.flowgraphics.svg.to.SvgBaseTo;
import com.founder.fix.fixflow.core.impl.flowgraphics.svg.to.SvgParallelGatewayTo;
import com.founder.fix.fixflow.core.exception.FixFlowException;
import com.founder.fix.fixflow.core.impl.util.StringUtil;
import com.founder.fix.fixflow.core.impl.util.XmlUtil;

public class SvgParallelGatewayComponent implements ISvgComponent {

	private static String comPath = "/svgcomponent/parallelGateway.xml";
	
	public String createComponent(SvgBaseTo svgTo) {
		String result = null;
		try {
			SvgParallelGatewayTo pGateTo = (SvgParallelGatewayTo)svgTo;
			InputStream in = SvgBench.class.getResourceAsStream(comPath);
			Document doc = XmlUtil.read(in);
			String str = doc.getRootElement().asXML();
			str = FlowSvgUtil.replaceAll(str, local_x, StringUtil.getString(pGateTo.getX()+2));
			str = FlowSvgUtil.replaceAll(str, local_y, StringUtil.getString(pGateTo.getY()+2));
			str = FlowSvgUtil.replaceAll(str, id, pGateTo.getId());
			str = FlowSvgUtil.replaceAll(str, text, pGateTo.getLabel());
			result = str;
		} catch (DocumentException e) {
			throw new FixFlowException("",e);
		}
		return result;
	}

}