package ch.carnet.kasparscherrer;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.data.renderer.ComponentRenderer;

import java.util.Locale;

/**
 * LANGUAGE FLAGS:
 * You need to provide a flag image for each Locale/Language that you will add as item.
 * Place these images in 'img/languageflags/' folder, and name them [language_code].png
 * - for example en.png for english flag.
 * To find out where the 'img' folder should be, see https://stackoverflow.com/questions/57553973/where-should-i-place-my-vaadin-10-static-files
 * It will either be  '/src/main/webapp/img' or '/src/main/resources/META-INF/resources/img'
 *
 * TRANSLATIONS OF LANGUAGE NAMES:
 * In the ResourceBundle that your I18NProvider implementation uses, add Translations for each Locale/Language that you will use.
 * The keys must be named 'LanguageSelect.[language_code]'
 * - for example LanguageSelect.en=English in the English resourcebundle-file, and LanguageSelect.en=Inglés  in the Spanish resourcebundle-file
 */
public class LanguageSelect extends Select<Locale> {

    private ComponentRenderer<HorizontalLayout, Locale> languageRenderer = new ComponentRenderer<>(item -> {
        HorizontalLayout hLayout = new HorizontalLayout();
        Image languageFlag = new Image("img/languageflags/"+item.getLanguage()+".png", "flag for "+item.getLanguage());
        languageFlag.setHeight("30px");
        hLayout.add(languageFlag);
        hLayout.add(new Span(getTranslation("LanguageSelect."+item.getLanguage())));
        hLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        return hLayout;
    });

    public LanguageSelect() {
        super();
        prepareLanguageSelection();
    }

    /**
     * You can also use setItems(Locale... items) after instantiation.
     * @param items
     */
    public LanguageSelect(Locale... items){
        super(items);
        prepareLanguageSelection();
    }

    /**
     * Call this function in localeChange() of the View.
     * This will refresh all items and use the names of each language, translated in the new Locale
     */
    public void refresh(){
        setRenderer(this.languageRenderer);
        // TODO: as soon as Select::refreshItems is public, use that!
        //  see https://github.com/vaadin/flow/issues/6337
    }

    private void prepareLanguageSelection() {
        setEmptySelectionAllowed(false);
        setRenderer(this.languageRenderer);
        setValue(UI.getCurrent().getLocale());
        addValueChangeListener(change -> UI.getCurrent().getSession().setLocale(change.getValue()));
    }

}
