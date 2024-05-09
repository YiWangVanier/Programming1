package org.example;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        this.streetNo = streetNo;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = isPostalCodeValid(postalCode) ? postalCode.toUpperCase() : null;
        this.country = country;
    }

    /**
     * checks if a postal code is valid or not, a valid postal code can only have two format:
     * if the length is 6, then it is "CDCDCD"
     * if the length is 7, then it is "CDC DCD"
     * where C is a character, and D is a digit
     *
     * @param postalCode
     * @return if a postal code is valid or not
     */
    public static boolean isPostalCodeValid(String postalCode) {
        int len = postalCode.length();

        if (len == 6) {
            return Character.isAlphabetic(postalCode.charAt(0)) &&
                    Character.isDigit(postalCode.charAt(1)) &&
                    Character.isAlphabetic(postalCode.charAt(2)) &&
                    Character.isDigit(postalCode.charAt(3)) &&
                    Character.isAlphabetic(postalCode.charAt(4)) &&
                    Character.isDigit(postalCode.charAt(5));
        }
        if (len == 7) {
            return Character.isAlphabetic(postalCode.charAt(0)) &&
                    Character.isDigit(postalCode.charAt(1)) &&
                    Character.isAlphabetic(postalCode.charAt(2)) &&
                    Character.isWhitespace(postalCode.charAt(3)) &&
                    Character.isDigit(postalCode.charAt(4)) &&
                    Character.isAlphabetic(postalCode.charAt(5)) &&
                    Character.isDigit(postalCode.charAt(6));
        }
        return false;
    }
}
