package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {
    String ru = "Добро пожаловать";
    String en = "Welcome";

    @Test
    public void testSendRuIp(){
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String expected = ru;

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        String actual = messageSender.send(headers);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSendEnIp(){
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String expected = en;

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String actual = messageSender.send(headers);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSendLocalIp(){
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "127.0.0.1");
        String actual = messageSender.send(headers);

        Assertions.assertEquals(null, actual);
    }

    @Test
    public void testSendAnyIp(){
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String expected = ru;

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.36.18.124");
        String actual = messageSender.send(headers);

        Assertions.assertEquals(expected, actual);
    }
}
