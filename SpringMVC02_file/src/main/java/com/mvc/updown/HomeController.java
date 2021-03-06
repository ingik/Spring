package com.mvc.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.updown.validate.FileValidator;
import com.mvc.updown.validate.UploadFile;

@Controller
public class HomeController {
	@Autowired
	private FileValidator fileValidator;

	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}

	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {

		fileValidator.validate(uploadFile, result);
		// 파일 유효성검사, 에러발생시 업로드페이지로 리턴
		if (result.hasErrors()) {
			return "upload";
		}

		MultipartFile file = uploadFile.getMpfile();
		String name = file.getOriginalFilename();

		UploadFile fileObj = new UploadFile();
		fileObj.setName(name);
		fileObj.setDesc(uploadFile.getDesc());

		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			// 파일데이터를 읽어오기 위한 스트림
			inputStream = file.getInputStream();

			// 파일 저장할 위치
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");

			System.out.println("업로드 될 실제 경로: " + path);

			// 저장경로가 없을시
			File storage = new File(path);
			if (!storage.exists()) {
				storage.mkdir();
			}

			File newFile = new File(path + "/" + name);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}

			outputStream = new FileOutputStream(newFile);

			int read = 0;
			byte[] b = new byte[(int) file.getSize()];
			while ((read = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);
			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("fileObj", fileObj);
		
		return "download";
	}
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request,HttpServletResponse response ,String name) {
		byte[] down = null;
		
		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
			
			File file = new File(path+"/"+name);
			
			down = FileCopyUtils.copyToByteArray(file);
			String filename = new String(file.getName().getBytes(),"8859_1");
			
			response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
			response.setContentLength(down.length);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return down;
	}
}
