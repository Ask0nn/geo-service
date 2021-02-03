package ru.netology;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {

    @Test
    public void testByIp(){
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);

        Mockito.when(geoService.byIp(GeoServiceImpl.MOSCOW_IP))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        Mockito.when(geoService.byIp(GeoServiceImpl.LOCALHOST))
                .thenReturn(new Location(null, null, null, 0));

        Mockito.when(geoService.byIp(GeoServiceImpl.NEW_YORK_IP))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        Mockito.when(geoService.byIp("172.14.25.123"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        Mockito.when(geoService.byIp("78.36.18.124"))
                .thenReturn(null);
    }
}
