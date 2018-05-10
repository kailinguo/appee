package com.ssm.common.pdf;

import com.lowagie.text.pdf.BaseFont;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.OutputStream;
@Component
public class FlyingSaucerPdf {

	public String getPdfContent() throws Exception {
		String html = "<!DOCTYPE html><html><body style=\"font-family:'Arial Unicode MS'\">";
		
		String contents = "%s=%d";

		html += contents;

		html += "</body></html>";
		html = html.replaceAll("&nbsp;", " ");
		return html;
	}
	
	public void generate(String html, String baseUrl, OutputStream out)
			throws Exception {
		File thisFile = new File(FlyingSaucerPdf.class.getClassLoader().getResource(File.separator).getPath());
		String path = thisFile.getParentFile().getParentFile().getPath();
		
		ITextRenderer render = null;
		render = new ITextRenderer();
		
		// 添加字体，以支持中文
//		render.getFontResolver().addFont(path + File.separator + "fonts" + File.separator + "simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		render.getFontResolver().addFont("C:/WINDOWS/Fonts/arialuni.TTF",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 宋体字

		render.setDocumentFromString(html);
		if (baseUrl != null && !baseUrl.equals("")) {
			// html中如果有图片，图片的路径则使用这里设置的路径的相对路径，这个是作为根路径
			render.getSharedContext().setBaseURL("file:/" + baseUrl);
		}
		render.layout();
		render.createPDF(out);
		render.finishPDF();
		render = null;
	}

}
