package EducativeIo.Courses.GrokkingTheCodingInterview.Ch13_TopKElements.PC3_FrequencyStack.Java;

import java.util.Comparator;

class ElementComparator implements Comparator<Element> {
    public int compare(Element e1, Element e2) {
        if (e1.frequency != e2.frequency) {
            return e2.frequency - e1.frequency;
        }
        // if both elements have same frequency, return the one that was pushed later
        return e2.sequenceNumber - e1.sequenceNumber;
    }
}
