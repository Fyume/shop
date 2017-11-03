package cn.edu.zhku.jsj.web.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/CheckCode")
public class CheckCode extends HttpServlet {
	private int width = 130;
	private int height = 30;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// 设置底色
		setbackground(g);
		// 设置边框
		setborder(g);
		// 设置随机线
		setline(g);
		// 设置字体
		String s=setfont((Graphics2D) g);
		request.getSession().setAttribute("checkcode", s);
		
		// 输出图片
		response.setContentType("image/jpeg");
		response.setDateHeader("expires", -1);
		response.setHeader("cache-control", "no-cache");
		response.setHeader("pragma", "no-cache");
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	private String setfont(Graphics2D g) {
		
		g.setColor(Color.RED);
		g.setFont(new Font("仿宋", Font.BOLD, 20));
		int x=20;			
		String str="\u7684\u4e00\u662f\u4e86\u6211\u4e0d\u4eba\u5728\u4ed6\u6709\u8fd9\u4e2a\u4e0a\u4eec\u6765\u5230\u65f6\u5927\u5730\u4e3a\u5b50\u4e2d\u4f60\u8bf4\u751f\u56fd\u5e74\u7740\u5c31\u90a3\u548c\u8981\u5979\u51fa\u4e5f\u5f97\u91cc\u540e\u81ea\u4ee5\u4f1a\u5bb6\u53ef\u4e0b\u800c\u8fc7\u5929\u53bb\u80fd\u5bf9\u5c0f\u591a\u7136\u4e8e\u5fc3\u5b66\u4e48\u4e4b\u90fd\u597d\u770b\u8d77\u53d1\u5f53\u6ca1\u6210\u53ea\u5982\u4e8b\u628a\u8fd8\u7528\u7b2c\u6837\u9053\u60f3\u4f5c\u79cd\u5f00\u7f8e\u603b\u4ece\u65e0\u60c5\u5df1\u9762\u6700\u5973\u4f46\u73b0\u524d\u4e9b\u6240\u540c\u65e5\u624b\u53c8\u884c\u610f\u52a8\u65b9\u671f\u5b83\u5934\u7ecf\u957f\u513f\u56de\u4f4d\u5206\u7231\u8001\u56e0\u5f88\u7ed9\u540d\u6cd5\u95f4\u65af\u77e5\u4e16\u4ec0\u4e24\u6b21\u4f7f\u8eab\u8005\u88ab\u9ad8\u5df2\u4eb2\u5176\u8fdb\u6b64\u8bdd\u5e38\u4e0e\u6d3b\u6b63\u611f\u89c1\u660e\u95ee\u529b\u7406\u5c14\u70b9\u6587\u51e0\u5b9a\u672c\u516c\u7279\u505a\u5916\u5b69\u76f8\u897f\u679c\u8d70\u5c06\u6708\u5341\u5b9e\u5411\u58f0\u8f66\u5168\u4fe1\u91cd\u4e09\u673a\u5de5\u7269\u6c14\u6bcf\u5e76\u522b\u771f\u6253\u592a\u65b0\u6bd4\u624d\u4fbf\u592b\u518d\u4e66\u90e8\u6c34\u50cf\u773c\u7b49\u4f53\u5374\u52a0\u7535\u4e3b\u754c\u95e8\u5229\u6d77\u53d7\u542c\u8868\u5fb7\u5c11\u514b\u4ee3\u5458\u8bb8\u7a1c\u5148\u53e3\u7531\u6b7b\u5b89\u5199\u6027\u9a6c\u5149\u767d\u6216\u4f4f\u96be\u671b\u6559\u547d\u82b1\u7ed3\u4e50\u8272\u66f4\u62c9\u4e1c\u795e\u8bb0\u5904\u8ba9\u6bcd\u7236\u5e94\u76f4\u5b57\u573a\u5e73\u62a5\u53cb\u5173\u653e\u81f3\u5f20\u8ba4\u63a5\u544a\u5165\u7b11\u5185\u82f1\u519b\u5019\u6c11\u5c81\u5f80\u4f55\u5ea6\u5c71\u89c9\u8def\u5e26\u4e07\u7537\u8fb9\u98ce\u89e3\u53eb\u4efb\u91d1\u5feb\u539f\u5403\u5988\u53d8\u901a\u5e08\u7acb\u8c61\u6570\u56db\u5931\u6ee1\u6218\u8fdc\u683c\u58eb\u97f3\u8f7b\u76ee\u6761\u5462\u75c5\u59cb\u8fbe\u6df1\u5b8c\u4eca\u63d0\u6c42\u6e05\u738b\u5316\u7a7a\u4e1a\u601d\u5207\u600e\u975e\u627e\u7247\u7f57\u94b1\u7d36\u5417\u8bed\u5143\u559c\u66fe\u79bb\u98de\u79d1\u8a00\u5e72\u6d41\u6b22\u7ea6\u5404\u5373\u6307\u5408\u53cd\u9898\u5fc5\u8be5\u8bba\u4ea4\u7ec8\u6797\u8bf7\u533b\u665a\u5236\u7403\u51b3\u7aa2\u4f20\u753b\u4fdd\u8bfb\u8fd0\u53ca\u5219\u623f\u65e9\u9662\u91cf\u82e6\u706b\u5e03\u54c1\u8fd1\u5750\u4ea7\u7b54\u661f\u7cbe\u89c6\u4e94\u8fde\u53f8\u5df4\u5947\u7ba1\u7c7b\u672a\u670b\u4e14\u5a5a\u53f0\u591c\u9752\u5317\u961f\u4e45\u4e4e\u8d8a\u89c2\u843d\u5c3d\u5f62\u5f71\u7ea2\u7238\u767e\u4ee4\u5468\u5427\u8bc6\u6b65\u5e0c\u4e9a\u672f\u7559\u5e02\u534a\u70ed\u9001\u5174\u9020\u8c08\u5bb9";
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<4;i++){
			String s=str.charAt(new Random().nextInt(str.length()))+"";
			sb.append(s);
			int temp=new Random().nextInt()%30;
			double rotate=temp*Math.PI/180;
			g.rotate(rotate, x, 20);
			g.drawString(s, x, 20);
			g.rotate(-rotate, x, 20);
			x+=20;
			
		}
		return sb.toString();
	}

	private void setline(Graphics g) {
		g.setColor(Color.YELLOW);
		for (int i = 0; i < 5; i++) {
			int x1 = new Random().nextInt(width);
			int x2 = new Random().nextInt(width);
			int y1 = new Random().nextInt(height);
			int y2 = new Random().nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
	}

	private void setbackground(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);

	}

	private void setborder(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(1, 1, width - 2, height - 2);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
