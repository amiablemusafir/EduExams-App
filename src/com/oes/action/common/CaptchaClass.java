package com.oes.action.common;


import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;

public class CaptchaClass {

	public void processRequest(HttpServletRequest request, HttpServletResponse response) {

 
		int width = 150;
		int height = 45;
 
		char data[][] = {

				{ 'Z', 'e', 't', '4' },
				{ 'c', 'O', 'd', 'e', '4' },
				{ 'l', 'i', 'N', 'u' },
				{ 'f', '8', 'r', 'e', '8' },
				{ 'U', 'b', 'u', 'n' }, 
				{ 'O', 'b', 'N', 'n' }, 
				{ '7', '8', '9', '0' }, 
				{ '9', '2', '1', '4' }, 
				{ '1', '5', '9', '6' }, 
				{ '7', '2', '4', '8' }, 
				{ 'C', 'b', 'u', 'D' }, 
				{ 'M', 'b', 'N', 'n' }, 
				{ 'j', 'E', 'e', '6', '3' },
				{ 'x', '2', '5', 'E' },
				{ 'b', 's', 'd', 't', '4' }
		}; 
 
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufferedImage.createGraphics(); 
		Font font = new Font("Georgia", Font.BOLD, 18);
		g2d.setFont(font); 
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
 
		g2d.setRenderingHints(rh);
		GradientPaint gp = new GradientPaint(0, 0, Color.WHITE, 0, height/2, Color.CYAN, true);
 
	    g2d.setPaint(gp);
	    g2d.fillRect(0, 0, width, height); 
	    g2d.setColor(new Color(255, 153, 0)); 
	    Random r = new Random();
	    int index = Math.abs(r.nextInt()) % 15;
 
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
	    try {
	    	OutputStream os = response.getOutputStream();
	  	    ImageIO.write(bufferedImage, "png", os);
	  	    
	  	    os = null;
	  	    response.getOutputStream().flush();
	  	    response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

	   
	} 
}