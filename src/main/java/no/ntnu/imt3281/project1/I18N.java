package no.ntnu.imt3281.project1;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Temp kommentar: Gjorde klassen statisk slik at konstruktoren til App()
 * kan bruke klassen for en dynamisk vindustittel.
 * 
 * @author thomasgg
 * @author sadario
 *
 */
public class I18N {
	
	private static Locale locale;
	private static ResourceBundle bundle;
	
	/**
	 * 
	 * @param key String key with a match in the AppResourcesBundle .properties files.
	 * @return String value belonging to the matching key argument
	 */
	public static String getString(String key) {
		return I18N.bundle.getString(key);
	}

	/**
	 * Change the language of the application
	 * @param lang The language to use. Currently only supports "en" and "no"
	 */
	public static void setLanguage(String lang) {
		if (lang.equals("en")) {
			locale = Locale.ENGLISH;
			bundle = ResourceBundle.getBundle("no.ntnu.imt3281.project1.AppResourcesBundle", locale);
		} else if (lang.equals("no")) {
			locale = Locale.forLanguageTag("no");
			bundle = ResourceBundle.getBundle("no.ntnu.imt3281.project1.AppResourcesBundle", locale);
		} else {
			locale = Locale.getDefault();
			bundle = ResourceBundle.getBundle("no.ntnu.imt3281.project1.AppResourcesBundle", locale);
		}
		
	}

}
