 ##LANGUAGE FLAGS:
 You need to provide a flag image for each Locale/Language that you will add as item.
 Place these images in `img/languageflags/` folder, and name them [language_code].png  
 For example en.png for english flag.  
 
 To find out where the `img` folder should be, see https://stackoverflow.com/questions/57553973/where-should-i-place-my-vaadin-10-static-files
 It will either be  `/src/main/webapp/img` or `/src/main/resources/META-INF/resources/img`
 
 ##TRANSLATIONS OF LANGUAGE NAMES:
 In the ResourceBundle that your I18NProvider implementation uses, add Translations for each Locale/Language that you will use.
 The keys must be named `LanguageSelect.[language_code]`  
 For example `LanguageSelect.en=English` in the English resourcebundle-file, and `LanguageSelect.en=Inglés`  in the Spanish resourcebundle-file