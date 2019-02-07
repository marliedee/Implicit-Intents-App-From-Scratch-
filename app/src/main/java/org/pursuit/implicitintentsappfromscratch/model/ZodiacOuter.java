package org.pursuit.implicitintentsappfromscratch.model;

import java.util.List;

public class ZodiacOuter {

    private List<Zodiacs> zodiac;

    public ZodiacOuter(List<Zodiacs> zodiac) {
        this.zodiac = zodiac;
    }

    public List<Zodiacs> getZodiac() {
        return zodiac;
    }

    public void setZodiac(List<Zodiacs> zodiac) {
        this.zodiac = zodiac;
    }

}