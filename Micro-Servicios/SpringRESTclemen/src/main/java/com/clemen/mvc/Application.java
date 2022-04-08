package com.clemen.mvc;


import com.clemen.mvc.entity.Cliente;
import com.clemen.mvc.service.impl.ClienteServiceImpl;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context  = (ApplicationContext) SpringApplication.run(Application.class, args);
		ClienteServiceImpl service = context.getBean(ClienteServiceImpl.class);

		Cliente cliente = new Cliente("Antonio", "Rodriguez", LocalDate.now(),"12345678M");
		service.crearCliente(cliente);
	}


}
