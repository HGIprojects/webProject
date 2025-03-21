package com.myweb.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myweb.mappers.QueryMapper;
import com.myweb.mybatis.generate.map.ContadorVisitasMapper;
import com.myweb.mybatis.generate.model.ContadorVisitas;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class HomeService {

	@Autowired
	QueryMapper queryMapper;
	
	@Autowired
	ContadorVisitasMapper contadorMapper;
	
	public String homePageInitialize(HttpServletRequest request, Model model) {
		
		//dummy
/*		String clickedSomething = "nara3hTourClick";
		System.out.println("Hola, estoy en el initializer");
		model.addAttribute("visitas", queryMapper.visitCounter());
		System.out.println("Esta es la direccion IP del visitante: " + getIpAddress(request));
*/		
/*		System.out.println("Este deberia ser de Espanna");
		System.out.println("El pais calculado es: " + getCountry(("81.44.128.0")));
		
		System.out.println("Este deberia ser de Francia");
		System.out.println("El pais calculado es: " + getCountry(("176.132.0.0")));
		
		System.out.println("Este deberia ser de USA");
		System.out.println("El pais calculado es: " + getCountry(("104.28.0.0")));
		
		System.out.println("Este deberia ser de Japon");
		System.out.println("El pais calculado es: " + getCountry(("133.18.0.0")));
*/		
		

		Boolean clickedSomething = false;
		updateDatabase(getIpAddress(request), clickedSomething, model);
		
		System.out.println("Total visits: " + queryMapper.visitCounter());
		System.out.println("las visitas del modelo: " + model.getAttribute("totalVisits"));
		return "Home/JDM";
	}
	
	public String getIpAddress(HttpServletRequest request) {
		
		String visitorAddress = "";
		
		if (request != null) {
			visitorAddress = request.getHeader("X-FORWARDED-FOR");
			if (visitorAddress == null || "".equals(visitorAddress)) {
				visitorAddress = request.getRemoteAddr();
			}
		}
		System.out.println("la direccion IP es: " + visitorAddress);
		
		return visitorAddress;
	}

	public void updateDatabase (String visitorAddress, Boolean clickedSomething, Model model) {
		
		String country = getCountry(visitorAddress);

		LocalDateTime timeNow = LocalDateTime.now();
		
		ContadorVisitas visitRow = new ContadorVisitas();
		visitRow.setClicked(clickedSomething);
		visitRow.setFecha(timeNow);
		visitRow.setIp(visitorAddress);
		visitRow.setPais(country);
		
		contadorMapper.insert(visitRow);
		
		System.out.println("Insertado correctamente");
		model.addAttribute("totalVisits", queryMapper.visitCounter());
	}
	public String parseCountryFromResponse(String jsonResponse) {
		
		
		System.out.println("dentro del parseador de paises");
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode rootNode = mapper.readTree(jsonResponse);
			System.out.println("Este es el rootNode con toda la info: " + rootNode);
			JsonNode countryNode = rootNode.path("country");
			System.out.println("Este es el countryNode con toda la del pais: " + countryNode);
			return countryNode.asText();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ha habido una excepcion");
			return "Unknown";
		}
		
	}
	
	public String getCountry(String ipAddress) {
	        //ipAddress = "176.132.0.0";
	        String apiUrl = "http://ip-api.com/json/" + ipAddress;
        	String country = "";
	        try {
	            URL url = new URL(apiUrl);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            connection.setRequestProperty("User-Agent", "Mozilla/5.0"); // Mimic a browser request

	            int responseCode = connection.getResponseCode();
	            if (responseCode != 200) {
	            	country = "ERROR";
	            	return country;
	            }
	            
	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            	String apiResponse = reader.readLine();
            	System.out.println("la apiResponse = " + apiResponse);
	            reader.close();	            
	            JSONObject json = new JSONObject(apiResponse);
	            if (apiResponse != null && !json.getString("status").equals("fail")) {
	            	System.out.println("ni es null ni el status es fail y el json es " + json.getString("status"));
	            	country = json.getString("country");
	            } else {
	            	country = "UNKNOWN";
	            	System.out.println("Ha habido un error al leer la direccion, el pais se fijara en: [" + country + "]");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	    }
            return country;

	}
	
}
