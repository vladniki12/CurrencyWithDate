package delivery.senstudio.ru.deliveryproject.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Valute", strict = false)
public class Valute {

    /*@Attribute(name = "ID")
    private String ID;*/

    @Element(name = "NumCode",required = false)
    private Integer NumCode;

    @Element(name = "CharCode",required = false)
    private String CharCode;

    @Element(name = "Nominal",required = false)
    private Integer Nominal;

    @Element(name = "Name",required = false)
    private String Name;

    @Element(name = "Value")
    private String Value;

    public String getName() {
        return Name;
    }

    public String getValue() {
        return Value;
    }

    public Integer getNominal() {
        return Nominal;
    }

    public Integer getNumCode() {
        return NumCode;
    }

    public String getCharCode() {
        return CharCode;
    }
}

