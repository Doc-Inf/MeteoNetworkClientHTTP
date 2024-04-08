package test;

import controller.MeteoClientHttp;

public class MeteoClientHttpLauncher {

	public static void main(String[] args) {
		MeteoClientHttp client = new MeteoClientHttp();
		client.login();
	}

}
