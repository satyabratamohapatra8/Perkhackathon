package com.earner.info.controller;

import org.springframework.stereotype.Controller;

@Controller
public class FileUploadController {
//	@Autowired
//	MtTranslatorUtil mtTranslatorUtil;
//	 UploadedFile ufile;
//	  public FileUploadController(){
//	    System.out.println("init RestController");
//	    ufile = new UploadedFile();
//	  }
//	 @RequestMapping(value = "/upload", method = RequestMethod.POST)
//	   public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse response) {    
//		 Properties properties = mtTranslatorUtil.getProps();
//		 String path = properties.getProperty("TMX_UPLOAD_PATH");
//	     Iterator<String> itr =  request.getFileNames();
//	 
//	     MultipartFile mpf = request.getFile(itr.next());
//	     System.out.println(mpf.getOriginalFilename() +" uploaded!");
//	 
//	     try {
//	        ufile.length = mpf.getBytes().length;
//	        ufile.bytes= mpf.getBytes();
//	        ufile.type = mpf.getContentType();
//	        ufile.name = mpf.getOriginalFilename();
//	        FileOutputStream fos = new FileOutputStream(path+"/"+ufile.name);
//	        fos.write(ufile.bytes);
//	        fos.close();
//	 
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	 
//	     return path+"/"+ufile.name;
//	 
//	  }
}
