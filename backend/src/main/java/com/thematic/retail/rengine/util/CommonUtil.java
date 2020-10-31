package com.thematic.retail.rengine.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.thematic.retail.rengine.model.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class CommonUtil {

	public static CategoryHierarchy getCategoryHierarchyObject() {
		// Storing preprocessed json(Added slashes)
		//String categoryHierarchyJson = "{\"departmentList\":[{\"departmentId\":1,\"departmentName\":\"Furniture\",\"categoryList\":[{\"categoryId\":1,\"categoryName\":\"BedRoom\",\"subCategoriesList\":[{\"subCategoryId\":1,\"subCategoryName\":\"Bed\",\"itemClassList\":[{\"itemClassId\":1,\"itemClassName\":\"WoodFrame\"},{\"itemClassId\":2,\"itemClassName\":\"Metal Frame\"}]},{\"subCategoryId\":2,\"subCategoryName\":\"Chest\",\"itemClassList\":[{\"itemClassId\":3,\"itemClassName\":\"With drawer\"},{\"itemClassId\":4,\"itemClassName\":\"Without drawer\"}]}]},{\"categoryId\":2,\"categoryName\":\"Living Room\",\"subCategoriesList\":[{\"subCategoryId\":3,\"subCategoryName\":\"Sofa\",\"itemClassList\":[{\"itemClassId\":5,\"itemClassName\":\"Sectional\"},{\"itemClassId\":6,\"itemClassName\":\"Love Seat\"}]},{\"subCategoryId\":4,\"subCategoryName\":\"Tables\",\"itemClassList\":[{\"itemClassId\":7,\"itemClassName\":\"Coffee table\"},{\"itemClassId\":8,\"itemClassName\":\"End Tables\"}]}]}]},{\"departmentId\":2,\"departmentName\":\"Garden\",\"categoryList\":[{\"categoryId\":3,\"categoryName\":\"Plant\",\"subCategoriesList\":[{\"subCategoryId\":5,\"subCategoryName\":\"Outdoor Plants\",\"itemClassList\":[{\"itemClassId\":9,\"itemClassName\":\"Perinnials\"},{\"itemClassId\":10,\"itemClassName\":\"Seasonals\"}]}]},{\"categoryId\":4,\"categoryName\":\"Equipemnt\",\"subCategoriesList\":[{\"subCategoryId\":6,\"subCategoryName\":\"Outdoor Gardening\",\"itemClassList\":[{\"itemClassId\":11,\"itemClassName\":\"Hoses\"},{\"itemClassId\":12,\"itemClassName\":\"Shovels\"}]}]}]}]}";
		String categoryHierarchyJson = "{\r\n" + 
				"	\"departmentList\": [\r\n" + 
				"		{\r\n" + 
				"			\"departmentId\": 1,\r\n" + 
				"			\"departmentName\": \"Furniture\",\r\n" + 
				"			\"categoryList\": [\r\n" + 
				"				{\r\n" + 
				"					\"categoryId\": 1,\r\n" + 
				"					\"categoryName\": \"BedRoom\",\r\n" + 
				"					\"selected\": true,\r\n" + 
				"					\"subCategoriesList\": [\r\n" + 
				"						{\r\n" + 
				"							\"subCategoryId\": 1,\r\n" + 
				"							\"subCategoryName\": \"Bed\",\r\n" + 
				"							\"selected\": false,\r\n" + 
				"							\"itemClassList\": [\r\n" + 
				"								{\r\n" + 
				"									\"itemClassId\": 1,\r\n" + 
				"									\"itemClassName\": \"WoodFrame\",\r\n" + 
				"									\"selected\": false\r\n" + 
				"								},\r\n" + 
				"								{\r\n" + 
				"									\"itemClassId\": 2,\r\n" + 
				"									\"itemClassName\": \"Metal Frame\",\r\n" + 
				"									\"selected\": false\r\n" + 
				"								}\r\n" + 
				"							]\r\n" + 
				"						},\r\n" + 
				"						{\r\n" + 
				"							\"subCategoryId\": 2,\r\n" + 
				"							\"subCategoryName\": \"Chest\",\r\n" + 
				"							\"selected\": false,\r\n" + 
				"							\"itemClassList\": [\r\n" + 
				"								{\r\n" + 
				"									\"itemClassId\": 3,\r\n" + 
				"									\"itemClassName\": \"With drawer\",\r\n" + 
				"									\"selected\": false\r\n" + 
				"								},\r\n" + 
				"								{\r\n" + 
				"									\"itemClassId\": 4,\r\n" + 
				"									\"itemClassName\": \"Without drawer\",\r\n" + 
				"									\"selected\": false\r\n" + 
				"								}\r\n" + 
				"							]\r\n" + 
				"						}\r\n" + 
				"					]\r\n" + 
				"				},\r\n" + 
				"				{\r\n" + 
				"					\"categoryId\": 2,\r\n" + 
				"					\"categoryName\": \"Living Room\",\r\n" + 
				"					\"selected\": false,\r\n" + 
				"					\"subCategoriesList\": [\r\n" + 
				"						{\r\n" + 
				"							\"subCategoryId\": 3,\r\n" + 
				"							\"subCategoryName\": \"Sofa\",\r\n" + 
				"							\"selected\": true,\r\n" + 
				"							\"itemClassList\": [\r\n" + 
				"								{\r\n" + 
				"									\"itemClassId\": 5,\r\n" + 
				"									\"itemClassName\": \"Sectional\",\r\n" + 
				"									\"selected\": false\r\n" + 
				"								},\r\n" + 
				"								{\r\n" + 
				"									\"itemClassId\": 6,\r\n" + 
				"									\"itemClassName\": \"Love Seat\",\r\n" + 
				"									\"selected\": false\r\n" + 
				"								}\r\n" + 
				"							]\r\n" + 
				"						},\r\n" + 
				"						{\r\n" + 
				"							\"subCategoryId\": 4,\r\n" + 
				"							\"subCategoryName\": \"Tables\",\r\n" + 
				"							\"selected\": true,\r\n" + 
				"							\"itemClassList\": [\r\n" + 
				"								{\r\n" + 
				"									\"itemClassId\": 7,\r\n" + 
				"									\"itemClassName\": \"Coffee table\",\r\n" + 
				"									\"selected\": false\r\n" + 
				"								},\r\n" + 
				"								{\r\n" + 
				"									\"itemClassId\": 8,\r\n" + 
				"									\"itemClassName\": \"End Tables\",\r\n" + 
				"									\"selected\": false\r\n" + 
				"								}\r\n" + 
				"							]\r\n" + 
				"						}\r\n" + 
				"					]\r\n" + 
				"				}\r\n" + 
				"			]\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"departmentId\": 2,\r\n" + 
				"			\"departmentName\": \"Garden\",\r\n" + 
				"			\"categoryList\": [\r\n" + 
				"				{\r\n" + 
				"					\"categoryId\": 3,\r\n" + 
				"					\"categoryName\": \"Plant\",\r\n" + 
				"					\"selected\": false,\r\n" + 
				"					\"subCategoriesList\": [\r\n" + 
				"						{\r\n" + 
				"							\"subCategoryId\": 5,\r\n" + 
				"							\"subCategoryName\": \"Outdoor Plants\",\r\n" + 
				"							\"selected\": false,\r\n" + 
				"							\"itemClassList\": [\r\n" + 
				"								{\r\n" + 
				"									\"itemClassId\": 9,\r\n" + 
				"									\"itemClassName\": \"Perinnials\",\r\n" + 
				"									\"selected\": true\r\n" + 
				"								},\r\n" + 
				"								{\r\n" + 
				"									\"itemClassId\": 10,\r\n" + 
				"									\"itemClassName\": \"Seasonals\",\r\n" + 
				"									\"selected\": true\r\n" + 
				"								}\r\n" + 
				"							]\r\n" + 
				"						}\r\n" + 
				"					]\r\n" + 
				"				},\r\n" + 
				"				{\r\n" + 
				"					\"categoryId\": 4,\r\n" + 
				"					\"categoryName\": \"Equipemnt\",\r\n" + 
				"					\"selected\": false,\r\n" + 
				"					\"subCategoriesList\": [\r\n" + 
				"						{\r\n" + 
				"							\"subCategoryId\": 6,\r\n" + 
				"							\"subCategoryName\": \"Outdoor Gardening\",\r\n" + 
				"							\"selected\": false,\r\n" + 
				"							\"itemClassList\": [\r\n" + 
				"								{\r\n" + 
				"									\"itemClassId\": 11,\r\n" + 
				"									\"itemClassName\": \"Hoses\",\r\n" + 
				"									\"selected\": false\r\n" + 
				"								},\r\n" + 
				"								{\r\n" + 
				"									\"itemClassId\": 12,\r\n" + 
				"									\"itemClassName\": \"Shovels\",\r\n" + 
				"									\"selected\": true\r\n" + 
				"								}\r\n" + 
				"							]\r\n" + 
				"						}\r\n" + 
				"					]\r\n" + 
				"				}\r\n" + 
				"			]\r\n" + 
				"		}\r\n" + 
				"	]\r\n" + 
				"}";
		// Creating a Gson Object
		Gson gson = new Gson();

		// Converting json to object
		// first parameter should be prpreocessed json
		// and second should be mapping class
		CategoryHierarchy categoryHierarchy = gson.fromJson(categoryHierarchyJson, CategoryHierarchy.class);

		// return object
		return categoryHierarchy;
	}

	public static ForceFactors getForceFactors() {
		// Storing preprocessed json(Added slashes)
		//String forceFactorJson = "{\"forceList\":[{\"forceId\":1,\"forceName\":\"Margin\",\"forceFactorList\":[{\"forceFactorId\":1,\"forceFactorName\":\"Price\",\"forceFactorWeight\":9},{\"forceFactorId\":2,\"forceFactorName\":\"Margin Rate\",\"forceFactorWeight\":7},{\"forceFactorId\":3,\"forceFactorName\":\"Store Revenue\",\"forceFactorWeight\":7},{\"forceFactorId\":4,\"forceFactorName\":\"Digital Revenue\",\"forceFactorWeight\":7}]},{\"forceId\":2,\"forceName\":\"Customer\",\"forceFactorList\":[{\"forceFactorId\":5,\"forceFactorName\":\"Rating Review\",\"forceFactorWeight\":7},{\"forceFactorId\":6,\"forceFactorName\":\"Abandonment Rate\",\"forceFactorWeight\":7},{\"forceFactorId\":7,\"forceFactorName\":\"Q&A\",\"forceFactorWeight\":7}]},{\"forceId\":3,\"forceName\":\"Product\",\"forceFactorList\":[{\"forceFactorId\":8,\"forceFactorName\":\"Complexcity Ambiguity\",\"forceFactorWeight\":7},{\"forceFactorId\":9,\"forceFactorName\":\"Susbtitution\",\"forceFactorWeight\":7},{\"forceFactorId\":10,\"forceFactorName\":\"Recency\",\"forceFactorWeight\":7},{\"forceFactorId\":11,\"forceFactorName\":\"Content Availability\",\"forceFactorWeight\":7}]},{\"forceId\":4,\"forceName\":\"Competition\",\"forceFactorList\":[{\"forceFactorId\":12,\"forceFactorName\":\"Promo Frequency\",\"forceFactorWeight\":7},{\"forceFactorId\":13,\"forceFactorName\":\"Inventory Status\",\"forceFactorWeight\":7},{\"forceFactorId\":14,\"forceFactorName\":\"Price Matching\",\"forceFactorWeight\":7}]}]}";
		//String json = readFileAsString();

		String forceFactorJson = "{\r\n" +
				"	\"forceList\" : [ {\r\n" + 
				"						\"forceId\" : 1,\r\n" + 
				"						\"forceName\" : \"Margin\",\r\n" + 
				"						\"forceFactorList\" : [ \r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 1,	\r\n" + 
				"							 \"forceFactorName\" : \"Price\",\r\n" + 
				"							 \"forceFactorWeight\" : 1\r\n" + 
				"							},\r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 2,	\r\n" + 
				"							 \"forceFactorName\" : \"Margin Rate\",\r\n" + 
				"							 \"forceFactorWeight\" : 2\r\n" + 
				"							},\r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 3,	\r\n" + 
				"							 \"forceFactorName\" : \"Store Revenue\",\r\n" + 
				"							 \"forceFactorWeight\" : 3\r\n" + 
				"							},\r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 4,	\r\n" + 
				"							 \"forceFactorName\" : \"Digital Revenue\",\r\n" + 
				"							 \"forceFactorWeight\" : 4\r\n" + 
				"							}\r\n" + 
				"						  ]\r\n" + 
				"					},\r\n" + 
				"					{\r\n" + 
				"						\"forceId\" : 2,\r\n" + 
				"						\"forceName\" : \"Customer\",\r\n" + 
				"						\"forceFactorList\" : [ \r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 5,	\r\n" + 
				"							 \"forceFactorName\" : \"Rating Review\",\r\n" + 
				"							 \"forceFactorWeight\" : 5\r\n" + 
				"							},\r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 6,	\r\n" + 
				"							 \"forceFactorName\" : \"Abandonment Rate\",\r\n" + 
				"							 \"forceFactorWeight\" : 6\r\n" + 
				"							},\r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 7,	\r\n" + 
				"							 \"forceFactorName\" : \"Q&A\",\r\n" + 
				"							 \"forceFactorWeight\" : 7\r\n" + 
				"							}\r\n" + 
				"						  ]\r\n" + 
				"					},\r\n" + 
				"					{\r\n" + 
				"						\"forceId\" : 3,\r\n" + 
				"						\"forceName\" : \"Product\",\r\n" + 
				"						\"forceFactorList\" : [ \r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 8,	\r\n" + 
				"							 \"forceFactorName\" : \"Complexcity Ambiguity\",\r\n" + 
				"							 \"forceFactorWeight\" : 8\r\n" + 
				"							},\r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 9,	\r\n" + 
				"							 \"forceFactorName\" : \"Susbtitution\",\r\n" + 
				"							 \"forceFactorWeight\" : 9\r\n" + 
				"							},\r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 10,	\r\n" + 
				"							 \"forceFactorName\" : \"Recency\",\r\n" + 
				"							 \"forceFactorWeight\" : 10\r\n" + 
				"							},\r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 11,	\r\n" + 
				"							 \"forceFactorName\" : \"Content Availability\",\r\n" + 
				"							 \"forceFactorWeight\" : 11\r\n" + 
				"							}\r\n" + 
				"						  ]\r\n" + 
				"					},\r\n" + 
				"					{\r\n" + 
				"						\"forceId\" : 4,\r\n" + 
				"						\"forceName\" : \"Competition\",\r\n" + 
				"						\"forceFactorList\" : [ \r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 12,	\r\n" + 
				"							 \"forceFactorName\" : \"Promo Frequency\",\r\n" + 
				"							 \"forceFactorWeight\" : 12\r\n" + 
				"							},\r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 13,	\r\n" + 
				"							 \"forceFactorName\" : \"Inventory Status\",\r\n" + 
				"							 \"forceFactorWeight\" : 13\r\n" + 
				"							},\r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 14,	\r\n" + 
				"							 \"forceFactorName\" : \"Price Matching\",\r\n" + 
				"							 \"forceFactorWeight\" : 14\r\n" + 
				"							},\r\n" + 
				"							{ \r\n" + 
				"							 \"forceFactorId\" : 15,	\r\n" + 
				"							 \"forceFactorName\" : \"Available\",\r\n" + 
				"							 \"forceFactorWeight\" : 15\r\n" + 
				"							}\r\n" + 
				"						  ]\r\n" + 
				"					}\r\n" + 
				"				]	\r\n" + 
				"}";
		// Creating a Gson Object
		Gson gson = new Gson();

		// Converting json to object
		// first parameter should be prpreocessed json
		// and second should be mapping class
		ForceFactors forceFactors = gson.fromJson(forceFactorJson, ForceFactors.class);

		// return object
		return forceFactors;
	}

	public static NForceFactors[] getNForceFactors() {
		// Storing preprocessed json(Added slashes)
		//String forceFactorJson = "{\"forceList\":[{\"forceId\":1,\"forceName\":\"Margin\",\"forceFactorList\":[{\"forceFactorId\":1,\"forceFactorName\":\"Price\",\"forceFactorWeight\":9},{\"forceFactorId\":2,\"forceFactorName\":\"Margin Rate\",\"forceFactorWeight\":7},{\"forceFactorId\":3,\"forceFactorName\":\"Store Revenue\",\"forceFactorWeight\":7},{\"forceFactorId\":4,\"forceFactorName\":\"Digital Revenue\",\"forceFactorWeight\":7}]},{\"forceId\":2,\"forceName\":\"Customer\",\"forceFactorList\":[{\"forceFactorId\":5,\"forceFactorName\":\"Rating Review\",\"forceFactorWeight\":7},{\"forceFactorId\":6,\"forceFactorName\":\"Abandonment Rate\",\"forceFactorWeight\":7},{\"forceFactorId\":7,\"forceFactorName\":\"Q&A\",\"forceFactorWeight\":7}]},{\"forceId\":3,\"forceName\":\"Product\",\"forceFactorList\":[{\"forceFactorId\":8,\"forceFactorName\":\"Complexcity Ambiguity\",\"forceFactorWeight\":7},{\"forceFactorId\":9,\"forceFactorName\":\"Susbtitution\",\"forceFactorWeight\":7},{\"forceFactorId\":10,\"forceFactorName\":\"Recency\",\"forceFactorWeight\":7},{\"forceFactorId\":11,\"forceFactorName\":\"Content Availability\",\"forceFactorWeight\":7}]},{\"forceId\":4,\"forceName\":\"Competition\",\"forceFactorList\":[{\"forceFactorId\":12,\"forceFactorName\":\"Promo Frequency\",\"forceFactorWeight\":7},{\"forceFactorId\":13,\"forceFactorName\":\"Inventory Status\",\"forceFactorWeight\":7},{\"forceFactorId\":14,\"forceFactorName\":\"Price Matching\",\"forceFactorWeight\":7}]}]}";
		String json = readFileAsString();


		// Creating a Gson Object
		Gson gson = new Gson();

		// Converting json to object
		// first parameter should be prpreocessed json
		// and second should be mapping class
		NForceFactors[] forceFactors = gson.fromJson(json, NForceFactors[].class);

		// return object
		return forceFactors;
	}

	public static String readFileAsString()
	{
		CommonUtil app = new CommonUtil();

		String fileName = "json/ForceFactors.json";

		String jsonString = app.getFileFromResourceAsStream(fileName);

		return jsonString;
	}

	// get a file from the resources folder
// works everywhere, IDEA, unit test and JAR file.
	private String getFileFromResourceAsStream(String fileName) {

		// The class loader that loaded the class
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(fileName);
		InputStreamReader isReader = new InputStreamReader(inputStream);
		//Creating a BufferedReader object
		BufferedReader reader = new BufferedReader(isReader);
		StringBuffer sb = new StringBuffer();
		String str;
		try{
			while((str = reader.readLine())!= null){
				sb.append(str);
			}
		} catch(IOException e){
			e.printStackTrace();
		}

		String jsonstring = sb.toString();
		return jsonstring;

	}

	public static ForceFactors getForceFactorsFromFile() {

		// JSON parser object to parse read file
		ForceFactors forceFactors = null;
		System.out.println("here .. trying to find the file .....");
		try (FileReader reader = new FileReader("src/main/resources/json/ForceFactors.json")) {
			// Read JSON file
			Gson gson = new Gson();
			forceFactors = gson.fromJson(reader, ForceFactors.class);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return forceFactors;

	}

	public static CategoryHierarchy getCategoryHierarchyObjectFromFile() {
		CategoryHierarchy categoryHierarchy = null;

		try (FileReader reader = new FileReader("src/main/resources/json/CategoryHierarchy.json")) {
			// Read JSON file
			Gson gson = new Gson();
			categoryHierarchy = gson.fromJson(reader, CategoryHierarchy.class);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return categoryHierarchy;
	}

	public static String getCurrentLoggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
			return auth.getName();
		else
			return null;
	}

	public static ForceFactors getForceFactorsFromString(String forceFactorJson) {
		// Creating a Gson Object
		Gson gson = new Gson();

		// Converting json to object
		// first parameter should be prpreocessed json
		// and second should be mapping class
		ForceFactors forceFactors = gson.fromJson(forceFactorJson, ForceFactors.class);

		// return object
		return forceFactors;
	}
	
	public static String  getJsonStringFromCategoryHierarchy(CategoryHierarchy categoryHierarchy) {
		ObjectMapper Obj = new ObjectMapper(); 
		  String jsonStr = null;
        try { 
  
            // get Oraganisation object as a json string 
            jsonStr = Obj.writeValueAsString(categoryHierarchy); 
  
            // Displaying JSON String 
            System.out.println(jsonStr); 
        } 
  
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
        return jsonStr;
	}
	
	public static String  getJsonStringFromForceFactors(ForceFactors forceFactors) {
		ObjectMapper Obj = new ObjectMapper(); 
		  String jsonStr = null;
        try { 
  
            // get Oraganisation object as a json string 
            jsonStr = Obj.writeValueAsString(forceFactors); 
  
            // Displaying JSON String 
            System.out.println(jsonStr); 
        } 
  
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
        return jsonStr;
	}


	public static String  getJsonStringFromNForceFactors(NForceFactors[] nforceFactors) {
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = null;
		try {

			// get Oraganisation object as a json string
			jsonStr = Obj.writeValueAsString(nforceFactors);

			// Displaying JSON String
			System.out.println(jsonStr);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	public static ForceFactorWeight getForceFactorWeight(ForceFactors forceFactors) {
		
		List<ForceFactor> forceFactorList = new ArrayList<ForceFactor>();
		
		List<Force> forceList = forceFactors.getForceList();
		for(Force force : forceList) {
			forceFactorList.addAll(force.getForceFactorList());
		}		
		
		ForceFactorWeight forceFactorWeight = new ForceFactorWeight();
		forceFactorWeight.setAbandonmentRateWeight(forceFactorList.get(5).getForceFactorWeight());
		forceFactorWeight.setComplexcityWeight(forceFactorList.get(7).getForceFactorWeight());
		forceFactorWeight.setContentAvailabilityWeight(forceFactorList.get(10).getForceFactorWeight());
		forceFactorWeight.setContentAvailableWeight(forceFactorList.get(14).getForceFactorWeight());
		forceFactorWeight.setDigitalRevenueWeight(forceFactorList.get(3).getForceFactorWeight());
		forceFactorWeight.setInventoryStatusWeight(forceFactorList.get(12).getForceFactorWeight());
		forceFactorWeight.setMarginWeight(forceFactorList.get(1).getForceFactorWeight());
		forceFactorWeight.setPriceMatchingWeight(forceFactorList.get(13).getForceFactorWeight());
		forceFactorWeight.setPriceWeight(forceFactorList.get(0).getForceFactorWeight());
		forceFactorWeight.setPromotionFrequencyWeight(forceFactorList.get(11).getForceFactorWeight());
		forceFactorWeight.setqAndAWeight(forceFactorList.get(6).getForceFactorWeight());
		forceFactorWeight.setRatingReviewWeight(forceFactorList.get(4).getForceFactorWeight());
		forceFactorWeight.setRecencyWeight(forceFactorList.get(9).getForceFactorWeight());
		forceFactorWeight.setStoreRevenueWeight(forceFactorList.get(2).getForceFactorWeight());
		forceFactorWeight.setSubstitutionWeight(forceFactorList.get(8).getForceFactorWeight());
		
		System.out.println("FORCEFACTORWEIGHT : " + forceFactorWeight.toString());
		return forceFactorWeight;
		
	}

	public static ForceFactorWeight getForceFactorWeight(NForceFactors[] forceFactors) {

		ForceFactorWeight forceFactorWeight = new ForceFactorWeight();
		forceFactorWeight.setAbandonmentRateWeight(forceFactors[5].getForceFactorWeight());
		forceFactorWeight.setComplexcityWeight(forceFactors[7].getForceFactorWeight());
		forceFactorWeight.setContentAvailabilityWeight(forceFactors[10].getForceFactorWeight());
		forceFactorWeight.setContentAvailableWeight(forceFactors[14].getForceFactorWeight());
		forceFactorWeight.setDigitalRevenueWeight(forceFactors[3].getForceFactorWeight());
		forceFactorWeight.setInventoryStatusWeight(forceFactors[12].getForceFactorWeight());
		forceFactorWeight.setMarginWeight(forceFactors[1].getForceFactorWeight());
		forceFactorWeight.setPriceMatchingWeight(forceFactors[13].getForceFactorWeight());
		forceFactorWeight.setPriceWeight(forceFactors[0].getForceFactorWeight());
		forceFactorWeight.setPromotionFrequencyWeight(forceFactors[11].getForceFactorWeight());
		forceFactorWeight.setqAndAWeight(forceFactors[6].getForceFactorWeight());
		forceFactorWeight.setRatingReviewWeight(forceFactors[4].getForceFactorWeight());
		forceFactorWeight.setRecencyWeight(forceFactors[9].getForceFactorWeight());
		forceFactorWeight.setStoreRevenueWeight(forceFactors[2].getForceFactorWeight());
		forceFactorWeight.setSubstitutionWeight(forceFactors[8].getForceFactorWeight());

		System.out.println("FORCEFACTORWEIGHT : " + forceFactorWeight.toString());
		return forceFactorWeight;

	}
	
	public static String getQueryForItemSelection(CategoryHierarchy categoryHierarchy) {
		String query = "";
				
		List<Department> departmentsList = categoryHierarchy.getDepartmentList();
		
		List<Category> selectedCategoryList = new ArrayList<Category>();
		
		List<SubCategories> selectedSubCategoriesList = new ArrayList<SubCategories>();
		
		List<ItemClass> selectedItemClassList = new ArrayList<ItemClass>();
		
		List<Integer> selectedCategoryListIds = new ArrayList<Integer>();
		
		List<Integer> selectedSubCategoriesListIds = new ArrayList<Integer>();
		
		List<Integer> selectedItemClassListIds = new ArrayList<Integer>();
		
		for(Department department : departmentsList) {
			List<Category> categoryList = department.getCategoryList();
			for(Category category : categoryList) {
				if(category.isSelected()) {
					selectedCategoryList.add(category);
					selectedCategoryListIds.add(category.getCategoryId());
				} else {
					List<SubCategories> subCategoriesList = category.getSubCategoriesList();
					for(SubCategories subCategories : subCategoriesList) {
						if(subCategories.isSelected()) {
							selectedSubCategoriesList.add(subCategories);
							selectedSubCategoriesListIds.add(subCategories.getSubCategoryId());
						} else {
							List<ItemClass> itemClassList =subCategories.getItemClassList();
							for(ItemClass itemClass : itemClassList) {
								if(itemClass.isSelected()) {
									selectedItemClassList.add(itemClass);
									selectedItemClassListIds.add(itemClass.getItemClassId());
								}
							}
						}
					}
				}
			}
		}
		
		query = "Select all_items            from items          where items.itemclass         in ( selectedItemClassList + " + "\n" +
			    "( Select all_ItemClass      from ItemClass      where itemClass.subCategories in ( selectedSubCategoriesList + " + "\n" + 
			    "( select all_SubCategories  from SubCategories  where subCategories.category  in (selectedCategoryList ) ) ) ) ) ";
		
//		System.out.println(selectedCategoryListIds);
//		System.out.println(selectedSubCategoriesListIds);
//		System.out.println(selectedItemClassListIds);
		
		CategorySelection categorySelection = new CategorySelection(selectedCategoryListIds, selectedSubCategoriesListIds, selectedItemClassListIds);
		System.out.println(categorySelection.toString());
		return query;
	}
	
}
