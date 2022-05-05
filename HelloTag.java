package demoJDBC;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class HelloTag extends SimpleTagSupport {
	StringWriter sw = new StringWriter();
	public void doTag() throws JspException, IOException {
//		JspWriter out = getJspContext().getOut();
//		out.println("demo custom tag");
		getJspBody().invoke(sw);
		getJspContext().getOut().println(sw.toString());
	}
}
