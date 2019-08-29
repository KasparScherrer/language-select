package ch.carnet.kasparscherrer;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import java.util.Locale;

@Route("")
public class View extends Div {

    public View() {
        LanguageSelect languageSelect = new LanguageSelect(new Locale("de"), new Locale("fr"), new Locale("en"));
        add(languageSelect);
    }
}
