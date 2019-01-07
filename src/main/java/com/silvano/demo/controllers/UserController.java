package com.silvano.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.silvano.demo.model.User;
import com.silvano.demo.service.UserService;
import com.silvano.demo.util.RestResponse;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;

	protected ObjectMapper objectMapper;

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson)
			throws JsonParseException, JsonMappingException, IOException {
		this.objectMapper = new ObjectMapper();
		User user = this.objectMapper.readValue(userJson, User.class);
		if (!validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los campos obligatorios estan en nulo");
		}
		this.userService.save(user);
		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}
	
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<User> getUsers() {
		return this.userService.findAll();
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody String userJson) throws Exception {
		this.objectMapper = new ObjectMapper();
		User user = this.objectMapper.readValue(userJson, User.class);
		if(user.getId()==null) {
			throw new Exception("El id es nulo");
		}
		this.userService.delete(user);
	}

	private boolean validate(User user) {
		boolean isValid = true;
		if (StringUtils.trimToNull(user.getFirsName()) == null) {
			isValid = false;
		} else if (StringUtils.trimToNull(user.getFirstSurName()) == null) {
			isValid = false;
		} else if (StringUtils.trimToNull(user.getAddress()) == null) {
			isValid = false;
		}
		return isValid;
	}
}
