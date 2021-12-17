package utils;

import java.io.File;


@SuppressWarnings("unused")
public class LearningPlatformConstants {

	
	public static final String COMMONFILEPATH = System.getProperty("user.dir")
			+ File.separator + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator + "testdata";

	public static ThreadLocal<String> environmentURL = new ThreadLocal<String>();	
   
 }
