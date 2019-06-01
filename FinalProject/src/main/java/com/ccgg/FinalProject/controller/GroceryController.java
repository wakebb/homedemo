package com.ccgg.FinalProject.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import com.ccgg.FinalProject.beans.Grocery;
import com.ccgg.FinalProject.dao.GroceryDao;
import com.ccgg.FinalProject.http.Response;
import com.ccgg.FinalProject.service.GroceryService;

@RestController()
public class GroceryController {
	
	@Autowired
	GroceryService groceryService;
	
	@Autowired
	GroceryDao groceryDao;
	
	public List<String> files = new ArrayList<String>();
	
	@GetMapping("/grocery")
	public List<Grocery> getGroceryList() {
		return groceryService.getGroceryList();
	}
	
	@GetMapping("/grocery/{id}")
	public Grocery getOneGro(@PathVariable int id) {
		return groceryDao.findOne(id);
	}
	
	@GetMapping("/getallfiles")
	public ResponseEntity<List<String>> getListFiles(Model model) {
		
		List<String> results = new ArrayList<String>();
		File[] pics = new File("grocery").listFiles();
		for(File pic : pics) {
			results.add(pic.getName());
		}
		
		List<String> fileNames = results
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(GroceryController.class, "getFile", fileName).build().toString())
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(fileNames);
	}

	//get one pic
//	@GetMapping("/getOnePic/{filename:.+}")
//	public ResponseEntity<List<String>> getOnePic(Model model) {
//		
//		List<String> results = new ArrayList<String>();
////		String pic = new File("grocery/).getName();
//		results.add(pic);
//		
//		List<String> fileNames = results
//				.stream().map(fileName -> MvcUriComponentsBuilder
//						.fromMethodName(GroceryController.class, "getPic", fileName).build().toString())
//				.collect(Collectors.toList());
//
//		return ResponseEntity.ok().body(fileNames);
//	}
	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = groceryService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	//method to get one pic
	@GetMapping("/pic/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getPic(@PathVariable String filename) {
		Resource file = groceryService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	@PostMapping("/grocery")
	public Response addGrocery(@ModelAttribute Grocery grocery, @RequestParam("grocery_image") MultipartFile file) {
		grocery.setPic(file.getOriginalFilename());
		try {
			groceryService.store(file);
			files.add(file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groceryService.addGrocery(grocery);
	}
	
}
