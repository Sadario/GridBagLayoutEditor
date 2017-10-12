package no.ntnu.imt3281.project1;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Har 2 forslag til impelmentasjon av denne:
 * 
 * Statisk klasse/funksjoner slik at alle eksisterende klasser
 * og funksjoner kan kalle på denne klassens metoder direkte
 *  eks: String columnHeaderType = I18N.getString("columnName.type");
 * 
 * Composition(?) med protected I18N objekt i App klassen (antar dette er øverste klasse) 
 * der alle underklasser har tilgang til objektet og dens funksjoner.
 * eks: I18N localLang = new I18N();
 *      ...
 *      localLang.getString("columnName.type");
 * 
 * oppdater public GBLEDataModel() når vi har kommet til en enighet
 * 
 * 
 * @author thomasgg
 * @author sadario
 *
 */
public class I18N {
	
	private Locale locale;
	private ResourceBundle bundle;
	
	/**
	 * No argument constructor
	 */
	public I18N() {
		locale = Locale.getDefault();
		bundle = ResourceBundle.getBundle("no.ntnu.imt3281.project1.AppResourcesBundle", locale);
	}
	
	/**
	 * 
	 * @param key String key with a match in the AppResourcesBundle .properties files.
	 * @return String value belonging to the matching key argument
	 */
	public String getString(String key) {
		return bundle.getString(key);
	}

}
