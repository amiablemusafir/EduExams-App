package com.sms.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * Servlet implementation class CaptchaServlet
 */
public class LoginCaptcha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response) 
throws ServletException, IOException {

					int width = 95;
					int height = 50;
					 
					/*char data[][] = {
					{ 'z', 'e', 't', 'c', 'o', 'd', 'e' },
					{ 'l', 'i', 'd', 'r', 'x' ,'f', 't'},
					{ 'f', 'r', 'e', 'e', 'b', 's', 'd' },
					{ 'u', 'y', 'o', 'k', 'p', 'u', 'o' },
					{ 'j', 'f', 'g', 'a', 'd', 'h', 'n' },
					{ 'r', 'n', 'h', 'd', 'q', 'w', 'e' },
					{ 'm', 'n', 'l', 'k', 'o', 'i', 'b' },
					{ 'z', 'x', 'a', 's', 'q', 'w', 'c' },
					{ 't', 'y', 'g', 'h', 'v', 'b', 'm' },
					{ 'e', 'r', 's', 'd', 'x', 'c', 'v'},
					{ 'r', 'n', 'h', 'd', 'q', 'w', 'e'},
					{ 'r', 'a', 'f', 'e', 't', 'e', 'e' },
					
					};
					//TYPE_BYTE_GRAY
					
					BufferedImage bufferedImage = new BufferedImage(width, height, 
					BufferedImage.TYPE_BYTE_GRAY);
					
					Graphics2D g2d = bufferedImage.createGraphics();
					
					Font font = new Font("Georgia", Font.BOLD, 18);
					g2d.setFont(font);
					
					RenderingHints rh = new RenderingHints(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
					
					rh.put(RenderingHints.KEY_RENDERING, 
					RenderingHints.VALUE_RENDER_QUALITY);
					
					g2d.setRenderingHints(rh);
					
					GradientPaint gp = new GradientPaint(0, 0, 
					Color.red, 0, height/2, Color.black, true);
					
					g2d.setPaint(gp);
					g2d.fillRect(0, 0, width, height);
					
					g2d.setColor(new Color(255, 153, 0));
					
					Random r = new Random();
					int index = Math.abs(r.nextInt()) % 5;
					
					String captcha = String.copyValueOf(data[index]);
					request.getSession().setAttribute("captcha", captcha );
					
					int x = 0; 
					int y = 0;
					
					for (int i=0; i<data[index].length; i++) {
					x += 10 + (Math.abs(r.nextInt()) % 15);
					y = 20 + Math.abs(r.nextInt()) % 20;
					g2d.drawChars(data[index], i, 1, x, y);
					}
					
					g2d.dispose();
					
					response.setContentType("image/png");
					OutputStream os = response.getOutputStream();
					ImageIO.write(bufferedImage, "png", os);
					os.close();*/
					char data[][] = new char[1][];
					data[0] = getRandomNumber(4).toCharArray();
					
					final BufferedImage bufferedImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
					
					final Graphics2D g2d = bufferedImage.createGraphics();
					
					final Font font = new Font("Times Roman", Font.BOLD, 18);
					
					RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
					
					renderingHints.put(RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY);
					
					g2d.setRenderingHints(renderingHints);
					
					g2d.setFont(font);
					g2d.setColor(new Color(0, 0, 0));
					
					final GradientPaint gradientPaint = new GradientPaint(0, 0, 
							new Color(238, 233, 233), 0, height/2, new Color(238, 233, 233), true);
					
					g2d.setPaint(gradientPaint);
					g2d.fillRect(0, 0, width, height);
					
					g2d.setColor(new Color(0, 0, 0));
					Random random = new Random();
					
					final String captcha = String.copyValueOf(data[0]);
					request.getSession().setAttribute("logincaptcha", captcha);
					
					int xCordinate = 0;
					int yCordinate = 0;
					
					for (int i = 0; i < data[0].length; i++) {
					xCordinate += 10 + (Math.abs(random.nextInt()) % 15);
					if (xCordinate >= width - 5) {
					xCordinate = 0;
					}
					yCordinate = 20 + Math.abs(random.nextInt()) % 20;
					g2d.drawChars(data[0], i, 1, xCordinate, yCordinate);
					}
					
					g2d.dispose();
					
					response.setContentType("image/png");
					final OutputStream outputStream = response.getOutputStream();
					ImageIO.write(bufferedImage, "png", outputStream);
					outputStream.close();
} 

	public static String getRandomNumber(int length) {

		String chars = "www.s2sgateway.comabcdefghjijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ123456789";
		Random random = new Random();

		char[] buf = new char[length];

		for (int i = 0; i < length; i++) {
		buf[i] = chars.charAt(random.nextInt(chars.length()));
		}

		return new String(buf);

		}
	
		protected void doGet(HttpServletRequest request, 
		   HttpServletResponse response)
		       throws ServletException, IOException {
		processRequest(request, response);
		} 


	protected void doPost(HttpServletRequest request, 
	    HttpServletResponse response)
	        throws ServletException, IOException {
	processRequest(request, response);
	}

}
