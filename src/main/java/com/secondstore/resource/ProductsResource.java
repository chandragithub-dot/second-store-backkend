package com.secondstore.resource;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.secondstore.domain.Products;
import com.secondstore.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsResource {


	@Autowired
	private ProductsService productsService;
	
    @RequestMapping (value="/add", method=RequestMethod.POST)
	public Products addProductsPost(@RequestBody Products products) {
		return productsService.save(products);
	}
    
    @RequestMapping(value="/add/image", method=RequestMethod.POST)
	public ResponseEntity upload(
			@RequestParam("id") Long id,
			HttpServletResponse response, HttpServletRequest request
			){
		try {
			Products products = productsService.findOne(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+".png";
			
			
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/products/"+fileName)));
			stream.write(bytes);
			stream.close();
			
			return new ResponseEntity("Upload Success!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping("/productsList")
	public List<Products> getProductsList() {
		return productsService.findAll();
	}
	
	
	@RequestMapping("/{id}")
	public Products getProducts(@PathVariable("id") Long id){
		Products products = productsService.findOne(id);
		return products;
	}
	
	@RequestMapping(value="/searchBook", method=RequestMethod.POST)
	public List<Products> searchProducts (@RequestBody String keyword) {
		List<Products> productsList = productsService.blurrySearch(keyword);
		
		return productsList;
	}
  }

