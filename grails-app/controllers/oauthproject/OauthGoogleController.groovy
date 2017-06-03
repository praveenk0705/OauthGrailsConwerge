package oauthproject
import org.codehaus.groovy.grails.web.json.JSONObject;

import groovyx.net.http.*
import grails.converters.*





class OauthGoogleController {

	
	def googleredirect = {
		render " you are in google redirect uri"
		def response_code = request.getParameter("code")
		//println "the response_code is ${response_code} "

		def clientId ='1036578206093.apps.googleusercontent.com'
		def clientSecret='qqhlp-9Dc9wwVKDiS4-2Pn8g'
		def callbackUrl='http://localhost:8080/OauthProject/oauthGoogle/googleredirect'


		
		StringBuilder sb = new StringBuilder("code=");
		sb.append(URLEncoder.encode(response_code, "UTF-8"));
		sb.append("&client_id=");
		sb.append(URLEncoder.encode(clientId, "UTF-8"));
		sb.append("&client_secret=");
		sb.append(URLEncoder.encode(clientSecret, "UTF-8"));
		sb.append("&redirect_uri=");
		sb.append(URLEncoder.encode(callbackUrl, "UTF-8"));
		sb.append("&grant_type=");
		sb.append(URLEncoder.encode('authorization_code', "UTF-8"));

		String URL_TO_REQUEST_TOKEN= 'https://accounts.google.com/o/oauth2/token'

		URL url = new URL(URL_TO_REQUEST_TOKEN);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try {
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Length", "" + sb.toString().length());
			connection.setRequestProperty("Host", "accounts.google.com");
			//println "works fine"

			// this is something i'll have to do my self
			connection.setDoOutput(true);
			//

			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());

			outputStreamWriter.write(sb.toString());
			
			outputStreamWriter.flush();
		
			log.debug("Response code ${connection.responseCode} , Message : ${connection.responseMessage}")
			String resultData = connection.content.text
			println resultData
			def responseJson = JSON.parse(resultData)
			println responseJson

			String ACCESS_TOKEN = responseJson?.access_token

			//println ("the access token as recieved ${ACCESS_TOKEN}");
			
			//response.sendRedirect("https://www.googleapis.com/oauth2/v1/userinfo?access_token=${ACCESS_TOKEN}")
			
			
			
			//code to get the user info
			//StringBuilder sb1 = new StringBuilder("access_token=");
			//sb1.append(URLEncoder.encode(ACCESS_TOKEN, "UTF-8"));
			
			
			
			
			
			
			
			
			
			
	
			String queryString = "access_token=" +
					URLEncoder.encode(ACCESS_TOKEN, "UTF-8");


			// Make connection

			URL urls = new URL("https://www.googleapis.com/oauth2/v1/userinfo?"+queryString);
			URLConnection urlConnection = (URLConnection)urls.openConnection();

			// Read the response

			
				
			InputStreamReader i = new InputStreamReader(urlConnection.getInputStream());
			
			String res =urlConnection.content.text
			println res 
			def response1 = JSON.parse(res)
			println response1
			String email = response1?.email
			println email
				
			/*BufferedReader ins = new BufferedReader(
				new InputStreamReader(urlConnection.getInputStream()));
			
			String line = null;

			while ((line = ins.readLine()) != null)
			{
				System.out.println(line);
			}
			

			ins.close();*/
			
			
			
		
		  
		  
		  
		  
		  
		  
		  
		  
		  	
		}
		catch (Exception e) {
			e.printStackTrace()
		}


		
		
		
		
		
	} // end of googleredirecturi
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	def xyz ={
		
		
		
		String URL_FOR_USER_INFO= 'https://www.googleapis.com/oauth2/v1/userinfo'
		
		URL url_userinfo = new URL(URL_FOR_USER_INFO);
		HttpURLConnection connection2 = (HttpURLConnection) url_userinfo.openConnection();
		try {
			connection2.setRequestMethod("GET");
			//connection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			//connection2.setRequestProperty("Content-Length", "" + sb.toString().length());
			connection2.setRequestProperty("Host", "googleapis.com");
			connection2.setRequestProperty("Authorization", "Bearer" + "ya29.AHES6ZQS0GItGSoe6IKmydnVGQvydjL4NjOZ2OND0E_iikqSkqPYhQ" )
			connection2.setDoOutput(true);
			connection2.setDoInput(true);
			/*OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(connection2.getOutputStream());
			 
			println 'praveenklxfkngdxf'
			outputStreamWriter2.write(sb1.toString());
			//outputStreamWriter2.write();
			outputStreamWriter2.flush();
			//log.debug("Response code ${connection.responseCode} , Message : ${connection.responseMessage}")
			String resultData2 = connection2.content.text
			//println resultData2
			//def responseJson2 = JSON.parse(resultData2)
*/
			connection2.connect();

			InputStream inp = new InputStreamReader(connection2.getInputStream());
			inp.read();
			
			String resultData2 = connection2.content.text
			println resultData2
			//connection2.disconnect();
			
		}
		catch (Exception e) {
			e.printStackTrace()
		}
		
		
		/*
		public class OAM
		{
		public static void main(String[] args)
		{
		String addr = "http://www.some-url.com";
		String username = "username";
		String password = "password";
		try{
		URL url = new URL(addr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String encoding = new sun.misc.BASE64Encoder().encode("username 	 assword".getBytes());
		conn.setRequestProperty ("Authorization", "Basic " + encoding);
		conn.setRequestMethod("GET");
		
		conn.connect();
		InputStream in = conn.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String text = reader.readLine();
		System.out.println(text);
		
		conn.disconnect();
		}catch(IOException ex)
		{
		ex.printStackTrace();
		System.out.println("made it here");
		}
		}
		
		}*/
		
		
			
	}
	
	
	
	
	
	
	def facebookRedirect ={
		render "you are in facebook redirect"
		
		def response_code = request.getParameter("code")
		println "the response_code is ${response_code} "
		

		def clientId ='541669239191656'
		def clientSecret='13fa98be503cd7796e9c905f23d2c79f'
		def callbackUrl='http://localhost:8080/OauthProject/oauthGoogle/facebookRedirect'
		
		StringBuilder sb = new StringBuilder("code=");
		sb.append(URLEncoder.encode(response_code, "UTF-8"));
		sb.append("&client_id=");
		sb.append(URLEncoder.encode(clientId, "UTF-8"));
		sb.append("&client_secret=");
		sb.append(URLEncoder.encode(clientSecret, "UTF-8"));
		sb.append("&redirect_uri=");
		sb.append(URLEncoder.encode(callbackUrl, "UTF-8"));
		//sb.append("&grant_type=");
		//sb.append(URLEncoder.encode('authorization_code', "UTF-8"));

		String URL_TO_REQUEST_TOKEN= 'https://graph.facebook.com/oauth/access_token'

		URL url = new URL(URL_TO_REQUEST_TOKEN);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try {
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Length", "" + sb.toString().length());
			connection.setRequestProperty("Host", "graph.facebook.com");
			//println "works fine"

			// this is something i'll have to do my self
			connection.setDoOutput(true);
			//

			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());

			outputStreamWriter.write(sb.toString());
			
			outputStreamWriter.flush();
		
			log.debug("Response code ${connection.responseCode} , Message : ${connection.responseMessage}")
			String resultData = connection.content.text
			println resultData
			
			//String res = resultData.toString();
			
			//println res
			
			
			//def responseJson = JSON.parse(res)
			
			//String ACCESS_TOKEN = responseJson?.access_token

			//println ("the access token as recieved ${ACCESS_TOKEN}");
			
			//response.sendRedirect("https://www.googleapis.com/oauth2/v1/userinfo?access_token=${ACCESS_TOKEN}")
			
		}
		catch (Exception e) {
			e.printStackTrace()
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
