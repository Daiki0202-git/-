package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /*   
		public void init(ServletConfig config) throws ServletException {
			super.init();
			

  		訪問回数を示すintegerインスタンスを新規作成し
  		アプリケーションスコープに保存
 
			Integer count = 0;
			ServletContext application = config.getServletContext();
			application.setAttribute("count", count);
			System.out.println("initが実行されました");
		}
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		アプリケーションスコープに保存された訪問回数を増加
		ServletContext application = this.getServletContext();
		Integer count = (Integer) application.getAttribute("count");
		count++;
		application.setAttribute("count", count);
		
//		HTMLを出力
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>訪問回数を表示");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>訪問回数：" + count + "</p>");
		out.println("<a href=\"/example/CounterServlet\">更新</a>");
		out.println("</body>");
		out.println("</html>");
		
	}
	private void destoroy() {
		System.out.println("destoroyが実行されました");
	}
}
