<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.awt.*" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.awt.geom.AffineTransform" %>
<%@ page contentType="image/png" language="java" %>
<%
    int width = 100;
    int height = 40;
    //生成图片
    BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    //生成画图工具
    Graphics2D g = bi.createGraphics();
    //随机生成4位数
    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < 4; i++){
    sb.append(random.nextInt(10));
    }
    //将生成的验证码提交到session中
    session.setAttribute("vercode",sb.toString());

    //画图，背景颜色
    g.fillRect(0,0,width,height);
    g.setColor(Color.blue);

    Font font = new Font("Arial",Font.PLAIN,20);
    g.setFont(font);

// 将数字 输出到图片
    g.drawString(sb.substring(0,1),10,25);
    g.drawString(sb.substring(1,2),30,25);
    g.drawString(sb.substring(2,3),50,25);
    g.drawString(sb.substring(2,3),70,25);

// 画线条 长度随机
    g.setColor(Color.gray); for (int i = 0; i < 20; i++) {
    int x = random.nextInt(width - 1);
    int y = random.nextInt(height - 1);
    int xl = random.nextInt(6) + 1;
    int yl = random.nextInt(12) + 1;
    g.drawLine(x, y, x + xl + 40, y + yl + 20);
    }

    g.dispose();
// 将图片内容输出到 输出流
    ImageIO.write(bi,"png",response.getOutputStream());

    response.getOutputStream().flush();
    response.getOutputStream().close();
%>