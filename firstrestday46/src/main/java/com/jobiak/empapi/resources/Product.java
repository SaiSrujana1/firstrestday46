package com.jobiak.empapi.resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jobiak.empapi.model.Mobile;
import com.jobiak.empapi.service.MobileService;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/catalog")
public class Product 
{
	@Autowired
	MobileService service;


	
	@GetMapping(value="/mobile",produces=MediaType.APPLICATION_JSON_VALUE)
	public Mobile showCatalog()
	{
		Mobile mobile = new Mobile();
		mobile.setBrand("Samsung");
		mobile.setModel("E2FH,Dual Camera,32");
		mobile.setPrice(4999);
		return mobile;
	}
	@GetMapping("/intro")
	public String introduction()
	{
		return new String("I am srujana");
	}
	
	@GetMapping("/mobile/{modelId}")
	public String searchModel(@PathVariable(value="modelId")String modelId)
	{
		return new String(modelId+"Is availabel in Blue and Black color can be delivered in 24 hours");
	}
	@GetMapping("/mobile/{modelId}/brand/{brand}")
	public String searchModel(@PathVariable(value="modelId")String modelId,@PathVariable(value="brand")String brand)
	{
		return new String(modelId+brand+"Currently not avaiable for your loacation");
	}
	@PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Mobile addProduct(@RequestBody Mobile mobile)
	{
		//System.out.println(mobile);
		Mobile ref = service.addMobile(mobile);
		return ref;
	}
	@PostMapping(value="/modify",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Mobile modifyProduct(@RequestBody Mobile mobile)
	{
		Mobile ref = service.modifyMobile(mobile);
		return ref;
	}
	@DeleteMapping(value="/remove/{mobileid}")
	public void removeProduct(@PathVariable(value="mobileid")Long mobileid) {
		service.removeProduct(mobileid);
	}
}