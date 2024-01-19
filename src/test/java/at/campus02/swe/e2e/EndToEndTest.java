package at.campus02.swe.e2e;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;

public class EndToEndTest {

    @Test
    public void testE2EMultiplicationTest() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);
        double isResult = parser.parse(new File("src/test/resources/test-e2e-multiplication.xml"));

        double expectedResult = getResultOfXMLTestFile(new File("src/test/resources/test-e2e-multiplication.xml"));
        assertEquals(expectedResult, isResult, 0);
    }

    @Test
    public void testE2EDivisionTest() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);
        double isResult = parser.parse(new File("src/test/resources/test-e2e-division.xml"));

        double expectedResult = getResultOfXMLTestFile(new File("src/test/resources/test-e2e-division.xml"));
        assertEquals(expectedResult, isResult, 0);
    }

    private double getResultOfXMLTestFile(File calculation) throws FileNotFoundException,
            XMLStreamException {

        double result = 0;
        XMLEventReader r = createXmlEventReader(calculation);

        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
            Attribute attribute = e.asStartElement().getAttributeByName(
                    new QName("value"));
            String value = attribute != null ? attribute.getValue() : "";
            if ("result".equals(e.asStartElement().getName().getLocalPart())) {
                return Double.parseDouble(value);
            }
        }

        return result;
    }

    private XMLEventReader createXmlEventReader(File calculation)
            throws FactoryConfigurationError, FileNotFoundException,
            XMLStreamException {
        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        FileReader fr = new FileReader(calculation);
        XMLEventReader xmler = xmlif.createXMLEventReader(fr);
        EventFilter filter = new EventFilter() {
            public boolean accept(XMLEvent event) {

                return event.isStartElement();
            }
        };

        XMLEventReader r = xmlif.createFilteredReader(xmler, filter);
        return r;
    }

    @Test
    public void testE2ERandomTest() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);
        double isResult = parser.parse(new File("src/test/resources/test-e2e-random.xml"));

        double expectedResult = getResultOfXMLTestFile(new File("src/test/resources/test-e2e-random.xml"));
        assertEquals(expectedResult, isResult, 0);
    }

}
