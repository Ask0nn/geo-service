package ru.netology;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {

    @Test
    public void testLocale(){
        String ru = "Добро пожаловать";
        String en = "Welcome";

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);

        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn(ru);

        Mockito.when(localizationService.locale(Country.BRAZIL))
                .thenReturn(en);

        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn(en);

        Mockito.when(localizationService.locale(Country.GERMANY))
                .thenReturn(en);
    }
}
