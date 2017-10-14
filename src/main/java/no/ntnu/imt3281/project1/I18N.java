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
	
	private static I18N i18n = new I18N();
	private static Locale locale;
	private static ResourceBundle bundle;
	
	/**
	 * No argument constructor
	 */
	public I18N() {
		locale = Locale.getDefault();
		I18N.bundle = ResourceBundle.getBundle("no.ntnu.imt3281.project1.AppResourcesBundle", locale);
	}
	
	/**
	 * 
	 * @param key String key with a match in the AppResourcesBundle .properties files.
	 * @return String value belonging to the matching key argument
	 */
	public static String getString(String key) {
		return I18N.bundle.getString(key);
	}

}
