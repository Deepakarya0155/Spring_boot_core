package com.core.fileuploadAndDownload;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
public class FileUploadAndDownloadController {
	
	RestTemplate resttemp=new RestTemplate();
	
	@GetMapping("uploadTest")
	public void uploadTest() {
		HttpHeaders head=new HttpHeaders();
		head.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		File fl=new File("pom.xml");
		
		FileSystemResource rs=new FileSystemResource(fl);
		
		MultiValueMap<String, Object> body
		  = new LinkedMultiValueMap<>();

		body.put("files", Arrays.asList(rs,rs));
		body.put("name",Arrays.asList("Deepak"));
		body.put("age",Arrays.asList("26"));
		
		
		HttpEntity et=new HttpEntity(body,head);
		try {
		
			ResponseEntity<String> response=resttemp.exchange("http://localhost:8080/file/upload", HttpMethod.POST,et,String.class,new HashMap());
			
			System.out.println(response.getBody());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	@PostMapping(path = "upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void uploadFileAPI(@RequestParam MultiValueMap<String,String> mp,
			@RequestPart("files") List<MultipartFile> files ) {
		
		System.out.println(mp.get("name").get(0));
		System.out.println(mp.get("age").get(0));
		System.out.println(files.get(0).getOriginalFilename());
		
	}
	
	
	@GetMapping("download")
	public ResponseEntity downloadFile() throws FileNotFoundException {
		File file2Upload = new File("pom.xml");
      
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file2Upload.getName());
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        FileSystemResource rs=new FileSystemResource(file2Upload);
        System.out.println("The length of the file is : "+file2Upload.length());

        return ResponseEntity.ok().headers(headers).contentLength(file2Upload.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(rs);
	}
}
