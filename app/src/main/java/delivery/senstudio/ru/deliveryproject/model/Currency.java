package delivery.senstudio.ru.deliveryproject.model;

import com.tickaroo.tikxml.annotation.Path;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ValCurs",strict = false)
public class Currency {

    @Attribute(name = "Date")
    private String Date;

    @Attribute(name = "name")
    private String Name;

    @ElementList( name="Valute", required = false, inline = true)
    private List<Valute> valuteList;



    public List<Valute> getValuteList() {
        return this.valuteList;
    }

    //@Element(name = "Valute")


}
