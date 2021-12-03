package utils;

import java.io.File;


@SuppressWarnings("unused")
public class LearningPlatformConstants {

	
	public static final String COMMONFILEPATH = System.getProperty("user.dir")
			+ File.separator + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator + "testdata";

	public static ThreadLocal<String> environmentURL = new ThreadLocal<String>();	
    public static ThreadLocal<String> ordernumber = new ThreadLocal<String>();
    public static ThreadLocal<String> equipmentname = new ThreadLocal<String>();
    public static ThreadLocal<String> materialname = new ThreadLocal<String>();
    public static ThreadLocal<String> customername = new ThreadLocal<String>();
    public static ThreadLocal<String> haulhubcustomername = new ThreadLocal<String>();
    //public static ThreadLocal<int> einname = new ThreadLocal<i>();
    public static ThreadLocal<String> jobsitename = new ThreadLocal<String>();
    public static ThreadLocal<String> brokercustomername = new ThreadLocal<String>();
    public static ThreadLocal<String> brokerjobsitename = new ThreadLocal<String>();
    public static ThreadLocal<String> brokermaterialname = new ThreadLocal<String>();
    public static ThreadLocal<String> bookjobcontractorname = new ThreadLocal<String>();

 }
