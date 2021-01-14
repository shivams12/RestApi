package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Addplace;
import pojo.Location;

public class TestData {

public Addplace addplacePayload(String name,String language,String address)
{
Addplace P = new Addplace();
P.setAccuracy(50);
P.setAddress(address);
P.setLanguage(language);
P.setPhone_number("(+91) 983 893 3937");
P.setWebsite("http://google.com");
P.setName(name);
List<String> myList = new ArrayList<String>();
myList.add("shoe park");
myList.add("shop");
P.setTypes(myList);
Location l = new Location();
l.setLat(-38.383494);
l.setLng(33.427362);
P.setLocation(l);
return P;
}

}