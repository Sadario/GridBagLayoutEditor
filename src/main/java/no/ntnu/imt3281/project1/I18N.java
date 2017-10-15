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
	
	private static Locale locale = Locale.ENGLISH; // Uncomment for English language (during development)
	//private static Locale locale = Locale.getDefault(); // Uncomment for Norwegian language (during development)
	private static ResourceBundle bundle = ResourceBundle.getBundle("no.ntnu.imt3281.project1.AppResourcesBundle", locale);
	
	/**
	 * 
	 * @param key String key with a match in the AppResourcesBundle .properties files.
	 * @return String value belonging to the matching key argument
	 */
	public static String getString(String key) {
		return I18N.bundle.getString(key);
	}

}
